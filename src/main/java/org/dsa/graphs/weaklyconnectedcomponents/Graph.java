package org.dsa.graphs.weaklyconnectedcomponents;


import java.util.ArrayList;
import java.util.*;

public class Graph {
    public static void dfs(List<List<Integer>> list, boolean[] visited, int start){
        visited[start] = true;
        for(int x: list.get(start)){
            if(!visited[x]){
                dfs(list,visited,x);
            }
        }
    }
    public static int dfsUtil(List<List<Integer>>list, boolean[] visited){
        int count =0;
        for(int i=0;i<list.size();i++){
            if(!visited[i]){
                dfs(list,visited,i);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // 0->{1,2} 1->{2} 3->{4}
        // There are 2 disconnected directed graphs in the above i.e, {0,1,2} and {3,4}
        // Both graphs cannot be strongly connected components as in 1st subgraph {0,1,2} we cannot reach 0 or 1 from 2
        // we cannot reach 3 from 4
        // These 2 sub-graphs can be weakly connected components
        // Inorder to find number of weakly connected components of a directed graph, First convert directed graph
        // into undirected graph and perform connected components' algorithm.
        List<List<Integer>> list = new ArrayList<>();
        int size = 5;
        for(int i=0;i<size;i++){
            list.add(new ArrayList<>());
        }
        list.get(0).addAll(List.of(1,2));
        list.get(1).addAll(List.of(0,2));
        list.get(2).add(0);
        list.get(3).add(4);
        list.get(4).add(3);
        boolean[] visited = new boolean[size];
        System.out.println(dfsUtil(list,visited));
    }
}
