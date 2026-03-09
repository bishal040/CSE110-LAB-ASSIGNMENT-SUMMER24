import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g[u].add(v);
            g[v].add(u);
        }

        int[] color = new int[N + 1];
        Arrays.fill(color, -1);

        long ans = 0;

        for (int i = 1; i <= N; i++) {
            if (color[i] != -1) continue;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            color[i] = 0;

            int c0 = 1, c1 = 0;

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g[u]) {
                    if (color[v] == -1) {
                        color[v] = color[u] ^ 1;
                        if (color[v] == 0) c0++;
                        else c1++;
                        q.add(v);
                    }
                }
            }

            ans += Math.max(c0, c1);
        }

        System.out.print(ans);
    }
}