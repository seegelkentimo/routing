package model;

import java.util.ArrayList;

/*
    @author Ostbot, PartyRazorHolland, Seegelkernspaltung
*/
public class RoutingGraph {

    private final int[][] distances;
    private final String[] nodeNames;
    private RoutingNode graph;

    public RoutingGraph(int[][] distances, String[] nodeNames) {
        this.distances = distances;
        this.nodeNames = nodeNames;
        this.graph = null;
    }
    
    public void buildGraph() {
        
        for (int row = 0; row < distances.length; row++) {
            
//            System.out.println("Knoten: "+nodeNames[row]);
            RoutingNode graph = new RoutingNode(nodeNames[row]);
            
            for (int col = 0; col < distances[row].length; col++) {
                if (distances[row][col] == 0 || distances[row][col] == -1) continue; 
                
//                System.out.println("NodeName: "+nodeNames[col]+" "+a[row][col]);
                graph.addNeighbor((new RoutingNode(nodeNames[col])), distances[row][col]);
            }
//            System.out.println("==================");
//            System.out.println("Nachbarn: ");
//            for (int k = 0; k < graph.getNeighbors().size(); k++) {
//                System.out.println(graph.getNeighbors().get(k).getNeighbor().getName());
//            }
//            System.out.println("==================");
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
    
    /********************************* Setter *********************************/
    
    public void setGraph(RoutingNode graph) {
        this.graph = graph;
    }
        
    /********************************* Getter *********************************/
    public RoutingNode getGraph() {
        return graph;
    }

    public int[][] getDistances() {
        return distances;
    }

    public String[] getNodeNames() {
        return nodeNames;
    }
}
