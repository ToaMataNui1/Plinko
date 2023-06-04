import java.util.Scanner;

public class Lab_Plinko {
    public static void dropMarble(int[] slots) {
        int pegs = slots.length - 1;
        for (int i = 0; i < pegs; i++) {
            int rand = (int) (Math.random() * 2) + 0;
    
            if (rand == 0) {
                System.out.print('L');
            } else if (rand == 1) {
                System.out.print('R');
            }
    
        }

        int randomIndex = (int)(Math.random() * slots.length);
        slots[randomIndex]++;

        System.out.println();
    }
    

    public static void printBoard(int[] slots){
        System.out.print("|");
        for (int i = 0; i < slots.length; i++) {
            System.out.print(slots[i] + "|");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Plinko!");
        System.out.println("How many slots in the board?");
        
        int numSlots = input.nextInt();
        while (numSlots <= 0) {
            System.out.println("That's a bad number! Try again with another number.");
            numSlots = input.nextInt();
        }
        int[] slots = new int[numSlots];

        System.out.println("How many marbles to drop?");
        int numBallDrop = input.nextInt();

        while (numBallDrop != 0 && numBallDrop >= 0) { 
            do {
                dropMarble(slots);
                numBallDrop--;
            } while (numBallDrop > 0);
            printBoard(slots);

            System.out.println("How many balls to drop?");
            numBallDrop = input.nextInt();

            if (numBallDrop <= 0) {
                // program quits when a negative number or zero is entered.
                System.out.println("That's the end!");
                input.close();
            }
        }
    }
}
