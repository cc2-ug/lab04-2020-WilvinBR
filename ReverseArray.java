import java.util.Arrays;

public class ReverseArray {

  public static void main(String[] args) {
    int[][] testcases = {{1, 2, 3}, {5}, {4, 7, 0, 2, 1}, {15, 8, 10, 23, 5, 0, 11, 39}, null, {-1, 1}};
    for (int[] testcase: testcases) {
      System.out.println("Testcase: " + Arrays.toString(testcase));
      reverse(testcase);
      System.out.println("Reverse: " + Arrays.toString(testcase));
      System.out.println();
    }

  }

  public static void reverse(int[] A) {
    /* Implemente aqui su solucion */

  }

}
