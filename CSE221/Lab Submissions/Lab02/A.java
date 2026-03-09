import java.io.*;
import java.util.*;

public class A {

  public static void main(String[] args) {
    try{
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      String line = bf.readLine();
      StringTokenizer st = new StringTokenizer(line);
      int[] arr = new int[Integer.parseInt(st.nextToken())];
      int target = Integer.parseInt(st.nextToken());
      line = bf.readLine();
      st = new StringTokenizer(line);
      for(int i = 0; i< arr.length; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }
      int p1 = 0, p2 = arr.length-1;
      while(p1<p2){
        if(arr[p1] + arr[p2] == target) break;
        if(arr[p1]+arr[p2]>target){
          p2--;
        }
        else{
          p1++;
        }
      }
      if(arr[p1]+arr[p2]==target && p1!=p2){
        bw.write((p1+1)+ " " + (p2+1));
      }
      else{
        bw.write("-1");
      }
      bw.flush();
     bw.close();
     bf.close();
    }
    catch(Exception e){
      System.out.println("Something went wrong");
    }

  }
}