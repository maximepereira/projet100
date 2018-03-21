package servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import services.AnnonceService;
import services.CategorieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/historique")
public class HistoriqueServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String mailUtilisateur = req.getSession().getAttribute("user").toString();
        context.setVariable("Annonce", AnnonceService.getInstance().listAnnonceByUtilisateur(mailUtilisateur));
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("historique", context, resp.getWriter());
    }
}