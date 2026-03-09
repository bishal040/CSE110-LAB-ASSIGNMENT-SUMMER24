import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indeg = new int[N + 1];
        int[] outdeg = new int[N + 1];

        int[] u = new int[M];
        int[] v = new int[M];

        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                u[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                outdeg[u[i]]++;
                indeg[v[i]]++;
            }
        } else {
            br.readLine();
            br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(indeg[i] - outdeg[i]);
            if (i < N) sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}