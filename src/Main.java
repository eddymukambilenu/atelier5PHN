/*public class Main {

    public static void main(String[] args) {
        GestionnaireBibliotheque gestionnaire = new GestionnaireBibliotheque();

        LivreRoman livre1 = new LivreRoman("Les Misérables", "Victor Hugo");
        LivreRoman livre2 = new LivreRoman("Germinal", "Émile Zola");
        LivreRoman livre3 = new LivreRoman("L'appel de la foret", "John London");

        gestionnaire.ajouterLivre(livre1);
        gestionnaire.ajouterLivre(livre2);
        gestionnaire.ajouterLivre(livre2);

        // Exemple d'utilisation des méthodes du gestionnaire
        //gestionnaire.supprimerLivre(1);

        // Sauvegarde des données dans un fichier texte
        gestionnaire.sauvegarderDansFichier("bibliotheque.txt");
    }


}

 */
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        try {
            GestionDB gestionDB = new GestionDB();
            gestionDB.createTable();
            gestionDB.insertLivre("les miserables", "victor hugo");
            gestionDB.insertLivre("Germinal", "Emile zola");
            System.out.println("livres dans la base de données:");
            gestionDB.selectLivres();
            gestionDB.updateLivre(1, "les miserables Updated", "victor hugo");
            System.out.println("livres après mise à jour:");
            gestionDB.selectLivres();
            gestionDB.deleteLivre(2);
            System.out.println("livres après suppression: ");
                    gestionDB.selectLivres();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     }

