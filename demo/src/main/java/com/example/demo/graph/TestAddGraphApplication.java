package com.example.demo.graph;

/**
 * 简单的矩阵图的增删和查
 */
public class TestAddGraphApplication {

    public static void main(String[] args) {
        int n = 5;
        String Vertex[] = {"A","B","C","D","E"};
        GraphTestV1 graphTestV1 = new GraphTestV1(n);

        for (String vertex : Vertex){
            graphTestV1.addEdgeToList(vertex);
        }

        //A-B A-C B-C B-D B-E
        graphTestV1.addIndexOfEdge(0,1,1);
        graphTestV1.addIndexOfEdge(0,2,1);
        graphTestV1.addIndexOfEdge(1,2,1);
        graphTestV1.addIndexOfEdge(1,3,1);
        graphTestV1.addIndexOfEdge(1,4,1);

        graphTestV1.showEdge();
    }
}
