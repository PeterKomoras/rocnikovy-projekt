import java.util.ArrayList;

public class FindKBisections {
    private int k;
    private final UndirectedGraph g;

    /** minimal number of components greater than 1 */
    private int minimalNumOfComponents;
    private ArrayList<Partition> bisections; // bipartitný graf 2 partície

    private final int partitionSizeDif;


    //    /** a count of components with one colour and size 2 */
//    private int minComponentsCount;
    private final int vertexCount;

    public FindKBisections(UndirectedGraph g, int k) {
        this.g = g;
        this.k = k;
        this.vertexCount = g.getVertexCount();
        this.partitionSizeDif = 0;
        bisections = new ArrayList<>();

        minimalNumOfComponents = Integer.MAX_VALUE;

        Partition A = new Partition();
        Partition B = new Partition();

        bisections.add(A);
        bisections.add(B);




        A.addVertex(1, g.getNeighbours(1));
        search(2, A, B);
    }

    public FindKBisections(UndirectedGraph g, int k, int partitionSizeDif) {
        this.g = g;
        this.k = k;
        this.vertexCount = g.getVertexCount();
        this.partitionSizeDif = partitionSizeDif;
        bisections = new ArrayList<>();

        minimalNumOfComponents = Integer.MAX_VALUE;

        Partition A = new Partition();
        Partition B = new Partition();

        bisections.add(A);
        bisections.add(B);




        A.addVertex(1, g.getNeighbours(1));
        search(2, A, B);
    }


    private void search(int v, Partition A, Partition B) {
        if (v > vertexCount) {
            // check num of components
            int numOfComponents = A.getNumOfComponent() + B.getNumOfComponent();
            if (numOfComponents > minimalNumOfComponents) return;
            minimalNumOfComponents = numOfComponents;
            bisections.clear();

            bisections.add(A);
            bisections.add(B);
            return;
        }

        Partition vertexToA = A.returnCopy();

        if (k >= vertexToA.addVertex(v, g.getNeighbours(v))) {
            if (vertexToA.getSize() - partitionSizeDif <= vertexCount/2) {
                search(v+1, vertexToA, B);
            }
        }




        Partition vertexToB = B.returnCopy();
        if (k >= vertexToB.addVertex(v, g.getNeighbours(v))) {
            if (vertexToB.getSize() - partitionSizeDif <= vertexCount/2) {
                search(v+1, A, vertexToB);
            }
        }
    }



    public ArrayList<Partition> getKbisections() {
        return bisections;
    }

    public int getMinimalNumOfComponents() {
        return minimalNumOfComponents;
    }

}
