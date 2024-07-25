import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class GestionDB {
    private Connection connection;
    public GestionDB() throws SQLException {
        this.connection = DatabaseSingleton.getInstance().getConnection();
    }
    public void createTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Livre ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "titre VARCHAR(50), "
                + "auteur VARCHAR(10))";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table 'livre' created.");
        }
    }

    public void insertLivre(String titre, String auteur) throws SQLException {
        String insertSQL = "INSERT INTO Livre (Titre, Auteur) VALUES (?, ?)";
        try (PreparedStatement pstmt =
                     connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, titre);
            pstmt.setString(2, auteur);
            pstmt.executeUpdate();
            System.out.println("livre inserted.");
        }
    }
    public void selectLivres() throws SQLException {
        String selectSQL = "SELECT * FROM Livre";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                System.out.println("ID: " + id + ", titre: " + titre + ", auteur: " + auteur);
            }
        }
    }
    public void updateLivre(int id, String titre, String auteur)
            throws SQLException {
        String updateSQL = "UPDATE Livre SET titre = ?, auteur = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            pstmt.setString(1, titre);
            pstmt.setString(2, auteur);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Livre updated.");
        }
    }


        public void deleteLivre(int id) throws
        SQLException {
            String deleteSQL = "DELETE FROM Livre WHERE id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                System.out.println("Livre deleted.");
            }
        }
        public void researchLivre(String titre)throws
                SQLException{
                        String sql="SELECT*FROM livres WHERE titre= ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, titre);
                pstmt.executeUpdate();
                System.out.println("Livre found.");

        }
    }

    public void listerlivres()throws
            SQLException{
                    String sql= "SELECT*FROM livres WHERE titre like ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1,  "lettre" + "%");
            try(ResultSet rs= pstmt. executeQuery()){
                while(rs.next()){
                    String titre = rs.getString("titre");
                    String auteur= rs.getString("auteur");
                    System.out.println("titre: "+ titre + "auteur: "+ auteur);
                }
            }
        }
    }

    public void afficherlivres(String Categorie) throws
            SQLException{
        String sql= "SELECT*FROM livres WHERE Categorie= ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, Categorie);

            // Exécution de la requête
            try (ResultSet rs = pstmt.executeQuery()) {
                // Parcourir et afficher les résultats
                while (rs.next()) {
                    String titre = rs.getString("titre");
                    String auteur = rs.getString("auteur");
                    String CategorieLivres = rs.getString("categorie");
                    System.out.println("Titre: " + titre + ", Auteur: " + auteur + ", Catégorie: " + CategorieLivres);
                }
            }
        }
    }
    public void afficherDetail(int id)throws
            SQLException{
        String sql="SELECT * FROM livres WHERE id=?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            // Exécution de la requête
            try (ResultSet rs = pstmt.executeQuery()) {
                // Vérifier si le livre a été trouvé
                if (rs.next()) {
                    String titre = rs.getString("titre");
                    String auteur = rs.getString("auteur");
                    String categorie = rs.getString("categorie");
                    int anneePublication = rs.getInt("annee_publication");
                    float prix = rs.getFloat("prix");

                    // Affichage des détails du livre
                    System.out.println("Titre: " + titre);
                    System.out.println("Auteur: " + auteur);
                    System.out.println("Catégorie: " + categorie);
                    System.out.println("Année de publication: " + anneePublication);
                    System.out.println("Prix: " + prix);
                } else {
                    System.out.println("Aucun livre trouvé avec l'identifiant " + id);
                }
            }
        }
    }
}

