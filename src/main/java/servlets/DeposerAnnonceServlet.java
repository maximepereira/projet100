package servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import pojos.Annonce;
import pojos.Categorie;
import pojos.Utilisateur;
import services.AnnonceService;
import services.CategorieService;
import services.UtilisateurService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/deposerannonce")
public class DeposerAnnonceServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("Categorie", CategorieService.getInstance().listCategorie());
        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("deposerAnnonce", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //GET PARAMETERS

        String titreAnnonce = req.getParameter("nomAdd");
        String descriptionAnnonce = req.getParameter("descriptionAdd");
        String motsClefsAnnonce = req.getParameter("keyAdd");
        //LocalDate dateAnnonce = Calendar.getInstance().getTime();
        //System.out.println(dateAnnonce.toString());
        Date input = new Date();
        LocalDate dateAnnonce = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Boolean evenement = false;
        String nomCategorieAnnonce = req.getParameter("categorieAdd");
        Categorie categorieAnnonce = CategorieService.getInstance().getCategorie(nomCategorieAnnonce);
        Utilisateur utilisateurTest = new Utilisateur(1, "Nom #1", "Prenom #1", "Tel #1", "Mail #1", "H1", 0, "new");
        //Utilisateur utilisateurAnnonce = UtilisateurService.getInstance().getUtilisateur(req.getSession().getAttribute("user").toString());

        //CREATE NEW ADD
        Annonce nouvelleAnnonce = new Annonce(null,titreAnnonce, descriptionAnnonce, motsClefsAnnonce, dateAnnonce, evenement, categorieAnnonce, utilisateurTest);
        AnnonceService.getInstance().addAnnonce(nouvelleAnnonce);
        resp.sendRedirect("/accueil");
    }
}
