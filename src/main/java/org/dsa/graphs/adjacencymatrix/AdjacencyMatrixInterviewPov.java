package org.dsa.graphs.adjacencymatrix;

import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyMatrixInterviewPov {
    public static void bfs(int[][] list, boolean[] visited, int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            var x = queue.poll();
            System.out.println(x);
            for(int i=0;i<list.length;i++){
                if(!visited[i] && list[x][i] == 1){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void modifiedBfs(int[][] list, boolean[] visited){
        for(int i=0;i<list.length;i++){
            if(!visited[i]) {
                bfs(list, visited, i);
            }
        }
    }
    public static void dfs(int[][] list,boolean[] visited,int start){
        visited[start] = true;
        System.out.println(start);
        for(int i=0;i<list[start].length;i++){
            if(!visited[i] && list[start][i]==1){
                visited[i] = true;
                dfs(list,visited,i);
            }
        }
    }
    public static void modifiedDfs(int[][] list, boolean[] visited){
        for(int i=0;i<list.length;i++){
            if(!visited[i]){
                dfs(list,visited,i);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("------------------------BFS 1------------------------------");

        // 1) Undirected connected graph
        // 0->{1,2,3}, 1->{0,3}, 2->{0,3}, 3->{0,1,2}
        int size1 = 4;
        int[][] list1 = new int[4][4];
        boolean[] visited1 = new boolean[size1];
        list1[0][1] = 1;
        list1[0][2] = 1;
        list1[0][3] = 1;
        list1[1][0] = 1;
        list1[1][3] = 1;
        list1[2][0] = 1;
        list1[2][3] = 1;
        list1[3][0] = 1;
        list1[3][1] = 1;
        list1[3][2] = 1;
        bfs(list1,visited1,0);

        System.out.println("------------------------BFS 2------------------------------");

        // 2) Directed connected graph
        // 0->{1,2} 1->{3} 4->{3} 3->{0}
        int size2 = 5;
        int[][] list2 = new int[5][5];
        boolean[] visited2 = new boolean[size2];
        list2[0][1] = 1;
        list2[0][2] = 1;
        list2[1][3] = 1;
        list2[4][3] = 1;
        list2[3][0] = 1;
        bfs(list2,visited2,1);

        System.out.println("-----------------------------BFS 3-------------------------");

        // 3) Un-connected Un-directed graph
        // 0->{1,2} 1->{0,2} 2->{0,1} 3->{4} 4->{3}
        int size3 = 5;
        int[][] list3 = new int[5][5];
        boolean[] visited3 = new boolean[size3];
        list3[0][1] = 1;
        list3[0][2] = 1;
        list3[1][0] = 1;
        list3[1][2] = 1;
        list3[2][0] = 1;
        list3[2][1] = 1;
        list3[3][4] = 1;
        list3[4][3] = 1;
        modifiedBfs(list3,visited3);

        System.out.println("-----------------------------BFS 4-------------------------");

        // 4) Un-connected directed graph
        // 0->{1,2} 1->{3} 4->{5}
        int size4 = 6;
        int[][] list4 = new int[6][6];
        boolean[] visited4 = new boolean[size4];
        list4[0][1] = 1;
        list4[0][2] = 1;
        list4[1][3] = 1;
        list4[4][5] = 1;
        modifiedBfs(list4,visited4);

        System.out.println("-----------------------------DFS 1-------------------------");

        // 1) Undirected connected graph
        // 0->{1,2,3}, 1->{0,3}, 2->{0,3}, 3->{0,1,2}
        int size5 = 4;
        int[][] list5 = new int[4][4];
        boolean[] visited5 = new boolean[size5];
        list5[0][1] = 1;
        list5[0][2] = 1;
        list5[0][3] = 1;
        list5[1][0] = 1;
        list5[1][3] = 1;
        list5[2][0] = 1;
        list5[2][3] = 1;
        list5[3][0] = 1;
        list5[3][1] = 1;
        list5[3][2] = 1;
        dfs(list5,visited5,0);

        System.out.println("-----------------------------DFS 2-------------------------");
        // 2) Directed connected graph
        // 0->{1,2} 1->{3} 4->{3} 3->{0}

        int size6 = 5;
        int[][] list6 = new int[5][5];
        boolean[] visited6 = new boolean[size6];
        list6[0][1] = 1;
        list6[0][2] = 1;
        list6[1][3] = 1;
        list6[4][3] = 1;
        list6[3][0] = 1;
        dfs(list6,visited6,0);

        System.out.println("-----------------------------DFS 3-------------------------");

        // 3) Un-connected Un-directed graph
        // 0->{1,2} 1->{0,2} 2->{0,1} 3->{4} 4->{3}
        int size7 = 5;
        int[][] list7 = new int[5][5];
        boolean[] visited7 = new boolean[size7];
        list7[0][1] = 1;
        list7[0][2] = 1;
        list7[1][0] = 1;
        list7[1][2] = 1;
        list7[2][0] = 1;
        list7[2][1] = 1;
        list7[3][4] = 1;
        list7[4][3] = 1;
        modifiedDfs(list7,visited7);

        System.out.println("-----------------------------DFS 4-------------------------");

        // 4) Un-connected directed graph
        // 0->{1,2} 1->{3} 4->{5}
        int size8=6;
        boolean[] visited8 = new boolean[size8];
        int[][] list8 = new int[6][6];
        list8[0][1] = 1;
        list8[0][2] = 1;
        list8[1][3] = 1;
        list8[4][5] = 1;
        modifiedDfs(list8,visited8);
    }
}
