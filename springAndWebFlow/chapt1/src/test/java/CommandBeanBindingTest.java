import com.object.Name;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;

import static org.junit.Assert.assertEquals;

/**
 * Created by wangqi on 16/4/9.
 */
public class CommandBeanBindingTest {
    private Name name;
    private ServletRequestDataBinder binder;
    private MockHttpServletRequest request;
    @Before
    public void setUp() throws Exception {
        name = new Name();
        binder = new ServletRequestDataBinder(name, "nameBean");
        request = new MockHttpServletRequest();
    }
    @Test
    public void testSimpleBind() {
        // just like /servlet?firstName=Anya&lastName=Lala
        request.addParameter("firstName", "Anya");
        request.addParameter("lastName", "Lala");
        binder.bind(request);    // performed by BaseCommandController
        // on submit so you don’t have to
        assertEquals("Anya", name.getFirstName());  // true!
        assertEquals("Lala", name.getLastName());   // true!
        System.out.println(name);

    }
}
