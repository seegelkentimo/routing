/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Neighborship {

    private final int distance;
    private final RoutingNode neighbor;

    public Neighborship(RoutingNode neighbor, int distance) {
        this.distance = distance;
        this.neighbor = neighbor;
    }

    public int getDistance() {
        return distance;
    }

    public RoutingNode getNeighbor() {
        return neighbor;
    }

}
