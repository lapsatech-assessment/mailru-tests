package mailru.hiring_tests.test;
public class ReverseString {

  public static void main(final String[] args) {
    if (args.length < 1)
      throw new IllegalArgumentException("Argument expected");
    final String source = args[0] + "A";
    {
      final String target = var1(source);
      System.out.println(target);
    }
    {
      final String target = var2(source);
      System.out.println(target);
    }
    {
      final String target = var3(source);
      System.out.println(target);
    }
  }

  public static String var3(final String source) {
    final char[] chars = source.toCharArray();
    recursive(chars, 0);
    return new String(chars);
  }

  private static void recursive(char[] cc, int pos) {
    if (pos > cc.length / 2)
      return;
    final char temp = cc[pos];
    cc[pos] = cc[cc.length - pos - 1];
    cc[cc.length - pos - 1] = temp;
    recursive(cc, pos + 1);

  }

  private static String var1(final String source) {
    final int n = source.length() - 1;
    final char[] reverse = new char[n + 1];
    for (int i = n; i >= 0; i--)
      reverse[n - i] = source.charAt(i);
    return new String(reverse);
  }

  public static String var2(final String source) {
    final char[] chars = source.toCharArray();
    reverse(chars);
    return new String(chars);
  }

  public static void arrayReverse(char[] ary) {
    for (int i = 0; i < ary.length / 2; i++) {
      final char val = ary[i];
      ary[i] = ary[ary.length - i - 1];
      ary[ary.length - i - 1] = val;
    }
  }

  public static <T> void arrayReverse(T[] ary) {
    for (int i = 0; i < ary.length / 2; i++) {
      final T val = ary[i];
      ary[i] = ary[ary.length - i - 1];
      ary[ary.length - i - 1] = val;
    }
  }

  public static void reverse(char[] data) {
    reverse(data, 0, data.length - 1);
  }

  public static void reverse(char[] data, int left, int right) {
    while (left < right) {
      // swap the values at the left and right indices
      char temp = data[left];
      data[left] = data[right];
      data[right] = temp;

      // move the left and right index pointers in toward the center
      left++;
      right--;
    }
  }

}
