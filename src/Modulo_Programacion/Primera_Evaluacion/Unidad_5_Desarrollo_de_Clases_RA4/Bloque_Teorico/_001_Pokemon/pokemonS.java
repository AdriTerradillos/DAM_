package Modulo_Programacion.Primera_Evaluacion._01_POO.Teoria._001_Pokemon;

public class pokemonS {

    public static void main(String[] args) {

        Pokemon p1 = new Pokemon(1, "Bulbasaur", "Planta");
        Pokemon p2 = new Pokemon(6, "Charizard", "Fuego", "Volador"); // la evolución de Charizard apunta a null => ver archivo 'Pokemon.java'
        Pokemon p3 = new Pokemon(2, "Ivysaur", "Planta");


        p1.mostrar(); // => resultado por pantalla antes de la evolución. 'Bulbasaur es Bulbasaur'
        p2.mostrar(); // => resultado por pantalla 'Charizard es Charizard'



        // evolución de pokemon 'Bulbasaur' => 'Ivysaur'

        p1.setEvolucion(p3);  // determina la evolución de Bulbasaur a Ivysaur
        // p1 = p1.evoluciona(); ==> una vez 'Bulbasaur' apunta a 'Ivysaur', relaciono primer elemento con evoluciona
        p1.mostrar();   // muestro en pantalla el resultado



        // pokemon que NO evoluciona, valor p2 => valor null en archivo p2 archivo 'Pokemon.java'
        p2 = p2.evoluciona();
        p2.mostrar();



        // genero un 4 pokemon
        Pokemon p4 = new Pokemon(25, "Pikachu", "Eléctrico");



        // vamos a ejecutar un combate entre los pokemons mencionados...

        p4.combateContra(p2);
        p1.combateContra(p4);
        p2.mostrar();
        p4.mostrar();
        p1.mostrar();


    }
}
