import java.io.*;
import java.util.*;

public class D {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        int[] u = new int[M];
        int[] v = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) u[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) v[i] = Integer.parseInt(st.nextToken());

        int[] degree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = u[i], b = v[i];
            graph.get(a).add(b);
            graph.get(b).add(a);
            degree[a]++;
            degree[b]++;
        }

        if (M == 0) {
            System.out.println("YES");
            return;
        }

        int start = -1;
        for (int i = 1; i <= N; i++) {
            if (degree[i] > 0) {
                start = i;
                break;
            }
        }

        visited = new boolean[N + 1];
        dfs(start);

        for (int i = 1; i <= N; i++) {
            if (degree[i] > 0 && !visited[i]) {
                System.out.println("NO");
                return;
            }
        }

        int odd = 0;
        for (int i = 1; i <= N; i++) if (degree[i] % 2 != 0) odd++;

        if (odd == 0 || odd == 2) System.out.println("YES");
        else System.out.println("NO");
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int nxt : graph.get(node)) if (!visited[nxt]) dfs(nxt);
    }
}