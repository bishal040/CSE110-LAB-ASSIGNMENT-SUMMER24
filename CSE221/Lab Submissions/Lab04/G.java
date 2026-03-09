import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[N+1][M+1];
        int[] dx = {-2,-2,-1,-1,1,1,2,2};
        int[] dy = {-1,1,-2,2,-2,2,-1,1};
        for(int i=0;i<K;i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j=0;j<8;j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx>=1 && nx<=N && ny>=1 && ny<=M){
                    if(board[nx][ny]){
                        System.out.println("YES");
                        return;
                    }
                }
            }
            board[x][y] = true;
        }
        System.out.println("NO");
    }
}