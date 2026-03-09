package Lab05;

import java.io.*;
import java.util.*;

public class G {
   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(System.out);

       String line;
       while ((line = br.readLine()) != null && line.length() > 0) {
           StringTokenizer st = new StringTokenizer(line);
           int R = Integer.parseInt(st.nextToken());
           int H = Integer.parseInt(st.nextToken());

           char[][] grid = new char[R][H];
           for (int i = 0; i < R; i++) {
               grid[i] = br.readLine().toCharArray();
           }

           boolean[][] visited = new boolean[R][H];
           int maxDiamonds = 0;

           int[] dx = {-1, 1, 0, 0};
           int[] dy = {0, 0, -1, 1};

           for (int i = 0; i < R; i++) {
               for (int j = 0; j < H; j++) {
                   if (!visited[i][j] && grid[i][j] != '#') {
                       Queue<int[]> q = new LinkedList<>();
                       q.add(new int[]{i, j});
                       visited[i][j] = true;
                       int count = 0;
                       while (!q.isEmpty()) {
                           int[] cur = q.poll();
                           int x = cur[0], y = cur[1];
                           if (grid[x][y] == 'D') count++;
                           for (int d = 0; d < 4; d++) {
                               int nx = x + dx[d];
                               int ny = y + dy[d];
                               if (nx >= 0 && nx < R && ny >= 0 && ny < H
                                       && !visited[nx][ny] && grid[nx][ny] != '#') {
                                   visited[nx][ny] = true;
                                   q.add(new int[]{nx, ny});
                               }
                           }
                       }
                       if (count > maxDiamonds) maxDiamonds = count;
                   }
               }
           }

           pw.println(maxDiamonds);
       }

       pw.flush();
   }
}

