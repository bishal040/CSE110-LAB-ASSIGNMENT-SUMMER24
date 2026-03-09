import java.io.*;
import java.util.StringTokenizer;

public class G {

    static int[] inOrder;
    static int[] preOrder;
    static int[] postOrderResult;
    static int preIndex = 0;
    static int postIndex = 0;
    private static int findInOrderIndex(int value, int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == value) {
                return i;
            }
        }
        return -1;
    }
    public static void buildPostOrder(int inStart, int inEnd) {
        if (inStart > inEnd) {
            return;
        }
        int rootVal = preOrder[preIndex];
        preIndex++;
        int inRootIndex = findInOrderIndex(rootVal, inStart, inEnd);
        buildPostOrder(inStart, inRootIndex - 1);
        buildPostOrder(inRootIndex + 1, inEnd);
        postOrderResult[postIndex] = rootVal;
        postIndex++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        preOrder = new int[n];
        postOrderResult = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preOrder[i] = Integer.parseInt(st.nextToken());
        }

        buildPostOrder(0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(postOrderResult[i]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}