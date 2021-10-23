package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String s = scanner.nextLine();
        int i = 0;
        System.out.println("---------\n" +
                "| " + s.charAt(i++) + " " + s.charAt(i++) + " " + s.charAt(i++) + " |\n" +
                "| " + s.charAt(i++) + " " + s.charAt(i++) + " " + s.charAt(i++) + " |\n" +
                "| " + s.charAt(i++) + " " + s.charAt(i++) + " " + s.charAt(i) + " |\n" +
                "---------");
    }
}
