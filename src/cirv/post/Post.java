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

    public void mostraPost() {
        System.out.println("###############################");
        System.out.println("Data: "+this.dataPost);
        System.out.println("Autor: "+this.editor.getNomUsuari());   
        System.out.println("+ 18? "+this.contingutMajor);
        System.out.println("Titol: "+this.titol);
        System.out.println("Contingut: "+this.contingut);
        System.out.println("###############################");  
    }

    public String mostraPostCurt() {
        return "Data: "+this.dataPost+" Autor: "+this.editor.getNomUsuari()+" Titol: "+this.titol;
    }

    

}