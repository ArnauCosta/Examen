package cirv;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.Period;
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


        //funciona tot el usuari administrador, i la creacio de usuaris, pero els usuaris lectors i editors no poden fer res.

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
                                    post.mostraPost();
                                }

                                break;
                            case "3":

                                for (Post post : posts) {
                                    System.out.println((posts.indexOf(post) + 1) + " - " + post.mostraPostCurt());
                                }
                                System.out.print("Quin post vols borrar: ");
                                posts.remove(sc.nextInt() - 1);
                                sc.nextLine();

                                break;
                            case "4":

                                for (Usuari usuari : usuaris) {
                                    if (usuari.getClass().toString().equals("Lector")) {
                                        System.out.println(usuari);
                                    }
                                }
                                System.out.print("Escriu el username del usuari: ");

                                usuaris.get(usuaris.indexOf(Funcions.retornaUsuariPelNom(usuaris, sc.nextLine())))
                                        .setRol("edi");

                                break;
                            case "5":

                                for (Usuari usuari : usuaris) {
                                    if (usuari.getClass().toString().equals("Editor")) {
                                        System.out.println(usuari);
                                    }
                                }

                                break;
                            case "6":
                                for (Usuari usuari : usuaris) {
                                    if (usuari.getClass().toString().equals("Lector")) {
                                        System.out.println(usuari);
                                    }
                                }
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

                            switch (sc.nextLine()) {
                            case "1":

                                break;
                            case "2":

                                break;
                            case "3":

                                break;
                            case "0":
                                bucleUsuari = false;

                                break;

                            default:
                                System.out.println("El valor entrat no es correcte");

                                break;
                            }

                            break;

                        case "edi":

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

                System.out.print("Introdueix el nom que tindra el lector: ");
                Lector lectorNou = new Lector(sc.nextLine());
                System.out.print("Introdueix la contrasenya del lector: ");
                lectorNou.setPassword(sc.nextLine());
                System.out.print("Introdueix data de neixement del lector (12/1/2020): ");
                String edatString[] = sc.nextLine().split("/");
                int edatInt[] = Funcions.arrayDeStringAInt(edatString);
                LocalDateTime edat = LocalDateTime.of(edatInt[2], edatInt[1], edatInt[0], 0, 0, 0);
                
                lectorNou.setRol("lec");
                usuaris.add(lectorNou);

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