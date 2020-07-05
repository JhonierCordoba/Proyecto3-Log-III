package Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Storage {
    private ArrayList<MatrizAdyacente> sg = new ArrayList<>();
    private ObservableList<String> nom = FXCollections.observableArrayList();
    private ArrayList<ObservableList> vts = new ArrayList<>();
    
    public void save(String name, MatrizAdyacente m, ObservableList vts) {
        this.nom.add(name);
        this.sg.add(m);
        this.vts.add(vts);
    }
    
    public MatrizAdyacente returnM(int i) {
        return this.sg.get(i);
    }
    
    public ObservableList returnN() {
        return nom;
    }
    
    public ObservableList returnV(int i) {
        return this.vts.get(i);
    }
    
    public ArrayList returnVts(){
        return this.vts;
    }
    
    public void addV(MatrizAdyacente m, int vt) {
        int pos = this.sg.indexOf(m);
        this.vts.get(pos).add(vt);
    }
    public Integer searchV(int pName, int n) {
        return vts.get(n).indexOf(pName);
        /*int i = -1;
        for (String name : vts.get(n)) {
            i++;
            if (name.equals(pName)) {
                return i;
            }
        }
        return null;*/
   }
}
