package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Graph {

    private int[][] distances;
    private String[] nodeNames;

    public Graph(int[][] distances, String[] nodeNames) {
        this.distances = distances;
        this.nodeNames = nodeNames;
    }

}
