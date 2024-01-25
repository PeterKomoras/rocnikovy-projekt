import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    private static void findOptimalSizeKBisection() {

        File directory = new File("C:\\Users\\asus\\IdeaProjects\\Ban_Linial\\data");
        int vertexCount = 4;

        String filePath = "C:\\Users\\asus\\IdeaProjects\\Ban_Linial\\result3.txt";
        Path path = Paths.get(filePath);

        StringBuilder sb = new StringBuilder("size dif:\n0  1  2  3  4  5  6  7  8  9  10\n");

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) for (File file : files) {
                sb.append(vertexCount + "-vrcholove grafy \n");

                ArrayList<UndirectedGraph> graphs = GraphMaker.readGraphs(file, vertexCount);
                for (UndirectedGraph g : graphs) {
                    FindKBisections my2Bisections = new FindKBisections(g, 2);
                    int numOfComponents = my2Bisections.getMinimalNumOfComponents();

                    sb.append(numOfComponents + "|");

                    for (int sizeDif = 1; sizeDif < vertexCount/2; sizeDif++) {
                        FindKBisections Bisections = new FindKBisections(g, 2, sizeDif);


                        if (numOfComponents > Bisections.getMinimalNumOfComponents()) {
                            numOfComponents = Bisections.getMinimalNumOfComponents();
                            sb.append(" " + numOfComponents + "|");
                        } else sb.append("  |");
                        if (numOfComponents <= 1) break;
                    }

                    sb.append("\n");
                }

                System.out.println(vertexCount);

                vertexCount += 2;

                if (vertexCount == 20) {
                    System.out.println(sb);
                    try {
                        Files.write(path, sb.toString().getBytes());
                    } catch (IOException e) {
                        System.err.println("An error occurred while writing to the file: " + e.getMessage());
                    }
                    return;

                }
            }
        }

    }
    private static void findOptimalSizeBisection() {
        File directory = new File("C:\\Users\\asus\\IdeaProjects\\Ban_Linial\\data");
        int vertexCount = 4;

        String filePath = "C:\\Users\\asus\\IdeaProjects\\Ban_Linial\\result2.txt";
        Path path = Paths.get(filePath);

        StringBuilder sb = new StringBuilder("size dif:\n0  1  2  3  4  5  6  7  8  9  10\n");

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) for (File file : files) {
                sb.append(vertexCount + "-vrcholove grafy \n");

                ArrayList<UndirectedGraph> graphs = GraphMaker.readGraphs(file, vertexCount);
                for (UndirectedGraph g : graphs) {
                    FindKBisections my2Bisections = new FindKBisections(g, 2);
                    int numOfComponents = my2Bisections.getMinimalNumOfComponents();

                    sb.append(numOfComponents + "|");

                    for (int sizeDif = 1; sizeDif < vertexCount/2; sizeDif++) {
                        FindKBisections Bisections = new FindKBisections(g, 2, sizeDif);


                        if (numOfComponents > Bisections.getMinimalNumOfComponents()) {
                            numOfComponents = Bisections.getMinimalNumOfComponents();
                            sb.append(" " + numOfComponents + "|");
                        } else sb.append("  |");
                        if (numOfComponents <= 1) break;
                    }

                    sb.append("\n");
                }

                System.out.println(vertexCount);

                vertexCount += 2;

                if (vertexCount == 20) {
                    System.out.println(sb);
                    try {
                        Files.write(path, sb.toString().getBytes());
                    } catch (IOException e) {
                        System.err.println("An error occurred while writing to the file: " + e.getMessage());
                    }
                    return;

                }
            }
        }
    }

    private static void findOptimalKBisection() {
        File directory = new File("C:\\Users\\asus\\IdeaProjects\\Ban_Linial\\data");
        int vertexCount = 4;

        String filePath = "C:\\Users\\asus\\IdeaProjects\\Ban_Linial\\result1.txt";
        Path path = Paths.get(filePath);

        StringBuilder sb = new StringBuilder("k  2  3  4  5  6  7  8  9  10\n");

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) for (File file : files) {
                sb.append(vertexCount + "-vrcholove grafy \n");

                ArrayList<UndirectedGraph> graphs = GraphMaker.readGraphs(file, vertexCount);
                for (UndirectedGraph g : graphs) {
                    FindKBisections my2Bisections = new FindKBisections(g, 2);
                    int numOfComponents = my2Bisections.getMinimalNumOfComponents();

                    sb.append("   " + numOfComponents + "|");

                    for (int k = 3; k <= vertexCount/2; k++) {
                        FindKBisections kBisections = new FindKBisections(g, k);

                        if (numOfComponents > kBisections.getMinimalNumOfComponents()) {
                            numOfComponents = kBisections.getMinimalNumOfComponents();
                            sb.append(" " + numOfComponents + "|");
                        } else sb.append("  |");
                        if (numOfComponents <= 2) break;
                    }

                    sb.append("\n");
                }

                System.out.println(vertexCount);

                vertexCount += 2;

                if (vertexCount == 20) {
                    System.out.println(sb);
                    try {
                        Files.write(path, sb.toString().getBytes());
                    } catch (IOException e) {
                        System.err.println("An error occurred while writing to the file: " + e.getMessage());
                    }
                    return;

                }
            }
        }
    }


    public static void main(String[] args) {
//        findOptimalKBisection();
//        findOptimalSizeBisection();
    }
}