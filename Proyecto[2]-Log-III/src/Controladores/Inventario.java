package Controladores;

import Modelos.ListaGeneralizada;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Registro> invLg = new ArrayList<>();

    public void guardarLg(Registro r){
        invLg.add(r);
    }

    public ListaGeneralizada retornaLg(int i){
        Registro r = invLg.get(i);
        return r.retornaLg();
    }

    public String retornaNombreLg(int i){
        Registro r = invLg.get(i);
        return r.retornaNombre();
    }

    public int retornaCantidadLg(){
        return this.invLg.size();
    }
}
