import java.io.*;
import java.util.StringTokenizer;

public class B {
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line = bf.readLine();
    StringTokenizer st = new StringTokenizer(line);
    int[] arr1 = new int[Integer.parseInt(st.nextToken())];
    int[] arr2 = new int[Integer.parseInt(st.nextToken())];
    int key = Integer.parseInt(st.nextToken());
    line = bf.readLine();
    st = new StringTokenizer(line);
    for(int i=0; i<arr1.length; i++){      
      arr1[i] = Integer.parseInt(st.nextToken());
    }
    line = bf.readLine();
    st = new StringTokenizer(line);
    for(int i=0; i<arr2.length; i++){
      arr2[i] = Integer.parseInt(st.nextToken());
    }
    int p1=0, p2=0, i = 0, j = arr2.length-1;
    int min=Integer.MAX_VALUE;

    while(i<arr1.length && j>= 0){
      int difference = diff((arr1[i] + arr2[j]), key);
      if(difference < min || (difference == min && j > p2)){
          min = difference;
          p1 = i;
          p2 = j;
        }
        if(arr1[i] + arr2[j] > key){
          j--;
        }
        else{
          i++;
        }
    }
    bw.write(p1+1 + " " + (p2+1));
    bf.close();
    bw.flush();
    bw.close();
  }
 private static int diff(int x, int y){
    return Math.abs(x - y);
}
}
