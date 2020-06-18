package Root;

/**
 *
 * @author JuanZea
 */
public class Program {
    static Tripleta tx = new Tripleta(4, 5, 0);
    static Tripleta t1 = new Tripleta(2, 2, "juan");
    static Tripleta t2 = new Tripleta(1, 1, "first");
    static Tripleta t3 = new Tripleta(3, 5, "Zea");
    static Tripleta t4 = new Tripleta(3, 1, 7);
    static Tripleta t5 = new Tripleta(1, 3, 29);

    public static void main(String[] args) {
        test1();
        // test2();
    }

    public static void test1() {

        // MatrizEnTripletas m = new MatrizEnTripletas(3, 3); // Forma1
        MatrizEnTripletas m = new MatrizEnTripletas(tx); // Forma2
        m.insertaTripleta_v2(t1);
        m.insertaTripleta_v2(t2);
        m.insertaTripleta_v2(t3);
        m.insertaTripleta_v2(t4);
        m.insertaTripleta_v2(t5);
        m.imprimeMatriz();
        m.muestraMatrizEnTripletas();
        MatrizEnTripletas mt = m.transpuesta();
        mt.imprimeMatriz();
        mt.muestraMatrizEnTripletas();
    }

    public void test2() {
        MatrizEnForma1 m = new MatrizEnForma1(4, 5);
        m.contruyeNodosCabeza(); // Porque no se añade esta instrucción al constructor?
        NodoDoble x1 = new NodoDoble(t1);
        NodoDoble x2 = new NodoDoble(t2);
        NodoDoble x3 = new NodoDoble(t3);
        NodoDoble x4 = new NodoDoble(t4);
        NodoDoble x5 = new NodoDoble(t5);
        m.conectaPorFilas(x1);
        m.conectaPorColumnas(x1);
        m.conectaPorFilas(x2);
        m.conectaPorColumnas(x2);
        m.conectaPorFilas(x3);
        m.conectaPorColumnas(x3);
        m.conectaPorFilas(x4);
        m.conectaPorColumnas(x4);
        m.conectaPorFilas(x5);
        m.conectaPorColumnas(x5);
        m.recorrePorFilas();
        m.recorrePorColumnas();
    }
}