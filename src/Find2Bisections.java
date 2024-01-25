import java.util.*;

public class Find2Bisections {
    private final UndirectedGraph g;
    private ArrayList<Partition> bisections; // bipartitný graf 2 partície


//    /** a count of components with one colour and size 2 */
//    private int minComponentsCount;
    private final int vertexCount;

    public Find2Bisections(UndirectedGraph g) {
        this.g = g;
        this.vertexCount = g.getVertexCount();
        bisections = new ArrayList<>();

        Partition A = new Partition();
        Partition B = new Partition();




        A.addVertex(1, g.getNeighbours(1));
        search(2, A, B);
    }

    private void search(int v, Partition A, Partition B) {
        if (v > vertexCount) {
            bisections.add(A);
            bisections.add(B);
            return;
        }

        Partition vertexToA = A.returnCopy();

        if (2 >= vertexToA.addVertex(v, g.getNeighbours(v))) {
            if (vertexToA.getSize() <= vertexCount/2) {
                search(v+1, vertexToA, B);
            }
        }




        Partition vertexToB = B.returnCopy();
        if (2 >= vertexToB.addVertex(v, g.getNeighbours(v))) {
            if (vertexToB.getSize() <= vertexCount/2) {
                search(v+1, A, vertexToB);
            }
        }
    }



    public ArrayList<Partition> get2bisections() {
        return bisections;
    }
}
