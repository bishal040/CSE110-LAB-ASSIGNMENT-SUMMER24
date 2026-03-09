import java.io.*;
import java.util.*;

public class C {
    static ArrayList<int[]>[] adj;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[][] edges = new int[m][4]; 

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;
        
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        
        long mstSum = 0;
        int count = 0;
        
        for (int[] e : edges) {
            int rootA = find(p, e[0]), rootB = find(p, e[1]);
            if (rootA != rootB) {
                p[rootA] = rootB; 
                mstSum += e[2];
                e[3] = 1; 
                adj[e[0]].add(new int[]{e[1], e[2]});
                adj[e[1]].add(new int[]{e[0], e[2]});
                count++;
            }
        }

        if (count < n - 1) { out.println("-1"); out.flush(); return; }

        long minDiff = Long.MAX_VALUE;
        
        for (int[] e : edges) {
            if (e[3] == 0) { 
                int maxVal = dfs(e[0], e[1], e[2], -1);
                if (maxVal != -1) minDiff = Math.min(minDiff, (long)e[2] - maxVal);
            }
        }

        out.println(minDiff == Long.MAX_VALUE ? -1 : mstSum + minDiff);
        out.flush();
    }

    static int find(int[] p, int i) { return p[i] == i ? i : (p[i] = find(p, p[i])); }

    static int dfs(int u, int target, int limit, int p) {
        if (u == target) return -1;
        
        for (int[] edge : adj[u]) {
            int v = edge[0], w = edge[1];
            if (v != p) {
                int res = dfs(v, target, limit, u);
                if (res != -2) { 
                    int validW = (w < limit) ? w : -1;
                    return Math.max(validW, res);
                }
            }
        }
        return -2;
    }
}