package ru.javacourse.struts.action;

import org.apache.struts.action.*;
import ru.javacourse.struts.data.UserDataSourse;
import ru.javacourse.struts.form.UserForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddNewUserAction extends Action {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String target = SUCCESS;
        UserForm userForm = (UserForm) form;

        try {
            UserDataSourse.add(userForm);
        } catch (Exception e) {
            e.printStackTrace();
            target = FAILURE;
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.negative.id"));
            saveErrors(request, errors);
        }
        return mapping.findForward(target);

    }

}
