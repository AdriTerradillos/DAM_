package Modulo_Programacion.Primera_Evaluacion._01_POO.Teoria.porMiCuenta._001_LigaFutbol;

import javax.xml.transform.Source;

public class LigaEspanyola {

    // *** Atributos ***

    private String equipo;
    private String[] continente = new String[5];
    private String jugador;
    private String[] posicion = new String[11];
    private int mediaFutbolista;
    private String[] piernaGolpeo = new String[2];


    // *** Constructor(es) ***

    // Primer constructor
    public LigaEspanyola(String eq, String cont1, String cont2, String cont3, String cont4,
                         String cont5, String jug, String pos1, String pos2, String pos3, String pos4,
                         String pos5, String pos6, String pos7, String pos8, String pos9, String pos10,
                         String pos11, String pos12, String med, String pGolp) {
        this.equipo = eq;
        this.continente[0] = cont1;
        this.continente[1] = cont2;
        this.continente[2] = cont3;
        this.continente[3] = cont4;
        this.continente[4] = cont5;
        this.jugador = jug;
        this.posicion[0] = pos1;
        this.posicion[1] = pos2;
        this.posicion[2] = pos3;
        this.posicion[3] = pos4;
        this.posicion[4] = pos5;
        this.posicion[5] = pos6;
        this.posicion[6] = pos7;
        this.posicion[7] = pos8;
        this.posicion[8] = pos9;
        this.posicion[9] = pos10;
        this.posicion[10] = pos11;

    }

    public mostrar() {

        System.out.println("---------------------------");
        System.out.println(this.equipo + " " + this.jugador);

        if (this.continente)
    }


}
