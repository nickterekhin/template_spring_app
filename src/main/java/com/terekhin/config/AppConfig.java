package com.terekhin.config;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.lang.NonNull;
import org.springframework.web.context.WebApplicationContext;
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
        return new String[]{"/"};
    }


    //Set development profile;
    @Override
    protected WebApplicationContext createRootApplicationContext() {

       /* WebApplicationContext ctx =  super.createRootApplicationContext();
        ((ConfigurableEnvironment)ctx.getEnvironment()).setActiveProfiles("dev");
        return ctx;*/
        return super.createRootApplicationContext();
    }
}
