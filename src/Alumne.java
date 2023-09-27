public class Alumne {
    private String nom;

    public Alumne(){
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int examinar(){
        return (int)(Math.random() * 11);
    }
}
