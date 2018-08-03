package mailru.hiring_tests.test;
import java.util.Random;

public class BinarySearch {

  public static void main(final String[] args) {
    int[] a = new Random()
	.ints(100, 0, new Random().nextInt(10000))
	.sorted()
	.toArray();

    for (int i = 0; i < a.length; i++)
      System.out.println(String.format("a[%1$d] = %2$d", i, a[i]));

    int i = binarySearch(a, 1000);
    if (i >= 0)
      System.out.println(i + " " + a[i]);
  }

  public static int binarySearch(int[] a, int key) {
    return binarySearch(a, key, 0, a.length - 1);
  }

  private static int binarySearch(int[] a, int key, int low, int high) {
    int mid = -1;
    while (low < high) {
      mid = low + ((high - low) / 2);
      if (key < a[mid])
	high = mid - 1;
      else if (key > a[mid])
	low = mid + 1;
      else
	return mid;
    }
    return -(low + 1);
  }

}
