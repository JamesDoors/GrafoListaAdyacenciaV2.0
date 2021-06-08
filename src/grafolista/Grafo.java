package grafolista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Grafo {
    
    //Atributos
    private ArrayList<Vertice> ListaAd;
    
    //Constructor
    public Grafo() {
        this.ListaAd = new ArrayList<Vertice>();
    }

    //Verifica si ya existe un vértice en el grafo
    public boolean existeVertice (String nombre) {
        Vertice v = new Vertice(nombre);
        return (ListaAd.contains(v)) ? true : false;
    }
    
    //Crea un nuevo vértice
    public void nuevoVertice (String nombre) {
        if (!existeVertice(nombre)) {
            Vertice v = new Vertice(nombre);
            ListaAd.add(v);
            System.out.println("El vértice " + nombre + " se cargó correctamente");
        }
        else {
            System.out.println("El vértice " + nombre +" ya existe, no se cargará");
        }
    } 
    
    //Verifica si dos vértices son adyacentes
    boolean adyacente(String a, String b) throws Exception{
        int v1, v2;
        Vertice Vert1 = new Vertice(a);
        Vertice Vert2 = new Vertice(b);
        v1 = ListaAd.indexOf(Vert1);
        v2 = ListaAd.indexOf(Vert2);
        if (!ListaAd.contains(Vert1)) {
            throw new Exception ("El vértice " + a + " no existe");
        }
        else {
            if (!ListaAd.contains(Vert2)) {
                throw new Exception ("El vértice " + b + " no existe");
            }
        }
        if (ListaAd.get(v1).getLad().contains(new Arista(v2))) {
            return true;
        } else {
            return false;
        }
    }
    
    //Crea una nueva arista entre 2 vértices
    public void nuevaArista(String a, String b) throws Exception {
        if (!adyacente(a,b)){
            int v1, v2;
            Vertice Vert1 = new Vertice(a);
            Vertice Vert2 = new Vertice(b);
            v1 = ListaAd.indexOf(Vert1);
            v2 = ListaAd.indexOf(Vert2);
            if (!ListaAd.contains(Vert1)) {
                throw new Exception ("El vértice " + a + " no existe");
            }
            else {
                if (!ListaAd.contains(Vert2)) {
                    throw new Exception ("El vértice " + b + " no existe");
                }
            }
            Arista ab = new Arista(v2);
            ListaAd.get(v1).getLad().add(ab);
            System.out.println("Se creó la arista desde " + a + " a " + b + " correctamente.");
        }
        else {
            System.out.println("La arista desde " + a + " a " + b + " ya existe, no se creará.");
        }
    }

    //Borra la arista entre dos vértices
    public void borrarArista(String a, String b) throws Exception {
        int v1, v2;
        Vertice Vert1 = new Vertice(a);
        Vertice Vert2 = new Vertice(b);
        v1 = ListaAd.indexOf(Vert1);
        v2 = ListaAd.indexOf(Vert2);
        if (!ListaAd.contains(Vert1)) {
            throw new Exception ("El vértice " + a + " no existe");
        }
        else {
            if (!ListaAd.contains(Vert2)) {
                throw new Exception ("El vértice " + b + " no existe");
            }
        }
        Arista ab = new Arista(v2);
        ListaAd.get(v1).getLad().remove(ab);
        System.out.println("Se borró la arista desde " + a + " a " + b + " correctamente.");
    }

    //Ordena los vértices creados del grafo
    public void ordenarLista() {
        Collections.sort(ListaAd, new Comparator<Vertice>() {
            //@Override
            public int compare(Vertice v1, Vertice v2) {
                return new String(v1.getNombre()).compareTo(new String(v2.getNombre()));
            }
        });
    }

    //Imprime la lista de adyacencia
    public void mostrarListaAdyacencia() {
        System.out.println("");
        System.out.println("LISTA DE ADYACENCIA DEL GRAFO");
        System.out.println("-----------------------------");
        for (int i = 0; i < ListaAd.size(); i++) {
            System.out.print("Nodo: " + ListaAd.get(i).getNombre() + " --> ");
            if (ListaAd.get(i).getLad().isEmpty()) {
                System.out.print("NULL");
            }
            else {
                int j = 0;
                for (; j < ListaAd.get(i).getLad().size(); j++) {
                    Arista Adyacente = (Arista) ListaAd.get(i).getLad().get(j);
                    System.out.print(ListaAd.get(Adyacente.getDestino()).getNombre() + " --> ");
                }
                if (j == ListaAd.get(i).getLad().size()) {
                    System.out.print("NULL");
                }
            }
            System.out.println("");
        }
    }
}