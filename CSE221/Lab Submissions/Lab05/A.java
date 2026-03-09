package Lab05;

import java.io.*;
import java.util.*;

public class A {
   public static void main(String[] args) throws Exception {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(System.out);

       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       ArrayList<Integer>[] adj = new ArrayList[N + 1];
       for (int i = 1; i <= N; i++) {
           adj[i] = new ArrayList<Integer>();
       }

       for (int i = 0; i < M; i++) {
           st = new StringTokenizer(br.readLine());
           int u = Integer.parseInt(st.nextToken());
           int v = Integer.parseInt(st.nextToken());
           adj[u].add(v);
           adj[v].add(u);
       }

       int[] colour = new int[N + 1];
       Queue<Integer> q = new LinkedList<Integer>();

       colour[1] = 1;
       q.add(1);

       while (!q.isEmpty()) {
           int u = q.remove();
           pw.print(u + " ");

           for (int v : adj[u]) {
               if (colour[v] == 0) {
                   colour[v] = 1;
                   q.add(v);
               }
           }
       }

       pw.println();
       pw.flush();
   }
}

