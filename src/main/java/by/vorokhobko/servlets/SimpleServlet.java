package by.vorokhobko.servlets;

import by.vorokhobko.database.DatabaseDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public abstract class SimpleServlet extends HttpServlet {

    private DatabaseDAO dao = new DatabaseDAO();

    public DatabaseDAO getDao() {
        return dao;
    }

    @Override
    public void init() {
        this.dao.createConnection();
        this.dao.createTable();
    }

    @Override
    public void destroy() {
        this.dao.closeConnection();
        this.dao.closeConnection();
    }
    /**
     * The method works in jsp.
     */
    protected void forward(String address, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(req, resp);
    }
}
