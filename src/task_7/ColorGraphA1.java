package task_7;

import task_5.Graph;

import java.util.*;

public class ColorGraphA1 {
    static int n;
    static ArrayList<Integer>[] arr;
    static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Считывание данных, инициализация
        n = sc.nextInt();
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() == 1) {
                    arr[i].add(j);
                }
            }
        }

        HashMap<Integer, Integer> connections = new HashMap();
        for (int i = 0; i < n; i++) {
            connections.put(i + 1, arr[i].size());
        }

    }

    static void sort(HashMap<Integer, Integer> a) {
        for(Integer i : a.keySet()){
            for(Integer j : a.keySet()) {
                if(i < j) {
                    Integer t = i;
                    i = j;
                    j = t;
                }
            }
        }
    }

}


/**
 5
 0 1 1 0 0
 1 0 1 0 0
 1 1 0 1 1
 0 0 1 0 0
 0 0 1 0 0
 */