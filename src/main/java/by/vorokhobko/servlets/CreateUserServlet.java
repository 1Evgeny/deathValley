package by.vorokhobko.servlets;

import by.vorokhobko.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserServlet extends SimpleServlet {
    /**
     * The method handle a Post request.
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        getDao().addUser(new User(
                req.getParameter("name"),
                req.getParameter("superName")
        ));
        this.forward("/createUser.jsp", req, resp);
    }
}