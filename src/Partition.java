import java.util.*;

public class Partition {
    private final ArrayList<Set<Integer>> partition;
    /** num of vertices in partition */
    private int size;
    /** key = component size; value = num of component of that size */
    private final Map<Integer,Integer> componentsSize;

    public Partition() {
        partition = new ArrayList<>();
        size = 0;
        componentsSize = new HashMap<>();
    }

    public Partition(ArrayList<Set<Integer>> partition, int size, Map<Integer,Integer> componentsSize) {
        this.partition = partition;
        this.size = size;
        this.componentsSize = componentsSize;
    }

    @Override
    public String toString() {
        String toReturn = "";
        toReturn += partition.toString();
        return toReturn;
    }

    public int getSize() {
        return size;
    }

    public Map<Integer, Integer> getComponentsSize() {
        return componentsSize;
    }
    public ArrayList<Set<Integer>> getPartition() {
        return partition;
    }

    /** get number of components greater than 1 */
    public int getNumOfComponent() {
        int res = 0;
        for (int k: componentsSize.keySet()) if (k > 1) {
            res += componentsSize.get(k);
        }
        return res;
    }


    public int getGreatestComponent() {
        int greatest = 0;
        for (int k: componentsSize.keySet()) {
            if (greatest < k) greatest = k;
        }
        return greatest;
    }


    /** @return size of a just created component  */
    public int addVertex(int v, List<Integer> neighbours) {
        size++;
        Set<Integer> component = new HashSet<>(Set.of(v));

        for (int i = 0; i < partition.size(); i++) {
            Set<Integer> currentPartition = partition.get(i);
            for (Integer n : neighbours) {
                if (currentPartition.contains(n)) {
                    partition.remove(currentPartition);
                    i--;
                    component.addAll(currentPartition);
//                    neighbours.remove(n);
                    componentsSize.put(currentPartition.size(), componentsSize.get(currentPartition.size()) - 1);
                    if (componentsSize.get(currentPartition.size()) == 0) componentsSize.remove(currentPartition.size());
                    break;
                }

            }
        }

        partition.add(component);
        if (componentsSize.containsKey(component.size())) {
            componentsSize.put(component.size(), componentsSize.get(component.size()) + 1);
        } else componentsSize.put(component.size(), 1);
        return component.size();
    }

    public static void main(String[] args) {
        Partition A = new Partition();
        Partition B = A.returnCopy();
        A.addVertex(1, List.of(2));
        System.out.println(A.getPartition() + " " + A.getComponentsSize() + " " + B.getPartition() + " " + B.getComponentsSize() + " "+ A + " " + B);
        System.out.println("p " + A.getPartition() + "s " + A.getSize() + "cs " + A.getComponentsSize());
        for (int i = 0; i < 15; i++) {
            System.out.println(i);
            if (i < 4) System.out.println("xx " + A.addVertex(i, List.of(6)));
            else System.out.println("yy " + i%2 + " " + i%5 + " " + A.addVertex(i, List.of(i%2, i%5)));
            System.out.println("p " + A.getPartition() + "s " + A.getSize() + "cs " + A.getComponentsSize());
            System.out.println("BBBBB: " + B.getPartition() + "s " + B.getSize() + "cs " + B.getComponentsSize());

        }


    }

    public Partition returnCopy() {
        HashMap<Integer, Integer> newComponentSize = new HashMap<>();
        for (Integer k : componentsSize.keySet()) newComponentSize.put(k, componentsSize.get(k));
        return new Partition((ArrayList<Set<Integer>>) partition.clone(), size, newComponentSize);
    }
}
