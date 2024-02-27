package Practica5_gualpamathias;

//Clase atleta donde se crean los atributos 
public class Atleta {
    //generamos los atributos
    String nombr_atleta;
    String Pais;
    double tiempo;

    //Generamos el contrusctor 
    public Atleta(double tiempo,String nombr_atleta, String Pais ) {
        this.nombr_atleta = nombr_atleta;
        this.Pais = Pais;
        this.tiempo = tiempo;
    }   
}
