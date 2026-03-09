import java.io.*;
import java.util.*;

public class C {
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;

        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        boolean[][] vis = new boolean[N][N];
        int[][] dist = new int[N][N];

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(x1, y1));
        vis[x1][y1] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == x2 && cur.y == y2) {
                System.out.println(dist[cur.x][cur.y]);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }

        System.out.println(-1);
    }
}