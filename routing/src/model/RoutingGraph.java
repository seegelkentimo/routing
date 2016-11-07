package model;

import java.util.ArrayList;

/*
    @author Ostbot, PartyRazorHolland, Seegelkernspaltung
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

    public int calculateCost(RoutingNode start, RoutingNode target, ArrayList<RoutingNode> visited) {
        int minCost = -1;

        if (visited.contains(start)) {
            return -1;
        }
        visited.add(start);
        for (Neighborship neighbor : start.getNeighbors()) {
            int currentCost;
            if (neighbor.getNeighbor() == target) {
                currentCost = neighbor.getDistance();
            } else {
                currentCost = calculateCost(neighbor.getNeighbor(), target, visited);
            }
            if ( (minCost < 0) || ( (currentCost > 0) && (currentCost < minCost) ) ) {
                minCost = currentCost;
            }
        }
        return minCost;
    }
}