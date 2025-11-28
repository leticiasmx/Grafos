package grafoGenerico;

//AdjacencyListGraph.java
import java.util.*;

public class listaAdjacencia<V, E> implements grafo<V, E> {
 private final Map<V, Map<V, E>>listaAdjacencia;
 private final boolean directed;
 private int edgeCount;
 
 public listaAdjacencia(boolean directed) {
     this.listaAdjacencia = new HashMap<>();
     this.directed = directed;
     this.edgeCount = 0;
 }
 
 public listaAdjacencia() {
     this(false);
 }
 
 @Override
 public void addVertex(V vertex) {
     if (vertex == null) throw new IllegalArgumentException("Vértice não pode ser nulo");
     listaAdjacencia.putIfAbsent(vertex, new HashMap<>());
 }
 
 @Override
 public void removeVertex(V vertex) {
     if (!listaAdjacencia.containsKey(vertex)) return;
     
     // Remove arestas de entrada
     for (V v : listaAdjacencia.keySet()) {
         if (listaAdjacencia.get(v).containsKey(vertex)) {
        	 listaAdjacencia.get(v).remove(vertex);
             edgeCount--;
         }
     }
     
     // Remove arestas de saída
     edgeCount -= listaAdjacencia.get(vertex).size();
     listaAdjacencia.remove(vertex);
 }
 
 @Override
 public void addEdge(V source, V destination, E weight) {
     if (source == null || destination == null) {
         throw new IllegalArgumentException("Vértices não podem ser nulos");
     }
     
     addVertex(source);
     addVertex(destination);
     
     Map<V, E> sourceNeighbors = listaAdjacencia.get(source);
     
     if (!sourceNeighbors.containsKey(destination)) {
         edgeCount++;
     }
     sourceNeighbors.put(destination, weight);
     
     if (!directed && !source.equals(destination)) {
         Map<V, E> destNeighbors = listaAdjacencia.get(destination);
         if (!destNeighbors.containsKey(source)) {
             edgeCount++;
         }
         destNeighbors.put(source, weight);
     }
 }
 
 @Override
 public void removeEdge(V source, V destination) {
     if (!containsVertex(source) || !containsVertex(destination)) return;
     
     Map<V, E> sourceNeighbors = listaAdjacencia.get(source);
     if (sourceNeighbors.containsKey(destination)) {
         sourceNeighbors.remove(destination);
         edgeCount--;
     }
     
     if (!directed) {
         Map<V, E> destNeighbors = listaAdjacencia.get(destination);
         if (destNeighbors.containsKey(source)) {
             destNeighbors.remove(source);
         }
     }
 }
 
 @Override
 public Set<V> getVertices() {
     return Collections.unmodifiableSet(listaAdjacencia.keySet());
 }
 
 @Override
 public Set<V> getNeighbors(V vertex) {
     if (!containsVertex(vertex)) return Collections.emptySet();
     return Collections.unmodifiableSet(listaAdjacencia.get(vertex).keySet());
 }
 
 @Override
 public E getEdgeWeight(V source, V destination) {
     if (!containsEdge(source, destination)) {
         throw new IllegalArgumentException("Aresta não existe: " + source + " -> " + destination);
     }
     return listaAdjacencia.get(source).get(destination);
 }
 
 @Override
 public boolean containsVertex(V vertex) {
     return listaAdjacencia.containsKey(vertex);
 }
 
 @Override
 public boolean containsEdge(V source, V destination) {
     return containsVertex(source) && listaAdjacencia.get(source).containsKey(destination);
 }
 
 @Override
 public int getVertexCount() {
     return listaAdjacencia.size();
 }
 
 @Override
 public int getEdgeCount() {
     return edgeCount;
 }
 
 @Override
 public boolean isDirected() {
     return directed;
 }
 
 @Override
 public void display() {
     System.out.println("Grafo " + (directed ? "Direcionado" : "Não-Direcionado"));
     System.out.println("Vértices: " + getVertexCount() + ", Arestas: " + getEdgeCount());
     
     for (V vertex : listaAdjacencia.keySet()) {
         Map<V, E> neighbors = listaAdjacencia.get(vertex);
         System.out.print(vertex + " -> ");
         
         if (neighbors.isEmpty()) {
             System.out.println("Nenhum vizinho");
         } else {
             List<String> neighborStrings = new ArrayList<>();
             for (Map.Entry<V, E> entry : neighbors.entrySet()) {
                 neighborStrings.add(entry.getKey() + "(" + entry.getValue() + ")");
             }
             System.out.println(String.join(", ", neighborStrings));
         }
     }
     System.out.println();
 }
 
 public int getDegree(V vertex) {
     if (!containsVertex(vertex)) return 0;
     return listaAdjacencia.get(vertex).size();
 }
 
 public boolean isEmpty() {
     return listaAdjacencia.isEmpty();
 }
 
 public void clear() {
	 listaAdjacencia.clear();
     edgeCount = 0;
 }
}
