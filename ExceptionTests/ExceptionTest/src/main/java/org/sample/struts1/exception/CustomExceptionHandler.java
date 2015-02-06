package org.sample.struts1.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

public class CustomExceptionHandler extends ExceptionHandler {
    @Override
    public ActionForward execute(Exception ex, ExceptionConfig ae,
            ActionMapping mapping, ActionForm formInstance,
            HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        ActionMessage msg = new ActionMessage(ae.getKey());
        System.out.println("Exception occurred! : " + ae.getKey() + ", " + ae.getPath() + ", " + formInstance);

        String property = Globals.ERROR_KEY;
        ActionForward forward = new ActionForward(ae.getPath());
        String scope = "request";

        storeException(request, property, msg, forward, scope);

        if (!response.isCommitted()) {
            return forward;
        }
        return null;
    }

}
