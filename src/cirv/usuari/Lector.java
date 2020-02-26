package cirv.usuari;

public class Lector extends Usuari{


    private boolean major;

    public Lector(String nomUsuari) {
        super(nomUsuari);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void demanaDades() {
        // TODO Auto-generated method stub

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