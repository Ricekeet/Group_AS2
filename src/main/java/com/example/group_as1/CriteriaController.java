package com.example.group_as1;

import entities.GeographicareaEntity;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CriteriaController", value = "/CriteriaController")
public class CriteriaController extends HttpServlet {
    private CriteriaHandler handler;

    public CriteriaController() throws ClassNotFoundException{
        super();
        try{
            handler = new CriteriaHandler();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = request.getParameter("pageName");

        if (pageName.equals("criteria")){
//            Get top 10 Multiselect of GeographicAreas
            List<GeographicareaEntity> multiselectItems = handler.GetTop10GeographicAreas();

        }
    }
}
