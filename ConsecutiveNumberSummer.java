import java.util.Scanner;

public class ConsecutiveNumberSummer {
    public static void findConsecutiveSums(int number) {
        boolean found = false;
        for (int start = 1; start < number; start++) {
            int sum = 0;
            for (int current = start; current < number; current++) {
                sum += current;
                if (sum == number) {
                    found = true;
                    for (int i = start; i <= current; i++) {
                        if (i == current) {
                            System.out.print(i);
                        }
                        else {
                            System.out.print(i + " + ");
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(Constant.ENTER_NUMBER);
        int number = sc.nextInt();
        findConsecutiveSums(number);
    }
}
