import com.domian.NestedCommandBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;

import static org.junit.Assert.assertEquals;

/**
 * Created by wangqi on 16/4/10.
 */
public class NestedCommandBeanTest {


    private ServletRequestDataBinder binder;
    private MockHttpServletRequest request;
    private NestedCommandBean bean;

    @Before
    public void setUp() throws Exception {
        bean = new NestedCommandBean();
        binder = new ServletRequestDataBinder(bean, "beanName");
        request = new MockHttpServletRequest();
    }

    @Test
    public void testSimpleBind() {
// just like /servlet?name.firstName=Anya&name.lastName=Lala // or name.firstName=Anya&name.lastName=Lala as the payload // of a POST request
        request.addParameter("name.firstName", "Anya"); request.addParameter("name.lastName", "Lala");
        binder.bind(request);
        assertEquals("Anya", bean.getName().getFirstName());  // true!
        assertEquals("Lala", bean.getName().getLastName());   // true!
        System.out.println(bean);
    }

}
