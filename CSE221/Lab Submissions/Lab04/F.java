import java.io.*;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int i = row-1; i <= row+1; i++){
            for(int j = col-1; j <= col+1; j++){
                if(i >= 1 && i <= n && j >= 1 && j <= n){
                    if(i == row && j == col) continue;
                    count++;
                }
            }
        }

        System.out.println(count);

        for(int i = row-1; i <= row+1; i++){
            for(int j = col-1; j <= col+1; j++){
                if(i >= 1 && i <= n && j >= 1 && j <= n){
                    if(i == row && j == col) continue;
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}