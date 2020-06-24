package Controladores;

import Vistas.Plantilla;

import java.util.Scanner;

public class GestionRespuestas {
    private Plantilla plantilla = new Plantilla();

    public String escuchar() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int escuchar_opciones(Integer opciones) {
        Scanner sc = new Scanner(System.in);
        int ans;
        // Restricciones
        try {
            ans = Integer.parseInt(sc.nextLine());
            if (ans < 0 || ans > opciones) {
                this.limpiar();
                this.plantilla.error(0);
                return -1;
            }
        } catch (NumberFormatException e) {
            this.limpiar();
            this.plantilla.error(1);
            return -1;
        }
        this.limpiar();
        return ans;
    }

     public String escuchar_nombre(){
        this.plantilla.menu("Crear Lista Generalizada", "Póngale nombre a la lista", null);
        this.plantilla.input(0, null);
        String nom = this.escuchar();
        if (nom.equals("0")) {
            this.limpiar();
            this.plantilla.desacierto(0);
            return null;
        }
        this.limpiar();
        return nom;
    }

    public void limpiar() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    } // Original

    public boolean validar(String s) {
        /* Aquí quizás haga un método que verifique
        la correcta sintaxis de la entrada S para construir
        una lista generalizada, por ahora no hará nada*/
        return true;
    }
}
