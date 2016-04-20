package com.ssosame.filter;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangqi on 16/4/20.
 */
public class SSOAuth implements Filter {

    private String ssoService;

    private String ssoLogin;

    private String cookieName;

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        ssoService = fConfig.getInitParameter("SSOService");
        ssoLogin = fConfig.getInitParameter("SSOLogin");
        cookieName = fConfig.getInitParameter("cookieName");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String params = request.getQueryString();
        String URL = ssoLogin + "?gotoURL=" + (params != null ? request.getRequestURL().append("?").append(params).toString() : request.getRequestURL().toString());

        Cookie ticket = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null)
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals(cookieName)) {
                    ticket = cookie;
                    break;
                }
            }
        if(request.getRequestURI().equals(request.getContextPath() + "/logout"))
            doLogout(request, response, chain, ticket, URL);
        else if(ticket != null)
            authCookie(request, response, chain, ticket, URL);
        else
            response.sendRedirect(URL);
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Cookie ticket, String URL) throws IOException, ServletException {
        NameValuePair[] params = new NameValuePair[2];
        params[0] = new NameValuePair("action", "logout");
        params[1] = new NameValuePair("cookieName", ticket.getValue());
        try {
            post(request, response, chain, URL, params);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } finally {
            response.sendRedirect(ssoLogin + "?gotoURL=" + request.getRequestURL().toString().replace("logout", "index.jsp"));
        }
    }

    private void authCookie(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Cookie ticket, String URL) throws IOException, ServletException {
        NameValuePair[] params = new NameValuePair[2];
        params[0] = new NameValuePair("action", "authTicket");
        params[1] = new NameValuePair("cookieName", ticket.getValue());
        try {
            JSONObject result = post(request, response, chain, URL, params);
            if(result.getBoolean("error")) {
                response.sendRedirect(URL);
            } else {
                request.setAttribute("username", result.getString("username"));
                chain.doFilter(request, response);
            }
        } catch (JSONException e) {
            response.sendRedirect(URL);
            throw new RuntimeException(e);
        }
    }

    private JSONObject post(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String URL, NameValuePair[] params) throws IOException, ServletException, JSONException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(ssoService);
        postMethod.addParameters(params);
        switch(httpClient.executeMethod(postMethod)) {
            case HttpStatus.SC_OK:
                return new JSONObject(postMethod.getResponseBodyAsString());
            default:
                // 其它处理
                return null;
        }
    }

}
