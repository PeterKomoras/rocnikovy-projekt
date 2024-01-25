import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GraphMaker {
    public static ArrayList<UndirectedGraph> readGraphs(File file, int vertexCount) {
        ArrayList<UndirectedGraph> result = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();

            UndirectedGraph g = new UndirectedGraph();
            for (int v = 1; v <= vertexCount; v++) g.addVertex(v);


            int i = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.trim().split("\\s+");

                if (Objects.equals(numbers[0], "Graph")) {

                    result.add(g);
                    g  = new UndirectedGraph();
                    i = 1;
                    for (int v = 1; v <= vertexCount; v++) g.addVertex(v);
                } else if (numbers.length > 0 && numbers[0].length() > 0 && Character.isDigit(numbers[0].charAt(0))) {
                    for (String num : numbers) {
                        if (!g.hasEdge(i, Integer.parseInt(num)))
                            g.addEdge(i, Integer.parseInt(num));
                    }
                    i++;
                }

            }
            result.add(g);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return result;
    }





}
