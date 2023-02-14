/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectografosdiscretas;

/**
 *
 * @author Kevin
 */
public class ProyectoGrafosDiscretas {

    public static class Grafo {
        
        //Creamos la matriz y los vectices del grafo
        private int V;
        private int matriz[][];

        //Constructor del grafo
        public Grafo(int vertices) {
            this.V = vertices;
            matriz = new int[vertices][vertices];
        }
        
        //Creamos las aristas del grafo en ambas direcciones
        public void agregarArista(int origen, int destino, int peso) {
            matriz[origen][destino] = peso;
            matriz[destino][origen] = peso;
        }


        
        //Buscamos el siguiente vectice con el valor mas pequeño
        int vecticeMenor(boolean[] mst, int[] pesos) {
            int pesoMenor = Integer.MAX_VALUE;
            int vertice = -1;

            for (int i = 0; i < V; i++) {
                if (mst[i] == false && pesoMenor > pesos[i]) {
                    pesoMenor = pesos[i];
                    vertice = i;
                }
            }
            return vertice;
        }

        class Resultado {
            int vectice;
            int peso;
        }
        
        public void mst() {
            boolean[] visitados = new boolean[V]; //crea matriz logica con vertices visitados
            int[] pesos = new int[V];   //crea matriz de pesos
            Resultado[] resultado = new Resultado[V]; //creamos la matriz de resultados que luego se imprimirá

            for (int i = 0; i < V; i++) {
                pesos[i] = Integer.MAX_VALUE;
                resultado[i] = new Resultado();
            }
            pesos[0] = 0;
            resultado[0].vectice = -1;
            for (int i = 0; i < V; i++) {
                int vertice = vecticeMenor(visitados, pesos);
                visitados[vertice] = true;
                for (int j = 0; j < V; j++) {
                    if (matriz[vertice][j] > 0) {
                        if(visitados[j] == false && matriz[vertice][j] < pesos[j]){ //comprobamos si los vectices no forman ciclo
                            pesos[j] = matriz[vertice][j];
                            resultado[j].vectice = vertice; //agregamos a la matriz de resultados
                            resultado[j].peso = pesos[j];
                        }
                    }
                }
            }
            print(resultado);
        }

        public void print(Resultado[] resultado) {
            int costo = 0;
            System.out.println("\t\t\t\t Algoritmo de Prim");
            System.out.println("\t\t\t------Arbol Recubridor Minimo------");
            for (int i = 1; i < V; i++) {
                System.out.println("Vectice inicial: " + resultado[i].vectice + "| Vertice Final: " + i + " Peso: " + resultado[i].peso + " ; ");
                costo += resultado[i].peso;
            }
            System.out.println("Coste minimo = " + costo);
        }
    }

    public static void main(String[] args) {
        int vertices = 15     ;
        Grafo grafo = new Grafo(vertices);
        grafo.agregarArista(0, 1, 4);
        grafo.agregarArista(0, 10, 5);
        grafo.agregarArista(0, 2, 8);
        grafo.agregarArista(0, 5, 6);
        grafo.agregarArista(0, 11, 10);
        grafo.agregarArista(1, 2, 11);
        grafo.agregarArista(1, 5, 8);
        grafo.agregarArista(2, 3, 1);
        grafo.agregarArista(2, 4, 7);
        grafo.agregarArista(3, 4, 6);
        grafo.agregarArista(3, 6, 4);
        grafo.agregarArista(3, 7, 2);
        grafo.agregarArista(4, 5, 2);
        grafo.agregarArista(4, 8, 15);
        grafo.agregarArista(5, 7, 4);
        grafo.agregarArista(5, 6, 7);
        grafo.agregarArista(6, 7, 14);
        grafo.agregarArista(6, 8, 9);
        grafo.agregarArista(7, 8, 10);
        grafo.agregarArista(9, 3, 3);
        grafo.agregarArista(9, 7, 8);
        grafo.agregarArista(10, 9, 5);
        grafo.agregarArista(10, 4, 7);
        grafo.agregarArista(10, 2, 11);
        grafo.agregarArista(11, 1, 9);
        grafo.agregarArista(11, 6, 2);
        grafo.agregarArista(11, 5, 4);
        grafo.agregarArista(12, 9, 9);
        grafo.agregarArista(12, 7, 5);
        grafo.agregarArista(12, 8, 4);
        grafo.agregarArista(13, 7, 14);
        grafo.agregarArista(13, 1, 17);
        grafo.agregarArista(13, 11, 5);
        grafo.agregarArista(13, 6, 8);
        grafo.agregarArista(13, 8, 3);
        grafo.agregarArista(13, 12, 14);
        grafo.agregarArista(14, 10, 7);
        grafo.agregarArista(14, 3, 10);
        grafo.mst();
    }
}
