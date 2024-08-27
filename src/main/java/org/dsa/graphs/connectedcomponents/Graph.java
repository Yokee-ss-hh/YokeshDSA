package org.dsa.graphs.connectedcomponents;
import java.util.*;

public class Graph {
    public static void connectedComponentListDfs(List<List<Integer>> list, boolean[] visited, int start) {
        visited[start] = true;
        for (int x : list.get(start)) {
            if (!visited[x]) {
                visited[x] = true;
                connectedComponentListDfs(list, visited, x);
            }
        }
    }

    public static int dfsList(List<List<Integer>> list, boolean[] visited) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                connectedComponentListDfs(list, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void connectedComponentMatrixDfs(int[][] list, boolean[] visited, int start) {
        visited[start] = true;
        for(int i=0;i<list[start].length;i++){
            if(!visited[i] && list[start][i] == 1){
                visited[i] = true;
                connectedComponentMatrixDfs(list,visited,i);
            }
        }
    }

    public static int dfsMatrix(int[][] list, boolean[] visited) {
        int count = 0;
        for(int i=0;i<list.length;i++){
            if(!visited[i]){
                connectedComponentMatrixDfs(list,visited,i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 0->{1,2} 1->{0} 2->{0} 3->{4} 4->{3}  5
        List<List<Integer>> list = new ArrayList<>();
        int count = 6;
        boolean[] visited = new boolean[count];
        for (int i = 0; i < count; i++) {
            list.add(new ArrayList<>());
        }
        list.get(0).addAll(List.of(1, 2));
        list.get(1).add(0);
        list.get(2).add(0);
        list.get(3).add(4);
        list.get(4).add(3);
        list.get(5).add(5);
        System.out.println(dfsList(list, visited));

        int[][] list1 = new int[count][count];
        list1[0][1] = 1;
        list1[0][2] = 1;
        list1[1][0] = 1;
        list1[2][0] = 1;
        list1[3][4] = 1;
        list1[4][3] = 1;
        list1[5][5] = 1;
        boolean[] visited1 = new boolean[count];
        System.out.println(dfsMatrix(list1,visited1));
    }
}
