package cirv.usuari;

public class Editor extends Usuari{

    public Editor(String nomUsuari) {
        super(nomUsuari);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void demanaDades() {
        System.out.println("------------------------------------");
        System.out.println("-1 - Crear un post                 -");
        System.out.println("-2 - Seguir un editor nou          -");
        System.out.println("-3 - Veure els editors que segueixo-");
        System.out.println("-4 - Mirar el teu mur              -");
        System.out.println("-0 - Log out                       -");
        System.out.println("------------------------------------");
    }

    

}