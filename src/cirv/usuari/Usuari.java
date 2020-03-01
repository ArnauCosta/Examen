package cirv.usuari;

import java.util.ArrayList;


public abstract class Usuari {

    protected String nomUsuari, password, rol;
    protected ArrayList<Usuari> usuarisSeguits;


    public Usuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
    

    public abstract void demanaDades();

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ArrayList<Usuari> getUsuarisSeguits() {
        return usuarisSeguits;
    }

    public void setUsuarisSeguits(ArrayList<Usuari> usuarisSeguits) {
        this.usuarisSeguits = usuarisSeguits;
    }

    public void seguirUsuari(Usuari usuariPerSeguir) {
        this.usuarisSeguits.add(usuariPerSeguir);
    }


    public void mostraEditorsSeguits() {
        for (Usuari usuari : this.usuarisSeguits) {
            System.out.println(usuari.getNomUsuari());
        }
    }

}