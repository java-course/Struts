package students.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.struts.ActionSupport;
import students.facade.ProfessionFacade;
import students.view.ProfessionView;

public class LookupAction extends ActionSupport {

    private ProfessionFacade professionFacade;

    @Override
    protected void onInit() {
        WebApplicationContext ctx = getWebApplicationContext();
        professionFacade = (ProfessionFacade) ctx.getBean("professionFacade");
    }

    protected String getProfession(Long professionId) {
        ProfessionView pv = professionFacade.getProfession(professionId);
        return pv!=null ? pv.getProfessionName() : null;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String profession = null;

        // Use the LookupForm to get the request parameters
        LookupForm lookupForm = (LookupForm) form;
        // Default target to success
        String target = "success";
        Long professionId = null;
        if (form != null) {
            try {
                professionId = Long.parseLong(lookupForm.getProfessionId());
                profession = getProfession(professionId);
            } catch (Exception e) {
            }
        }
        // Set the target to failure
        if (profession == null) {
            target = "failure";
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.lookup.unknown", professionId));
            saveErrors(request, errors);
        } else {
            lookupForm.setProfessionName(profession);
        }
        // Forward to the appropriate View
        return (mapping.findForward(target));
    }
}