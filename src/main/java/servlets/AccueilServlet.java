package servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import pojos.Utilisateur;
import services.CategorieService;
import services.UtilisateurService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/accueil")
public class AccueilServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("Categorie", CategorieService.getInstance().listCategorie());
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("accueil", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET PARAMETERS

        String motsClefsRecherche = req.getParameter("recherche");
        //SET ATTRIBUTE
        req.getSession().setAttribute("rechercheAnnonce", motsClefsRecherche);
        resp.sendRedirect("/recherche");
    }
}

