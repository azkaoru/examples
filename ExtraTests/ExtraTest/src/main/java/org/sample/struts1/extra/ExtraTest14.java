package org.sample.struts1.extra;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ExtraTest14 extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        MultiBoxTest multiBoxTest = (MultiBoxTest) form;
        System.out.println("Data length: " + ((multiBoxTest.getData() != null) ? multiBoxTest.getData().length : "null"));
        System.out.println("checkedArray length: " + ((multiBoxTest.getCheckedArray() != null) ? multiBoxTest.getCheckedArray().length : "null"));
        
        return mapping.findForward("success");
	}
}