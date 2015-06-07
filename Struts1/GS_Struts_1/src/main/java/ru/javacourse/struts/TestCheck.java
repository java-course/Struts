package ru.javacourse.struts;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.FieldChecks;

public class TestCheck {

    public static boolean validateRequired(Object bean, ValidatorAction va, Field field, ActionMessages errors, Validator validator, HttpServletRequest request) {
        System.out.println("Call custom validator:"+bean.getClass().toString());
        return FieldChecks.validateRequired(bean, va, field, errors, validator, request);
    }
}
