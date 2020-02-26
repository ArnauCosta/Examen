package cirv.post;

import java.time.LocalDateTime;

import cirv.usuari.Usuari;

public class Post {

    private String titol, contingut;
    private boolean contingutMajor;
    private LocalDateTime dataPost;
    private Usuari editor;

    public Post(String titol) {
        this.titol = titol;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getContingut() {
        return contingut;
    }

    public void setContingut(String contingut) {
        this.contingut = contingut;
    }

    public boolean isContingutMajor() {
        return contingutMajor;
    }

    public void setContingutMajor(boolean contingutMajor) {
        this.contingutMajor = contingutMajor;
    }

    public LocalDateTime getDataPost() {
        return dataPost;
    }

    public void setDataPost(LocalDateTime dataPost) {
        this.dataPost = dataPost;
    }

    public Usuari getEditor() {
        return editor;
    }

    public void setEditor(Usuari editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "###############################"+
                "Data: "+this.dataPost+"\r"+
                "Autor: "+this.editor.getNomUsuari()+"\r"+
                "+ 18? "+this.contingutMajor+"\r"+
                "Titol: "+this.titol + "\r" +
                "Contingut: "+this.contingut+
                "###############################";
    }

    public String toStringCurt() {
        return "###############################"+
                "Data: "+this.dataPost+"\r"+
                "Autor: "+this.editor.getNomUsuari()+"\r"+
                "+ 18? "+this.contingutMajor+"\r"+
                "Titol: "+this.titol + "\r" +
                "Contingut: "+this.contingut+
                "###############################";
    }

    

}