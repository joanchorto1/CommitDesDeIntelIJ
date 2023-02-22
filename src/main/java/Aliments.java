public class Aliments {

    int quantitat;
    String nom;


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public String getNom() {
        return nom;
    }
    @Override
    public String toString() {
        return "Aliment{" +
                "nom='" + nom + '\'' +
               "quantitat="+quantitat+
                '}';
    }

    //CONSTRUCTOR
    public Aliments(){
        this.nom=nom;
        this.quantitat=quantitat;
    }

}
