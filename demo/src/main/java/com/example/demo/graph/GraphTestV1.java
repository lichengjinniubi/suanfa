package com.example.demo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据矩阵法生成图
 */
public class GraphTestV1 {


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

    //存储每个节点是否关联
    private int[][] edges;
    private List<String> edgeList = new ArrayList<>();

    private int edgeNum = 0;

    private boolean[] isVisited;


    public GraphTestV1(int n){
        edges = new int[n][n];
    }

    /**
     * 添加节点到List
     * @param value
     */
    public void addEdgeToList(String value){
        edgeList.add(value);
        edgeNum++;
    }


    public void addIndexOfEdge(int i, int j, int value){
        edges[i][j] = value;
        edges[j][i] = value;
    }


    public void showEdge(){
        for (int[] edge : edges){
            System.out.println(Arrays.toString(edge));
        }
    }







}
