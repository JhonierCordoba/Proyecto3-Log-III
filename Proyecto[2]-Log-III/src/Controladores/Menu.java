package Controladores;

import Modelos.ListaGeneralizada;
import Vistas.Plantilla;

import java.util.Scanner;

public class Menu {

    private GestionRespuestas gr = new GestionRespuestas();
    private Plantilla plantilla = new Plantilla();


    public void principal() {
        int ans;
        String[] opciones = {"Crear"};
        do {
            this.plantilla.menu("MENU PRINCIPAL","Bienvenido",opciones);
            ans = gr.escuchar_opciones(opciones.length);
            if (ans == 0) {
                break;
            }
            if (ans == -1) {
                continue;
            }
            switch (ans) {
                case 1:{
                    this.crear();
                    break;
                }
            }
        } while (true);
        this.plantilla.defecto(2);
    }
    
    public void crear(){
        int ans;
        String[] opciones = {"Lista generalizada","Árbol ene-ario","Árbol binario"};
                do {
                    this.plantilla.menu("Crear","Seleccione que lo que quiera crear",opciones);
                    ans = gr.escuchar_opciones(opciones.length);
                    if (ans == 0) {
                        break;
                    }
                    if (ans == -1) {
                        continue;
                    }
                    switch (ans) {
                        case 1:{
                            this.crear_lg();
                            break;
                        }
                    }
                } while (true);
    }

    public void crear_lg(){
        this.plantilla.menu("Crear Lista Generalizada","Ingrese los parámetros de creación", null);
        this.plantilla.input(0);
        String ans = this.gr.escuchar();
        if(ans.equals("0")){
            this.gr.limpiar();
            this.plantilla.desacierto(0);
            return;
        }
        // Creamos la lista
        if(!gr.validar(ans)){
            this.gr.limpiar();
            this.plantilla.error(3);
        }
        ListaGeneralizada lg = new ListaGeneralizada();
        lg.construirLista(ans);
        this.gr.limpiar();
        this.plantilla.acierto(0);
    }
}
