package Controllers;

import Modelos.MatrizAdyacente;
import Modelos.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class WindowController {
    
    private Storage sg = new Storage();
    @FXML
    private TextField tfNom_Ma;
    @FXML
    private TextField tfVert_Ma;
    @FXML
    private ListView listN_Ma;
    @FXML
    private ListView listV_Ma;
    
    public void mostrarVertices_Ma(){
        this.listV_Ma.setItems(this.sg.returnV_Ma(this.listN_Ma.getSelectionModel().getSelectedIndex()));
    }
    
    public void agregarNombre_Ma(MouseEvent event) {
        if(this.tfNom_Ma.isDisable()){
            this.agregarVertice_Ma();
            return;
        }
        if (this.tfNom_Ma.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre primero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.tfNom_Ma.setDisable(true);
        this.tfVert_Ma.setDisable(false);
        MatrizAdyacente mT = new MatrizAdyacente(0);
        ObservableList<String> vts = FXCollections.observableArrayList();
//        MatrizAdyacente m1 = new MatrizAdyacente(1);
//        MatrizAdyacente m2 = new MatrizAdyacente(2);
        this.sg.save_Ma(this.tfNom_Ma.getText(), mT,vts);
        this.listN_Ma.setItems(this.sg.returnN_Ma());
        this.listN_Ma.getSelectionModel().select(this.sg.returnN_Ma().size() - 1);
    }
    
    public void agregarVertice_Ma(){
        if (this.tfVert_Ma.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se admiten vértices vacíos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int pos = this.listN_Ma.getSelectionModel().getSelectedIndex();
        String vt = this.tfVert_Ma.getText();
        this.sg.addV_Ma(pos,vt);
        this.tfVert_Ma.setText("");
        this.tfVert_Ma.setPromptText("Agregado");
        this.listV_Ma.setItems(this.sg.returnV_Ma(pos));
    }
    
    public void finaliza_Ma(){
        this.tfNom_Ma.setText("");
        this.tfNom_Ma.setDisable(false);
        this.tfVert_Ma.setText("");
        this.tfVert_Ma.setDisable(true);
    }
}