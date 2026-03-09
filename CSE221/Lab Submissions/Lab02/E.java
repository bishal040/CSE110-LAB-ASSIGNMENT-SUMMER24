import java.io.*;
import java.util.StringTokenizer;
public class E { 
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int[] arr = new int[Integer.parseInt(st.nextToken())];
    int target = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(bf.readLine());
    for(int i = 0; i < arr.length; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int maxLength = Integer.MIN_VALUE;
    int left = 0, sum = 0;
    for(int right = 0; right < arr.length; right++){
      sum+= arr[right];
      while(sum>target){
        sum-= arr[left++];
      }
      maxLength = Math.max(maxLength,right-left+1);
    }
    
    bw.write(maxLength + "\n");
    bw.flush();
    bw.close();
    bf.close();
  }
}
