package managers;

import pojos.Utilisateur;
import services.UtilisateurService;

public class UtilisateurManager {
    public boolean confirmPassword(String mailUtilisateur, String mdpUtilisateur){
        return UtilisateurService.getInstance().getStoredPassword(mailUtilisateur).equals(mdpUtilisateur);
    }
}
