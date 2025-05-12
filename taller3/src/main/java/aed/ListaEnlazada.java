package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
	
	private Nodo primero;
    private Nodo ultimo;

    private class Nodo {
    T valor;
    Nodo sig;
    Nodo ant;
    Nodo(T v){
    	valor = v;
        sig = null;
        ant = null;
    }
    }

    public ListaEnlazada() {
    	primero = null;
    }

    public int longitud() {
    int i = 0;
    Iterador<T> it = iterador();
    Nodo actual = primero;
    if(actual == null){
        i = 0;
        return i;
    }
    while (it.haySiguiente()) {
        it.siguiente();
        i += 1;
    };
    return i;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if(primero != null){
        Nodo actual = primero;
        actual.ant = nuevo;
        nuevo.sig = primero;
        primero = nuevo;}
        else{
            primero = nuevo;
            ultimo = nuevo;
            nuevo.ant = null;
            nuevo.sig = null;
        }
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if(primero != null){
            Nodo actual = ultimo;
            actual.sig = nuevo;
            nuevo.ant = actual;
            ultimo = nuevo;
        }else {
            primero = nuevo;
            ultimo = nuevo;
            nuevo.ant = null;
            nuevo.sig = null;
        }
    }

    public T obtener(int i) {
        Iterador<T> it = iterador();
        if(i == 0){
            return primero.valor;
        }else{
            for (int j = 0; j < i; j++) {
                if(it.haySiguiente()){
                    it.siguiente();
                }
                
            }
            return it.siguiente();
        }
        
    }

    public void eliminar(int i) {
    Nodo actual = primero;
    Nodo previo = primero;       

    for (int j = 0; j < i; j++) {
       previo = actual;
       actual = actual.sig; 
    }
    
    if(i == 0 && longitud() == 1){
        primero = null;
    }
    else if(i == 0){
        primero = actual.sig;
        primero.ant = null;
    }
    else if(i == longitud()-1){
        ultimo = previo;
        previo.sig = null;
        for (int j = i; j < 0; j--) {
        actual = previo;
        previo = previo.ant;    
        }
    }else{
        Nodo nodoPostEliminar = actual.sig;
        nodoPostEliminar.ant = previo;
        previo.sig = nodoPostEliminar;
    }
        
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        for (int i = 0; i < indice; i++) {
            actual = actual.sig;
        }
        actual.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
    	Nodo actual = lista.primero;
    	while (actual != null) {
    		agregarAtras(actual.valor);
    		actual = actual.sig;
    	}
    }
    
    @Override
    public String toString() {
        Nodo actual = primero;
        String res = "[";
        for (int i = 0; i < longitud() - 1; i++) {
            String valor = (actual.valor).toString();
            res += valor;
            res += ", ";
            actual = actual.sig;
        }
        res += actual.valor.toString();
        res += "]";
        return res;
    }

    private class ListaIterador implements Iterador<T> {
        public Nodo nodoActual = primero;
        public Nodo nodoPrevio = null;


        public boolean haySiguiente() {
            return nodoActual != null; 
        }
        
        public boolean hayAnterior() {
            return nodoPrevio != null;
        }

        public T siguiente() {
                Nodo actual = nodoActual;
                nodoPrevio = nodoActual;
                nodoActual = nodoActual.sig;
                return actual.valor;
        }
        

        public T anterior() {
            Nodo actual = nodoPrevio;
            nodoActual = nodoPrevio;
            nodoPrevio = nodoPrevio.ant;
            return actual.valor;
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}
