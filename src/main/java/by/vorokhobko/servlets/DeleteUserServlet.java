package by.vorokhobko.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends SimpleServlet {
    /**
     * The method handle a Delete request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("userId"));
        if (id != 0) {
            getDao().removeItem(id);
            this.forward("/delete.jsp", req, resp);
        } else {
            this.forward("/notDelete.jsp", req, resp);
        }
    }
}