package servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import services.AnnonceService;
import services.CategorieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allannonces")
public class ListAnnonceServlet extends GenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("Categorie",CategorieService.getInstance().listCategorie());
        context.setVariable("Annonce", AnnonceService.getInstance().listAnnonce());
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("lesAnnonces", context, resp.getWriter());
    }
}
