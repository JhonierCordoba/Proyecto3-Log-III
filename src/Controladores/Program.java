package Controladores;

import Modelo.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author JuanZea
 */
public class Program {
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        menu();
        // Generadores ---------------------------------------------------
        // MatrizEnTripletas m = ingresoManual_MatrizEnTripletas_Automatico();
        // testMatrizEnTripletas(); + Transpuesta + SumaSI + SumaID
        // testMatrizEnForma1();
        // testMatrizEnForma2();

        // Métodos -------------------------------------------------------

        // Imprime
        // m.imprimeMatriz();
        // Muestra
        // m.muestraMatrizEnTripletas();
        // Transpuesta
        // m = transpuesta(m);
        // Imprime
        // m.imprimeMatriz();
        // Muestra
        // m.muestraMatrizEnTripletas();
    }

    public static void menu() {
        // Inicialización
        Configuracion conf = new Configuracion();
        conf.plantilla("inicio");
        do {
            conf.plantilla("principal");
            int ans = conf.escuchar(4);
            switch (ans) {
                default: {
                    continue;
                }
                case 0: {
                    break;
                }
                case 1: {
                    // Crear matriz
                    conf.crear();
                    continue;
                }
                case 2: {
                    // Ver matrices
                    conf.ver();
                    continue;
                }
                case 3: {
                    // Configuración
                    conf.operar();
                    continue;
                }
                case 4: {
                    // Configuración
                    conf.actualizar();
                    continue;
                }
            }
            break;
        } while (true);
        conf.plantilla("despedida");
    }
}