package com.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by wangqi on 16/4/9.
 */
public class HandleUploadController extends AbstractController
        implements InitializingBean {
    private File destinationDir;
    public void setDestinationDir(File destinationDir) {
        this.destinationDir = destinationDir;
    }

    public void afterPropertiesSet() throws Exception {
        if (destinationDir == null) {
            throw new IllegalArgumentException("Must specify destinationDir");
        } else if (!destinationDir.isDirectory() && !destinationDir.mkdir()) {
            throw new IllegalArgumentException(destinationDir + " is not a " +
                    "directory, or it couldn't be created");
        }
    }
    protected ModelAndView handleRequestInternal(HttpServletRequest req,
                                                 HttpServletResponse res) throws Exception {
        res.setContentType("text/plain");
        if (!(req instanceof MultipartHttpServletRequest)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Expected multipart request");
            return null;
        }
        MultipartHttpServletRequest multipartRequest =
                (MultipartHttpServletRequest) req;
        MultipartFile file = multipartRequest.getFile("uploaded");
        File destination = File.createTempFile("file", "uploaded",
                destinationDir);
        FileCopyUtils.copy(file.getInputStream(),
                new FileOutputStream(destination));
        res.getWriter().write("Success, wrote to " + destination);
        res.flushBuffer();
        return null;
    }
}
