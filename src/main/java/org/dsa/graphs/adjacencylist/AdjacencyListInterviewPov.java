package org.dsa.graphs.adjacencylist;

import java.util.*;

public class AdjacencyListInterviewPov {
    public static void bfs(List<List<Integer>> adj, boolean[] visited, int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            Integer curr = queue.poll();
            System.out.println(curr);
            for(Integer x: adj.get(curr)){
                if(!visited[x]){
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
    }
    public static void modifiedBfs(List<List<Integer>> list,boolean[] visited){
        for(int i=0;i<list.size();i++){
            if(!visited[i]){
                bfs(list,visited,i);
            }
        }
    }
    public static void dfs(List<List<Integer>> list, boolean[] visited, int start){
        System.out.println(start);
        visited[start] = true;
        for(int x: list.get(start)){
            if(!visited[x]){
                dfs(list,visited,x);
            }
        }
    }
    public static void modifiedDfs(List<List<Integer>> list,boolean[] visited){
        for(int i=0;i<list.size();i++){
            if(!visited[i]){
                dfs(list,visited,i);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("------------------------BFS 1------------------------------");

        // 1) Undirected connected graph
        // 0->{1,2,3}, 1->{0,3}, 2->{0,3}, 3->{0,1,2}
        List<List<Integer>> list1 = new ArrayList<>();
        int size1 = 4;
        boolean[] b1 = new boolean[4];
        for (int i = 0; i < size1; i++) {
            list1.add(new ArrayList<>());
        }
        list1.get(0).addAll(List.of(1, 2, 3));
        list1.get(1).addAll(List.of(0, 3));
        list1.get(2).addAll(List.of(0, 3));
        list1.get(3).addAll(List.of(0, 1, 2));
        bfs(list1, b1, 0);

        System.out.println("--------------------------BFS 2----------------------------");

        // 2) Directed connected graph
        // 0->{1,2} 1->{3} 4->{3} 3->{0}
        List<List<Integer>> list2 = new ArrayList<>();
        int size2 = 5;
        boolean[] b2 = new boolean[5];
        for (int i = 0; i < size2; i++) {
            list2.add(new ArrayList<>());
        }
        list2.get(0).addAll(List.of(1, 2));
        list2.get(1).addAll(List.of(3));
        list2.get(3).addAll(List.of(0));
        list2.get(4).addAll(List.of(3));
        bfs(list2, b2, 0);

        System.out.println("-----------------------------BFS 3-------------------------");

        // 3) Un-connected Un-directed graph
        // 0->{1,2} 1->{0,2} 2->{0,1} 3->{4} 4->{3}
        List<List<Integer>> list3 = new ArrayList<>();
        int size3 = 5;
        boolean[] b3 = new boolean[5];
        for (int i = 0; i < size3; i++) {
            list3.add(new ArrayList<>());
        }
        list3.get(0).addAll(List.of(1, 2));
        list3.get(1).addAll(List.of(0,2));
        list3.get(2).addAll(List.of(0, 1));
        list3.get(3).addAll(List.of(4));
        list3.get(4).addAll(List.of(3));
        modifiedBfs(list3, b3);

        System.out.println("---------------------------BFS 4---------------------------");

        // 4) Un-connected Directed graph
        // 0->{1,2} 1->{3} 4->{5}
        List<List<Integer>> list4 = new ArrayList<>();
        int size4 = 6;
        boolean[] b4 = new boolean[6];
        for (int i = 0; i < size4; i++) {
            list4.add(new ArrayList<>());
        }
        list4.get(0).addAll(List.of(1,2));
        list4.get(1).addAll(List.of(3));
        list4.get(4).addAll(List.of(5));
        modifiedBfs(list4, b4);

        System.out.println("-------------------------DFS 1-----------------------------");
        // 1) Undirected connected graph
        // 0->{1,2,3}, 1->{0,3}, 2->{0,3}, 3->{0,1,2}
        List<List<Integer>> list5 = new ArrayList<>();
        int size5 = 4;
        boolean[] b5 = new boolean[4];
        for (int i = 0; i < size5; i++) {
            list5.add(new ArrayList<>());
        }
        list5.get(0).addAll(List.of(1, 2, 3));
        list5.get(1).addAll(List.of(0, 3));
        list5.get(2).addAll(List.of(0, 3));
        list5.get(3).addAll(List.of(0, 1, 2));
        dfs(list5,b5,0);

        System.out.println("-------------------------DFS 2-----------------------------");
        // 2) Directed connected graph
        // 0->{1,2} 1->{3} 4->{3} 3->{0}
        List<List<Integer>> list6 = new ArrayList<>();
        int size6 = 5;
        boolean[] b6 = new boolean[5];
        for (int i = 0; i < size6; i++) {
            list6.add(new ArrayList<>());
        }
        list6.get(0).addAll(List.of(1, 2));
        list6.get(1).addAll(List.of(3));
        list6.get(3).addAll(List.of(0));
        list6.get(4).addAll(List.of(3));
        dfs(list6,b6,0);

        System.out.println("-------------------------DFS 3-----------------------------");
        // 3) Un-connected Un-directed graph
        // 0->{1,2} 1->{0,2} 2->{0,1} 3->{4} 4->{3}
        List<List<Integer>> list7 = new ArrayList<>();
        int size7 = 5;
        boolean[] b7 = new boolean[5];
        for (int i = 0; i < size7; i++) {
            list7.add(new ArrayList<>());
        }
        list7.get(0).addAll(List.of(1, 2));
        list7.get(1).addAll(List.of(0,2));
        list7.get(2).addAll(List.of(0, 1));
        list7.get(3).addAll(List.of(4));
        list7.get(4).addAll(List.of(3));
        modifiedDfs(list7,b7);

        System.out.println("-------------------------DFS 4-----------------------------");

        // 4) Un-connected Directed graph
        // 0->{1,2} 1->{3} 4->{5}
        List<List<Integer>> list8 = new ArrayList<>();
        int size8 = 6;
        boolean[] b8 = new boolean[6];
        for (int i = 0; i < size8; i++) {
            list8.add(new ArrayList<>());
        }
        list8.get(0).addAll(List.of(1,2));
        list8.get(1).addAll(List.of(3));
        list8.get(4).addAll(List.of(5));
        modifiedDfs(list8,b8);
    }
}
