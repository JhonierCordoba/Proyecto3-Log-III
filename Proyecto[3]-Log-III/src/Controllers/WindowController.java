package Controllers;

import Modelos.MatrizAdyacente;
import Modelos.NodoDoble;
import Modelos.Storage;
import Modelos.Tripleta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.util.ArrayList;

public class WindowController {
    
    private Storage sg = new Storage();
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfVert;
    @FXML
    private TextField tfPrice;
    @FXML
    private TextField tfAgregarVert;
    @FXML
    private TextField tfEliminarVert;
    @FXML
    private TextField tfInicio;
    @FXML
    private TextArea taMostrar;
    @FXML
    private TextArea taRecorrer;
    @FXML
    private ListView listN;
    @FXML
    private ListView listN_1;
    @FXML
    private ListView listN_2;
    @FXML
    private ListView listN_3;
    @FXML
    private ListView listV;
    @FXML
    private ListView listV_1;
    @FXML
    private ComboBox cbV1;
    @FXML
    private ComboBox cbV2;
    @FXML
    private ComboBox cbV1_1;
    @FXML
    private ComboBox cbV2_1;
    
    // OnKeyPressed - open
    
    public void btnAgregar(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregar();
        }
    }
    
    public void btnConectarV(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.conectarV();
        }
    }
    
    public void tfNom(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregar();
        }
    }
    
    public void tfVert(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregar();
        }
    }
    
    // OnKeyPressed - close
    
    public void agregar() {
        if (!this.restricciones(0)) {
            return;
        }
        int nV = Integer.parseInt(this.tfVert.getText());
        MatrizAdyacente m = new MatrizAdyacente(nV);
        ObservableList vts = FXCollections.observableArrayList();
        for (int i = 1; i <= nV; i++) {
            vts.add(i);
        }
        this.sg.save(this.tfNom.getText(), m, vts);
        this.listN.setItems(this.sg.returnN());
        this.listN_1.setItems(this.sg.returnN());
        this.listN_2.setItems(this.sg.returnN());
        this.listN_3.setItems(this.sg.returnN());
        this.listN.getSelectionModel().select(this.sg.returnN().size() - 1);
        this.tfNom.setText("");
        this.tfVert.setText("");
        this.tfVert.setPromptText("Agregado");
        this.actualizarVertices();
        // LLenar los combobox
        this.cbV1.setItems(this.listV.getItems());
        this.cbV2.setItems(this.listV.getItems());
        this.cbV1.setDisable(false);
        this.cbV2.setDisable(false);
    }
    
    public void actualizarVertices() {
        this.listV.setItems(this.sg.returnV(this.listN.getSelectionModel().getSelectedIndex()));
        this.cbV1.setItems(this.sg.returnV(this.listN.getSelectionModel().getSelectedIndex()));
        this.cbV2.setItems(this.sg.returnV(this.listN.getSelectionModel().getSelectedIndex()));
        this.cbV1.getSelectionModel().clearSelection();
        this.cbV2.getSelectionModel().clearSelection();
    }
    
    public void actualizarVertices_1() {
        this.listV_1.setItems(this.sg.returnV(this.listN_1.getSelectionModel().getSelectedIndex()));
        this.cbV1_1.setItems(this.sg.returnV(this.listN_1.getSelectionModel().getSelectedIndex()));
        this.cbV2_1.setItems(this.sg.returnV(this.listN_1.getSelectionModel().getSelectedIndex()));
        this.cbV1_1.getSelectionModel().clearSelection();
        this.cbV2_1.getSelectionModel().clearSelection();
    }
    
    public void conectarV() {
        if (!this.restricciones(1)) {
            return;
        }
        int select = this.listN.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        int a = cbV1.getSelectionModel().getSelectedIndex() + 1;
        int b = cbV2.getSelectionModel().getSelectedIndex() + 1;
        int price = Integer.parseInt(this.tfPrice.getText());
        m.agregarConexion(a, b, price);
        this.tfPrice.setText("");
        this.tfPrice.setPromptText("Conectado");
    }
    
    public void actualizarMuestra() {
        int select = this.listN_2.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        this.taMostrar.setText(m.retornaM1().imprimeMatriz());
    }
    
    public void DFS() {
        int select = this.listN_3.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        int d = Integer.parseInt(tfInicio.getText());
        select = this.sg.searchV(d, select);
        ArrayList<Integer> o = m.DFS(select);
        String pv = "";
        ObservableList lv = (ObservableList) this.sg.returnVts().get(select);
        for (Integer ent : o) {
            pv += lv.get(ent) + " ";
        }
        this.taRecorrer.setText(pv);
    }
    
    public void BFS() {
        int select = this.listN_3.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        int d = Integer.parseInt(tfInicio.getText());
        select = this.sg.searchV(d, select);
        ArrayList<Integer> o = m.DFS(select);
        String pv = "";
        ObservableList lv = (ObservableList) this.sg.returnVts().get(select);
        for (int ent = o.size() - 1; ent >= 0; ent--) {
            pv += lv.get(ent) + " ";
        }
        this.taRecorrer.setText(pv);
    }
    
    public void agregarVertice() {
        if (!this.restricciones(2)) {
            return;
        }
        int select = this.listN_1.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        int vt = Integer.parseInt(this.tfAgregarVert.getText());
        this.sg.addV(m, vt);
        m.retornaM1().agregarNodoCabeza();
        this.tfAgregarVert.setText("");
        this.tfAgregarVert.setPromptText("Agregado");
        this.actualizarVertices();
    }
    
    public void eliminarVertice() {
        if (!this.restricciones(3)) {
            return;
        }
        int select = this.listN_1.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        select = this.listV_1.getSelectionModel().getSelectedIndex();
        this.sg.removeV(m, select);
        m.retornaM1().eliminarNodoCabeza(select);
        this.actualizarVertices();
    }
    
    public void eliminarLado(){
        int select = this.listN_1.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        int a = this.cbV1_1.getSelectionModel().getSelectedIndex() + 1;
        int b = this.cbV2_1.getSelectionModel().getSelectedIndex() + 1;
        m.retornaM1().eliminarLado(a,b);
        actualizarVertices_1();
    }
    
    /**
     * Restricciones de la aplicación
     *
     * @param tipo 0: Crear, 1: Conectar, 2: Agregar
     */
    public Boolean restricciones(int tipo) {
        switch (tipo) {
            case 0: {
                if (this.tfNom.getText().isEmpty()) {
                    errors(0);
                    return false;
                }
                if (this.tfVert.getText().isEmpty()) {
                    errors(1);
                    return false;
                }
                int n;
                try {
                    n = Integer.parseInt(this.tfVert.getText());
                } catch (NumberFormatException exception) {
                    errors(4);
                    return false;
                }
                if (n < 0) {
                    errors(4);
                    return false;
                }
                break;
            }
            case 1: {
                if (this.cbV1.getSelectionModel().getSelectedIndex() == -1 || this.cbV2.getSelectionModel().getSelectedIndex() == -1) {
                    errors(2);
                    return false;
                }
                if (this.cbV1.getSelectionModel().getSelectedIndex() == this.cbV2.getSelectionModel().getSelectedIndex()) {
                    errors(3);
                    return false;
                }
                if (this.tfPrice.getText().isEmpty()) {
                    errors(5);
                    return false;
                }
                int n;
                try {
                    n = Integer.parseInt(this.tfPrice.getText());
                } catch (NumberFormatException exception) {
                    errors(6);
                    return false;
                }
                if (n < 0) {
                    errors(6);
                    return false;
                }
                break;
            }
            case 2: {
                if (this.listN_1.getSelectionModel().getSelectedIndex() == -1) {
                    errors(6);
                    return false;
                }
                if (this.tfAgregarVert.getText().isEmpty()) {
                    errors(1);
                    return false;
                }
                int n;
                try {
                    n = Integer.parseInt(this.tfAgregarVert.getText());
                } catch (NumberFormatException exception) {
                    errors(4);
                    return false;
                }
                if (n < 0) {
                    errors(4);
                    return false;
                }
                break;
            }
            case 3: {
                if (this.listV_1.getSelectionModel().getSelectedIndex() == -1) {
                    errors(6);
                    return false;
                }
                break;
            }
        }
        return true;
    }
    
    /**
     * Errores de la aplicación
     *
     * @param tipo 0: Nombre vacío, 1: Vértices vacíos, 2: Faltan vértices, 3: Mismo vértice, 4: No numérico positivo, 5: Sin Precio, 6: Formato Precio, 7: Sin Selección
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
            case 4: {
                message = "El número de vértices debe ser un entero positivo";
                break;
            }
            case 5: {
                message = "Ingrese un precio";
                break;
            }
            case 6: {
                message = "El precio debe ser un entero positivo";
            }
            case 7: {
                message = "No se ha seleccionado ningún elemento";
            }
        }
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}