import java.util.Scanner;
public class DigitSumLoop {
    public static int digitSumLoop(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum = sum + num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constant.ENTER_ZERO);
        do{
            System.out.println(Constant.ENTER_NUMBER);
            int num = sc.nextInt();
            if (num == 0){
                System.out.println(Constant.EXIT);
                break;
            }
            if(num < 0){
                System.out.println(Constant.INVALID);
            }
            else {
                int result = digitSumLoop(num);
                System.out.println(Constant.RESULT + result);
            }
        } while (true);
    }
}
