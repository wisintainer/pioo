package com.quick.filter;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adrianow
 */
public abstract class AbstractFilter {

    public AbstractFilter() {
    }

    protected void doLogin(ServletRequest request, ServletResponse resposne, HttpServletRequest req) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("../entrada.jsf");
        dispatcher.forward(request, resposne);
    }

    protected void acessoNegado(ServletRequest request, ServletResponse resposne, HttpServletRequest req) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("acessonegado.jsf");
    }
}
