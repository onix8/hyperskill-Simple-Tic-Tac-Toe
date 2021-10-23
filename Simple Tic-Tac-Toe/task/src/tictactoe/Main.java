package tictactoe;

import java.util.Scanner;

public class Main {

    static char[] field;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String s = scanner.nextLine();
        field = s.toCharArray();
        System.out.println("---------");
        System.out.println("| " + field[0] + " " + field[1] + " " + field[2] + " |");
        System.out.println("| " + field[3] + " " + field[4] + " " + field[5] + " |");
        System.out.println("| " + field[6] + " " + field[7] + " " + field[8] + " |");
        System.out.println("---------");

        System.out.println(isImpossible() ? "Impossible" :
                isDraw() ? "Draw" :
                        isWin('X') ? "X wins" :
                                isWin('O') ? "O wins" :
                                        "Game not finished");
    }

    /**
     * "Draw"
     */
    private static boolean isDraw() {
        return count('_') == 0 &&
                !isWin('X') &&
                !isWin('O');
    }

    /**
     * "Impossible"
     */
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
        return (field[0] == c && field[1] == c && field[2] == c) ||
                (field[3] == c && field[4] == c && field[5] == c) ||
                (field[6] == c && field[7] == c && field[8] == c) ||
                (field[0] == c && field[3] == c && field[6] == c) ||
                (field[1] == c && field[4] == c && field[7] == c) ||
                (field[2] == c && field[5] == c && field[8] == c) ||
                (field[0] == c && field[4] == c && field[8] == c) ||
                (field[2] == c && field[4] == c && field[6] == c);
    }

    private static int count(char c) {
        int counter = 0;
        for (char c1 : field) {
            if (c == c1) {
                counter++;
            }
        }
        return counter;
    }

}
