package Modulo_Programacion.Primera_Evaluacion._01_POO.Teoria._000_ejercicioInicial;

public class grupoPersonas {

    /*
        1º- hasta este momento, no me devuelve nada del script 'Persona'
            con la palabra inicial Persona, hacemos llamamiento al constructor del script
           'Persona.java'
     */

    public static void main(String[] args) {


        Persona persona1 = new Persona("Lucía", "Sanz");
        persona1.mostrar();


      /*
            genero e inicializo una segunda variable Persona.
            en este caso, no devuelve nada ya que no apunta al contructor
            'Persona.java'
        */


        Persona persona2;
        persona2 = new Persona("Pepe", "Potamo", 57);
        persona2.mostrar();

        // ahora persona2 no apunta a nada
        persona2 = null;



        /* si ejecuto despues de este comando
           persona2.mostrar();
           no funciona, deja de apuntar a Persona
        */

    }
}







