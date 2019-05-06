package by.vorokhobko.servlets;

import by.vorokhobko.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserServlet extends SimpleServlet {
    /**
     * The method handle a Put request.
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        if (id == null) {
            this.forward("/notUpdate.jsp", req, resp);
        } else {
            getDao().updateUser(
                    Integer.parseInt(req.getParameter("userId")),
                    new User(req.getParameter("name"),
                            req.getParameter("superName")
                    ));
            this.forward("/updateUser.jsp", req, resp);
        }
    }
}