import java.util.Arrays;

public class ReplaceArray {

  public static void main(String[] args) {
    int[][] testcases = {{1, 2, 3}, {5}, {4, 7, 2, 0, 2, 1}, {15, 8, 10, 23, 5, 0, 11, 39}, null, {2, -1, 1}};
    for (int[] testcase: testcases) {
      System.out.println("Testcase: " + Arrays.toString(testcase));
      replace(testcase, 2, 100);
      System.out.println("Replace 2 for 100: " + Arrays.toString(testcase));
      System.out.println();
    }

  }

  public static void replace(int[] A, int o, int n) {
    /* Implemente aqui su solucion */
    
  }

}
