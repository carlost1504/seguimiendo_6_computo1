package datastructures;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda <K extends Comparable<K>, T> implements IBinarySearchTree<K, T>{
    private Nodo<K, T> raiz;
    private int tamaño;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
        this.tamaño = 0;
    }

    public void insert(K clave, T valor) {
        this.raiz = insertarAux(this.raiz, clave, valor);
    }

    private Nodo<K, T> insertarAux(Nodo<K, T> nodo, K clave, T valor) {
        if (nodo == null) {
            nodo = new Nodo<K, T>(clave, valor);
            this.tamaño++;
        } else if (clave.compareTo(nodo.getClave()) < 0) {
            nodo.setIzquierdo(insertarAux(nodo.getIzquierdo(), clave, valor));
        } else if (clave.compareTo(nodo.getClave()) > 0) {
            nodo.setDerecho(insertarAux(nodo.getDerecho(), clave, valor));
        } else {
            nodo.setValor(valor);
        }
        return nodo;
    }

    public T delete(K clave) {
        this.raiz = eliminarAux(this.raiz, clave);
        return null;
    }

    private Nodo<K, T> eliminarAux(Nodo<K, T> nodo, K clave) {
        if (nodo == null) {
            return null;
        } else if (clave.compareTo(nodo.getClave()) < 0) {
            nodo.setIzquierdo(eliminarAux(nodo.getIzquierdo(), clave));
        } else if (clave.compareTo(nodo.getClave()) > 0) {
            nodo.setDerecho(eliminarAux(nodo.getDerecho(), clave));
        } else {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null){
                // Caso 1: el nodo a eliminar es una hoja
                nodo = null;
                this.tamaño--;
            } else if (nodo.getIzquierdo() == null) {
                // Caso 2: el nodo a eliminar tiene un hijo derecho
                nodo = nodo.getDerecho();
                this.tamaño--;
            } else if (nodo.getDerecho() == null) {
                // Caso 2: el nodo a eliminar tiene un hijo izquierdo
                nodo = nodo.getIzquierdo();
                this.tamaño--;
            } else {
                // Caso 3: el nodo a eliminar tiene dos hijos
                Nodo<K, T> sucesor = obtenerSucesor(nodo);
                nodo.setClave(sucesor.getClave());
                nodo.setValor(sucesor.getValor());
                nodo.setDerecho(eliminarAux(nodo.getDerecho(), sucesor.getClave()));
            }
        }
        return nodo;
    }

    private Nodo<K, T> obtenerSucesor(Nodo<K, T> nodo) {
        Nodo<K, T> actual = nodo.getDerecho();
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return actual;
    }

    public T search(K key) {
        Nodo<K, T> nodo = searchAux(this.raiz, key);
        if (nodo == null) {
            return null;
        }
        return nodo.getValor();
    }

    private Nodo<K, T> searchAux(Nodo<K, T> nodo, K key) {
        if (nodo == null || nodo.getClave().equals(key)) {
            return nodo;
        }
        if (key.compareTo(nodo.getClave()) < 0) {
            return searchAux(nodo.getIzquierdo(), key);
        } else {
            return searchAux(nodo.getDerecho(), key);
        }
    }

    public int obtenerTamaño() {
        return this.tamaño;
    }

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrderAux(this.raiz, sb);
        return sb.toString();
    }

    private void inOrderAux(Nodo<K, T> nodo, StringBuilder sb) {
        if (nodo != null) {
            inOrderAux(nodo.getIzquierdo(), sb);
            sb.append(nodo.getClave().toString()).append(" ");
            inOrderAux(nodo.getDerecho(), sb);
        }
    }
    public T getRoot() {
        if (this.raiz == null) {
            return null;
        }
        return this.raiz.getValor();
    }

}
