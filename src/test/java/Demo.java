import com.te.People;
import org.apache.commons.beanutils.BeanUtilsBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.commons.beanutils.SuppressPropertiesBeanIntrospector;
import org.junit.Test;

import java.lang.reflect.Method;

public class Demo {

    /**
     * Example displaying the new default behaviour such that
     * it is not possible to access class level properties utilizing the
     * BeanUtilsBean, which in turn utilizes the PropertyUtilsBean.
     */
    @Test
    public void testSuppressClassPropertyByDefault() throws Exception {
        final BeanUtilsBean bub = new BeanUtilsBean();
        final People bean = new People();
        try {
            String aClass = bub.getProperty(bean, "class");
            System.out.println(aClass);
//            fail("Could access class property!");
        } catch (final NoSuchMethodException ex) {
            ex.printStackTrace();
            // ok
        }
    }

    /**
     * Example showing how by which one would use to revert to the
     * behaviour prior to the 1.9.4 release where class level properties were accessible by
     * the BeanUtilsBean and the PropertyUtilsBean.
     */
    @Test
    public void testAllowAccessToClassProperty() throws Exception {
        final BeanUtilsBean bub = new BeanUtilsBean();
        bub.getPropertyUtils().removeBeanIntrospector(SuppressPropertiesBeanIntrospector.SUPPRESS_CLASS);
        try {
            final People bean = new People();
            String result = bub.getProperty(bean, "class");
            System.out.println(result);
//            assertEquals("Class property should have been accessed", "class org.apache.commons.beanutils2.com.te.People",
//                    result);
        } catch (final NoSuchMethodException ex) {
            ex.printStackTrace();
        }
        // ok
    }

    @Test
    public void tt1() throws Exception {
        Class cls = Runtime.class.getClass();
        Method method = cls.getMethod("getMethod",new Class[]{String.class,Class[].class});
        Method run =(Method) method.invoke(java.lang.Runtime.class,new Object[]{"getRuntime",null});
        Class fuck = run.getClass();
        Method method2 =(Method) fuck.getMethod("invoke", Object.class, Object[].class);
        Runtime method3 = (Runtime) run.invoke(null,null);
//        Process exec = method3.exec("open /Applications/优酷.app");
        System.out.println(1);
    }

    @Test
    public void t1() throws Exception {
        final BeanUtilsBean bub = new BeanUtilsBean();
        final People bean = new People("1",100);
        final People bean2 = new People();

//        Object o = bub.cloneBean(bean);
//        bub.copyProperties(bean,bean2);

//        String name = bub.getProperty(bean, "name");
        String class1 = bub.getProperty(bean, "class");

        System.out.println(bean2);
    }

    @Test
    public void t2() throws Exception {
        Method exec = String.class.getClass().
                forName("java.lang.Runtime")
                .getMethod("exec", String.class);
        System.out.println(1);
    }
}
