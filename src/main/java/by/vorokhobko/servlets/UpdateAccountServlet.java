package by.vorokhobko.servlets;

import by.vorokhobko.model.Account;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAccountServlet extends SimpleServlet {
    /**
     * The method handle a Put request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        if (id == null) {
            this.forward("/notUpdate.jsp", req, resp);
        } else {
            getDao().updateAccount(
                    Integer.parseInt(req.getParameter("accountId")),
                    new Account(Integer.parseInt(req.getParameter("account")),
                            Integer.parseInt(req.getParameter("userId"))
                    ));
            this.forward("/updateAccount.jsp", req, resp);
        }
    }
}
