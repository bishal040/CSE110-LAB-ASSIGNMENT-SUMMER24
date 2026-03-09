package Lab05;

import java.io.*;
import java.util.*;

public class F {
   static class NodeState {
       int node;
       int childIndex;
       NodeState(int node, int childIndex) {
           this.node = node;
           this.childIndex = childIndex;
       }
   }

   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(System.out);
       String line;
       while ((line = br.readLine()) != null && line.length() > 0) {
           StringTokenizer st = new StringTokenizer(line);
           int N = Integer.parseInt(st.nextToken());
           int M = Integer.parseInt(st.nextToken());

           ArrayList<Integer>[] adj = new ArrayList[N + 1];
           for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

           for (int i = 0; i < M; i++) {
               st = new StringTokenizer(br.readLine());
               int u = Integer.parseInt(st.nextToken());
               int v = Integer.parseInt(st.nextToken());
               adj[u].add(v);
           }

           int[] color = new int[N + 1]; 
           boolean cycle = false;

           for (int start = 1; start <= N; start++) {
               if (color[start] != 0) continue;

               Stack<NodeState> stack = new Stack<>();
               stack.push(new NodeState(start, 0));
               color[start] = 1; 

               while (!stack.isEmpty() && !cycle) {
                   NodeState top = stack.peek();
                   int node = top.node;
                   int idx = top.childIndex;

                   if (idx >= adj[node].size()) {
                       color[node] = 2; 
                       stack.pop();
                       continue;
                   }
                   int child = adj[node].get(idx);
                   top.childIndex++; 

                   if (color[child] == 0) {
                       color[child] = 1;
                       stack.push(new NodeState(child, 0));
                   } else if (color[child] == 1) {
                       cycle = true;
                       break;
                   }
               }

               if (cycle) break;
           }
           pw.println(cycle ? "YES" : "NO");
       }
       pw.flush();
   }
}

