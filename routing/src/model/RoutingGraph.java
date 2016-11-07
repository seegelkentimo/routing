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
    
    public void buildGraph(int[][] a, String[] b) {
        
        for (int row = 0; row < a.length; row++) {
            
            System.out.println("Knoten: "+nodeNames[row]);
            RoutingNode n = new RoutingNode(nodeNames[row]);
            
            for (int col = 0; col < a[row].length; col++) {
                if (a[row][col] == 0 || a[row][col] == -1) continue; 
                
                System.out.println("NodeName: "+nodeNames[col]+" "+a[row][col]);
                n.addNeighbor((new RoutingNode(nodeNames[col])), a[row][col]);
            }
            System.out.println("==================");
            System.out.println("Nachbarn: ");
            for (int k = 0; k < n.getNeighbors().size(); k++) {
                System.out.println(n.getNeighbors().get(k).getNeighbor().getName());
            }
            System.out.println("==================");
        }
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
