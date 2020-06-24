package Modelos;

public class ArbolEneario {
//    private /*¿Tipo?*/ raiz;

    public int grado(NodoLg raiz){
        if(raiz == null){
            return 0;
        }
        NodoLg p = raiz.retornaLiga();
        if(p == null){
            return 0;
        }
        return -123123;
    }
}
