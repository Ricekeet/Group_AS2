package com.example.group_as1;

import entities.AgeEntity;
import entities.GeographicareaEntity;
import entities.TotalincomeEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
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
        String forward = "";

        if (pageName.equals("criteria")){
            forward = "CriteriaQuery.jsp";

//            Get top 10 Multiselect of GeographicAreas
            List<GeographicareaEntity> multiselectItems = handler.GetTop10GeographicAreas();
            request.setAttribute("multiselect", multiselectItems);

//            Get top 20 combined age from the Age table order by desc
            List<AgeEntity> ages = handler.GetTop20AgeByDesc();
            request.setAttribute("combined", ages);

//            Get Peterborough
            GeographicareaEntity area = handler.GetPeterborough();
            List<GeographicareaEntity> areas = new ArrayList<>();
            areas.add(area);
            request.setAttribute("peterborough", areas);

//            Get TotalIncome Descriptions between 10 and 20
            List<TotalincomeEntity> incomes = handler.GetTotalIncomesBetween10and20();
            request.setAttribute("totalIncomes", incomes);

//            Get geographicAreas By Level
            List<GeographicareaEntity> areasByLevel = handler.GetGeoGraphicAreasByLevel();
            request.setAttribute("geographicAreasByLevel", areasByLevel);
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request,response);
    }
}
