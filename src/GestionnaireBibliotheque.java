// Classe GestionnaireBibliotheque
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
public class GestionnaireBibliotheque {
    private HashMap<Integer, Livre> bibliotheque = new HashMap<>();
    private int idCounter = 1;

    // Méthode pour ajouter un livre à la bibliothèque
    public void ajouterLivre(Livre livre) {
        bibliotheque.put(idCounter, livre);
        idCounter++;
    }

    // Méthode pour supprimer un livre de la bibliothèque par son identifiant
    public void supprimerLivre(int id) {
        bibliotheque.remove(id);
    }

    // Méthode pour sauvegarder les données dans un fichier texte
    public void sauvegarderDansFichier(String nomFichier) {
        try (FileWriter writer = new FileWriter(nomFichier)) {
            for (Livre livre : bibliotheque.values()) {
                writer.write(livre.getTitre() + ";" + livre.getAuteur() + ";" + livre.getCategorie() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde dans le fichier : " + e.getMessage());
        }
    }
}

