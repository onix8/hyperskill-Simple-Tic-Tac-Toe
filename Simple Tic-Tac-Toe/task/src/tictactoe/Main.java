package tictactoe;

import java.util.Scanner;

public class Main {

    static char[][] field = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printField();
        while (true) {
            enterXY();
            printField();
            if (isDraw()) {
                System.out.println("Draw");
                break;
            } else if (isWin('X')) {
                System.out.println("X wins");
                break;
            } else if (isWin('O')) {
                System.out.println("O wins");
                break;
            }
        }
    }

    private static void printField() {
        System.out.println("---------");
        System.out.println("| " + field[0][0] + " " + field[0][1] + " " + field[0][2] + " |");
        System.out.println("| " + field[1][0] + " " + field[1][1] + " " + field[1][2] + " |");
        System.out.println("| " + field[2][0] + " " + field[2][1] + " " + field[2][2] + " |");
        System.out.println("---------");
    }

    private static void enterXY() {
        int x;
        int y;
        boolean invalidCoordinates = true;
        while (invalidCoordinates) {
            System.out.print("Enter the coordinates: ");

            try {
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            try {
                switch (field[x][y]) {
                    case 'X':
                    case 'O':
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                }
                field[x][y] = count('X') <= count('O') ? 'X' : 'O';
                invalidCoordinates = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
    }


    private static boolean isDraw() {
        return count(' ') == 0 &&
                !isWin('X') &&
                !isWin('O');
    }

    private static boolean isWin(char c) {
        return (field[0][0] == c && field[0][1] == c && field[0][2] == c) ||
                (field[1][0] == c && field[1][1] == c && field[1][2] == c) ||
                (field[2][0] == c && field[2][1] == c && field[2][2] == c) ||
                (field[0][0] == c && field[1][0] == c && field[2][0] == c) ||
                (field[0][1] == c && field[1][1] == c && field[2][1] == c) ||
                (field[0][2] == c && field[1][2] == c && field[2][2] == c) ||
                (field[0][0] == c && field[1][1] == c && field[2][2] == c) ||
                (field[0][2] == c && field[1][1] == c && field[2][0] == c);
    }

    private static int count(char c) {
        int counter = 0;
        for (char[] chars : field) {
            for (char c1 : chars) {
                if (c == c1) {
                    counter++;
                }
            }
        }
        return counter;
    }

}
