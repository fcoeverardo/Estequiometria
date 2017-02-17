package quimica.ufc.br.estequiometria.models;

/**
 * Created by root on 29/03/16.
 */
public class Topic {
    private String title;
    private String description;

    public Topic(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
