// Classe LivreRoman
class LivreRoman extends Livre {
    public LivreRoman(String titre, String auteur) {
        super(titre, auteur);
    }

    @Override
    public String getCategorie() {
        return "Roman";
    }
}
