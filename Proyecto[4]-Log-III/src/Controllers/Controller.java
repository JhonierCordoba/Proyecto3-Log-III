package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Controller {
    @FXML
    TextField in_n;
    @FXML
    TextField in_k;
    @FXML
    TextField in_string;
    @FXML
    TextField in_r;
    @FXML
    TextField in_pesos;
    @FXML
    TextField in_beneficios;
    @FXML
    TextField in_capacidad;

    @FXML
    TextField out_cantidad;

    @FXML
    TextArea tb_1;
    @FXML
    TextArea tb_2;
    @FXML
    TextArea tb_3;
    @FXML
    TextArea tb_4;

    @FXML
    ComboBox cb_rango;

    private int n;
    private int[] v;
    private int[] vUI;
    private int[] primos;

    public void generarEntero() {
        Random rnd = new Random();
        this.n = rnd.nextInt(41) + 10;
        String ans = "El número n es: " + this.n + "\n";
        this.tb_1.setText(ans);
    }

    public void generarVector() {
        Random rnd = new Random();
        if (this.n == 0) {
            this.tb_1.setText("Primero genere un entero con la opción 1.");
            return;
        }
        v = new int[this.n + 1];
        for (int i = 1; i < v.length; i++) {
            v[i] = rnd.nextInt(100) + 1;
        }
        this.mostrar(1);
    }

    public void Ordenar() {
        Stack pila = new Stack();
        int n = this.n;
        int size = 1;
        int avance_mitad = size - 1;
        int avance_final = size * 2 - 1;
        // Separación en parejas
        int i;
        while (size < n) {
            i = 1;
            while (i < n) {
                if (i + avance_final > n) {
                    this.intercalar(i, i + avance_mitad, i + avance_final - 1);
                    pila.push(this.copiar(v));
                    break;
                }
                this.intercalar(i, i + avance_mitad, i + avance_final);
                pila.push(this.copiar(v));
                i += size * 2;
            }
            size *= 2;
            avance_mitad = size - 1;
            avance_final = size * 2 - 1;
        }
        pila.pop();
        this.vUI = (int[]) pila.pop();
        this.mostrar(2);
    }

    public void intercalar(int inicio, int mitad, int fin) {
        int[] w = new int[v.length];
        for (int i = inicio; i <= fin; i++) {
            w[i] = v[i];
        }
        int i = inicio;
        int j = mitad + 1;
        int k = inicio - 1;
        while (i <= mitad && j <= fin) {
            k++;
            if (w[i] <= w[j]) {
                v[k] = w[i];
                i++;
            } else {
                v[k] = w[j];
                j++;
            }
        }
        while (i <= mitad) {
            k++;
            v[k] = w[i];
            i++;
        }
        while (j <= fin) {
            k++;
            v[k] = w[j];
            j++;
        }
    }

    public void combinaciones() {
        int r = Integer.parseInt(this.in_r.getText());
        String s = this.in_string.getText();
        int n = s.length();
        String ans = "";
        if (r > n || r < 1){
            JOptionPane.showMessageDialog(null,"r debe ser positivo y menor que el tamaño del string","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        int j, t;
        int[] b = new int[r];
        for (int i = 0; i < r; i++) {
            b[i] = i;
        }
        j = r - 1;
        while (b[0] <= n - r) {
            t = 0;
            while (t < r) {
                ans += s.charAt(b[t]);
                t++;
            }
            ans += "\n";
            b[j]++;
            while (b[j] > n + j - r) {
                if (r == 1){
                    this.tb_3.setText(ans);
                    return;
                  }
                b[j - 1]++;
                if (b[j - 1] >= n + j - r) {
                    j--;
                    if (j == 0){
                        System.out.println(ans);
                        this.tb_3.setText(ans);
                        return;
                      }
                    continue;
                } else
                    while (j < r) {
                        b[j] = b[j - 1] + 1;
                        j++;
                    }
                j--;
            }
        }
    }

    public void AlgoritmoNK() {

    }

    public void calcularPrimos() {
      int[] primos = new int[1000];
      primos[0] = 2;
      int i = 1;
      int j;
      for (int num = 3; num <= 1000; num++) {
        j = 0;
        while(primos[j] <= Math.sqrt(num)){
            if(num%primos[j] == 0){
              break;
            }
            j++;
        }
        if(primos[j] > Math.sqrt(num)){
          primos[i] = num;
          i++;
        }
      }
      this.primos = primos;
      this.mostrarPrimos();
    }

    /**
     * @param ansI 1: Generado, 2: Ordenado
     */
    public void mostrar(int ansI) {
        String ans = "";
        switch (ansI) {
            case 1: {
                ans = "El vector ha sido generado correctamente\nEl número n es: " + this.n + "\n";
                break;
            }
            case 2: {
                ans = "El vector en antes de su última intercalación estaba así:\n";
                ans += "Índice | Valor\n";
                for (int i = 1; i < vUI.length; i++) {
                    ans += i + " | " + vUI[i] + "\n";
                }
                ans += "El vector ha sido ordenado correctamente\nEl número n es: " + this.n + "\n";
                break;
            }
        }
        ans += "Índice | Valor\n";
        for (int i = 1; i < v.length; i++) {
            ans += i + " | " + v[i] + "\n";
        }
        this.tb_1.setText(ans);
    }

    public int[] copiar(int[] v) {
        int[] vCopia = new int[v.length];
        for (int i = 0; i < v.length; i++) {
            vCopia[i] = v[i];
        }
        return vCopia;
    }

    public void mostrarPrimos(){
      String ans = "Los números primos entre 1 y 1000 son:\n";
      for (int i = 0; i < this.primos.length; i++) {
          if(i%20 == 0){
            ans += "\n";
          }
          if(this.primos[i] != 0){
            ans += this.primos[i] + "\t";
          } else {
            break;
          }
      }
      this.tb_2.setText(ans);
      ObservableList rangos = FXCollections.observableArrayList();
      for (int i = 1; i < 1000; i+=100) {
        rangos.add(i + " - " + (i + 99));
      }
      this.cb_rango.setItems(rangos);
    }
    public void actualizarCantidad(){
      int select = this.cb_rango.getSelectionModel().getSelectedIndex();
      if(select == -1){
        return;
      }
      int cotaInf,cotaSup;
      int k;
      int i = 0;
      cotaInf = select*100 + 1;
      cotaSup = select*100 + 100;
      while(this.primos[i] < cotaInf){
        i++;
      }
      k = i;
      while(this.primos[i] <= cotaSup && this.primos[i] != 0){
            i++;
      }
      int num = i - k;
      this.out_cantidad.setText(String.valueOf(num));
    }
    public void calcularFormas(){
      if(this.in_pesos.getText().isEmpty() || this.in_beneficios.getText().isEmpty() || this.in_capacidad.getText().isEmpty()){
        JOptionPane.showMessageDialog(null,"Hay datos sin ingresar","ERROR",JOptionPane.ERROR_MESSAGE);
        return;
      }
      String[] pesos_string = this.in_pesos.getText().split(",");
      String[] beneficios_string = this.in_beneficios.getText().split(",");
      int[] pesos = new int[pesos_string.length];
      int[] beneficios = new int[beneficios_string.length];
      if(pesos.length != beneficios.length){
        JOptionPane.showMessageDialog(null,"Algo anda mal.","ERROR",JOptionPane.ERROR_MESSAGE);
        return;
      }
      int cantidad = pesos.length;
      for (int i = 0; i < pesos_string.length; i++) {
        try{
          pesos[i] = Integer.parseInt(pesos_string[i]);
        } catch(NumberFormatException exception) {
          JOptionPane.showMessageDialog(null,"El formato en el que se ingresó el vector es incorrecto.","ERROR",JOptionPane.ERROR_MESSAGE);
          return;
        }
      }
      for (int i = 0; i < beneficios_string.length; i++) {
        try{
          pesos[i] = Integer.parseInt(beneficios_string[i]);
        } catch(NumberFormatException exception) {
          JOptionPane.showMessageDialog(null,"El formato en el que se ingresó el vector es incorrecto.","ERROR",JOptionPane.ERROR_MESSAGE);
          return;
        }
      }
      boolean[] x = new boolean[cantidad];
      ArrayList<boolean[]> soluciones = new ArrayList();
//      this.cargarMochila(0, pesos, beneficios, x, soluciones);
      String ans = "Las soluciones posibles son:\n";
      for (int i = 0; i < soluciones.size(); i++) {
        ans += "Solucion #" + (i + 1) + ":\n";
        for (int j = 0; j < soluciones.get(i).length; j++) {
          ans += "Objeto #" + (j + 1) + soluciones.get(i)[j] + "\n";
        }
      }
      this.tb_4.setText(ans);
    }

//    public void cargarMochila(int i, int[] pesos, int[] beneficios, boolean[] x,ArrayList soluciones, int beneMax){
//        int beneT = 0;
//        for (int j = 0; j < beneficios.length; j++) {
//            beneT += beneficios[j];
//        }
//        if(n < i){
//            if(beneT > beneMax){
//              reemplazar(mejorX, X);
//              beneMax = beneT;
//            }
//            return;
//        }
//        if(pesoT + peso[i] <= C){
//          x[i] = true;.
//          pesoT += peso[i];
//          beneT += bene[i];
//          cargaMochila(i++, pesos, beneficios, soluciones);
//          x[i] = false;
//          pesoT -= peso[i];
//          beneT -= bene[i];
//        }
//        cargaMochila(i++);
//    }
}
