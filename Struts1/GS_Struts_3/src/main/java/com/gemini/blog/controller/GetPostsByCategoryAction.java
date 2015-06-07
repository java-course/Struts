package com.gemini.blog.controller;

import com.gemini.blog.dao.impl.CategoryDao;
import com.gemini.blog.dao.impl.PostDao;
import com.gemini.blog.model.Post;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Georgy Gobozov on 6/4/2015.
 */
public class GetPostsByCategoryAction extends Action {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    PostDao postDao = new PostDao();
    CategoryDao categoryDao = new CategoryDao();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Integer id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("posts", postDao.getPostsByCategoryId(id));
        request.setAttribute("categories", categoryDao.getAll());

        return mapping.findForward(SUCCESS);

    }
}
