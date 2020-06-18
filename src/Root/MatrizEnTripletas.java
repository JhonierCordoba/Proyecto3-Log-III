package Root;

/**
 *
 * @author JuanZea
 */
public class MatrizEnTripletas {

    private Tripleta[] V;

    public MatrizEnTripletas(Tripleta t) { // Modificado
        int n = t.retornaColumna();
        int m = t.retornaFila();
        int p = n * m + 1;
        // int i; // se usa en docs
        V = new Tripleta[p];
        V[0] = t;
        // for (i = 1; i <= p; i++) { // se usa en docs
        // }
    }

    public MatrizEnTripletas(int m, int n) {
        int p = m * n;
        Tripleta[] V = new Tripleta[p + 1];
        V[0] = new Tripleta(m, n, 0);
        this.V = V;
    }

    public void asignaNumberTripletas(int n) {
        this.V[0].asignaValor(n);
    }

    public void asignaTripleta(Tripleta t, int i) {
        this.V[i] = t;
    }

    public int retornaNumeroFilas() {
        return this.V[0].retornaFila();
    }

    public int retornaNumeroColumnas() {
        return this.V[0].retornaColumna();
    }

    public int retornaNumeroTripletas() {
        return (int) this.V[0].retornaValor();
    }

    public Tripleta retornaTripleta(int i) {
        return this.V[i];
    }

    public void muestraMatrizEnTripletas() { // Modificado
        System.out.println("------------------------------");
        System.out.println("id. | Fila | Columnaa | Valor");
        System.out.println("------------------------------");
        for (int i = 1; i <= (int) this.V[0].retornaValor(); i++) {
            System.out.println(i + "." + " | " + this.V[i].retornaFila() + " | " + this.V[i].retornaColumna() + " | "
                    + this.V[i].retornaValor());
        }
    }

    public void imprimeMatriz() { // Original
        for (int f = 1; f <= this.V[0].retornaFila(); f++) {
            for (int c = 1; c <= this.V[0].retornaColumna(); c++) {
                for (int i = 1; i <= (int) this.V[0].retornaValor(); i++) {
                    if (f == this.V[i].retornaFila() && c == this.V[i].retornaColumna()) {
                        System.out.print(this.V[i].retornaValor() + "\t");
                        break;
                    } else if (i == (int) this.V[0].retornaValor()) {
                        System.out.print("0" + "\t");
                        break;
                    }
                }
            }
            System.out.println("");
        }
    }

    public void insertaTripleta(Tripleta t) { // Defectuoso (83)
        int f = t.retornaFila();
        int c = t.retornaColumna();
        int i = 0;
        int p = (int) this.V[0].retornaValor();
        while (i <= p && f > this.V[i].retornaFila()) {
            i++;
        }
        while (i <= p && f == this.V[i].retornaFila() && c > this.V[i].retornaColumna()) {
            i++;
        }
        int j = p;
        while (j >= i) {
            this.V[j + 1] = this.V[j];
            j--;
        }
        this.V[i] = t;
        p++;
        this.V[0].asignaValor(p);
    }

    public void insertaTripleta_v2(Tripleta t) { // i comienza en 1, para que las tripletas a insertar no se comparen con
        // V[0]
        int f = t.retornaFila();
        int c = t.retornaColumna();
        int i = 1;
        int p = (int) this.V[0].retornaValor();
        while (i <= p && f > this.V[i].retornaFila()) {
            i++;
        }
        while (i <= p && f == this.V[i].retornaFila() && c > this.V[i].retornaColumna()) {
            i++;
        }
        int j = p;
        while (j >= i) {
            this.V[j + 1] = this.V[j];
            j--;
        }
        this.V[i] = t;
        p++;
        this.V[0].asignaValor(p);
    }

    public MatrizEnTripletas suma(MatrizEnTripletas b) {
        return null;
    }

    public MatrizEnTripletas multiplicar(MatrizEnTripletas b) {
        return null;
    }

    public MatrizEnTripletas transpuesta_obsoleto() { // Modificado (140)
        int m = this.V[0].retornaFila();
        int n = this.V[0].retornaColumna();
        int p = (int) this.V[0].retornaValor();
        Tripleta tx = new Tripleta(n, m, 0);
        MatrizEnTripletas at = new MatrizEnTripletas(tx);
        int i = 1;
        while (i <= p) {
            int f = this.V[i].retornaFila();
            int c = this.V[i].retornaColumna();
            Object v = this.V[i].retornaValor();
            Tripleta t = new Tripleta(c, f, v);
            at.insertaTripleta_v2(t);
            i++;
        }
        return at;
    }

    public MatrizEnTripletas transpuesta() { // Modificado (165)
        int m = this.V[0].retornaFila();
        int n = this.V[0].retornaColumna();
        Object p = this.V[0].retornaValor();
        Tripleta t = new Tripleta(n, m, p);
        MatrizEnTripletas at = new MatrizEnTripletas(t);
        int[] s = new int[n + 1];
        for (int i = 1; i <= (int)p; i++) {
            s[this.V[i].retornaColumna()] = s[this.V[i].retornaColumna()] + 1;

        }
        int[] pos = new int[n + 1];
        pos[0] = 1;
        for (int i = 1; i <= n; i++) {
            pos[i] = pos[i - 1] + s[i - 1];
        }
        for (int i = 1; i <= (int)p; i++) {
            int f = this.V[i].retornaFila();
            int c = this.V[i].retornaColumna();
            Object v = this.V[i].retornaValor();
            t = new Tripleta(c, f, v);
            int k = pos[c];
            at.asignaTripleta(t, k);
            pos[c] = pos[c] + 1;
        }
        return at;
    }

    public MatrizEnTripletas transpuestaMedia() {
        return null;
    }

    public MatrizEnTripletas transpuestaRapida() {
        return null;
    }
}