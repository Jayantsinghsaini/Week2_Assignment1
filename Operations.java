/***
 * Java Programming Assignment - Week-2, Assignment-1
 * This Program runs the five operations according to the user's choice.
 * 1. Parentheses Combination Generator.
 * 2. Digit Sum Loop.
 * 3. Consecutive Number Summer.
 * 4. Caesar Cipher with Shift Variability.
 * 5. ASCII Conversion.
 * Program Owner -> Jayant Singh
 * Date -> 09/09/2024
 */
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operations {
    /***
     * this method generates all valid combinations of the string pairs of
     * parentheses. Each combination is unique and well-formed.
     * input -> String
     * output -> combination of String pairs
     */
    public static void validParentheses() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constant.ENTER_STRING);
        String result = scanner.nextLine();
        String input = "";
        for (int i = 0; i < result.length(); i++) {
            if (Character.isLetter(result.charAt(i))) {
                input = input + result.charAt(i);
            }
        }
        int n = input.length();
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(input.charAt(i) + ", ");
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print(input.charAt(i) + "" + input.charAt(j) + ", ");
                System.out.print(input.charAt(j) + "" + input.charAt(i) + ", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /***
     * this method continuously takes a number as input and replaces it with the sum of
     * its digits until the number is reduced to a single digit.
     * input -> integer
     * output -> single digit sum
     */
    public static void digitSumLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constant.ENTER_NUMBER);
        try {
            int num = scanner.nextInt();
            if(num < 0) {
                System.out.println(Constant.INVALID);
            }
            else {
                while (num >= 10) {
                    int sum = 0;
                    while (num > 0) {
                        sum = sum + num % 10;
                        num = num / 10;
                    }
                    num = sum;
                }
                System.out.println(Constant.RESULT + num);
            }
        }
        catch (InputMismatchException e) {
            System.out.println(Constant.INVALID);
        }
    }

    /***
     * this method finds whether a given number can be expressed as the sum of two or
     * more consecutive natural numbers. If possible, it prints all possible
     * combinations of consecutive natural numbers that sum up to the given number.
     * input -> integer
     * output -> consecutive sum
     */
    public static void consecutiveSummer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Constant.ENTER_NUMBER);
        try {
            int number = scanner.nextInt();
            boolean found = false;
            for (int i = 1; i < number; i++) {
                int sum = 0;
                for (int j = i; j < number; j++) {
                    sum = sum + j;
                    if (sum == number) {
                        found = true;
                        for (int k = i; k <= j; k++) {
                            if (k == j) {
                                System.out.print(k);
                            }
                            else {
                                System.out.print(k + " + ");
                            }
                        }
                        System.out.println();
                        break;
                    }
                    if (sum > number) {
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println(Constant.NO_COMBINATION);
            }
        }
        catch (InputMismatchException e){
            System.out.println(Constant.INVALID);
        }
    }

    /***
     * this method implements the Caesar Cipher encryption technique
     * but with a twist. it takes an input string and a shift pattern array. For
     * each character in the string, apply the corresponding shift value from the pattern array. If
     * the pattern array length is shorter than the input string, repeat the pattern.
     * input -> String
     * output -> caesar cipher
     */
    public static void caesarCipher() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Constant.ENTER_STRING);
        String input = scanner.nextLine();
        boolean isValid = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i)) && !Character.isWhitespace(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            System.out.print(Constant.SHIFT_NUMBER);
            int patternLength = -1;
            try {
                patternLength = scanner.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println(Constant.INVALID);
                return;
            }
            if (patternLength<=0){
                System.out.println(Constant.INVALID);
                return;
            }
            int[] shiftPattern = new int[patternLength];
            System.out.println(Constant.SHIFT_PATTERN);
            for (int i = 0; i < patternLength; i++) {
                try {
                    shiftPattern[i] = scanner.nextInt();
                }
                catch (Exception e){
                    System.out.println(Constant.INVALID);
                    return;
                }

            }
            char[] result = new char[input.length()];
            int shiftIndex = 0;
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (Character.isLetter(currentChar)) {
                    int shift = shiftPattern[shiftIndex % patternLength];
                    shiftIndex++;
                    if (Character.isUpperCase(currentChar)) {
                        result[i] = (char) ((currentChar - 'A' + shift) % 26 + 'A');
                    }
                    else if (Character.isLowerCase(currentChar)) {
                        result[i] = (char) ((currentChar - 'a' + shift) % 26 + 'a');
                    }
                }
                else {
                    result[i] = currentChar;
                }
            }
            System.out.println(Constant.RESULT + new String(result));
        }
        else {
            System.out.println(Constant.INVALID);
        }
    }

    /***
     * this method takes an unsorted array of digits and a series of integers. It encodes
     * the highest digits, based on the provided series, into their corresponding ASCII characters.
     * input -> integer array
     * output -> the highest digits corresponding to ASCII value
     */
    public static void asciiConversion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constant.ENTER_ARRAY_SIZE);
        int array_size;
        try {
            array_size = scanner.nextInt();
        }
        catch (Exception e){
            System.out.println(Constant.INVALID);
            return;
        }
        if (array_size <= 0){
            System.out.println(Constant.INVALID);
            return;
        }
        int[] array = new int[array_size];
        System.out.println(Constant.ENTER_ARRAY);
        for (int i = 0; i < array.length; i++) {
            try {
                array[i] =scanner.nextInt();
            }
            catch (Exception e){
                System.out.println(Constant.INVALID);
                return;
            }
        }
        Arrays.sort(array);
        System.out.println(Constant.ENTER_SERIES_SIZE);
        int series_size;
        try {
            series_size = scanner.nextInt();
        }
        catch (Exception e){
            System.out.println(Constant.INVALID);
            return;
        }
        if (series_size <= 0){
            System.out.println(Constant.INVALID);
            return;
        }
        int[] series = new int[series_size];
        System.out.println(Constant.ENTER_SERIES);
        for (int i = 0; i < series.length ; i++) {
            try {
                series[i] = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println(Constant.INVALID);
                return;
            }
        }
        String result = "";
        for (int i = 0; i < series.length; i++) {
            int position = series[i];
            if (position > 0 && position <= array.length) {
                int digit = array[array.length - position];
                result = result + (digit + '0');
            }
        }
        System.out.println(Constant.RESULT + result);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constant.METHOD_COMMENT);
        do {
            System.out.println(Constant.ENTER_METHODKEY);
            String methodKey = scanner.next();
            switch (methodKey){
                case "0":
                    System.out.println(Constant.EXIT);
                    return;
                case "1":
                    validParentheses();
                    break;
                case "2":
                    digitSumLoop();
                    break;
                case "3":
                    consecutiveSummer();
                    break;
                case "4":
                    caesarCipher();
                    break;
                case "5":
                    asciiConversion();
                    break;
                default:
                    System.out.println(Constant.INVALID);
                    break;
            }
        }while (true);



    }
}
