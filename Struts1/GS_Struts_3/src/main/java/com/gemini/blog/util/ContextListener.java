package com.gemini.blog.util;

import com.gemini.blog.model.Category;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Georgy Gobozov on 6/4/2015.
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context initialized!");
        ConvertUtils.register(new CategoryConverter(), Category.class);


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
