package Lab05;

import java.io.*;
import java.util.*;

public class C {
   public static void main(String[] args) throws Exception {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(System.out);
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       int S = Integer.parseInt(st.nextToken());
       int D = Integer.parseInt(st.nextToken());

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

       for (int i = 1; i <= N; i++) Collections.sort(adj[i]);

       int[] parent = new int[N + 1];
       Arrays.fill(parent, -1);

       boolean[] visited = new boolean[N + 1];
       Queue<Integer> q = new LinkedList<>();
       q.add(S);
       visited[S] = true;

       while (!q.isEmpty()) {
           int node = q.poll();

           for (int i = 0; i < adj[node].size(); i++) {
               int x = adj[node].get(i);
               if (!visited[x]) {
                   visited[x] = true;
                   parent[x] = node;
                   q.add(x);
               }
           }
       }

       if (!visited[D]) {
           pw.println(-1);
           pw.flush();
           return;
       }

       ArrayList<Integer> path = new ArrayList<>();
       int cur = D;
       while (cur != -1) {
           path.add(cur);
           cur = parent[cur];
       }
       Collections.reverse(path);

       pw.println(path.size() - 1);
       for (int i = 0; i < path.size(); i++) {
           pw.print(path.get(i) + (i == path.size() - 1 ? "\n" : " "));
       }
       pw.flush();
   }
}