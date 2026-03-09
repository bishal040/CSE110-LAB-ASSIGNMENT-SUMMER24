import java.io.*;
import java.util.*;

public class B {
public static void main(String[] args) throws IOException{
  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(bf.readLine());
  int N = Integer.parseInt(st.nextToken());
  int M = Integer.parseInt(st.nextToken());
  int[] u = new int[M];
  int[] v = new int[M];
  int[] w = new int[M];
  st = new StringTokenizer(bf.readLine());
  for(int i = 0; i < M; i++){
    u[i] = Integer.parseInt(st.nextToken());
  }
  st = new StringTokenizer(bf.readLine());
  for(int i = 0; i < M; i++){
    v[i] = Integer.parseInt(st.nextToken());
  }
  st = new StringTokenizer(bf.readLine());
  for(int i = 0; i < M; i++){
    w[i] = Integer.parseInt(st.nextToken());
  }
  LinkedList<String>[] li = new LinkedList[N+1];
  for(int i = 1; i <= N; i++){
    li[i] = new LinkedList<>();
  }
  for(int i = 0; i < M ; i++){
    li[u[i]].add("(" + v[i] + "," + w[i] + ")");
  }
  for(int i = 1; i <= N; i++){
    System.out.print(i + ":");
    if(!li[i].isEmpty()){
      System.out.print(" ");
      for(int j = 0; j < li[i].size(); j++){
        System.out.print(li[i].get(j));
        if (j != li[i].size() - 1) System.out.print(" ");
      }
    }
    System.out.println();
  }
}
    
}