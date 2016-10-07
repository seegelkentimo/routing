/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class RoutingNode {

    private final String name;
    private ArrayList<Neighborship> neighbors;

    public RoutingNode(String name) {
        this.name = name;
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
