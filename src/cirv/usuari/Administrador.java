package cirv.usuari;

public class Administrador extends Usuari{



    public Administrador(String nomUsuari) {
        super(nomUsuari);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void demanaDades() {
        System.out.println("----------------------------------");
        System.out.println("-1 - Crear un post               -");
        System.out.println("-2 - Llistar tots els posts      -");
        System.out.println("-3 - Eliminar un post            -");
        System.out.println("-4 - Modificar un Lector a Editor-");
        System.out.println("-5 - Llistar editors             -");
        System.out.println("-6 - Llistar lectors             -");
        System.out.println("-0 - Log out                     -");
        System.out.println("----------------------------------");
    }

}