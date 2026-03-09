import java.io.*;
import java.util.StringTokenizer;
public class C {
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m;
    int[][] arr2D = new int[n][n];
    
    for(int i = 0; i < n ; i++){
      st = new StringTokenizer(bf.readLine());
      m = Integer.parseInt(st.nextToken());
      for(int j = 0; j < m; j++){
        arr2D[i][Integer.parseInt(st.nextToken())] = 1;
      }
    }
    print2DArray(arr2D);
  }
  public static void print2DArray(int[][] arr2D){
    for(int[] elem : arr2D){
      for(int val : elem){
        System.out.print(val + " ");
      }
      System.out.println();
    }
  }
}
