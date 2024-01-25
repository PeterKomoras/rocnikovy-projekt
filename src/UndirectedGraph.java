import java.util.*;

class UndirectedGraph {
    private int vertexCount;
    private Map<Integer, List<Integer>> adjacencyList;

//    private int[] color;
//
//    private void resetColor() {
//        color = new int[vertexCount + 1];
//        Arrays.fill(color, -1);
//    }
//
//    // Pomocná funkcia pre DFS na farbenie grafu
//    private boolean dfsColor(int v, int c) {
//        color[v] = c;
//        for (int n : getNeighbors(v)) {
//            if (color[n] == -1) {
//                if (!dfsColor(n, 1-c)) return false;
//            } else if (color[n] == c) {
//                return false; // Nedokážeme správne zafarbiť
//            }
//        }
//        return true;
//    }
//
//    // Funkcia na výpočet minimálneho počtu komponentov jednej farby veľkosti n
//    int minComponents(int n) {
//        resetColor();
//        // Pokus o zafarbenie grafu
//        if (!dfsColor(1, 0)) { // Začneme od vrcholu 1
////            System.out.println("Nedá sa zafarbiť graf");
//            return -1;
//        }
//
//        int[] count = new int[2];
//        Arrays.fill(count, 0);
//
//        // Spočítanie veľkostí komponentov pre každú farbu
//        for (int v = 1; v <= vertexCount; ++v) {
//            count[color[v]]++;
//        }
//
//        // Zistenie minimálneho počtu komponentov veľkosti n
//        if (count[0] == count[1] && count[0] == n) {
//            return 1;
//        }
//        return Math.min(count[0], count[1]);
//    }
//
//
//
//
//
//    // Funkcia na kontrolu, či je graf bipartitný
//    private boolean isBipartiteUtil(int v, int c) {
//        color[v] = c;
//
//        for (int n : getNeighbors(v)) {
//            if (color[n] == -1) {
//                if (!isBipartiteUtil(n, 1-c))
//                    return false;
//            } else if (color[n] == c) {
//                return false; // Ak susedný vrchol má rovnakú farbu, graf nie je bipartitný
//            }
//        }
//        return true;
//    }
//
//    // Funkcia na zistenie, či je možné zafarbiť graf dvoma farbami
//    boolean isBipartite2() {
//        resetColor();
//        for (int i = 1; i <= vertexCount; ++i) {
//            if (color[i] == -1) {
//                if (!isBipartiteUtil(i, 0)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    // Funkcia na výpis farieb vrcholov
//    void printColors() {
//        int count1 = 0, count2 = 0;
//        for (int i = 1; i <= vertexCount; ++i) {
//            if (color[i] == 0) count1++;
//            else if (color[i] == 1) count2++;
//        }
//        System.out.println("Počet vrcholov farby 1: " + count1);
//        System.out.println("Počet vrcholov farby 2: " + count2);
//    }
//
//    int[] retColors() {
//        int count1 = 0, count2 = 0;
//        for (int i = 1; i <= vertexCount; ++i) {
//            if (color[i] == 0) count1++;
//            else if (color[i] == 1) count2++;
//        }
//        return new int[]{count1, count2};
//    }
//
//    public boolean isBipartite() {
//        Map<Integer, Integer> colors = new HashMap<>();
//
//        for (int vertex : adjacencyList.keySet()) {
//            if (!colors.containsKey(vertex) && !bfsIsBipartite(vertex, colors)) {
//                return false;
//            }
//        }
//        System.out.println(colors);
//        return true;
//    }
//
//    // Helper function for BFS to check bipartiteness
//    private boolean bfsIsBipartite(int start, Map<Integer, Integer> colors) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(start);
//        colors.put(start, 0);
//
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//
//            for (int neighbor : getNeighbors(current)) {
//                if (!colors.containsKey(neighbor)) {
//                    colors.put(neighbor, 1 - colors.get(current)); // Color with the opposite color
//                    queue.add(neighbor);
//                } else if (colors.get(neighbor) == colors.get(current)) {
//                    // If adjacent vertices have the same color, the graph is not bipartite
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//

    public UndirectedGraph() {
        vertexCount = 0;
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        vertexCount++;
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(int vertex1, int vertex2) {
        // Adding edge from vertex1 to vertex2
        try {
            adjacencyList.get(vertex1).add(vertex2);
        } catch (Exception e) {
            System.out.println(vertex1);
        }
        // Adding edge from vertex2 to vertex1
        try {
            adjacencyList.get(vertex2).add(vertex1);
        } catch (Exception e) {
            System.out.println(vertex2);
        }
    }

    public List<Integer> getNeighbours(int vertex) {
        return adjacencyList.get(vertex);
    }

    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public boolean hasEdge( int vertex1, int vertex2) {
        if (adjacencyList.containsKey(vertex1))
            if (adjacencyList.get(vertex1).contains(vertex2))
                return true;
        return false;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}