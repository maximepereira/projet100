package servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import pojos.Utilisateur;
import services.AnnonceService;
import services.CategorieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Zoom")
public class ZoomAnnonceSevlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idCategorie = req.getParameter("id");
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("Annonce", AnnonceService.getInstance().getAnnonce(Integer.parseInt(idCategorie)));
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("zoomAnnonce", context, resp.getWriter());
    }
}
