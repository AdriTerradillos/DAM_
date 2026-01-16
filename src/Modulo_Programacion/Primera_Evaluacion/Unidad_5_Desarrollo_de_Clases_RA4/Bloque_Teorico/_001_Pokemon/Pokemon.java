package Modulo_Programacion.Primera_Evaluacion._01_POO.Teoria._001_Pokemon;

public class Pokemon {

    // *** Atributos => clase Pokemon ***
    private int codigo;
    private String nombre;
    private String[] tipo = new String[2];
    private int puntosVida;
    private Pokemon evolucion; // declaro e inicializo variable evolución en misma línea de código que clase privada


    // *** Constructor(es) ***

    // Primer constructor => pokemon's que SÍ evolucionan (2 tipos)
    public Pokemon(int cod, String nom, String tipo1, String tipo2) {
        this.codigo = cod;
        this.nombre = nom;
        this.tipo[0] = tipo1;
        this.tipo[1] = tipo2;
        this.puntosVida = (int) ((Math.random() * 51) + 50);
    }

    // Segundo constructor => pokemon's que NO evolucionan (1 tipo)
    public Pokemon(int cod, String nom, String tipo1) {
        this.codigo = cod;
        this.nombre = nom;
        this.tipo[0] = tipo1;
        this.puntosVida = (int) ((Math.random() * 51) + 50);
    }


    // invoco métodos para hacer llamamiento desde archivo 'pokemons.java'
    public void mostrar() {
        System.out.println("-----------------------");
        System.out.println(this.codigo + " " + this.nombre);

        if (this.tipo[1] == null)
            System.out.println("Tipos: " + this.tipo[0]);
        else
            System.out.println("Tipos: " + this.tipo[0] + ", " + this.tipo[1]);

        if (this.evolucion != null)
            System.out.println("\uD83D\uDCC8 Evoluciona en: " + this.evolucion.nombre);

        System.out.println("❤\uFE0F PV: " + this.puntosVida);
        System.out.println("-----------------------");
    }


    // 3º- getters & setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getTipo() {
        return tipo;
    }

    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public Pokemon getEvolucion() {
        return evolucion;
    }

    public void setEvolucion(Pokemon evolucion) {
        this.evolucion = evolucion;
    }


    public Pokemon evoluciona() {
        Pokemon pokemon = this;

        if (this.evolucion == null)
            System.out.println("Este pokemon no sabe evolucionar");
        else
            pokemon = this.evolucion;

        return pokemon;
    }


    public Pokemon combateContra(Pokemon atacado) {

        if (this.puntosVida <= 0) {
            System.out.println("Un pokemon sin PV no puede combatir");
            return this; // obligatorio devolver algo
        }

        System.out.println("\uD83E\uDD4A Comienza el combate entre " + this.nombre + " y " + atacado.nombre);
        System.out.println("-------------------------------");


        // bucle del combate (incluir while)
        while (this.puntosVida > 0 && atacado.puntosVida > 0) {

            // este pokemon ataca primero...
            int danyo = (int) ((Math.random() * 51) + 25);
            atacado.puntosVida -= danyo;

            System.out.println(this.nombre + " ataca y causa " + danyo + " puntos de daño a " + atacado.nombre);
            System.out.println("❤\uFE0F PV de " + atacado.nombre + ": " + Math.max(atacado.puntosVida, 0));
            System.out.println();


            // ¿ ha sido derrotado el pokemon atacado? (atacado.nombre)
            if (atacado.puntosVida <= 0) {
                System.out.println(atacado.nombre + " ha sido derrotado");
                System.out.println();

                return this; // este pokemon es el que gana (this.nombre win)
            }


            // el otro pokemon responde al ataque...
            danyo = (int) ((Math.random() * 51) + 25);
            atacado.puntosVida -= danyo;

            System.out.println(atacado.nombre + " contraataca y causa " + danyo + " puntos de daño a " + this.nombre);
            System.out.println("❤\uFE0F PV de " + this.nombre + ": " + Math.max(this.puntosVida, 0));
            System.out.println();

            // ¿ha sido derrotado este pokemon? (this.nombre)
            System.out.println(this.nombre + " ha sido derrotado");
            System.out.println();

            return atacado;  // el pokemon oponente gana (atacado.nombre win)
        }

        System.out.println("-------------------------------");


        return this;
    }
}