package Modulo_Programacion.Primera_Evaluacion._01_POO.Teoria._000_ejercicioInicial;

public class Persona {

    // atributos de Persona
    private String nombre;
    private String apellidos;
    private int edad;


    /* *** Contructor(es)  ==> inicializo los atributos, genero una nueva referencia que
                           apunte a los mismos */

    // primer constructor para persona1
    public Persona (String nom, String ape) {
        this.nombre = nom;
        this.apellidos = ape;
        this.edad = 0;
    }

    // segundo constructor para persona2
    public Persona (String nom, String ape, int edad) {
        this.nombre = nom;
        this.apellidos = ape;
        this.edad = edad;
    }



    // ingreso los métodos de clase Persona ==> forma de clases

    public void incrementaEdad() {
        this.edad++; // hacemos llamamiento al atributo edad 'como si fuera un contador'
    }


    public void mostrar() {
        System.out.println(this.apellidos + " " + this.nombre);
    }

}
