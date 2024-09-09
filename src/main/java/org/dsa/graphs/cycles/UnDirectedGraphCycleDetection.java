package org.dsa.graphs.cycles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnDirectedGraphCycleDetection {
    public static boolean dfsUtil(List<List<Integer>> list,boolean[] visited, int start, int parent){
        visited[start] = true;
        for(int i: list.get(start)){
            if(!visited[i]){
                if(dfsUtil(list, visited, i, start)){
                    return true;
                }
            }
            else if(i != parent){
                return true;
           }
        }
        return false;
    }
    static class Node{
        int node;
        int parent;
        Node(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public static boolean dfs(List<List<Integer>> list,boolean[] visited){
        for(int i=0;i<list.size();i++){
            if(!visited[i]){
                if(dfsUtil(list,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean bfsUtil(List<List<Integer>> list, boolean[] visited, int start){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start,-1));
        visited[start] = true;
        while(!queue.isEmpty()){
            var currentNode = queue.remove();
            var child = currentNode.node;
            var parent = currentNode.parent;
            for(Integer it: list.get(child)){
                if(!visited[it]){
                    queue.add(new Node(it,child));
                    visited[it] = true;
                }
                else if(it != parent){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean bfs(List<List<Integer>> list,boolean[] visited){
        for(int i=0;i<list.size();i++){
            if(!visited[i]){
                if(bfsUtil(list,visited,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int size = 2;
        boolean[] visited = new boolean[size];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            list.add(new ArrayList<>());
        }
        list.get(0).addAll(List.of(1));
        list.get(1).addAll(List.of(0));
        System.out.println(bfs(list,visited));
    }
}
