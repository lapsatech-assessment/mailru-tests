package mailru.hiring_tests.test;
public class Primes {

  public static void main(final String[] args) {
    if (args.length < 1)
      throw new IllegalArgumentException("Argument expected");
    final int n = Integer.parseInt(args[0]);
    final boolean[] primes = new boolean[n + 1];
    for (int i = 2; i < primes.length; ++i)
      if (!primes[i])
	for (int j = 2; i * j < primes.length; ++j)
	  primes[i * j] = true;
    for (int i = 2; i < primes.length; i++)
      if (!primes[i])
	System.out.println(i);
  }

}
