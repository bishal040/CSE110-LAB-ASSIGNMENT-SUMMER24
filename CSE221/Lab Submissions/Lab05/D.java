package Lab05;

import java.io.*;
import java.util.*;

public class D {
   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(System.out);
       StringTokenizer st;

       String line;
       while ((line = br.readLine()) != null && line.length() > 0) {
           st = new StringTokenizer(line);
           int N = Integer.parseInt(st.nextToken());
           int M = Integer.parseInt(st.nextToken());
           int S = Integer.parseInt(st.nextToken());
           int D = Integer.parseInt(st.nextToken());
           int K = Integer.parseInt(st.nextToken());
           ArrayList<Integer>[] adj = new ArrayList[N + 1];
           for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

           for (int i = 0; i < M; i++) {
               st = new StringTokenizer(br.readLine());
               int u = Integer.parseInt(st.nextToken());
               int v = Integer.parseInt(st.nextToken());
               adj[u].add(v);
           }

           boolean[] visited = new boolean[N + 1];
           int[] parent = new int[N + 1];
           Arrays.fill(parent, -1);
           Queue<Integer> q = new LinkedList<>();
           q.add(S);
           visited[S] = true;

           while (!q.isEmpty()) {
               int u = q.poll();
               for (int i = 0; i < adj[u].size(); i++) {
                   int v = adj[u].get(i);
                   if (!visited[v]) {
                       visited[v] = true;
                       parent[v] = u;
                       q.add(v);
                   }
               }
           }

           if (!visited[K]) {
               pw.println(-1);
               continue;
           }

           ArrayList<Integer> path = new ArrayList<>();
           int cur = K;
           while (cur != -1) {
               path.add(cur);
               cur = parent[cur];
           }
           Collections.reverse(path);

           Arrays.fill(visited, false);
           Arrays.fill(parent, -1);
           q.clear();
           q.add(K);
           visited[K] = true;

           while (!q.isEmpty()) {
               int u = q.poll();
               for (int i = 0; i < adj[u].size(); i++) {
                   int v = adj[u].get(i);
                   if (!visited[v]) {
                       visited[v] = true;
                       parent[v] = u;
                       q.add(v);
                   }
               }
           }

           if (!visited[D]) {
               pw.println(-1);
               continue;
           }

           cur = D;
           ArrayList<Integer> temp = new ArrayList<>();
           while (cur != -1) {
               temp.add(cur);
               cur = parent[cur];
           }
           Collections.reverse(temp);
           temp.remove(0);
           path.addAll(temp);

           pw.println(path.size() - 1);
           for (int i = 0; i < path.size(); i++) {
               pw.print(path.get(i));
               if (i < path.size() - 1) pw.print(" ");
           }
           pw.println();
       }

       pw.flush();
   }
}