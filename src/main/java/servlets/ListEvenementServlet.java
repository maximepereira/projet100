package servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import services.AnnonceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/evenements")
public class ListEvenementServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("Annonce", AnnonceService.getInstance().listEvenement());
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("evenement", context, resp.getWriter());
    }
}
