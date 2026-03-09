package Lab05;

import java.io.*;
import java.util.*;

public class B {
   public static void main(String[] args) throws Exception {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(System.out);

       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       ArrayList<Integer>[] adj = new ArrayList[N + 1];
       for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

       st = new StringTokenizer(br.readLine());
       int[] u = new int[M];
       for (int i = 0; i < M; i++) u[i] = Integer.parseInt(st.nextToken());

       st = new StringTokenizer(br.readLine());
       int[] v = new int[M];
       for (int i = 0; i < M; i++) v[i] = Integer.parseInt(st.nextToken());

       for (int i = 0; i < M; i++) {
           adj[u[i]].add(v[i]);
           adj[v[i]].add(u[i]);
       }

       boolean[] visited = new boolean[N + 1];
       Stack<Integer> stack = new Stack<>();
       stack.push(1);

       while (!stack.isEmpty()) {
           int node = stack.pop();

           if (visited[node]) {
               continue;
           }

           visited[node] = true;
           pw.print(node + " ");

           for (int i = adj[node].size() - 1; i >= 0; i--) {
               int x = adj[node].get(i);
               if (!visited[x]) {
                   stack.push(x);
               }
           }
       }

       pw.println();
       pw.flush();
   }
}

