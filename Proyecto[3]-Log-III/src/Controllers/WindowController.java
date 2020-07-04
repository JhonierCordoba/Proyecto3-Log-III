package Controllers;

import Modelos.MatrizAdyacente;
import Modelos.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class WindowController {
    
    private Storage sg = new Storage();
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfVert;
    @FXML
    private ListView listN;
    @FXML
    private ListView listV;
    @FXML
    private ComboBox cbV1;
    @FXML
    private ComboBox cbV2;
    
    // OnKeyPressed - open
    
    public void btnAgregarNombre(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregarNombre();
        }
    }
    
    /*public void btnFinaliza(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.finaliza();
        }
    }*/
    
    public void btnConectarV(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.conectarV();
        }
    }
    
    public void tfNom(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregarNombre();
        }
    }
    
    public void tfVert(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregarVertice();
        }
    }
    
    // OnKeyPressed - close
    
    public void agregarNombre() {
        if (this.tfNom.getText().isEmpty()) {
            errors(0);
            return;
        }
        this.tfNom.setDisable(true);
        this.tfVert.setDisable(false);
        MatrizAdyacente m = new MatrizAdyacente();
        ObservableList<String> vts = FXCollections.observableArrayList();
        this.sg.save(this.tfNom.getText(), m, vts);
        this.listN.setItems(this.sg.returnN());
        this.listN.getSelectionModel().select(this.sg.returnN().size() - 1);
        agregarVertice();
    }
    
    public void agregarVertice() {
        if (this.tfVert.getText().isEmpty()) {
            errors(1);
            return;
        }
        try {
            int pos = this.listN.getSelectionModel().getSelectedIndex();
            String vt = this.tfVert.getText();
            this.sg.addV(pos, vt);
            this.tfVert.setText("");
            this.tfVert.setPromptText("Agregado");
            this.listV.setItems(this.sg.returnV(pos));
        } catch (Exception e){
            errors(4);
        }
    }
    
    /*public void actualizarVertices() {
        this.listV.setItems(this.sg.returnV(this.listN.getSelectionModel().getSelectedIndex()));
        this.cbV1.setItems(this.sg.returnV(this.listN.getSelectionModel().getSelectedIndex()));
        this.cbV2.setItems(this.sg.returnV(this.listN.getSelectionModel().getSelectedIndex()));
    }*/
    
    /*public void finaliza() {
        if(this.listN.getSelectionModel().isEmpty()){
            errors(0);
            return;
        }
        this.tfNom.setText("");
        this.tfNom.setDisable(false);
        this.tfVert.setText("");
        this.tfVert.setDisable(true);
        // Creación de matriz Adyacente
        int select = this.listN.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnN(select);
        select = this.sg.returnNV(select);
        m.tamaño(select);
        System.out.println(select);
        // LLenar los combobox
        this.cbV1.setItems(this.listV.getItems());
        this.cbV2.setItems(this.listV.getItems());
        this.cbV1.setDisable(false);
        this.cbV2.setDisable(false);
    }*/
    
    public void conectarV() {
        if (this.cbV1.getSelectionModel().getSelectedIndex() == -1 || this.cbV2.getSelectionModel().getSelectedIndex() == -1) {
            errors(2);
            return;
        }
        if (this.cbV1.getSelectionModel().getSelectedIndex() == this.cbV2.getSelectionModel().getSelectedIndex()) {
            errors(3);
            return;
        }
        int i = this.listN.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnN(i);
        int a = cbV1.getSelectionModel().getSelectedIndex();
        int b = cbV2.getSelectionModel().getSelectedIndex();
        m.agregarConexion(a, b);
    }
    
    /**
     * Errores de la aplicación
     *
     * @param tipo 0: Nombre vacío, 1: Vértices vacíos, 2: Faltan vértices, 3: Mismo vértice
     */
    public void errors(int tipo) {
        String message = "error";
        switch (tipo) {
            case 0: {
                message = "Ingrese un nombre primero";
                break;
            }
            case 1: {
                message = "No se admiten vértices vacíos";
                break;
            }
            case 2: {
                message = "Seleccione 2 vértices";
                break;
            }
            case 3: {
                message = "No se permiten loops en las matrices";
                break;
            }
        }
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}