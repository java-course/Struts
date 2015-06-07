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
public class GetPostAction extends Action {


    PostDao postDao = new PostDao();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Post post = (Post)form;

        Integer id = Integer.parseInt(request.getParameter("id"));

        Post p = postDao.getById(id);
        post.setBody(p.getBody());
        post.setSummary(p.getSummary());
        post.setTitle(p.getTitle());
        post.setCategory(p.getCategory());

        return mapping.findForward("success");

    }
}
