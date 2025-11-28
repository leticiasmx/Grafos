# Grafo Genérico em Java

Uma implementação genérica e flexível de estrutura de dados de grafo em Java, suportando vértices e arestas de qualquer tipo.

# 📋 Funcionalidades

# Operações Básicas
- ✅ **Adicionar vértice** - Insere um novo vértice no grafo
- ✅ **Adicionar aresta** - Conecta dois vértices com peso personalizado
- ✅ **Remover vértice** - Remove vértice e todas suas conexões
- ✅ **Remover aresta** - Remove conexão entre dois vértices
- ✅ **Consultas** - Verificar existência de vértices/arestas, obter vizinhos, pesos, etc.

# Características
- 🔄 **Genérico** - Suporte a qualquer tipo de vértice e peso
- 🧭 **Flexível** - Grafos direcionados e não-direcionados
- 🏗️ **Lista de Adjacência** - Implementação eficiente para grafos esparsos
- 🛡️ **Robusto** - Tratamento de erros e validações

  
# 📊 Métodos Disponíveis
# Operações Principais
Método	            Descrição
addVertex(V vertex)	Adiciona vértice
removeVertex(V vertex)	Remove vértice
addEdge(V source, V destination, E weight)	Adiciona aresta
removeEdge(V source, V destination)	Remove aresta

# Consultas
Método	        Descrição
getVertices()	Retorna todos os vértices
getNeighbors(V vertex)	Retorna vizinhos de um vértice
getEdgeWeight(V source, V destination)	Retorna peso da aresta
containsVertex(V vertex)	Verifica se vértice existe
containsEdge(V source, V destination)	Verifica se aresta existe
getVertexCount()	Número total de vértices
getEdgeCount()	Número total de arestas
isDirected()	Se o grafo é direcionado

# Utilitários
Método	  Descrição
display()	Exibe representação textual do grafo
getDegree(V vertex)	Grau do vértice
isEmpty()	Verifica se grafo está vazio
clear()	Limpa todo o grafo

# 🔄 Extensibilidade
A interface Graph<V, E> permite implementações alternativas:

Matriz de adjacência

Map/Dictionary personalizado

Outras estruturas de dados
