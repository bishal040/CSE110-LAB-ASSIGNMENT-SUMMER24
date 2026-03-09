import java.io.*;
import java.util.*;

public class H {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(System.out);

       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int Q = Integer.parseInt(st.nextToken());

       ArrayList<Integer>[] neighbors = new ArrayList[N+1];
       for (int i=1; i<=N; i++) neighbors[i] = new ArrayList<>();

       for (int i=1; i<=N; i++){
           for (int j=1; j<=N; j++){
               if (i != j && gcd(i,j) == 1) neighbors[i].add(j);
           }
       }

       for (int i=0; i<Q; i++){
           st = new StringTokenizer(br.readLine());
           int X = Integer.parseInt(st.nextToken());
           int K = Integer.parseInt(st.nextToken());
           if (K <= neighbors[X].size()){
               pw.println(neighbors[X].get(K-1));
           }
           else {
               pw.println(-1);
           }
       }

       pw.flush();
   }

   static int gcd(int a, int b){
       while (b != 0){
           int tmp = b;
           b = a % b;
           a = tmp;
       }
       return a;
   }
}
