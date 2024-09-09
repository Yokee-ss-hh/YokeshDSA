package org.dsa.graphs.cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectedGraphCycleDetection {
    public static boolean dfs(List<List<Integer>> list, boolean[] visited, boolean[] pathVisited, int start){
        visited[start] = true;
        pathVisited[start] = true;
        for(int i: list.get(start)){
            if(!visited[i] && dfs(list,visited,pathVisited,i)){
                return true;
            }
            else if(pathVisited[i]){
                return true;
            }
        }
        pathVisited[start] = false;
        return false;
    }
    public static boolean dfsUtil(List<List<Integer>> list, boolean[] visited, boolean[] pathVisited){
        for(int i=0;i<list.size();i++){
            if(!visited[i] && dfs(list, visited, pathVisited, i)){
                return true;
            }
        }
        return false;
    }
    public static boolean dfs1(int[][] list, boolean[] visited, boolean[] pathVisited, int start){
        visited[start] = true;
        pathVisited[start] = true;
        for(int j=0;j<list[start].length;j++){
            if(!visited[j] && list[start][j]==1){
                if(dfs1(list,visited,pathVisited,j)){
                    return true;
                }
            }
            else if(pathVisited[j] && list[start][j]==1){
                return true;
            }
        }
        pathVisited[start] = false;
        return false;
    }
    public static boolean dfsUtil1(int[][] list, boolean[] visited, boolean[] pathVisited){
        for(int i=0;i< list.length;i++){
            if(!visited[i] && dfs1(list,visited,pathVisited,i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // Given the root of directed graph, Need to find the cycle in it.
        // 0->{1} 1->{0}
        int size = 3;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(1).add(2);
        boolean[] visited = new boolean[size];
        boolean[] pathVisited = new boolean[size];
        System.out.println(dfsUtil(list,visited,pathVisited));

        // 0->{1} 1->{0}
        int[][] list1 = new int[size][size];
        boolean[] visited1 = new boolean[size];
        boolean[] pathVisited1 = new boolean[size];
        list1[0][1] = 1;
        list1[1][2] = 1;
        System.out.println(dfsUtil1(list1,visited1,pathVisited1));

        // There is a reason why we need pathVisited array for directed graph only...
        // Let's take this example 0->{1,2} 1->{3} 2->{3} and explore dfs using only 1 boolean visited array
        // when we start at 0, the dfs will explore 1 & 3, the visited array will be [T,T,F,T]
        // Backtracking will be from 3->1->0
        // Now, We will visit 2, and it will be marked, [T,T,T,T]
        // From 2, we go to 3 which is already marked as visited and the algorithm will declare as cyclic since we visited the node '3' in boolean visited array.
        // Now, The DFS is completed for all nodes. But, If we see the graph. The graph has no cycle in it. This is the reason we need to use
        // secondary boolean array for the directed graphs.
        // For Undirected graphs, No need to extra boolean array as it has bidirectional edges and loop will be detected using visited boolean array.
        // But make sure to check parent for undirected graphs while finding cycles. Since, if there is a path from 0->1 there will a path from 1->0 as well.
        // If we are going from 0->1 , after reaching 1, we will have a path to 0 as well, so track the 1 from where it came from and avoid it. i.e, avoid '0' which
        // is its parent.
    }
}
