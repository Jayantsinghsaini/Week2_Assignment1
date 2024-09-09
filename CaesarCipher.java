import java.util.Scanner;
public class CaesarCipher {
    public static String caesarCipher(String input, int[] shiftPattern) {
        char[] result = new char[input.length()];
        int patternLength = shiftPattern.length;
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
        return new String(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(Constant.ENTER_STRING);
        String input = sc.nextLine();
        boolean isValid = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i)) && !Character.isWhitespace(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            System.out.print(Constant.SHIFT_NUMBER);
            int patternLength = sc.nextInt();
            int[] shiftPattern = new int[patternLength];
            System.out.println(Constant.SHIFT_PATTERN);
            for (int i = 0; i < patternLength; i++) {
                shiftPattern[i] = sc.nextInt();
            }
            String result = caesarCipher(input, shiftPattern);
            System.out.println(Constant.RESULT + result);
        }
        else {
            System.out.println(Constant.INVALID);
        }
    }
}
