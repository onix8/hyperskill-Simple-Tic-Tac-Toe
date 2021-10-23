package tictactoe;

import java.util.Scanner;

public class Main {

    static char[][] field = new char[3][3];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        String s = scanner.nextLine();
        fillField(s);
        printField();
        enterXY();
        printField();
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
                field[x][y] = 'X';
                invalidCoordinates = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
    }

    private static void fillField(String s) {
        int length = 3;
        char[] chars = s.toCharArray();
        int index = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                field[i][j] = chars[index++];
            }
        }
    }

/*
    private static void printState() {
        System.out.println(isImpossible() ? "Impossible" :
                isDraw() ? "Draw" :
                        isWin('X') ? "X wins" :
                                isWin('O') ? "O wins" :
                                        "Game not finished");
    }

    private static boolean isDraw() {
        return count('_') == 0 &&
                !isWin('X') &&
                !isWin('O');
    }

    private static boolean isImpossible() {
        int x = count('X');
        int o = count('O');

        if (isWin('X') && isWin('O')) {
            return true;
        } else {
            return x >= o ?
                    x - o > 1 :
                    o - x > 1;
        }
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

*/
}
