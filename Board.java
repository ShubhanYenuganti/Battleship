import java.sql.SQLOutput;

public class Board extends Main {
    static Places[][] player_board = new Places[10][10];
    static Places[][] player2_board = new Places[10][10];
    static Places[][] ai_board = new Places[10][10];
    static Places[][] blank_board = new Places[10][10];

    // Set Board for Player #1/ For Reg. User in 1P
    public static void setBoard() {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                Board.player_board[r][c] = new Places(false, false, false, false, false, false, false, true, false, false );
            }
        }
    }

    public static void printOceanMap(boolean visibility, Places[][] player) {
        System.out.println();
        //First section of Ocean Map
        System.out.print("  ");
        for (int i = 0; i < 10; i++)
            System.out.print(i);
        System.out.println();
        if (visibility) {
            //Middle section of Ocean Map
            for (int x = 0; x < player.length; x++) {
                System.out.print(x + "|");
                for (int y = 0; y < player[x].length; y++) {
                    System.out.print(player[x][y]);
                }
                System.out.println("|" + x);
            }
        } else {
            //Middle section of Ocean Map
            for (int x = 0; x < player.length; x++) {
                System.out.print(x + "|");
                for (int y = 0; y < player[x].length; y++) {
                    if (player[x][y].hasCarrier || player[x][y].hasBattleship || player[x][y].hasCruiser || player[x][y].hasCruiser2 || player[x][y].hasDestroyer) {
                        if (player[x][y].madeShot) {
                            System.out.print(player[x][y]);
                        } else {
                            System.out.print("~");
                        }
                    } else {
                        System.out.print(player[x][y]);
                    }
                }
                System.out.println("|" + x);
            }
        }
        //Last section of Ocean Map
        System.out.print("  ");
        for (int i = 0; i < 10; i++)
            System.out.print(i);
        System.out.println();
    }

    public static void setOpponentBoard() {
        for (int r = 0; r < Board.player2_board.length; r++) {
            for (int c = 0; c < Board.player2_board.length; c++) {
                Board.player2_board[r][c] = new Places(false, false, false, false, false, false, false, true, false, false);
            }
        }
    }

    public static void setAi_board() {
        for (int r = 0; r < Board.ai_board.length; r++) {
            for (int c = 0; c < Board.ai_board.length; c++) {
                Board.ai_board[r][c] = new Places(false, false, false, false, false, false, false, true, false, false);
            }
        }
    }

}
