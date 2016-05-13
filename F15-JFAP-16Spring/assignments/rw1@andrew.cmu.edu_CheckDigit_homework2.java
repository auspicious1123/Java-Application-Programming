/**
 * @author-Rui Wang rw1
 */
public class CheckDigit {
    /**
     * @param args the args
     */
    public static void main(String[] args) {
        String elevenDigits = args[0];  // get the 11 digits number
        System.out.println(elevenDigits);
        char[] elevenDigitsArray = elevenDigits.toCharArray();
        int num = elevenDigitsArray.length;
        int[] digits = new int[num];
        for (int i = 0; i < num; i++) {
            digits[i] = elevenDigitsArray[i] - '0';
        }
        int even = 0;
        int odd = 0;
        final int times = 3;
        final int base = 10;
        for (int i = 0; i < num - 1; i += 2) {
            even += times * digits[i];
            odd += digits[i + 1];
        }
        even += times * digits[num - 1];
        int twelfthDigit = (base - (even + odd) % base) % base;
        System.out.println(twelfthDigit);
    }

}
