package org.dsa.graphs.stronglyconnectedcomponents;

import java.util.Stack;

public class Graph {
    public static void dfs(int[][] list, boolean[] visited, int start, Stack<Integer> stack) {
        visited[start] = true;
        for (int i = 0; i < list[start].length; i++) {
            if (!visited[i] && list[start][i] == 1) {
                visited[i] = true;
                dfs(list, visited, i, stack);
            }
        }
        stack.push(start);
    }
    public static void dfs1(int[][] list, boolean[] visited, int start) {
        visited[start] = true;
        System.out.print(start);
        for (int i = 0; i < list[start].length; i++) {
            if (!visited[i] && list[start][i] == 1) {
                visited[i] = true;
                dfs1(list, visited, i);
            }
        }
    }
    public static void dfsUtil(int[][] list, boolean[] visited,Stack<Integer> stack){
        for(int i=0;i<list.length;i++){
            if(!visited[i]){
                dfs(list,visited,i,stack);
            }
        }
    }
    public static void main(String[] args) {
        // 0->{1} 1->{2} 2->{0,3} 3->{4} 4->{5,7} 5->{6} 6->{4,7} 7
        int size = 8;
        int[][] list = new int[size][size];
        boolean[] visited = new boolean[size];
        Stack<Integer> stack = new Stack<>();
        list[0][1] = 1;
        list[1][2] = 1;
        list[2][0] = 1;
        list[2][3] = 1;
        list[3][4] = 1;
        list[4][5] = 1;
        list[4][7] = 1;
        list[5][6] = 1;
        list[6][4] = 1;
        list[6][7] = 1;
        dfsUtil(list,visited,stack);
        int[][] list1 = new int[size][size];
        for(int i=0;i<list.length;i++){
            visited[i] = false;
            for(int j=0;j<list.length;j++){
                list1[i][j] = list[j][i];
            }
        }
        int count = 0;
        while (!stack.isEmpty()){
            int temp = stack.pop();
            if(!visited[temp]){
                count ++;
                dfs1(list1,visited,temp);
                System.out.println("\n");
            }
        }
        System.out.println(count);
    }
}
