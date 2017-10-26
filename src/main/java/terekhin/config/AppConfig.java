package terekhin.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Nick on 23.10.17.
 */
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MVCConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
