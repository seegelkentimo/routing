package model;

/**
 *
 * @author Ostbot, PartyRazorHolland, Seegelkernspaltung
 */
public class Main {
    private static final int[][] distances = {  {  0, 152, 292,  -1,  -1,  -1},
                                                {152,   0, 292, 351, 263,  -1},
                                                {292, 292,   0,  -1, 198, 187},
                                                { -1, 351,  -1,   0, 396,  -1},
                                                { -1, 263, 198, 396,   0, 115},
                                                { -1,  -1, 187,  -1, 115,   0} };

    private static final String[] nodes = {"Hamburg", "Hannover","Berlin","Frankfurt","Leipzig","Dresden"};

    public Main() {
        
    }

    public static void main(String[] args) {
        RoutingGraph topology = new RoutingGraph(distances, nodes);
        topology.buildGraph(distances, nodes);
    }
}
