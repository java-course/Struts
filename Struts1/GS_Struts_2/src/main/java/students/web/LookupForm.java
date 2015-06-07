package students.web;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LookupForm extends ActionForm {

    private String professionId = null;
    private String professionName = null;

    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.professionId = null;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors ae = new ActionErrors();
        if (professionId == null || professionId.trim().isEmpty()) {
            ae.add("professionId", new ActionMessage("errors.lookup.symbol.required"));
        }
        return ae;
    }
}