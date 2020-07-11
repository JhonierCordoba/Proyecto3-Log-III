package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {
    @FXML
    TextField in_n;
    @FXML
    TextField in_k;

    @FXML
    TextField out_Cantidad;

    @FXML
    TextArea tb_1;
    @FXML
    TextArea tb_2;

    @FXML
    ComboBox cb_Rango;

    private int n = 0;
    private int[]v;

    public void generarEntero(){
        Random rnd = new Random();
        n = rnd.nextInt(41) + 10;
        String ans = "El número n es: " + n + "\n";
        this.tb_1.setText(ans);
    }
    public void generarVector(){
        Random rnd = new Random();
        if(n == 0){
          this.tb_1.setText("Primero genere un entero con la opción 1.");
          return;
        }
        v = new int[this.n + 1];
        for (int i = 1; i < v.length; i++) {
            v[i] = rnd.nextInt(100) + 1;
        }
        String ans = "El número n es: " + this.n + "\n";
        ans += "Índice | Valor\n";
        for (int i = 1; i < v.length; i++) {
          ans += i + " | " + v[i] + "\n";
        }
        this.tb_1.setText(ans);
    }
    public void Ordenar(){
      int n = this.n;
      int size = 1;
      int avance_mitad = size - 1;
      int avance_final = size * 2 - 1;
      // Separación en parejas
      int i;
      while(size < n){
          i = 1;
        while (i < n) {
          if(i + avance_final > n){
            this.intercalar(i, i + avance_mitad, i + avance_final - 1);
            break;
          }
          this.intercalar(i, i + avance_mitad, i + avance_final);
          i+= size * 2;
        }
        size *= 2;
        avance_mitad = size - 1;
        avance_final = size * 2 - 1;
      }
    }
    public void intercalar(int inicio, int mitad, int fin){
      int[]w = new int[v.length];
      for(int i = inicio; i <= fin; i++){
        w[i] = v[i];
      }
      int i = inicio;
      int j = mitad + 1;
      int k = inicio - 1;
      while(i <= mitad && j <= fin){
        k++;
        if(w[i] <= w[j]){
          v[k] = w[i];
          i++;
        }else{
          v[k] = w[j];
          j++;
        }
      }
      while(i <= mitad){
        k++;
        v[k] = w[i];
        i++;
      }
      while(j <= fin){
        k++;
        v[k] = w[j];
        j++;
      }
    }
    public void combinaciones(){
        int r = 3;
      String s = "abcdef"; // Test
      int n = s.length();
      int t, j;
      t = 0;
      int []b = new int[r];
      for(int i = 0; i < r; i++){
        b[i] = i;
      }
      for(int i = 0; i < n; i++){
        j = r - 1;
        //imprime
        b[j]++;
        while(b[j] > n + j - r){
          b[j - 1]++;
          if(b[j -1] >= n + j - r){
            j--;
            if(j < 0)
              return;
            continue;
          }else
          b[j]++;
        }
      }
    }
    public void AlgoritmoNK(){

    }
    public void calcularPrimos(){

    }
}
