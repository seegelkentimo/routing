package model;

/**
 *
 * @author Ostbot, PartyRazorHolland, Seegelkernspaltung
 */
public class RoutingGraph {

    private final int[][] distances;
    private final String[] nodeNames;

    public RoutingGraph(int[][] distances, String[] nodeNames) {
        this.distances = distances;
        this.nodeNames = nodeNames;
    }

    public int[][] getDistances() {
        return distances;
    }

    public String[] getNodeNames() {
        return nodeNames;
    }

   

}
