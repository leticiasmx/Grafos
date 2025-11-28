package grafoGenerico;

//importar grafo
import java.util.*;

public interface grafo<V, E> {
 void addVertex(V vertex);
 void removeVertex(V vertex);
 void addEdge(V source, V destination, E weight);
 void removeEdge(V source, V destination);

 Set<V> getVertices();
 Set<V> getNeighbors(V vertex);
 E getEdgeWeight(V source, V destination);
 boolean containsVertex(V vertex);
 boolean containsEdge(V source, V destination);
 int getVertexCount();
 int getEdgeCount();
 boolean isDirected();
 void display();
}
