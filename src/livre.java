import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

// Classe abstraite Livre
abstract class Livre {
    private String titre;
    private String auteur;

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public abstract String getCategorie();
}
