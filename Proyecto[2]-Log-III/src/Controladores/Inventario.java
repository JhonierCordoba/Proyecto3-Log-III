package Controladores;

import Modelos.ListaGeneralizada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<ListaGeneralizada> lg = new ArrayList<>();
    private ObservableList<String> nomLg = FXCollections.observableArrayList();

    public void guardarLg(String nom,ListaGeneralizada lg){
        this.lg.add(lg);
        this.nomLg.add(nom);
    }

    public ObservableList<String> retornaNombresLg(){
        return this.nomLg;
    }

    public ListaGeneralizada retornaLg(int i){
        return this.lg.get(i);
    }

}
