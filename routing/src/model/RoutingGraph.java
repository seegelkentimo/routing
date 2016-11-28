package model;

import java.util.ArrayList;

/* @author Ostbot, PartyRazorHolland, Seegelkernspaltung */
public class RoutingGraph {

    private final int[][] distances;
    private final String[] nodeNames;
    private RoutingNode[] graph;

    public RoutingGraph(int[][] distances, String[] nodeNames) {
        this.distances = distances;
        this.nodeNames = nodeNames;
        this.graph = new RoutingNode[nodeNames.length];
    }
    
    public void buildGraph() {
        
        for (int row = 0; row < distances.length; row++) {
            
//            System.out.println("Knoten: "+nodeNames[row]);
            RoutingNode tmp = new RoutingNode(nodeNames[row]);
            
            for (int col = 0; col < distances[row].length; col++) {
                if (distances[row][col] == 0 || distances[row][col] == -1) continue; 
                
//                System.out.println("NodeName: "+nodeNames[col]+" "+distances[row][col]);
                tmp.addNeighbor((new RoutingNode(nodeNames[col])), distances[row][col]);
            }
            graph[row] = tmp;
 //           System.out.println("==================");
 //           System.out.println("Nachbarn: ");
 //           for (int k = 0; k < graph.getNeighbors().size(); k++) {
 //               System.out.println(graph.getNeighbors().get(k).getNeighbor().getName()+" : "+graph.getNeighbors().get(k).getDistance());
 //          }
 //           System.out.println("==================");
        }
    }
    
    public void printGraph() {
        System.out.println("Size = "+graph.length);
        for(int i=0;i<graph.length;i++) {
            System.out.println("++++++++++++++++++\nNode: "+graph[i].getName()+"\n++++++++++++++++++\nNeighbor :: Distance");
            for (Neighborship neighbor : graph[i].getNeighbors()) {
                System.out.println(neighbor.getNeighbor().getName()+" :: "+neighbor.getDistance());
            }
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
    //public void setGraph(RoutingNode graph) { this.graph = graph; }
        
    /********************************* Getter *********************************/
    public RoutingNode[] getGraph() { return graph; }

    public int[][] getDistances() { return distances; }

    public String[] getNodeNames() { return nodeNames; }
}