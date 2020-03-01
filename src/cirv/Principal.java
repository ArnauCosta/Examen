package cirv;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.time.LocalDate;
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

        // funciona tot el usuari administrador, i la creacio de usuaris, pero els
        // usuaris lectors i editors no poden fer res.

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
                    Usuari loginUsuari = Funcions.retornaUsuariPerNom(usuaris, userName);
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
                                                System.out.println(
                                                        (posts.indexOf(post) + 1) + " - " + post.mostraPostCurt());
                                            }
                                            System.out.print("Quin post vols borrar: ");
                                            posts.remove(sc.nextInt() - 1);
                                            sc.nextLine();

                                            break;
                                        case "4":

                                            for (Usuari usuari : usuaris) {
                                                if (usuari.getRol().equals("lec")) {
                                                    System.out.println(usuari.getNomUsuari());
                                                }
                                            }
                                            System.out.print("Escriu el username del usuari: ");
                                            String lectorPerEditor = sc.nextLine();
                                            Usuari lector = Funcions.retornaUsuariPerNom(usuaris, lectorPerEditor);

                                            // Editor nouEditor = (Editor) usuaris.get(usuaris
                                            // .indexOf(Funcions.retornaUsuariPerNom(usuaris, lectorPerEditor)));

                                            Editor nouEditor = new Editor(lectorPerEditor);
                                            nouEditor.setPassword(lector.getPassword());
                                            nouEditor.setUsuarisSeguits(lector.getUsuarisSeguits());
                                            nouEditor.setRol("edi");

                                            usuaris.remove(lector);
                                            usuaris.add(nouEditor);

                                            break;
                                        case "5":

                                            Funcions.printEditors(usuaris);

                                            break;
                                        case "6":
                                            for (Usuari usuari : usuaris) {
                                                if (usuari.getRol().equals("lec")) {
                                                    System.out.println(usuari.getNomUsuari());
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
                                            Funcions.printEditors(usuaris);
                                            String nomEditor;
                                            do {
                                                System.out.print("Escriu el nom del editor que vols seguir: ");
                                                nomEditor = sc.nextLine();
                                            } while (Funcions.comprovaExisteixElUsuari(usuaris, nomEditor));
                                            Usuari usuariPerSeguir = Funcions.retornaUsuariPerNom(usuaris, nomEditor);
                                            loginUsuari.seguirUsuari(usuariPerSeguir);

                                            break;
                                        case "2":

                                            loginUsuari.mostraEditorsSeguits();

                                            break;
                                        case "3":

                                            Funcions.mostraPostsDeEditorsSeguits(posts, loginUsuari);

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

                                    switch (sc.nextLine()) {
                                        case "1":
                                            Funcions.crearPost(posts, loginUsuari);
                                            break;

                                        case "2":

                                            Funcions.printEditors(usuaris);
                                            String nomEditor;
                                            do {
                                                System.out.print("Escriu el nom del editor que vols seguir: ");
                                                nomEditor = sc.nextLine();
                                            } while (!Funcions.comprovaExisteixElUsuari(usuaris, nomEditor));
                                            Usuari usuariPerSeguir = Funcions.retornaUsuariPerNom(usuaris, nomEditor);
                                            loginUsuari.seguirUsuari(usuariPerSeguir);

                                            break;

                                        case "3":
                                            loginUsuari.mostraEditorsSeguits();
                                            break;

                                        case "4":

                                            Funcions.mostraPostsDeEditorsSeguits(posts, loginUsuari);

                                            break;

                                        case "0":
                                            bucleUsuari = false;

                                            break;

                                        default:
                                            System.out.println("El valor entrat no es correcte");
                                            break;
                                    }

                                    break;

                                default:
                                    System.out.println("Error: Usuari sense rol");
                                    break;
                            }

                        }
                    } else {
                        System.out.println("Contrasenya incorrecte");
                    }
                    break;

                case "2":

                    String nom;
                    do {
                        System.out.print("Introdueix el nom que tindra el lector: ");
                        nom = sc.nextLine();
                    } while (Funcions.comprovaExisteixElUsuari(usuaris, nom));

                    Lector lectorNou = new Lector(nom);
                    System.out.print("Introdueix la contrasenya del lector: ");
                    lectorNou.setPassword(sc.nextLine());
                    System.out.print("Introdueix data de neixement del lector (12/1/2020): ");
                    String edatString[] = sc.nextLine().split("/");
                    int edatInt[] = Funcions.arrayDeStringAInt(edatString);
                    LocalDate neixament = LocalDate.of(edatInt[2], edatInt[1], edatInt[0]);
                    Period edat = Period.between(neixament, LocalDate.now());
                    if (edat.getYears() >= 18) {
                        lectorNou.setMajor(true);
                    } else {
                        lectorNou.setMajor(false);
                    }
                    lectorNou.setRol("lec");
                    ArrayList<Usuari> usuarisSeguits = new ArrayList<Usuari>();
                    lectorNou.setUsuarisSeguits(usuarisSeguits);
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