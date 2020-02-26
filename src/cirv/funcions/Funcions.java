package cirv.funcions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import cirv.post.Post;
import cirv.usuari.Usuari;

public class Funcions {
    static Scanner sc = new Scanner(System.in);


    public static void printLogin() {
        System.out.println("---------------------------------");
        System.out.println("- 1 - Login                     -");
        System.out.println("- 2 - Registre com a lector     -");
        System.out.println("- 3 - Sortir                    -");
        System.out.println("---------------------------------");
    }

    public static Usuari buscaUsuariPerNom(ArrayList<Usuari> usuaris, String userName) {
        for (Usuari usuari : usuaris) {
            if (usuari.getNomUsuari().equals(userName)) {
                return usuari;
            }
        }
        return null;
    }

    public static void crearPost(ArrayList<Post> posts, Usuari loginUsuari) {
        System.out.print("Escriu el titol del post: ");
        Post nouPost = new Post(sc.nextLine());
        System.out.print("Escriu el contingut del post: ");
        nouPost.setContingut(sc.nextLine());
        System.out.print("El post te contingut per adults S/N: ");
        if (sc.nextLine().equalsIgnoreCase("S")) {
            nouPost.setContingutMajor(true);
        } else{
            nouPost.setContingutMajor(false);
        }
        nouPost.setDataPost(LocalDateTime.now());
        nouPost.setEditor(loginUsuari);
        posts.add(nouPost);
    }

    public static Usuari retornaUsuariPelNom(ArrayList<Usuari> usuaris, String nom) {

        for (Usuari usuari : usuaris) {
            if(usuari.getNomUsuari().equals(nom)){
                return usuari;
            }
        }
        return null;

    }

    public static int[] arrayDeStringAInt(String[] dia) {
        int[] arrayInt = new int[dia.length];
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = Integer.parseInt(dia[i]);
        }
        return arrayInt;
    }

    
}