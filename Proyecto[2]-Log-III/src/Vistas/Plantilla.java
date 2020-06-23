package Vistas;

public class Plantilla {
    public static final String AMARILLO = "\u001B[33m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String ITALICA = "\u001B[3m";
    public static final String NEGRITA = "\u001B[1m";
    public static final String RESET = "\u001B[0m";

    public void menu(String titulo, String descripcion, String[] opciones) {
        int n = 0;
        if(opciones != null){
            n = opciones.length;
        }
        System.out.println(AMARILLO + titulo + RESET + " | " + MORADO + descripcion + RESET);
        for (int i = 1; i <= n; i++) {
            System.out.println(AMARILLO + i + ". " + RESET + opciones[i - 1] + RESET);
        }
        this.defecto(0);
    }

    /**
     * @param id 0: Ingresar S
     */
    public void input(int id){
    switch (id){
            case 0: {
                System.out.print(VERDE + "S = " + RESET);
                break;
            }}
    }

    /**
     * @param id 0: Lg build
     */
    public void acierto(int id) {
        switch (id) {
            case 0: {
                System.out.println(VERDE + "¡La lista generalizada fue creada correctamente!" + RESET);
                break;
            }
        }
    }

    /**
     * @param id 0: Lg build
     */
    public void desacierto(int id) {
        switch (id) {
            case 0: {
                System.out.println(ROJO + "¡La lista generalizada no fue creada!" + RESET);
                break;
            }
        }
    }

    /**
     * @param id 0: Respuesta fuera de rango, 1: Respuesta no numérica, 2: Respuesta negativa, 3: Cadena inválida
     */
    public void error(int id) {
        switch (id) {
            case 0: {
                System.out.println(ROJO + "La respuesta no esta en el rango de opciones. Intenta otra vez." + RESET);
                break;
            }
            case 1: {
                System.out.println(ROJO + "La respuesta debe ser numérica. Intenta otra vez." + RESET);
                break;
            }
            case 2: {
                System.out.println(ROJO + "La respuesta debe ser positiva. Intenta otra vez." + RESET);
                break;
            }
            case 3: {
                System.out.println(ROJO + "¡La cadena no tiene el formato correcto!" + RESET);
                break;
            }
        }
    }

    /*
     *
     * @param id 0: Salir, 1: Regresar, 2: Despedida
     */
    public void defecto(int id){
        switch (id){
            case 0: {
                System.out.println(ROJO + "0. Salir" + RESET);
                break;
            }
            case 1: {
                System.out.println(ROJO + "0. Regresar" + RESET);
                break;
            }
            case 2: {
                System.out.println(AMARILLO + "Adiós\t\t\t" + ITALICA + MORADO + "by: JuanZea" + RESET);
                break;
            }
        }
    }
}
