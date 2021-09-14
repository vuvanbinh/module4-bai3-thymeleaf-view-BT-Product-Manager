package com.codegym.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("config 1--------------------");
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("config 2--------------------");
        return new Class[]{};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("config 3--------------------");
        return new String[]{"/"};
    }
}