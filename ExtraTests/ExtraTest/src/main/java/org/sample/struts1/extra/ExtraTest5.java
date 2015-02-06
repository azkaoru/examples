package org.sample.struts1.extra;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ExtraTest5 extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        TestBean tb1 = new TestBean();
        tb1.setUsername("request");
        request.setAttribute("tbean", tb1);
        
        TestBean tb2 = new TestBean();
        tb2.setUsername("session");
        request.getSession().setAttribute("tbean_session", tb2);
        
        return mapping.findForward("success");
    }
}
