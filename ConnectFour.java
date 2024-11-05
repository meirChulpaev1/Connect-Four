import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        
        char[][] arr = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
            game(arr);
    }

    public static void game(char[][] arr) {
        char p12 = 2;
        Scanner in = new Scanner(System.in);
        while (!win(arr)) {
            if (p12 == '1')
                p12 = '2';
            else
                p12 = '1';
            bord(arr);
            System.out.println("player " + p12 + " enter number");

            int number = in.nextInt();
            player(arr, number, p12);
            if (draw(arr)) {
                System.err.println("it's draw");
                break;
            }
        }
        if (!draw(arr)) {
            bord(arr);
            System.out.println(p12 + " win");
        }
    }

    public static void bord(char[][] arr) {
        System.out.println("   1   2   3   4   5   6   7");
        System.out.println(" ------------------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" | " + arr[i][j]);
            }
            System.out.print(" |");
            System.out.println();
            System.out.println(" ------------------------------");
        }

    }

    public static void player(char[][] arr, int number, char pl) {

        Scanner in = new Scanner(System.in);
        while (number <= 0 || number >= 8) {
            System.out.println(" number need be '0<number<8' \n try agn");
            number = in.nextInt();
        }
        for (int i = 5; i >= 0; i--) {
            if (arr[i][number - 1] == ' ') {
                arr[i][number - 1] = pl;
                break;
            }
        }
    }

    public static boolean win(char[][] arr) {
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = 0; j < arr[i].length; j++) {//מאונך
                if (arr[i][j] == arr[i + 1][j] && arr[i + 1][j] == arr[i + 2][j] && arr[i + 1][j] == arr[i + 3][j] && arr[i][j] != ' ')
                    return true;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length - 3; j++) {//מאוזן
                if (arr[i][j] == arr[i][j + 1] && arr[i][j + 1] == arr[i][j + 2] && arr[i][j + 2] == arr[i][j + 3] && arr[i][j] != ' ')
                    return true;
            }
        }

        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = 0; j < arr[i].length - 3; j++) {//אלכסון ימין לשמאל
                if (arr[i][j] == arr[i + 1][j + 1] && arr[i][j] == arr[i + 2][j + 2] && arr[i][j] == arr[i + 3][j + 3] && arr[i][j] != ' ')
                    return true;
            }
        }
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = 3; j < arr[i].length; j++) {//אלכסון שמאל לימין
                if (arr[i][j] == arr[i + 1][j - 1] && arr[i][j] == arr[i + 2][j - 2] && arr[i][j] == arr[i + 3][j - 3] && arr[i][j] != ' ')
                    return true;
            }
        }
        return false;
    }

    public static boolean draw(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}


