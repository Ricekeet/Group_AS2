package com.example.group_as1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CriteriaController", value = "/CriteriaController")
public class CriteriaController extends HttpServlet {
    private CriteriaHandler handler;

    public CriteriaController() {
        this.handler = new CriteriaHandler();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = request.getParameter("pageName");

        if (pageName.equals("criteria")){

        }
    }
}
