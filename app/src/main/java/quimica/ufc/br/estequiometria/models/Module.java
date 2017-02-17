package quimica.ufc.br.estequiometria.models;

import android.graphics.drawable.Drawable;

/**
 * Created by root on 21/03/16.
 */
public class Module {
    private String name;
    private String description;
    private Drawable image;

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Drawable getImage(){
        return this.image;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setImage(Drawable image){
        this.image = image;
    }

}
