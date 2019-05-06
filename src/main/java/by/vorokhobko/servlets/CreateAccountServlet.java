package by.vorokhobko.servlets;

import by.vorokhobko.model.Account;
import by.vorokhobko.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAccountServlet extends SimpleServlet {
    /**
     * The method handle a Post request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        getDao().addAccount(new Account(
                Integer.parseInt(req.getParameter("account")),
                Integer.parseInt(req.getParameter("userId"))
        ));
        this.forward("/createAccount.jsp", req, resp);
    }
}