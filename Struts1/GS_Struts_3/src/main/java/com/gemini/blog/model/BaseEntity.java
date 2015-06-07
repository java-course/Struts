package com.gemini.blog.model;

import org.apache.struts.action.ActionForm;

/**
 * Author: Georgy Gobozov
 * Date: 21.04.13
 */
public class BaseEntity extends ActionForm{

    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
