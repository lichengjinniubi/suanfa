package com.example.demo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 根据矩阵法生成图，并进行广度优先遍历
 */
public class GraphTestV3 {


    public static void main(String[] args) {
        int n = 5;
        String Vertex[] = {"A","B","C","D","E"};
        GraphTestV3 graphTestV1 = new GraphTestV3(n);

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

        System.out.println("进行广度优先遍历");

        graphTestV1.bfs();

    }

    //存储每个节点是否关联
    private int[][] edges;
    private List<String> edgeList = new ArrayList<>();

    private int edgeNum = 0;

    private boolean[] isVisited;


    public GraphTestV3(int n){
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


    /**
     * 进行深度优先遍历
     * @param isVisited
     * @param index
     */
    public void def(boolean[] isVisited, int index){
        System.out.print(this.getValueByIndex(index) + "->");
        isVisited[index] = true;

        for(int w = getFirstNeighbor(index); w != -1; w = getNextNeighbor(index, w)){
            if(!isVisited[w]){
                def(isVisited, w);
            }
        }
    }


    public void def(){
        isVisited = new boolean[edgeList.size()];
        for(int i = 0; i < edgeList.size(); i++){
            if(!isVisited[i]){
                def(isVisited, i);
            }

        }
    }

    public void bfs(){
        isVisited = new boolean[edgeList.size()];
        for(int i = 0; i < edgeList.size(); i++){
            if(!isVisited[i]){

                bfs(isVisited, i);
            }

        }
    }

    public void bfs(boolean[] isVisited, int index){
        System.out.print(this.getValueByIndex(index) + "=>");
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(index);
        while (!queue.isEmpty()){
            int u = (Integer)queue.removeFirst();
            //getNextNeighbor意思是从w开始向后找u的下一个邻接点
            for(int w = getFirstNeighbor(index); w != -1; w = getNextNeighbor(u, w)){
                if(!isVisited[w]){
                    System.out.print(this.getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
            }
        }
    }

    public String getValueByIndex(int i){
        return this.edgeList.get(i);
    }

    /**
     * 找到当前节点的第一个连接点
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index){
        for(int j = 0; j < this.edgeList.size(); j++){
            if(this.edges[index][j] > 0){
                return j;
            }
        }

        return -1;
    }

    /**
     * 根据当前节点获取下一个连接点
     * @param indexv1
     * @param indexv2
     * @return
     */
    public int getNextNeighbor(int indexv1, int indexv2){
        for(int j = indexv2+1; j < this.edgeList.size(); j++){
            if(this.edges[indexv1][j] > 0){
                return j;
            }
        }

        return -1;
    }
}
