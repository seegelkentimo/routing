package model;

import java.util.ArrayList;

/* @author Ostbot, PartyRazorHolland, Seegelkernspaltung */
public class Main {
    
    /* -1 == not connected, 0 == 127.0.0.1, n == metric */
    private static final int[][] metrics = { {  0, 152, 292,  -1,  -1,  -1},
                                             {152,   0, 292, 351, 263,  -1},
                                             {292, 292,   0,  -1, 198, 187},
                                             { -1, 351,  -1,   0, 396,  -1},
                                             { -1, 263, 198, 396,   0, 115},
                                             { -1,  -1, 187,  -1, 115,   0} };

    private static final String[] nodeNames = {"Hamburg", "Hannover","Berlin","Frankfurt","Leipzig","Dresden"};

    public static void main(String[] args) {
        RoutingGraph topology = new RoutingGraph(metrics, nodeNames);
        topology.buildGraph();
        topology.printGraph();
        ArrayList<RoutingNode> a = new ArrayList();
        System.out.println("blakeks "+
        topology.calculateCost(topology.getGraph()[0], topology.getGraph()[1], a)
    );
    }
}