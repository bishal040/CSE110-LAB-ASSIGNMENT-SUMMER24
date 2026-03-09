import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken());
    int tc = Integer.parseInt(st.nextToken());

    int[][] arr2D = new int[n][n];
    while(tc-- > 0){
        st = new StringTokenizer(bf.readLine());
        arr2D[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
    }
    print2DArray(arr2D);
}
public static void print2DArray(int[][] arr2D){
    for(int[] arr: arr2D){
        for(int val: arr){
            System.out.print(val + " ");
        }
        System.out.println("");
    }
}
}