package ru.javacourse.struts.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import ru.javacourse.struts.form.UserForm;
import ru.javacourse.struts.data.UserDataSourse;

public class LookupUserAction extends Action {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    protected UserForm getUserById(Integer id) {
        return UserDataSourse.getById(id);
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String id = request.getParameter("id");
        UserForm user = getUserById(Integer.parseInt(id));


        // Default target to success
        String target = SUCCESS;

        // Set the target to failure
        if (user == null) {
            target = FAILURE;
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.lookup.unknown", id));
            saveErrors(request, errors);
        } else {
            // form object passed to jsp page
//            UserForm userForm = (UserForm) form;
//            userForm.setName(user.getName());
//            userForm.setAge(user.getAge());
//            userForm.setEmail(user.getEmail());

            request.setAttribute("user", user);

        }

        // Forward to the appropriate View
        return mapping.findForward(target);


    }


}