package grafoGenerico;

//Main.java
public class Main {
 public static void main(String[] args) {
     System.out.println("grafo generico");
     
     // Grafo não-direcionado com Strings
     System.out.println("grafo de strings(Não-Direcionado)");
     grafo<String, Integer> stringGraph = new listaAdjacencia<>();
     
     stringGraph.addVertex("A");
     stringGraph.addVertex("B");
     stringGraph.addVertex("C");
     stringGraph.addVertex("D");
     
     stringGraph.addEdge("A", "B", 5);
     stringGraph.addEdge("A", "C", 3);
     stringGraph.addEdge("B", "D", 2);
     stringGraph.addEdge("C", "D", 1);
     
     stringGraph.display();
     
     // Grafo direcionado com Integers
     System.out.println("grafos inteiros (Direcionado)");
     grafo<Integer, Double> intGraph = new listaAdjacencia<>(true);
     
     intGraph.addEdge(1, 2, 1.5);
     intGraph.addEdge(1, 3, 2.0);
     intGraph.addEdge(2, 4, 0.5);
     intGraph.addEdge(3, 4, 1.0);
     
     intGraph.display();

     System.out.println("demonstração das operações");
     demonstrateOperations();
 }
 
 private static void demonstrateOperations() {
     grafo<String, String> graph = new listaAdjacencia<>();
     
     // Add vértices e arestas
     graph.addVertex("X");
     graph.addVertex("Y");
     graph.addVertex("Z");
     
     graph.addEdge("X", "Y", "conectado");
     graph.addEdge("Y", "Z", "ligado");
     
     System.out.println("Grafo inicial:");
     graph.display();

     System.out.println("Vértices: " + graph.getVertices());
     System.out.println("Vizinhos de Y: " + graph.getNeighbors("Y"));
     System.out.println("Peso da aresta X->Y: " + graph.getEdgeWeight("X", "Y"));
     System.out.println("Contém vértice X? " + graph.containsVertex("X"));
     System.out.println("Contém aresta Y->Z? " + graph.containsEdge("Y", "Z"));
     
     // Remoção
     graph.removeEdge("X", "Y");
     System.out.println("\nApós remover aresta X-Y:");
     graph.display();
     
     graph.removeVertex("Z");
     System.out.println("Após remover vértice Z:");
     graph.display();
 }
}
