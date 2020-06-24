package Controladores;

import Modelos.ListaGeneralizada;
import Vistas.Plantilla;

public class Menu {

    Inventario inv = new Inventario();
    private GestionRespuestas gr = new GestionRespuestas();
    private Plantilla plantilla = new Plantilla();


    public void principal() {
        int ans;
        String[] opciones = {"Crear", "Mostrar","Copiar"};
        do {
            this.plantilla.menu("MENU PRINCIPAL", "Bienvenido", opciones);
            ans = gr.escuchar_opciones(opciones.length);
            if (ans == 0) {
                break;
            }
            if (ans == -1) {
                continue;
            }
            switch (ans) {
                case 1: {
                    this.crear();
                    break;
                }
                case 2: {
                    this.mostrar();
                    break;
                }
                case 3: {
                    this.copiar();
                    break;
                }
            }
        } while (true);
        this.plantilla.defecto(2);
    }

    public void crear() {
        int ans;
        String[] opciones = {"Lista generalizada", "Árbol ene-ario", "Árbol binario"};
        do {
            this.plantilla.menu("Crear", "Seleccione que lo que quiera crear", opciones);
            ans = gr.escuchar_opciones(opciones.length);
            if (ans == 0) {
                break;
            }
            if (ans == -1) {
                continue;
            }
            switch (ans) {
                case 1: {
                    this.crear_lg();
                    break;
                }
            }
        } while (true);
    }

    public void mostrar() {
        int ans;
        String[] opciones = {"Lista generalizada", "Árbol ene-ario", "Árbol binario"};
        do {
            this.plantilla.menu("Crear", "Seleccione que lo que quiera mostrar", opciones);
            ans = gr.escuchar_opciones(opciones.length);
            if (ans == 0) {
                break;
            }
            if (ans == -1) {
                continue;
            }
            switch (ans) {
                case 1: {
                    this.mostrar_lg();
                    break;
                }
            }
        } while (true);
    }

    public void copiar() {
        int ans;
        String[] opciones = {"Lista generalizada", "Árbol ene-ario", "Árbol binario"};
        do {
            this.plantilla.menu("Crear", "Seleccione que lo que quiera copiar", opciones);
            ans = gr.escuchar_opciones(opciones.length);
            if (ans == 0) {
                break;
            }
            if (ans == -1) {
                continue;
            }
            switch (ans) {
                case 1: {
                    this.copiar_lg();
                    break;
                }
            }
        } while (true);
    }

    public void crear_lg() {
        String nom = this.gr.escuchar_nombre();
        if (nom == null) {
            return;
        }
        this.plantilla.menu("Crear Lista Generalizada", "Ingrese los parámetros de creación", null);
        this.plantilla.input(0, nom);
        String ans = this.gr.escuchar();
        if (ans.equals("0")) {
            this.gr.limpiar();
            this.plantilla.desacierto(0);
            return;
        }
        // Creamos la lista
        if (!gr.validar(ans)) {
            this.gr.limpiar();
            this.plantilla.error(3);
        }
        ListaGeneralizada lg = new ListaGeneralizada();
        lg.construirLista(ans);
        Registro r = new Registro(nom, lg);
        this.inv.guardarLg(r);
        this.gr.limpiar();
        this.plantilla.acierto(0);
    }

    public void mostrar_lg() {
        String[] nombres = new String[this.inv.retornaCantidadLg()];
        for (int i = 0; i < this.inv.retornaCantidadLg(); i++) {
            nombres[i] = this.inv.retornaNombreLg(i);
        }
        int ans;
        do {
            this.plantilla.menu("Listas Generalizadas", "Seleccione la lista que desea mostrar", nombres);
            ans = gr.escuchar_opciones(nombres.length);
            if (ans == 0) {
                break;
            }
            if (ans == -1) {
                continue;
            }
            this.gr.limpiar();
            ListaGeneralizada lg = this.inv.retornaLg(ans - 1);
            String lista = lg.mostrarLista();
            this.plantilla.mostrarLg(lista);
            this.plantilla.defecto(3);
            this.gr.escuchar();
        } while (true);
    }

    public void copiar_lg() {
        String[] nombres = new String[this.inv.retornaCantidadLg()];
        for (int i = 0; i < this.inv.retornaCantidadLg(); i++) {
            nombres[i] = this.inv.retornaNombreLg(i);
        }
        int ans;
        do {
            this.plantilla.menu("Listas Generalizadas", "Seleccione la lista que desea copiar", nombres);
            ans = gr.escuchar_opciones(nombres.length);
            if (ans == 0) {
                break;
            }
            if (ans == -1) {
                continue;
            }
            this.gr.limpiar();
            ListaGeneralizada lg = this.inv.retornaLg(ans - 1);
            ListaGeneralizada copia = lg.copiarLista();
            String nom = this.gr.escuchar_nombre();
            if (nom == null) {
                return;
            }
            Registro r = new Registro(nom, copia);
            this.inv.guardarLg(r);
            this.gr.limpiar();
            this.plantilla.acierto(1);
        } while (true);
    }
}
