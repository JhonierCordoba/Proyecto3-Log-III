package Root;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author JuanZea
 */
public class Program {
    public static final String NEGRO = "\u001B[30m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
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
        System.out.println(AMARILLO + "******************");
        System.out.println(RESET + "MATRICES DISPERSAS");
        System.out.println(AMARILLO + "******************" + RESET);
        int[] configuracion = {1, 2, 1};
        do {
            // Opciones
            System.out.println(AMARILLO + "Menu Principal" + RESET);
            System.out.println("1. Crear matriz");
            System.out.println("2. Configuración");
            System.out.println(ROJO + "0. Salir" + RESET);
            int ans = recogerAns(2);
            switch (ans) {
                default: {
                    continue;
                }
                case 0: {
                    break;
                }
                case 1: {
                    crearMatriz(configuracion[0], configuracion[1], configuracion[2]);
                    continue;
                }
                case 2: {
                    // Configuración
                    configuracion = oConfiguracion(configuracion);
                    continue;
                }
            }
            break;
        } while (true);
        System.out.println(AMARILLO + "Adiós");
    }

    public static void crearMatriz(int tipo, int mGeneracion, int mDimension) {
        if (mDimension == 1) {
            int[] dim = pedirDimension();
        }
        switch (tipo) {

        }
    }

    public static int[] oConfiguracion(int[] configuracion) {
        do {
            // Opciones
            System.out.println(AMARILLO + "Configuración" + RESET);
            System.out.println("1. Establecer tipo de matriz");
            System.out.println("2. Establecer modo de generación de matriz");
            System.out.println("3. Establecer modo de dimensión de matriz");
            System.out.println("4. Establecer configuración predeterminada");
            System.out.println(ROJO + "0. Volver (Menu principal)" + RESET);
            int ans = recogerAns(4);
            switch (ans) {
                default: {
                    break;
                }
                case 1: {
                    // Tipo
                    int tipo = oTipo();
                    if (tipo != 0) {
                        configuracion[0] = tipo;
                    }
                    continue;
                }
                case 2: {
                    // Modo de generación
                    int mGeneracion = oModoGeneracion();
                    if (mGeneracion != 0) {
                        configuracion[1] = mGeneracion;
                    }
                    continue;
                }
                case 3: {
                    // Modo de dimensión
                    int mDimension = oModoDimension();
                    if (mDimension != 0) {
                        configuracion[2] = mDimension;
                    }
                    continue;
                }
                case 4: {
                    // Configuración predeterminada
                    configuracion = new int[]{1, 2, 1};
                }
            }
            break;
        } while (true);
        return configuracion;
    }

    public static int oTipo() {
        // Opciones
        int ans;
        do {
            System.out.print(AMARILLO + "Menu: Tipo de matriz" + RESET + " | ");
            System.out.println(MORADO + "Elija un tipo de matriz" + RESET);
            System.out.println("1. Matriz en tripletas");
            System.out.println("2. Matriz en forma 1");
            System.out.println("3. Matriz en forma 2");
            System.out.println(ROJO + "0. Volver (Configuración)" + RESET);
            ans = recogerAns(3);
        } while (ans == -1);
        return ans;
    }

    public static int oModoGeneracion() {
        // Opciones
        int ans;
        do {
            System.out.print(AMARILLO + "Menu: Modo de generación" + RESET + " | ");
            System.out.println(MORADO + "Elija un modo de generación de matriz" + RESET);
            System.out.println("1. Ingresar manualmente los datos de la matriz");
            System.out.println("2. Generar datos aleatorios");
            System.out.println(ROJO + "0. Volver (Configuración)" + RESET);
            ans = recogerAns(2);
        } while (ans == -1);
        return ans;
    }

    public static int oModoDimension() {
        // Opciones
        int ans;
        do {
            System.out.print(AMARILLO + "Menu: Modo de dimensión" + RESET + " | ");
            System.out.println(MORADO + "Elija un método para generar el tamaño de la matriz" + RESET);
            System.out.println("1. Ingresar tamaño manualmente");
            System.out.println("2. Generar tamaño automáticamente");
            System.out.println(ROJO + "0. Volver (Configuración)" + RESET);
            ans = recogerAns(2);
        } while (ans == -1);
        return ans;
    }

    public static int[] pedirDimension() {
        Scanner sc = new Scanner(System.in);
        int[] dim = new int[2];
        System.out.println(ROJO + "0. Volver (Menu principal)");
        int ans = 0;
        String eje = "filas";
        do {
            System.out.print(VERDE + "Ingrese la cantidad de " + eje + ": ");
            try {
                ans = Integer.parseInt(sc.nextLine());
                if (ans < 0) {
                    limpiar();
                    System.out.println(ROJO + "La respuesta debe ser mayor a cero (0). Intenta otra vez." + RESET);
                    continue;
                }
            } catch (NumberFormatException e) {
                limpiar();
                System.out.println(ROJO + "La respuesta debe ser numérica. Intenta otra vez." + RESET);
                continue;
            }
            if (ans == 0) {
                break;
            }
            if (eje.equals("filas")) {
                dim[0] = ans;
                eje = "columnas";
            } else {
                dim[1] = ans;
                limpiar();
                return dim;
            }
        } while (true);
        limpiar();
        return null;
    }

    public static int recogerAns(int opciones) {
        int ans;
        Scanner sc = new Scanner(System.in);
        // Restricciones
        try {
            ans = Integer.parseInt(sc.nextLine());
            if (ans < 0 || ans > opciones) {
                limpiar();
                System.out.println(ROJO + "La respuesta no esta en el rango de opciones. Intenta otra vez." + RESET);
                return -1;
            }
        } catch (NumberFormatException e) {
            limpiar();
            System.out.println(ROJO + "La respuesta debe ser numérica. Intenta otra vez." + RESET);
            return -1;
        }
        limpiar();
        return ans;
    }

    public static void limpiar() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static MatrizEnTripletas transpuesta(MatrizEnTripletas m) {
        return m.transpuesta();
    }

    public static MatrizEnTripletas ingresoManual_MatrizEnTripletas_Automatico() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tripleta> datos = new ArrayList<Tripleta>();
        System.out.println("BIENVENIDO\nIngrese un dato para guardar en la matriz ('*' para finalizar):");
        String ans;
        Tripleta t;
        int fila, columna;
        Object valor;
        do {
            System.out.print("Fila:");
            ans = sc.nextLine();
            if (!ans.equals("*")) {
                try {
                    fila = Integer.parseInt(ans);
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("La fila debe ser un número entero.");
                    continue;
                }
            } else {
                break;
            }
            System.out.print("Columna:");
            ans = sc.nextLine();
            if (!ans.equals("*")) {
                try {
                    columna = Integer.parseInt(ans);
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("La columna debe ser un número entero.");
                    continue;
                }
            } else {
                break;
            }
            System.out.print("Valor:");
            ans = sc.nextLine();
            valor = (Object) ans;
            t = new Tripleta(fila, columna, valor);
            datos.add(t);
            System.out.println("Ingrese el siguiente dato:");
        } while (!ans.equals("*"));
        System.out.println("Datos añadidos.");
        sc.close();
        // MatrizEnTripletas m = new MatrizEnTripletas(10, 10); // Constructor (int m,
        // int n)
        int[] dim = calcularTamaño(datos);
        t = new Tripleta(dim[0], dim[1], 0);
        MatrizEnTripletas m = new MatrizEnTripletas(t); // Constructor(Tripleta t)
        for (int i = 0; i < datos.size(); i++) {
            m.insertaTripleta_v2(datos.get(i));
        }
        // m.imprimeMatriz();
        // m.muestraMatrizEnTripletas();
        // MatrizEnTripletas mt = m.transpuesta();
        // mt.imprimeMatriz();
        // mt.muestraMatrizEnTripletas();
        return m;
    }

    public static void testMatrizEnTripletas() {
        ArrayList<Tripleta> datosR = generarTripletas(3, 3, 3);
        /*
         * MatrizEnTripletas m = new MatrizEnTripletas(10, 10); // Contructor (int m,
         * int n)
         */
        MatrizEnTripletas m = new MatrizEnTripletas(datosR.get(0)); // constructor(Tripleta t)
        for (int i = 1; i < datosR.size(); i++) {
            m.insertaTripleta_v2(datosR.get(i));
        }
        m.imprimeMatriz();
        m.muestraMatrizEnTripletas();
        // Suma de triangulares
        int sum = m.sumarTriangular_SupI();
        System.out.println(sum);
        sum = m.sumarTriangular_InfD();
        System.out.println(sum);
        // Transpuesta
        MatrizEnTripletas mt = m.transpuesta();
        mt.imprimeMatriz();
        mt.muestraMatrizEnTripletas();
    }

    public static void testMatrizEnForma1() {
        ArrayList<Tripleta> datosR = generarTripletas(4, 5, 5);
        MatrizEnForma1 m = new MatrizEnForma1(4, 5);
        m.contruyeNodosCabeza(); // Porque no se añade esta instrucción al constructor?
        for (int i = 1; i < datosR.size(); i++) {
            NodoDoble x = new NodoDoble(datosR.get(i));
            m.conectaPorFilas(x);
            m.conectaPorColumnas(x);
        }
        m.recorrePorFilas();
        m.recorrePorColumnas();
    }

    public static void testMatrizEnForma2() {
        ArrayList<Tripleta> datosR = generarTripletas(3, 3, 3);
        MatrizEnForma2 m = new MatrizEnForma2(3, 3);
        for (int i = 1; i < datosR.size(); i++) {
            NodoDoble x = new NodoDoble(datosR.get(i));
            m.conectaPorFilas(x);
            m.conectaPorColumnas(x);
        }
        m.muestraMatriz();
    }

    public static int[] calcularTamaño(ArrayList<Tripleta> datos) {
        int f = 0;
        int c = 0;
        int[] dim = new int[2];
        for (Tripleta tripleta : datos) {
            f = f > tripleta.retornaFila() ? f : tripleta.retornaFila();
        }
        for (Tripleta tripleta : datos) {
            c = c > tripleta.retornaColumna() ? c : tripleta.retornaColumna();
        }
        dim[0] = f;
        dim[1] = c;
        return dim;
    }

    public static ArrayList<Tripleta> generarTripletas(int f, int c, int n) {
        ArrayList<Tripleta> datosR = new ArrayList<Tripleta>();
        Random rnd = new Random();
        int fila, columna, valor;
        Tripleta t = new Tripleta(f, c, 0);
        datosR.add(t);
        for (int i = 0; i < n; i++) {
            fila = rnd.nextInt(f) + 1;
            columna = rnd.nextInt(c) + 1;
            valor = rnd.nextInt(1000);
            t = new Tripleta(fila, columna, valor);
            if (repetido(datosR, t)) {
                i--;
                continue;
            }
            datosR.add(t);
        }
        return datosR;
    }

    public static boolean repetido(ArrayList<Tripleta> datosR, Tripleta t) {
        for (Tripleta tripleta : datosR) {
            if (tripleta.retornaFila() == t.retornaFila() && tripleta.retornaColumna() == t.retornaColumna()) {
                return true;
            }
        }
        return false;
    }
}