package Practice;

import java.util.*;

public class RandomWinner {

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        Random sample1 = new Random();

        for (int i = 0; i >= 0; i++) {

            int value = sample1.nextInt(2);

            System.out.println("Choose number 1-10: ");
            int num = x.nextInt();

            if (num == value) {
                System.out.println("Lucky number is: " + value);
                System.out.println("You win!");
                break;
            } else if (num > 10) {
                System.out.println("Number out of range!");
            } else if (num < 1) {
                System.out.println("Choose number!");
            } else {
                System.out.println("Lucky number is: " + value);
                System.out.println("You lose!");
            }
        }

    }
}
