public class Power {
  public static double power(double base, long exp) {
    double result = 1;

    if (exp < 0) {
      exp = -1 * exp;
      base = 1 / base;
    }
    while (exp != 0) {
      if ((exp & 1) != 0) {
        result *= base;
      }
      base *= base;
      System.out.println(exp);
      exp = exp >> 1;
      // exp >>= 1;`
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(power(2, 3));
  }
}
