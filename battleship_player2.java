import java.util.Arrays;
import java.util.Scanner;

public class battleship_player2 {

    static int player2_carrier_FirstRow;
    static int player2_carrier_FirstColumn;
    static int player2_carrier_LastRow;
    static int player2_carrier_LastColumn;

    static int player2_battleship_FirstRow;
    static int player2_battleship_FirstColumn;
    static int player2_battleship_LastRow;
    static int player2_battleship_LastColumn;

    static int player2_cruiser_FirstRow;
    static int player2_cruiser_FirstColumn;
    static int player2_cruiser_LastRow;
    static int player2_cruiser_LastColumn;

    static int player2_cruiser2_FirstRow;
    static int player2_cruiser2_FirstColumn;
    static int player2_cruiser2_LastColumn;
    static int player2_cruiser2_LastRow;

    static int player2_destroyer_FirstRow;
    static int player2_destroyer_FirstColumn;
    static int player2_destroyer_LastColumn;
    static int player2_destroyer_LastRow;

    static int[][] carrier_player2;
    static int [][] battleship_player2;
    static int [][] cruiser_player2;
    static int [][] cruiser2_player2;
    static int [][] destroyer_player2;

    public static void player2_setCarrier() {

        Scanner input = new Scanner(System.in);

        System.out.print("The Carrier is 5 spaces, set row first space, Row: ");
        System.out.println();
        player2_carrier_FirstRow = input.nextInt();

        System.out.print("Set column of first space, Column: ");
        System.out.println();
        player2_carrier_FirstColumn = input.nextInt();

        System.out.print("Set row of last space, Row: ");
        System.out.println();
        player2_carrier_LastRow = input.nextInt();

        System.out.print("Set column of last space, Column: ");
        System.out.println();
        player2_carrier_LastColumn = input.nextInt();

        if (player2_carrier_FirstRow == player2_carrier_LastRow) {
            carrier_player2 = new int[][]{
                    {player2_carrier_FirstRow, player2_carrier_FirstColumn},
                    {player2_carrier_FirstRow, player2_carrier_FirstColumn + 1},
                    {player2_carrier_FirstRow, player2_carrier_FirstColumn + 2},
                    {player2_carrier_FirstRow, player2_carrier_LastColumn - 1},
                    {player2_carrier_FirstRow, player2_carrier_LastColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(carrier_player2));
            System.out.println();
        }

        if (player2_carrier_FirstColumn == player2_carrier_LastColumn) {
            carrier_player2 = new int[][]{
                    {player2_carrier_FirstRow, player2_carrier_FirstColumn},
                    {player2_carrier_FirstRow + 1, player2_carrier_FirstColumn},
                    {player2_carrier_FirstRow + 2, player2_carrier_FirstColumn},
                    {player2_carrier_LastRow - 1, player2_carrier_FirstColumn},
                    {player2_carrier_LastRow, player2_carrier_FirstColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(carrier_player2));
            System.out.println();
        }

        if (player2_carrier_FirstRow > 9 || player2_carrier_LastRow > 9 || player2_carrier_LastColumn > 9 || player2_carrier_FirstColumn > 9) {
            System.out.printf("Out of Bounds. Carrier coordinates First Coordinate: {%d,%d}, Last Coordinate: {%d,%d}", player2_carrier_FirstRow, player2_carrier_FirstRow, player2_carrier_LastRow, player2_carrier_LastColumn);
            Board.printOceanMap(true, Board.player2_board);
            System.out.println();
            player2_setCarrier();
        }

        if ((player2_carrier_FirstRow == player2_carrier_LastRow && player2_carrier_FirstColumn != player2_carrier_LastColumn) || ((player2_carrier_FirstColumn == player2_carrier_LastColumn && player2_carrier_FirstRow != player2_carrier_LastRow))) {
            if (((player2_carrier_FirstRow - player2_carrier_LastRow) == 4) || ((player2_carrier_FirstColumn - player2_carrier_LastColumn) == 4) || (player2_carrier_FirstRow - player2_carrier_LastRow == -4) || (player2_carrier_FirstColumn - player2_carrier_LastColumn == -4)) {
                if (player2_carrier_FirstRow == player2_carrier_LastRow) {
                    Board.player2_board[player2_carrier_FirstRow][player2_carrier_FirstColumn].hasCarrier = true;
                        Board.player2_board[player2_carrier_FirstRow][player2_carrier_FirstColumn].empty = false;
                    Board.player2_board[player2_carrier_FirstRow][player2_carrier_FirstColumn + 1].hasCarrier = true;
                        Board.player2_board[player2_carrier_FirstRow][player2_carrier_FirstColumn + 1].empty = false;
                    Board.player2_board[player2_carrier_FirstRow][player2_carrier_FirstColumn + 2].hasCarrier = true;
                        Board.player2_board[player2_carrier_FirstRow][player2_carrier_FirstColumn + 2].empty = false;
                    Board.player2_board[player2_carrier_FirstRow][player2_carrier_LastColumn - 1].hasCarrier = true;
                        Board.player2_board[player2_carrier_FirstRow][player2_carrier_LastColumn - 1].empty = false;
                    Board.player2_board[player2_carrier_FirstRow][player2_carrier_LastColumn].hasCarrier = true;
                        Board.player2_board[player2_carrier_FirstRow][player2_carrier_LastColumn].empty = false;
                    Board.printOceanMap(true, Board.player2_board);
                    player2_setBattleship();
                } else {
                    Board.player2_board[player2_carrier_FirstRow][player2_carrier_FirstColumn].hasCarrier = true;
                        Board.player2_board[player2_carrier_FirstRow][player2_carrier_FirstColumn].empty = false;
                    Board.player2_board[player2_carrier_FirstRow + 1][player2_carrier_FirstColumn].hasCarrier = true;
                        Board.player2_board[player2_carrier_FirstRow + 1][player2_carrier_FirstColumn].empty = false;
                    Board.player2_board[player2_carrier_FirstRow + 2][player2_carrier_FirstColumn].hasCarrier = true;
                        Board.player2_board[player2_carrier_FirstRow + 2][player2_carrier_FirstColumn].empty = false;
                    Board.player2_board[player2_carrier_LastRow - 1][player2_carrier_FirstColumn].hasCarrier = true;
                        Board.player2_board[player2_carrier_LastRow - 1][player2_carrier_FirstColumn].empty = false;
                    Board.player2_board[player2_carrier_LastRow][player2_carrier_FirstColumn].hasCarrier = true;
                        Board.player2_board[player2_carrier_LastRow][player2_carrier_FirstColumn].empty = false;
                    Board.printOceanMap(true, Board.player2_board);
                    player2_setBattleship();
                }
            } else {
                System.out.printf("Invalid Output. First Coordinate: {%d,%d}, Last Coordinate: {%d,%d}", player2_carrier_FirstRow, player2_carrier_FirstRow, player2_carrier_LastRow, player2_carrier_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setCarrier();
            }
        } else {
            System.out.printf("Invalid Output. First Coordinate: {%d,%d}, Last Coordinate: {%d,%d}", player2_carrier_FirstRow, player2_carrier_FirstRow, player2_carrier_LastRow, player2_carrier_LastColumn);
            Board.printOceanMap(true, Board.player2_board);
            System.out.println();
            player2_setCarrier();
        }
    }

    public static void player2_setBattleship() {
        Scanner input = new Scanner(System.in);

        // Asks user for battleship coordinates
        System.out.print("The Battleship is 4 spaces, set row first space, Row: ");
        System.out.println();
        player2_battleship_FirstRow = input.nextInt();

        System.out.print("Set column of first space, Column: ");
        System.out.println();
        player2_battleship_FirstColumn = input.nextInt();

        System.out.print("Set row of last space, Row: ");
        System.out.println();
        player2_battleship_LastRow = input.nextInt();

        System.out.print("Set column of last space, Column: ");
        System.out.println();
        player2_battleship_LastColumn = input.nextInt();

        if (player2_battleship_FirstRow == player2_battleship_LastRow) {
            battleship_player2 = new int[][]{
                    {player2_battleship_FirstRow, player2_battleship_FirstColumn},
                    {player2_battleship_FirstRow, player2_battleship_FirstColumn + 1},
                    {player2_battleship_FirstRow, player2_battleship_LastColumn - 1},
                    {player2_battleship_FirstRow, player2_battleship_LastColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(battleship_player2));
            System.out.println();
        }

        if (player2_battleship_FirstColumn == player2_battleship_LastColumn) {
            battleship_player2 = new int[][]{
                    {player2_battleship_FirstRow, player2_battleship_FirstColumn},
                    {player2_battleship_FirstRow + 1, player2_battleship_FirstColumn},
                    {player2_battleship_LastRow - 1, player2_battleship_FirstColumn},
                    {player2_battleship_LastRow, player2_battleship_FirstColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(battleship_player2));
            System.out.println();
        }

        if (player2_battleship_FirstRow > 9 || player2_battleship_LastRow > 9 || player2_battleship_FirstColumn > 9 || player2_battleship_LastColumn > 9) {
            System.out.printf("Invalid output. Battleship's First Coordinate {%d, %d}, Battleship's Last Coordinate {%d, %d}", player2_battleship_FirstRow, player2_battleship_FirstColumn, player2_battleship_LastRow, player2_battleship_LastColumn);
            Board.printOceanMap(true, Board.player2_board);
            System.out.println();
            player2_setBattleship();
        }

        if (player2_battleship_FirstRow == player2_battleship_LastRow) {
            if (Board.player2_board[player2_battleship_FirstRow][player2_battleship_LastRow].hasCarrier || Board.player2_board[player2_battleship_FirstRow][player2_battleship_FirstColumn + 1].hasCarrier || Board.player2_board[player2_battleship_FirstRow][player2_battleship_LastColumn - 1].hasCarrier || Board.player2_board[player2_battleship_FirstRow][player2_battleship_LastColumn].hasCarrier) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d}, Last Coordinate {%d, %d}", player2_battleship_FirstRow, player2_battleship_FirstColumn, player2_battleship_LastRow, player2_battleship_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setBattleship();
            }
        }

        if (player2_battleship_FirstColumn == player2_battleship_LastColumn) {
            if (Board.player2_board[player2_battleship_FirstRow + 1][player2_battleship_FirstColumn].hasCarrier || Board.player2_board[player2_battleship_LastRow - 1][player2_battleship_FirstColumn].hasCarrier || Board.player2_board[player2_battleship_LastRow][player2_battleship_FirstColumn].hasCarrier) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d}, Last Coordinate {%d, %d}", player2_battleship_FirstRow, player2_battleship_FirstColumn, player2_battleship_LastRow, player2_battleship_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setBattleship();
            }
        }

        if ((player2_battleship_FirstRow == player2_battleship_LastRow && player2_battleship_FirstColumn != player2_battleship_LastColumn) || ((player2_battleship_FirstColumn == player2_battleship_LastColumn && player2_battleship_FirstRow != player2_battleship_LastRow))) {
            if (((player2_battleship_FirstRow - player2_battleship_LastRow) == 3) || ((player2_battleship_FirstColumn - player2_battleship_LastColumn) == 3) || (player2_battleship_FirstRow - player2_battleship_LastRow == -3) || (player2_battleship_FirstColumn - player2_battleship_LastColumn == -3)) {
                if (player2_battleship_FirstRow == player2_battleship_LastRow) {
                    Board.player2_board[player2_battleship_FirstRow][player2_battleship_FirstColumn].hasBattleship = true;
                        Board.player2_board[player2_battleship_FirstRow][player2_battleship_FirstColumn].empty = false;
                    Board.player2_board[player2_battleship_FirstRow][player2_battleship_FirstColumn + 1].hasBattleship = true;
                        Board.player2_board[player2_battleship_FirstRow][player2_battleship_FirstColumn + 1].empty = false;
                    Board.player2_board[player2_battleship_FirstRow][player2_battleship_LastColumn - 1].hasBattleship = true;
                        Board.player2_board[player2_battleship_FirstRow][player2_battleship_LastColumn - 1].empty = false;
                    Board.player2_board[player2_battleship_FirstRow][player2_battleship_LastColumn].hasBattleship = true;
                        Board.player2_board[player2_battleship_FirstRow][player2_battleship_LastColumn].empty = false;
                    Board.printOceanMap(true, Board.player2_board);
                    player2_setCruiser();
                } else {
                    Board.player2_board[player2_battleship_FirstRow][player2_battleship_FirstColumn].hasBattleship = true;
                        Board.player2_board[player2_battleship_FirstRow][player2_battleship_FirstColumn].empty = false;
                    Board.player2_board[player2_battleship_FirstRow + 1][player2_battleship_FirstColumn].hasBattleship = true;
                        Board.player2_board[player2_battleship_FirstRow + 1][player2_battleship_FirstColumn].empty = false;
                    Board.player2_board[player2_battleship_LastRow - 1][player2_battleship_FirstColumn].hasBattleship = true;
                        Board.player2_board[player2_battleship_FirstRow + 1][player2_battleship_FirstColumn].empty = false;
                    Board.player2_board[player2_battleship_LastRow][player2_battleship_FirstColumn].hasBattleship = true;
                     Board.player2_board[player2_battleship_LastRow - 1][player2_battleship_FirstColumn].empty = false;
                    Board.printOceanMap(true, Board.player2_board);
                    player2_setCruiser();
                }
            } else {
                System.out.printf("Invalid output. Battleship's First Coordinate {%d, %d}, Battleship's Last Coordinate {%d, %d}", player2_battleship_FirstRow, player2_battleship_FirstColumn, player2_battleship_LastRow, player2_battleship_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setBattleship();
            }
        } else {
            System.out.printf("Invalid output. Battleship's First Coordinate {%d, %d}, Battleship's Last Coordinate {%d, %d}", player2_battleship_FirstRow, player2_battleship_FirstColumn, player2_battleship_LastRow, player2_battleship_LastColumn);
            Board.printOceanMap(true, Board.player2_board);
            System.out.println();
            player2_setBattleship();
        }

    }

    public static void player2_setCruiser() {
        Scanner input = new Scanner(System.in);

        // Prompts user to set coordinates of Cruiser
        System.out.print("The Cruiser is 3 spaces, set row first space, Row: ");
        System.out.println();
        player2_cruiser_FirstRow = input.nextInt();

        System.out.print("Set column of first space, Column: ");
        System.out.println();
        player2_cruiser_FirstColumn = input.nextInt();

        System.out.print("Set row of last space, Row: ");
        System.out.println();
        player2_cruiser_LastRow = input.nextInt();

        System.out.print("Set column of last space, Column: ");
        System.out.println();
        player2_cruiser_LastColumn = input.nextInt();

        if (player2_cruiser_FirstRow == player2_cruiser_LastRow) {
            cruiser_player2 = new int[][]{
                    {player2_cruiser_FirstRow, player2_cruiser_FirstColumn},
                    {player2_cruiser_FirstRow, player2_cruiser_FirstColumn + 1},
                    {player2_cruiser_FirstRow, player2_cruiser_LastColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(cruiser_player2));
            System.out.println();
        }

        if (player2_cruiser_FirstColumn == player2_cruiser_LastColumn) {
            cruiser_player2 = new int[][]{
                    {player2_cruiser_FirstRow, player2_cruiser_FirstColumn},
                    {player2_cruiser_FirstRow + 1, player2_cruiser_FirstColumn},
                    {player2_cruiser_LastRow, player2_cruiser_FirstColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(cruiser_player2));
            System.out.println();
        }

        if (player2_cruiser_FirstRow > 9 || player2_cruiser_LastRow > 9 || player2_cruiser_FirstColumn > 9 || player2_cruiser_LastColumn > 9) {
            System.out.printf("Invalid output. Cruiser's First Coordinate {%d, %d}, Cruiser's Last Coordinate {%d, %d}", player2_cruiser_FirstRow, player2_cruiser_FirstColumn, player2_cruiser_LastRow, player2_cruiser_LastColumn);
            Board.printOceanMap(true, Board.player2_board);
            System.out.println();
            player2_setCruiser();
        }

        if (player2_cruiser_FirstRow == player2_cruiser_LastRow) {
            if ((Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn].hasCarrier || Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn + 1].hasCarrier || Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_LastColumn].hasCarrier) ||
                    ((Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn].hasBattleship || Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn + 1].hasBattleship || Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_LastColumn].hasBattleship))) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d}, Last Coordinate {%d, %d}", player2_cruiser_FirstRow, player2_cruiser_FirstColumn, player2_cruiser_LastRow, player2_cruiser_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setCruiser();
            }
        }

        if (player2_cruiser_FirstColumn == player2_cruiser_LastColumn) {
            if ((Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn].hasCarrier || Board.player2_board[player2_cruiser_FirstRow + 1][player2_cruiser_FirstColumn].hasCarrier || Board.player2_board[player2_cruiser_LastRow][player2_cruiser_FirstColumn].hasCarrier) ||
                    ((Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn].hasBattleship || Board.player2_board[player2_cruiser_FirstRow + 1][player2_cruiser_FirstColumn].hasBattleship || Board.player2_board[player2_cruiser_LastRow][player2_cruiser_FirstColumn].hasBattleship))) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d}, Last Coordinate {%d, %d}", player2_cruiser_FirstRow, player2_cruiser_FirstColumn, player2_cruiser_LastRow, player2_cruiser_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setCruiser();
            }
        }

        if ((player2_cruiser_FirstRow == player2_cruiser_LastRow && player2_cruiser_FirstColumn != player2_cruiser_LastColumn) || ((player2_cruiser_FirstColumn == player2_cruiser_LastColumn && player2_cruiser_FirstRow != player2_cruiser_LastRow))) {
            if (player2_cruiser_FirstRow - player2_cruiser_LastRow == 2 || player2_cruiser_FirstColumn - player2_cruiser_LastColumn == 2 || player2_cruiser_FirstRow - player2_cruiser_LastRow == -2 || player2_cruiser_FirstColumn - player2_cruiser_LastColumn == -2) {
                if (player2_cruiser_FirstRow == player2_cruiser_LastRow) {
                    Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn].hasCruiser = true;
                        Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn].empty = false;
                    Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn + 1].hasCruiser = true;
                        Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn + 1].empty = false;
                    Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_LastColumn].hasCruiser = true;
                        Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_LastColumn].empty = false;
                    Board.printOceanMap(true, Board.player2_board);
                    player2_setCruiser2();
                } else {
                    Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn].hasCruiser = true;
                        Board.player2_board[player2_cruiser_FirstRow][player2_cruiser_FirstColumn].empty = false;
                    Board.player2_board[player2_cruiser_FirstRow + 1][player2_cruiser_FirstColumn].hasCruiser = true;
                        Board.player2_board[player2_cruiser_FirstRow + 1][player2_cruiser_FirstColumn].empty = false;
                    Board.player2_board[player2_cruiser_LastRow][player2_cruiser_FirstColumn].hasCruiser = true;
                        Board.player2_board[player2_cruiser_LastRow][player2_cruiser_FirstColumn].empty = false;
                    Board.printOceanMap(true, Board.player2_board);
                    player2_setCruiser2();
                }
            } else {
                System.out.printf("Invalid output. Cruiser's First Coordinate {%d, %d}, Cruiser's Last Coordinate {%d,%d}", player2_cruiser_FirstRow, player2_cruiser_FirstColumn, player2_cruiser_LastRow, player2_cruiser_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setCruiser();
            }
        } else {
            System.out.printf("Invalid output. Cruiser's First Coordinate {%d, %d}, Cruiser's Last Coordinate {%d, %d}", player2_cruiser_FirstRow, player2_cruiser_FirstColumn, player2_cruiser_LastRow, player2_cruiser_LastColumn);
            Board.printOceanMap(true, Board.player2_board);
            System.out.println();
            player2_setCruiser();
        }
    }

    public static void player2_setCruiser2() {
        Scanner input = new Scanner(System.in);

        // Prompts user to set coordinates of Cruiser
        System.out.print("The Cruiser #2 is 3 spaces, set row first space, Row: ");
        System.out.println();
        player2_cruiser2_FirstRow = input.nextInt();

        System.out.print("Set column of first space, Column: ");
        System.out.println();
        player2_cruiser2_FirstColumn = input.nextInt();

        System.out.print("Set row of last space, Row: ");
        System.out.println();
        player2_cruiser2_LastRow = input.nextInt();

        System.out.print("Set column of last space, Column: ");
        System.out.println();
        player2_cruiser2_LastColumn = input.nextInt();

        if (player2_cruiser2_FirstRow == player2_cruiser2_LastRow) {
            cruiser2_player2 = new int[][]{
                    {player2_cruiser2_FirstRow, player2_cruiser2_FirstColumn},
                    {player2_cruiser2_FirstRow, player2_cruiser2_FirstColumn + 1},
                    {player2_cruiser2_FirstRow, player2_cruiser2_LastColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(cruiser2_player2));
            System.out.println();
        }

        if (player2_cruiser2_FirstColumn == player2_cruiser2_LastColumn) {
            cruiser2_player2 = new int[][]{
                    {player2_cruiser2_FirstRow, player2_cruiser2_FirstColumn},
                    {player2_cruiser2_FirstRow + 1, player2_cruiser2_FirstColumn},
                    {player2_cruiser2_LastRow, player2_cruiser2_FirstColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(cruiser2_player2));
            System.out.println();
        }

        if (player2_cruiser2_FirstRow > 9 || player2_cruiser2_LastRow > 9 || player2_cruiser2_FirstColumn > 9 || player2_cruiser2_LastColumn > 9) {
            System.out.printf("Invalid output Cruiser's First Coordinate {%d, %d}, Cruiser's Last Coordinate {%d, %d}", player2_cruiser2_FirstRow, player2_cruiser2_FirstColumn, player2_cruiser2_LastRow, player2_cruiser2_LastColumn);
            Board.printOceanMap(true, Board.player2_board);
            System.out.println();
            player2_setCruiser2();
        }

        if (player2_cruiser2_FirstRow == player2_cruiser2_LastRow) {
            if ((Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn].hasCarrier || Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn + 1].hasCarrier || Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_LastColumn].hasCarrier) ||
                    ((Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn].hasBattleship || Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn + 1].hasBattleship || Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_LastColumn].hasBattleship)) ||
                    ((Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn].hasCruiser || Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn + 1].hasCruiser || Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_LastColumn].hasCruiser))) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d} Last Coordinate {%d, %d}", player2_cruiser2_FirstRow, player2_cruiser2_FirstColumn, player2_cruiser2_LastRow, player2_cruiser2_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setCruiser2();
            }
        }

        if (player2_cruiser2_FirstColumn == player2_cruiser2_LastColumn) {
            if ((Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn].hasCarrier || Board.player2_board[player2_cruiser2_FirstRow + 1][player2_cruiser2_FirstColumn].hasCarrier || Board.player2_board[player2_cruiser2_LastRow][player2_cruiser2_FirstColumn].hasCarrier) ||
                    ((Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn].hasBattleship || Board.player2_board[player2_cruiser2_FirstRow + 1][player2_cruiser2_FirstColumn].hasBattleship || Board.player2_board[player2_cruiser2_LastRow][player2_cruiser2_FirstColumn].hasBattleship)) ||
                    ((Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn].hasCruiser || Board.player2_board[player2_cruiser2_FirstRow + 1][player2_cruiser2_FirstColumn].hasCruiser || Board.player2_board[player2_cruiser2_LastRow][player2_cruiser2_FirstColumn].hasCruiser))) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d} Last Coordinate {%d, %d}", player2_cruiser2_FirstRow, player2_cruiser2_FirstColumn, player2_cruiser2_LastRow, player2_cruiser2_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setCruiser();
            }
        }

        if ((player2_cruiser2_FirstRow == player2_cruiser2_LastRow && player2_cruiser2_FirstColumn != player2_cruiser2_LastColumn) || ((player2_cruiser2_FirstColumn == player2_cruiser2_LastColumn && player2_cruiser2_FirstRow != player2_cruiser2_LastRow))) {
            if (player2_cruiser2_FirstRow - player2_cruiser2_LastRow == 2 || player2_cruiser2_FirstColumn - player2_cruiser2_LastColumn == 2 || player2_cruiser2_FirstRow - player2_cruiser2_LastRow == -2 || player2_cruiser2_FirstColumn - player2_cruiser2_LastColumn == -2) {
                if (player2_cruiser2_FirstRow == player2_cruiser2_LastRow) {
                    Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn].hasCruiser2 = true;
                    Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn].empty = false;
                    Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn + 1].hasCruiser2 = true;
                    Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn + 1].empty = false;
                    Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_LastColumn].hasCruiser2 = true;
                    Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_LastColumn].empty = false;
                    Board.printOceanMap(true, Board.player2_board);
                    player2_setDestroyer();
                } else {
                    Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn].hasCruiser2 = true;
                        Board.player2_board[player2_cruiser2_FirstRow][player2_cruiser2_FirstColumn].empty = false;
                    Board.player2_board[player2_cruiser2_FirstRow + 1][player2_cruiser2_FirstColumn].hasCruiser2 = true;
                        Board.player2_board[player2_cruiser2_FirstRow + 1][player2_cruiser2_FirstColumn].empty = false;
                    Board.player2_board[player2_cruiser2_LastRow][player2_cruiser2_FirstColumn].hasCruiser2 = true;
                        Board.player2_board[player2_cruiser2_LastRow][player2_cruiser2_FirstColumn].empty = false;
                    Board.printOceanMap(true, Board.player2_board);
                    player2_setDestroyer();
                }
            } else {
                System.out.printf("Invalid output. Cruiser's First Coordinate {%d, %d}, Battleship's Last Coordinate {%d, %d}", player2_cruiser2_FirstRow, player2_cruiser2_FirstColumn, player2_cruiser2_LastRow, player2_cruiser2_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setCruiser2();
            }
        } else {
            System.out.printf("Invalid output. Cruiser's First Coordinate {%d, %d}, Cruiser's Last Coordinate {%d, %d}", player2_cruiser2_FirstRow, player2_cruiser_FirstColumn, player2_cruiser2_LastRow, player2_cruiser2_LastColumn);
            Board.printOceanMap(true, Board.player2_board);
            System.out.println();
            player2_setCruiser2();
        }
    }

    public static void  player2_setDestroyer() {
        Scanner input = new Scanner(System.in);

        // Cruiser #2
        System.out.print("The Destroyer is 2 spaces, set row first space, Row: ");
        System.out.println();
        player2_destroyer_FirstRow = input.nextInt();

        System.out.print("Set column of first space, Column: ");
        System.out.println();
        player2_destroyer_FirstColumn = input.nextInt();

        System.out.print("Set row of last space, Row: ");
        System.out.println();
        player2_destroyer_LastRow = input.nextInt();

        System.out.print("Set column of last space, Column: ");
        System.out.println();
        player2_destroyer_LastColumn = input.nextInt();

        if (player2_destroyer_FirstRow == player2_destroyer_LastRow) {
            destroyer_player2 = new int[][]{
                    {player2_destroyer_FirstRow, player2_destroyer_FirstColumn},
                    {player2_destroyer_FirstRow, player2_destroyer_LastColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(destroyer_player2));
            System.out.println();
        }

        if (player2_destroyer_FirstColumn == player2_destroyer_LastColumn) {
            destroyer_player2 = new int[][]{
                    {player2_destroyer_FirstRow, player2_destroyer_FirstColumn},
                    {player2_destroyer_LastRow, player2_destroyer_FirstColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(destroyer_player2));
            System.out.println();
        }

        if (player2_destroyer_FirstRow > 9 || player2_destroyer_LastRow > 9 || player2_destroyer_FirstColumn > 9 || player2_destroyer_LastColumn > 9) {
            System.out.printf("Invalid output. Destroyer's First Coordinate {%d, %d}, Cruiser's Last Coordinate {%d, %d}", player2_destroyer_FirstRow, player2_destroyer_FirstColumn, player2_destroyer_LastRow, player2_destroyer_LastColumn);
            Board.printOceanMap(true, Board.player2_board);
            System.out.println();
            player2_setDestroyer();
        }

        if (player2_destroyer_FirstRow == player2_destroyer_LastRow) {
            if ((Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].hasCarrier || Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_LastColumn].hasCarrier) ||
                    ((Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].hasBattleship || Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_LastColumn].hasBattleship)) ||
                    ((Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].hasCruiser || Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_LastColumn].hasCruiser)) ||
                    (Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].hasCruiser2 || Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_LastColumn].hasCruiser2)) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d}, Last Coordinate {%d, %d}", player2_destroyer_FirstRow, player2_destroyer_FirstColumn, player2_destroyer_LastRow, player2_destroyer_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setDestroyer();
            }
        }

        if (player2_destroyer_FirstColumn == player2_destroyer_LastColumn) {
            if ((Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].hasCarrier || Board.player2_board[player2_destroyer_LastRow][player2_destroyer_FirstColumn].hasCarrier) ||
                    ((Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].hasBattleship || Board.player2_board[player2_destroyer_LastRow][player2_destroyer_FirstColumn].hasBattleship)) ||
                    ((Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].hasCruiser || Board.player2_board[player2_destroyer_LastRow][player2_destroyer_FirstColumn].hasCruiser)) ||
                    ((Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].hasCruiser2 || Board.player2_board[player2_destroyer_LastRow][player2_destroyer_FirstColumn].hasCruiser2))) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d}, Last Coordinate {%d, %d}", player2_destroyer_FirstRow, player2_destroyer_FirstColumn, player2_destroyer_LastRow, player2_destroyer_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setDestroyer();
            }
        }

        if ((player2_destroyer_FirstRow == player2_destroyer_LastRow && player2_destroyer_FirstColumn != player2_destroyer_LastColumn) || ((player2_destroyer_FirstColumn == player2_destroyer_LastColumn && player2_destroyer_FirstRow != player2_destroyer_LastRow))) {
            if (player2_destroyer_FirstRow - player2_destroyer_LastRow == 1 || player2_destroyer_FirstColumn - player2_destroyer_LastColumn == 1 || player2_destroyer_FirstRow - player2_destroyer_LastRow == -1 || player2_destroyer_FirstColumn - player2_destroyer_LastColumn == -1) {
                if (player2_destroyer_FirstRow == player2_destroyer_LastRow) {
                    Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].hasDestroyer = true;
                        Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].empty = false;
                    Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_LastColumn].hasDestroyer = true;
                        Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_LastColumn].empty = false;
                    Board.printOceanMap(true, Board.player2_board);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Main.shooting();
                } else {
                    Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].hasDestroyer = true;
                        Board.player2_board[player2_destroyer_FirstRow][player2_destroyer_FirstColumn].empty = false;
                    Board.player2_board[player2_destroyer_LastRow][player2_destroyer_FirstColumn].hasDestroyer = true;
                        Board.player2_board[player2_destroyer_LastRow][player2_destroyer_FirstColumn].empty = false;
                    Board.printOceanMap(true, Board.player2_board);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Main.shooting();
                }
            } else {
                System.out.printf("Invalid output. Destroyer's First Coordinate {%d, %d}, Cruiser's Last Coordinate {%d, %d}", player2_destroyer_FirstRow, player2_destroyer_FirstColumn, player2_destroyer_LastRow, player2_destroyer_LastColumn);
                Board.printOceanMap(true, Board.player2_board);
                System.out.println();
                player2_setDestroyer();
            }
        } else {
            System.out.printf("Invalid output. Destroyer's First Coordinate {%d, %d}, Cruiser's Last Coordinate {%d, %d}", player2_destroyer_FirstRow, player2_destroyer_FirstColumn, player2_destroyer_LastRow, player2_destroyer_LastColumn);
            Board.printOceanMap(true, Board.player2_board);
            System.out.println();
            player2_setDestroyer();
        }
    }
}

