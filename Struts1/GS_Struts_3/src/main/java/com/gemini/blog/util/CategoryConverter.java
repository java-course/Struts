package com.gemini.blog.util;

import com.gemini.blog.dao.impl.CategoryDao;
import org.apache.commons.beanutils.Converter;

/**
 * Created by Georgy Gobozov on 6/4/2015.
 */
public class CategoryConverter implements Converter {

    CategoryDao categoryDao = new CategoryDao();

    @Override
    public Object convert(Class aClass, Object o) {
        try {
            return categoryDao.getById(Integer.parseInt(o.toString()));
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }
}
