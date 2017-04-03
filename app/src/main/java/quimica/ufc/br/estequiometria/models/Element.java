package quimica.ufc.br.estequiometria.models;

/**
 * Created by root on 01/05/16.
 */
public class Element {

    private String name;
    private String result;
    private double mass;
    private int number;

    public static double MOLARMASS = 0.0;

    public Element(String name,double mass,int number,String result){
        this.name = name;
        this.result = result;
        this.mass = mass;
        this.number = number;
        Element.MOLARMASS += mass*number;
    }

    public Element(){

    }

    public Element(String name,double mass,int number){
        this.name = name;
        this.mass = mass;
        this.number = number;
        Element.MOLARMASS += mass*number;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    public double getMass() {
        return mass;
    }

    public int getNumber() {
        return number;
    }

    public static double getMOLARMASS() {
        return MOLARMASS;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static void setMOLARMASS(double MOLARMASS) {
        Element.MOLARMASS = MOLARMASS;
    }
}
