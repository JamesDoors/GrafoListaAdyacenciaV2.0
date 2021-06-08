package grafolista;

import java.util.ArrayList;

public class Vertice {
    
    //Atributos
    private String nombre;
    private int numVertice;
    private ArrayList<Object> lad;
    
    //Constructor
    public Vertice(String nombre) {
        this.nombre = nombre;
        this.lad = new ArrayList<Object>();
    }
    
    // Devuelve verdadero si dos vertices se llaman igual
    public boolean equals(Object d) {
        Vertice dos = (Vertice) d;
        return nombre.equals(dos.nombre);
    }
    
    // Indica el número que identificará este vértice
    public void asigVert(int n) {
        this.numVertice = n;
    }
    
    // Devuelve el nombre del vértice
    public String getNombre() {
        return nombre;
    }
    
    // Devuelve el número del vértice
    public int getNumero() {
        return numVertice;
    }

    // Devuelve los adyacentes del vértice
    public ArrayList<Object> getLad() {
        return lad;
    }
}