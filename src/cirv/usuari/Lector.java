package cirv.usuari;

public class Lector extends Usuari{


    private boolean major;

    public Lector(String nomUsuari) {
        super(nomUsuari);
    }

    @Override
    public void demanaDades() {
        System.out.println("------------------------------------");
        System.out.println("-1 - Seguir a un editor nou        -");
        System.out.println("-2 - Veure els editors que segueixo-");
        System.out.println("-3 - Mirar el teu mur              -");
        System.out.println("-0 - Log out                       -");
        System.out.println("------------------------------------");
    }

    public boolean isMajor() {
        return major;
    }

    public void setMajor(boolean major) {
        this.major = major;
    }

    public void calculaMajoria(boolean major) {

        this.major = major;
    }


}