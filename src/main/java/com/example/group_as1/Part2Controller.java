package com.example.group_as1;

import entities.GeographicareaEntity;
import entities.TotalincomeEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Part2Controller", value = "/Part2Controller")
public class Part2Controller extends HttpServlet {
    private CriteriaHandler handler;

    public Part2Controller() throws ClassNotFoundException{
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

        if (pageName.equals("part2")){
//          Run all queries
            List<GeographicareaEntity> part2 = handler.returnID10();
            List<GeographicareaEntity> part3 = handler.returnLevel2();
            List<TotalincomeEntity> part4 = handler.createQueryfindAllIncome();


            request.setAttribute("id10", part2);
            request.setAttribute("level2", part3);
            request.setAttribute("findAllIncome", part4);

            String forward = "Part2-4.jsp";
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request,response);
        }
    }
}
