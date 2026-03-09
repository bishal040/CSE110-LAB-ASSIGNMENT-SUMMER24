import java.io.*;
import java.util.*;

public class A {
    static int[] p, s;
    static int find(int x) { 
        return p[x] == x ? x : (p[x] = find(p[x])); 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line = br.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            s[i] = 1;
        }

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = find(Integer.parseInt(st.nextToken()));
            int v = find(Integer.parseInt(st.nextToken()));

            if (u != v) {
                p[u] = v; 
                s[v] += s[u];
            }
            out.println(s[v]);
        }
        
        out.flush();
        out.close();
    }
}