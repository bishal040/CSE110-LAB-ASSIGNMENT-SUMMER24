import java.io.*;
import java.util.StringTokenizer;
public class H {
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int x = Integer.parseInt(bf.readLine());
    int[][] index = new int[x][2];
    
    for(int i = 0; i < index.length; i++){
      StringTokenizer st = new StringTokenizer(bf.readLine());
      index[i][0] = Integer.parseInt(st.nextToken());
      index[i][1] = Integer.parseInt(st.nextToken());
      int result = index[i][0] + (index[i][0]-1)/(index[i][1]-1);
      bw.write(result + "");
      bw.newLine();
      
    }
    bf.close();
    bw.flush();
    bw.close();
  }
}