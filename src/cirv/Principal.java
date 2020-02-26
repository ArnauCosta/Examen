package cirv;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import cirv.usuari.*;
import cirv.funcions.*;
import cirv.post.*;

public class Principal {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuari> usuaris = new ArrayList<Usuari>();
        ArrayList<Post> posts = new ArrayList<Post>();

        System.out.print("Introdueix el nom que tindra el usuari amb rol d'administrador: ");
        Administrador admin = new Administrador(sc.nextLine());
        System.out.print("Introdueix la contrasenya del usuari administrador: ");
        admin.setPassword(sc.nextLine());
        admin.setRol("admin");
        usuaris.add(admin);

        boolean bucleLogin = true;
        while (bucleLogin) {

            Funcions.printLogin();
            System.out.print("Opcio: ");
            String opcioLogin = sc.nextLine();

            switch (opcioLogin) {
            case "1":
                System.out.print("Introdueix el teu username: ");
                String userName = sc.nextLine();
                Usuari loginUsuari = Funcions.buscaUsuariPerNom(usuaris, userName);
                System.out.print("Introdueix el teu password: ");
                String password = sc.nextLine();
                if (userName.equals(null)) {
                    System.out.println("El usuari no existeix");
                    break;
                }

                if (loginUsuari.getNomUsuari().equals(userName) && loginUsuari.getPassword().equals(password)) {
                    boolean bucleUsuari = true;
                    while (bucleUsuari) {
                        loginUsuari.demanaDades();
                        System.out.print("Accio: ");
                        switch (loginUsuari.getRol()) {
                        case "admin":

                            switch (sc.nextLine()) {
                            case "1":

                                Funcions.crearPost(posts, loginUsuari);

                                break;
                            case "2":

                                for (Post post : posts) {
                                    post.toString();
                                }

                                break;
                            case "3":

                            

                                break;
                            case "4":

                                break;
                            case "5":

                                break;
                            case "6":

                                break;

                            case "0":
                                bucleUsuari = false;
                                break;

                            default:
                                System.out.println("El valor entrat no es correcte");
                                break;
                            }

                            break;

                        case "lec":

                            break;

                        case "esc":

                            break;

                        default:
                            System.out.println("Error: el usuari no te un rol assignat");
                            break;
                        }

                    }
                } else {
                    System.out.println("Contrasenya incorrecte");
                }
                break;

            case "2":

                break;

            case "3":
                bucleLogin = false;
                break;

            default:
                System.out.println("Opcio no valida");
                break;
            }

        }

    }
}