import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int count = 1;
        int n = 0;
        for (int i = 1; i <= number; i++) {

            for (int j = 0; j < i; j++) {
                if (count > number) {
                    break;
                }
                System.out.print(i + " ");
                count++;
            }


        }
    }
}