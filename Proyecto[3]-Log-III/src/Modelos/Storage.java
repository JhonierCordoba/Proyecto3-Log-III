package Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Storage {
    private ObservableList<String> nom_Ma = FXCollections.observableArrayList();
    private ArrayList<MatrizAdyacente> sg_Ma = new ArrayList<>();
    private ArrayList<ObservableList> vt_Ma = new ArrayList<>();
    
    public void save_Ma(String name, MatrizAdyacente m, ObservableList<String> vts) {
        nom_Ma.add(name);
        sg_Ma.add(m);
        vt_Ma.add(vts);
    }
    
    public ObservableList returnN_Ma() {
        return nom_Ma;
    }
    
    public ObservableList returnV_Ma(int i) {
        return this.vt_Ma.get(i);
    }
    
    public Integer search_Ma(String nom) {
        int i = -1;
        for (String name:nom_Ma) {
            i++;
            if(name.equals(nom)){
                return i;
            }
        }
        return null;
    }

    public MatrizAdyacente return_Ma(int i){
        return this.sg_Ma.get(i);
    }

    public void addV_Ma(int i,String vt){
        this.vt_Ma.get(i).add(vt);
    }
}
