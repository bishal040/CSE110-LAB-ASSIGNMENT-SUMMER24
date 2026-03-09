import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        int[] indeg = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            g[A].add(B);
            indeg[B]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
       
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(" ");
            count++;

            for (int v : g[u]) {
                indeg[v]--;
                if (indeg[v] == 0) q.add(v);
            }
        }

        if (count != N) {
            System.out.println(-1); 
        } else {
            System.out.println(sb.toString());
        }
    }
}