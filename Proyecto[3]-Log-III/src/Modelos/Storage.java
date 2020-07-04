package Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Storage {
    private ObservableList<String> nom = FXCollections.observableArrayList();
    private ArrayList<MatrizAdyacente> sg = new ArrayList<>();
    private ArrayList<ObservableList> vt = new ArrayList<>();
    
    public void save(String name, MatrizAdyacente m, ObservableList<String> vts) {
        nom.add(name);
        sg.add(m);
        vt.add(vts);
    }
    
    public ObservableList returnN() {
        return nom;
    }
    
    public ObservableList returnV(int i) {
        return this.vt.get(i);
    }
    
    public Integer search(String pName) {
        int i = -1;
        for (String name:nom) {
            i++;
            if(name.equals(pName)){
                return i;
            }
        }
        return null;
    }

    public MatrizAdyacente returnN(int i){
        return this.sg.get(i);
    }

    public int returnNV(int i){
        return this.vt.get(i).size();
    }

    public void addV(int i,String vt){
        this.vt.get(i).add(vt);
    }
}
