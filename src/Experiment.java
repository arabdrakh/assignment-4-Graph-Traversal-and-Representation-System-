//Aruzhan Abdrakhmanova IT-2501
public class Experiment {
    public void runTraversals(Graph g) {
        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();
        long bfsTime = endBfs - startBfs;

        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();
        long dfsTime = endDfs - startDfs;

        System.out.println("Execution Time - BFS: " + bfsTime + " ns | DFS: " + dfsTime + " ns");
    }

    public void runMultipleTests() {
        System.out.println(" SMALL GRAPH (10 Vertices) ");
        Graph smallGraph = createGraph(10);
        smallGraph.printPath = true;
        System.out.println("Graph Structure:");
        smallGraph.printGraph();
        System.out.println();
        runTraversals(smallGraph);

        System.out.println("\n MEDIUM GRAPH (30 Vertices) ");
        Graph mediumGraph = createGraph(30);
        mediumGraph.printPath = false;
        runTraversals(mediumGraph);

        System.out.println("\n LARGE GRAPH (100 Vertices) ");
        Graph largeGraph = createGraph(100);
        largeGraph.printPath = false;
        runTraversals(largeGraph);
    }

    private Graph createGraph(int size) {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }
        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1);
            if (i + 2 < size) {
                g.addEdge(i, i + 2);
            }
        }
        return g;
    }

    public void printResults() {
        System.out.println("\n    Experiments Completed   ");
        System.out.println("Note: Time measurements (in nanoseconds) can vary slightly between runs due to JVM warmup.");
    }
}