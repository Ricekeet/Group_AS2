package com.example.group_as1;

import entities.GeographicareaEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HouseholdController", value = "/HouseholdController")
public class HouseholdController extends HttpServlet {
    private CriteriaHandler handler;

    public HouseholdController() throws ClassNotFoundException{
        super();
        try{
            handler = new CriteriaHandler();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = request.getParameter("pageName");
        if (pageName.equals("household")){
            String householdCount = handler.createQueryQuestion5().toString();
            request.setAttribute("household",householdCount);
        }
        RequestDispatcher view = request.getRequestDispatcher("Household.jsp");
        view.forward(request,response);
    }
}
