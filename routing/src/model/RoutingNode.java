package model;

import java.util.ArrayList;

/*
    @author Ostbot, PartyRazorHolland, Seegelkernspaltung
*/

public class RoutingNode {

    private final String name;
    private ArrayList<Neighborship> neighbors;

    public RoutingNode(String name) {
        this.name = name;
        this.neighbors = new ArrayList();
    }

    public void addNeighbor(RoutingNode neighbor, int distance) {
        this.neighbors.add(new Neighborship(neighbor, distance));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Neighborship> getNeighbors() {
        return neighbors;
    }
}
