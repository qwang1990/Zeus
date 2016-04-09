package com.springMock;

import com.object.Name;
import junit.framework.TestCase;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;

/**
 * Created by wangqi on 16/4/9.
 */
public class CommandBeanBindingTest extends TestCase {
    private Name name;
    private ServletRequestDataBinder binder;
    private MockHttpServletRequest request;
    public void setUp() throws Exception {
        name = new Name();
        binder = new ServletRequestDataBinder(name, "nameBean");
        request = new MockHttpServletRequest();
    }
    public void testSimpleBind() {
        // just like /servlet?firstName=Anya&lastName=Lala
        request.addParameter("firstName", "Anya");
        request.addParameter("lastName", "Lala");
        binder.bind(request);    // performed by BaseCommandController
        // on submit so you don’t have to
        assertEquals("Anya", name.getFirstName());  // true!
        assertEquals("Lala", name.getLastName());   // true!
    }
}
