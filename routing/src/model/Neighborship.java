package model;

/* @author Ostbot, PartyRazorHolland, Seegelkernspaltung */
public class Neighborship {

    private final int distance;
    private final RoutingNode neighbor;

    public Neighborship(RoutingNode neighbor, int distance) {
        this.distance = distance;
        this.neighbor = neighbor;
    }

    /********************************* Getter *********************************/  
    public int getDistance() { return distance; }

    public RoutingNode getNeighbor() { return neighbor; }
}