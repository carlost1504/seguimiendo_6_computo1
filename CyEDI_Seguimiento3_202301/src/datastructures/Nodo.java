package datastructures;

public class Nodo <K extends Comparable<K>, T>{
    private K clave;
    private T valor;
    private Nodo<K, T> izquierdo;
    private Nodo<K, T> derecho;

    public Nodo(K clave, T valor) {
        this.clave = clave;
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    public K getClave() {
        return this.clave;
    }

    public T getValor() {
        return this.valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<K, T> getIzquierdo() {
        return this.izquierdo;
    }

    public void setIzquierdo(Nodo<K, T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo<K, T> getDerecho() {
        return this.derecho;
    }

    public void setDerecho(Nodo<K, T> derecho) {
        this.derecho = derecho;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }
}
