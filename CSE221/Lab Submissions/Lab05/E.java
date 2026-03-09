package Lab05;

import java.io.*;
import java.util.*;

public class E {
   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(System.out);

       String line;
       while ((line = br.readLine()) != null && line.length() > 0) {
           StringTokenizer st = new StringTokenizer(line);
           int N = Integer.parseInt(st.nextToken());
           int R = Integer.parseInt(st.nextToken());

           ArrayList<Integer>[] adj = new ArrayList[N + 1];
           for (int i = 0; i <= N; i++) {
               adj[i] = new ArrayList<>();
           }

           for (int i = 0; i < N - 1; i++) {
               st = new StringTokenizer(br.readLine());
               int u = Integer.parseInt(st.nextToken());
               int v = Integer.parseInt(st.nextToken());
               adj[u].add(v);
               adj[v].add(u);
           }

           int[] subtree = new int[N + 1];
           boolean[] visited = new boolean[N + 1];

           Stack<Integer> stack = new Stack<>();
           Stack<Integer> post = new Stack<>();
           stack.push(R);
           visited[R] = true;
           while (!stack.isEmpty()) {
               int node = stack.pop();
               post.push(node);
               for (int i = 0; i < adj[node].size(); i++) {
                   int child = adj[node].get(i);
                   if (!visited[child]) {
                       visited[child] = true;
                       stack.push(child);
                   }
               }
           }

           while (!post.isEmpty()) {
               int node = post.pop();
               subtree[node] = 1;
               for (int i = 0; i < adj[node].size(); i++) {
                   int child = adj[node].get(i);
                   if (subtree[child] > 0) subtree[node] += subtree[child];
               }
           }

           int Q = Integer.parseInt(br.readLine());
           for (int i = 0; i < Q; i++) {
               int X = Integer.parseInt(br.readLine());
               pw.println(subtree[X]);
           }
       }

       pw.flush();
   }
}

