import java.util.Arrays;
import java.util.Scanner;

public class Battleship {

    static int carrier_FirstRow;
    static int carrier_FirstColumn;
    static int carrier_LastRow;
    static int carrier_LastColumn;

    static int battleship_FirstRow;
    static int battleship_FirstColumn;
    static int battleship_LastRow;
    static int battleship_LastColumn;

    static int cruiser_FirstRow;
    static int cruiser_FirstColumn;
    static int cruiser_LastRow;
    static int cruiser_LastColumn;

    static int cruiser2_FirstRow;
    static int cruiser2_FirstColumn;
    static int cruiser2_LastColumn;
    static int cruiser2_LastRow;

    static int destroyer_FirstRow;
    static int destroyer_FirstColumn;
    static int destroyer_LastColumn;
    static int destroyer_LastRow;

    static int[][] carrier;
    static int[][] battleship;
    static int[][] cruiser;
    static int[][] cruiser2;
    static int[][] destroyer;

    public static void setCarrier() {
        Scanner input = new Scanner(System.in);
        System.out.print("The Carrier is 5 spaces, set row first space, Row: ");
        System.out.println();
        carrier_FirstRow = input.nextInt();

        System.out.print("Set column of first space, Column: ");
        System.out.println();
        carrier_FirstColumn = input.nextInt();

        System.out.print("Set row of last space, Row: ");
        System.out.println();
        carrier_LastRow = input.nextInt();

        System.out.print("Set column of last space, Column: ");
        System.out.println();
        carrier_LastColumn = input.nextInt();


        if (carrier_FirstRow == carrier_LastRow) {
            carrier = new int[][]{
                    {carrier_FirstRow, carrier_FirstColumn},
                    {carrier_FirstRow, carrier_FirstColumn + 1},
                    {carrier_FirstRow, carrier_FirstColumn + 2},
                    {carrier_FirstRow, carrier_LastColumn - 1},
                    {carrier_FirstRow, carrier_LastColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(carrier));
            System.out.println();
        }

        if (carrier_FirstColumn == carrier_LastColumn) {
            carrier = new int[][]{
                    {carrier_FirstRow, carrier_FirstColumn},
                    {carrier_FirstRow + 1, carrier_FirstColumn},
                    {carrier_FirstRow + 2, carrier_FirstColumn},
                    {carrier_LastRow - 1, carrier_FirstColumn},
                    {carrier_LastRow, carrier_FirstColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(carrier));
            System.out.println();
        }

        if (carrier_FirstRow > 9 || carrier_LastRow > 9 || carrier_LastColumn > 9 || carrier_FirstColumn > 9) {
            System.out.println();
            System.out.printf("Out of bounds. Carrier's First Coordinate {%d,%d}, Carrier's Last Coordinate {%d, %d}", carrier_FirstRow, carrier_LastRow, carrier_FirstColumn, carrier_LastColumn);
            System.out.println();
            Board.printOceanMap(true, Board.player_board);
            System.out.println();
            setCarrier();
        }

        if ((carrier_FirstRow == carrier_LastRow && carrier_FirstColumn != carrier_LastColumn) || ((carrier_FirstColumn == carrier_LastColumn && carrier_FirstRow != carrier_LastRow))) {
            if (((carrier_FirstRow - carrier_LastRow) == 4) || ((carrier_FirstColumn - carrier_LastColumn) == 4) || (carrier_FirstRow - carrier_LastRow == -4) || (carrier_FirstColumn - carrier_LastColumn == -4)) {
                if (carrier_FirstRow == carrier_LastRow) {
                    Board.player_board[carrier_FirstRow][carrier_FirstColumn].hasCarrier = true;
                        Board.player_board[carrier_FirstRow][carrier_FirstColumn].empty = false;
                    Board.player_board[carrier_FirstRow][carrier_FirstColumn + 1].hasCarrier = true;
                        Board.player_board[carrier_FirstRow][carrier_FirstColumn + 1].empty = false;
                    Board.player_board[carrier_FirstRow][carrier_FirstColumn + 2].hasCarrier = true;
                        Board.player_board[carrier_FirstRow][carrier_FirstColumn + 2].empty = false;
                    Board.player_board[carrier_FirstRow][carrier_LastColumn - 1].hasCarrier = true;
                        Board.player_board[carrier_FirstRow][carrier_LastColumn - 1].empty = false;
                    Board.player_board[carrier_FirstRow][carrier_LastColumn].hasCarrier = true;
                        Board.player_board[carrier_FirstRow][carrier_LastColumn].empty = false;
                    Board.printOceanMap(true, Board.player_board);
                    setBattleship();
                } else {
                    Board.player_board[carrier_FirstRow][carrier_FirstColumn].hasCarrier = true;
                        Board.player_board[carrier_FirstRow][carrier_FirstColumn].empty = false;
                    Board.player_board[carrier_FirstRow + 1][carrier_FirstColumn].hasCarrier = true;
                        Board.player_board[carrier_FirstRow +1][carrier_FirstColumn].empty = false;
                    Board.player_board[carrier_FirstRow + 2][carrier_FirstColumn].hasCarrier = true;
                        Board.player_board[carrier_FirstRow +2][carrier_FirstColumn].empty = false;
                    Board.player_board[carrier_LastRow - 1][carrier_FirstColumn].hasCarrier = true;
                        Board.player_board[carrier_LastRow -1][carrier_FirstColumn].empty = false;
                    Board.player_board[carrier_LastRow][carrier_FirstColumn].hasCarrier = true;
                        Board.player_board[carrier_FirstRow][carrier_FirstColumn].empty = false;
                    Board.printOceanMap(true, Board.player_board);
                    setBattleship();
                }
            } else {
                System.out.printf("Invalid Output! Carrier's First Coordinate: {%d,%d}, Last Coordinate: {%d,%d}", carrier_FirstRow, carrier_FirstRow, carrier_LastRow, carrier_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setCarrier();
            }
        } else {
            System.out.printf("Invalid Output! Carrier's First Coordinate: {%d,%d}, Last Coordinate: {%d,%d}", carrier_FirstRow, carrier_FirstRow, carrier_LastRow, carrier_LastColumn);
            Board.printOceanMap(true, Board.player_board);
            System.out.println();
            setCarrier();
        }
    }

    public static void setBattleship() {
        Scanner input = new Scanner(System.in);

        // Asks user for battleship coordinates
        System.out.print("The Battleship is 4 spaces, set row first space, Row: ");
        System.out.println();
        battleship_FirstRow = input.nextInt();

        System.out.print("Set column of first space, Column: ");
        System.out.println();
        battleship_FirstColumn = input.nextInt();

        System.out.print("Set row of last space, Row: ");
        System.out.println();
        battleship_LastRow = input.nextInt();

        System.out.print("Set column of last space, Column: ");
        System.out.println();
        battleship_LastColumn = input.nextInt();

        if (battleship_FirstRow == battleship_LastRow) {
            battleship = new int[][]{
                    {battleship_FirstRow, battleship_FirstColumn},
                    {battleship_FirstRow, battleship_FirstColumn + 1},
                    {battleship_FirstRow, battleship_LastColumn - 1},
                    {battleship_FirstRow, battleship_LastColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(battleship));
            System.out.println();
        }

        if (battleship_FirstColumn == battleship_LastColumn) {
            battleship = new int[][]{
                    {battleship_FirstRow, battleship_FirstColumn},
                    {battleship_FirstRow + 1, battleship_FirstColumn},
                    {battleship_LastRow - 1, battleship_FirstColumn},
                    {battleship_LastRow, battleship_FirstColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(battleship));
            System.out.println();
        }

        if (battleship_FirstRow > 9 || battleship_LastRow > 9 || battleship_FirstColumn > 9 || battleship_LastColumn > 9) {
            System.out.printf("Out of Bounds. Battleship's First Coordinate {%d. %d}, Battleship's Last Coordinate {%d,%d}", battleship_FirstRow, battleship_FirstColumn, battleship_LastRow, battleship_LastColumn);
            Board.printOceanMap(true, Board.player_board);
            System.out.println();
            setBattleship();
        }

        if (battleship_FirstRow == battleship_LastRow) {
            if (Board.player_board[battleship_FirstRow][battleship_LastRow].hasCarrier || Board.player_board[battleship_FirstRow][battleship_FirstColumn + 1].hasCarrier
                    || Board.player_board[battleship_FirstRow][battleship_LastColumn - 1].hasCarrier || Board.player_board[battleship_FirstRow][battleship_LastColumn].hasCarrier) {
                System.out.printf("Invalid output, overlaps with another ship. Battleship's First Coordinate {%d, %d}, Last Coordinate {%d,%d}", battleship_FirstRow, battleship_FirstColumn, battleship_LastRow, battleship_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setBattleship();
            }
        }

        if (battleship_FirstColumn == battleship_LastColumn) {
            if (Board.player_board[battleship_FirstRow + 1][battleship_FirstColumn].hasCarrier || Board.player_board[battleship_LastRow - 1][battleship_FirstColumn].hasCarrier || Board.player_board[battleship_LastRow][battleship_FirstColumn].hasCarrier) {
                System.out.printf("Invalid output, overlaps with another ship. Battleship's First Coordinate {%d, %d}, Last Coordinate {%d,%d}", battleship_FirstRow, battleship_FirstColumn, battleship_LastRow, battleship_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setBattleship();
            }
        }

        if ((battleship_FirstRow == battleship_LastRow && battleship_FirstColumn != battleship_LastColumn) || ((battleship_FirstColumn == battleship_LastColumn && battleship_FirstRow != battleship_LastRow))) {
            if (((battleship_FirstRow - battleship_LastRow) == 3) || ((battleship_FirstColumn - battleship_LastColumn) == 3) || (battleship_FirstRow - battleship_LastRow == -3) || (battleship_FirstColumn - battleship_LastColumn == -3)) {
                if (battleship_FirstRow == battleship_LastRow) {
                    Board.player_board[battleship_FirstRow][battleship_FirstColumn].hasBattleship = true;
                        Board.player_board[battleship_FirstRow][battleship_FirstColumn].empty = false;
                    Board.player_board[battleship_FirstRow][battleship_FirstColumn + 1].hasBattleship = true;
                        Board.player_board[battleship_FirstRow][battleship_FirstColumn +1].empty = false;
                    Board.player_board[battleship_FirstRow][battleship_LastColumn - 1].hasBattleship = true;
                        Board.player_board[battleship_FirstRow][battleship_LastColumn -1].empty = false;
                    Board.player_board[battleship_FirstRow][battleship_LastColumn].hasBattleship = true;
                        Board.player_board[battleship_FirstRow][battleship_LastColumn].empty = false;
                    Board.printOceanMap(true, Board.player_board);
                    setCruiser();
                } else {
                    Board.player_board[battleship_FirstRow][battleship_FirstColumn].hasBattleship = true;
                        Board.player_board[battleship_FirstRow][battleship_FirstColumn].empty = false;
                    Board.player_board[battleship_FirstRow + 1][battleship_FirstColumn].hasBattleship = true;
                        Board.player_board[battleship_FirstRow + 1][battleship_FirstColumn].empty = false;
                    Board.player_board[battleship_LastRow - 1][battleship_FirstColumn].hasBattleship = true;
                        Board.player_board[battleship_LastRow - 1][battleship_FirstColumn].empty = false;
                    Board.player_board[battleship_LastRow][battleship_FirstColumn].hasBattleship = true;
                        Board.player_board[battleship_LastRow][battleship_FirstColumn].empty = false;
                    Board.printOceanMap(true, Board.player_board);
                    setCruiser();
                }
            } else {
                System.out.printf("Invalid output. Battleship's First Coordinate {%d. %d}, Battleship's Last Coordinate {%d,%d}", battleship_FirstRow, battleship_FirstColumn, battleship_LastRow, battleship_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setBattleship();
            }
        } else {
            System.out.printf("Invalid output. Battleship's First Coordinate {%d. %d}, Battleship's Last Coordinate {%d,%d}", battleship_FirstRow, battleship_FirstColumn, battleship_LastRow, battleship_LastColumn);
            Board.printOceanMap(true, Board.player_board);
            System.out.println();
            setBattleship();
        }

    }

    public static void setCruiser() {
        Scanner input = new Scanner(System.in);

        // Prompts user to set coordinates of Cruiser
        System.out.print("The Cruiser is 3 spaces, set row first space, Row: ");
        System.out.println();
        cruiser_FirstRow = input.nextInt();

        System.out.print("Set column of first space, Column: ");
        System.out.println();
        cruiser_FirstColumn = input.nextInt();

        System.out.print("Set row of last space, Row: ");
        System.out.println();
        cruiser_LastRow = input.nextInt();

        System.out.print("Set column of last space, Column: ");
        System.out.println();
        cruiser_LastColumn = input.nextInt();

        if (cruiser_FirstRow == cruiser_LastRow) {
            cruiser = new int[][]{
                    {cruiser_FirstRow, cruiser_FirstColumn},
                    {cruiser_FirstRow, cruiser_FirstColumn + 1},
                    {cruiser_FirstRow, cruiser_LastColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(cruiser));
            System.out.println();
        }

        if (cruiser_FirstColumn == cruiser_LastColumn) {
            cruiser = new int[][]{
                    {cruiser_FirstRow, cruiser_FirstColumn},
                    {cruiser_FirstRow + 1, cruiser_FirstColumn},
                    {cruiser_LastRow, cruiser_FirstColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(cruiser));
            System.out.println();
        }

        if (cruiser_FirstRow > 9 || cruiser_LastRow > 9 || cruiser_FirstColumn > 9 || cruiser_LastColumn > 9) {
            System.out.printf("Out of bounds. Cruiser's First Coordinate {%d. %d}, Cruiser's Last Coordinate {%d,%d}", cruiser_FirstRow, cruiser_FirstColumn, cruiser_LastRow, cruiser_LastColumn);
            Board.printOceanMap(true, Board.player_board);
            System.out.println();
            setCruiser();
        }

        if (cruiser_FirstRow == cruiser_LastRow) {
            if ((Board.player_board[cruiser_FirstRow][cruiser_FirstColumn].hasCarrier || Board.player_board[cruiser_FirstRow][cruiser_FirstColumn + 1].hasCarrier || Board.player_board[cruiser_FirstRow][cruiser_LastColumn].hasCarrier) ||
                    ((Board.player_board[cruiser_FirstRow][cruiser_FirstColumn].hasBattleship || Board.player_board[cruiser_FirstRow][cruiser_FirstColumn + 1].hasBattleship || Board.player_board[cruiser_FirstRow][cruiser_LastColumn].hasBattleship))) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d}, Last Coordinate {%d,%d}", cruiser_FirstRow, cruiser_FirstColumn, cruiser_LastRow, cruiser_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setCruiser();
            }
        }

        if (cruiser_FirstColumn == cruiser_LastColumn) {
            if ((Board.player_board[cruiser_FirstRow][cruiser_FirstColumn].hasCarrier || Board.player_board[cruiser_FirstRow + 1][cruiser_FirstColumn].hasCarrier || Board.player_board[cruiser_LastRow][cruiser_FirstColumn].hasCarrier) ||
                    ((Board.player_board[cruiser_FirstRow][cruiser_FirstColumn].hasBattleship || Board.player_board[cruiser_FirstRow + 1][cruiser_FirstColumn].hasBattleship || Board.player_board[cruiser_LastRow][cruiser_FirstColumn].hasBattleship))) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d}, Last Coordinate {%d,%d}", cruiser_FirstRow, cruiser_FirstColumn, cruiser_LastRow, cruiser_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setCruiser();
            }
        }

        if ((cruiser_FirstRow == cruiser_LastRow && cruiser_FirstColumn != cruiser_LastColumn) || ((cruiser_FirstColumn == cruiser_LastColumn && cruiser_FirstRow != cruiser_LastRow))) {
            if (cruiser_FirstRow - cruiser_LastRow == 2 || cruiser_FirstColumn - cruiser_LastColumn == 2 || cruiser_FirstRow - cruiser_LastRow == -2 || cruiser_FirstColumn - cruiser_LastColumn == -2) {
                if (cruiser_FirstRow == cruiser_LastRow) {
                    Board.player_board[cruiser_FirstRow][cruiser_FirstColumn].hasCruiser = true;
                        Board.player_board[cruiser_FirstRow][cruiser_FirstColumn].empty = false;
                    Board.player_board[cruiser_FirstRow][cruiser_FirstColumn + 1].hasCruiser = true;
                        Board.player_board[cruiser_FirstRow][cruiser_FirstColumn + 1].empty = false;
                    Board.player_board[cruiser_FirstRow][cruiser_LastColumn].hasCruiser = true;
                        Board.player_board[cruiser_FirstRow][cruiser_LastColumn].empty = false;
                    Board.printOceanMap(true, Board.player_board);
                    setCruiser2();
                } else {
                    Board.player_board[cruiser_FirstRow][cruiser_FirstColumn].hasCruiser = true;
                        Board.player_board[cruiser_FirstRow][cruiser_FirstColumn].empty = false;
                    Board.player_board[cruiser_FirstRow + 1][cruiser_FirstColumn].hasCruiser = true;
                        Board.player_board[cruiser_FirstRow + 1][cruiser_FirstColumn].empty = false;
                    Board.player_board[cruiser_LastRow][cruiser_FirstColumn].hasCruiser = true;
                        Board.player_board[cruiser_LastRow][cruiser_FirstColumn].empty = false;
                    Board.printOceanMap(true, Board.player_board);
                    setCruiser2();
                }
            } else {
                System.out.printf("Invalid output. Cruiser's First Coordinate {%d. %d}, Cruiser's Last Coordinate {%d,%d}", cruiser_FirstRow, cruiser_FirstColumn, cruiser_LastRow, cruiser_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setCruiser();
            }
        } else {
            System.out.printf("Invalid output. Cruiser's First Coordinate {%d. %d}, Cruiser's Last Coordinate {%d,%d}", cruiser_FirstRow, cruiser_FirstColumn, cruiser_LastRow, cruiser_LastColumn);
            Board.printOceanMap(true, Board.player_board);
            System.out.println();
            setCruiser();
        }
    }

    public static void setCruiser2() {
        Scanner input = new Scanner(System.in);

        // Prompts user to set coordinates of Cruiser
        System.out.print("The Cruiser #2 is 3 spaces, set row first space, Row: ");
        System.out.println();
        cruiser2_FirstRow = input.nextInt();

        System.out.print("Set column of first space, Column: ");
        System.out.println();
        cruiser2_FirstColumn = input.nextInt();

        System.out.print("Set row of last space, Row: ");
        System.out.println();
        cruiser2_LastRow = input.nextInt();

        System.out.print("Set column of last space, Column: ");
        System.out.println();
        cruiser2_LastColumn = input.nextInt();

        if (cruiser2_FirstRow == cruiser2_LastRow) {
            cruiser2 = new int[][]{
                    {cruiser2_FirstRow, cruiser2_FirstColumn},
                    {cruiser2_FirstRow, cruiser2_FirstColumn + 1},
                    {cruiser2_FirstRow, cruiser2_LastColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(cruiser2));
            System.out.println();
        }

        if (cruiser2_FirstColumn == cruiser2_LastColumn) {
            cruiser2 = new int[][]{
                    {cruiser2_FirstRow, cruiser2_FirstColumn},
                    {cruiser2_FirstRow + 1, cruiser2_FirstColumn},
                    {cruiser2_LastRow, cruiser2_FirstColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(cruiser2));
            System.out.println();
        }

        if (cruiser2_FirstRow > 9 || cruiser2_LastRow > 9 || cruiser2_FirstColumn > 9 || cruiser2_LastColumn > 9) {
            System.out.printf("Invalid output. Cruiser's First Coordinate {%d. %d}, Cruiser's Last Coordinate {%d,%d}", cruiser2_FirstRow, cruiser2_FirstColumn, cruiser2_LastRow, cruiser2_LastColumn);
            Board.printOceanMap(true, Board.player_board);
            System.out.println();
            setCruiser2();
        }

        if (cruiser2_FirstRow == cruiser2_LastRow) {
            if ((Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn].hasCarrier || Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn + 1].hasCarrier || Board.player_board[cruiser2_FirstRow][cruiser2_LastColumn].hasCarrier) ||
                    ((Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn].hasBattleship || Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn + 1].hasBattleship || Board.player_board[cruiser2_FirstRow][cruiser2_LastColumn].hasBattleship)) ||
                    ((Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn].hasCruiser || Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn + 1].hasCruiser || Board.player_board[cruiser2_FirstRow][cruiser2_LastColumn].hasCruiser))) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d} Last Coordinate {%d,%d}", cruiser2_FirstRow, cruiser2_FirstColumn, cruiser2_LastRow, cruiser2_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setCruiser2();
            }
        }

        if (cruiser2_FirstColumn == cruiser2_LastColumn) {
            if ((Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn].hasCarrier || Board.player_board[cruiser2_FirstRow + 1][cruiser2_FirstColumn].hasCarrier || Board.player_board[cruiser2_LastRow][cruiser2_FirstColumn].hasCarrier) ||
                    ((Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn].hasBattleship || Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn + 1].hasBattleship || Board.player_board[cruiser2_FirstRow][cruiser2_LastColumn].hasBattleship)) ||
                    ((Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn].hasCruiser || Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn + 1].hasCruiser || Board.player_board[cruiser2_FirstRow][cruiser2_LastColumn].hasCruiser))) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d} Last Coordinate {%d,%d}", cruiser2_FirstRow, cruiser2_FirstColumn, cruiser2_LastRow, cruiser2_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setCruiser2();
            }
        }

        if ((cruiser2_FirstRow == cruiser2_LastRow && cruiser2_FirstColumn != cruiser2_LastColumn) || ((cruiser2_FirstColumn == cruiser2_LastColumn && cruiser2_FirstRow != cruiser2_LastRow))) {
            if (cruiser2_FirstRow - cruiser2_LastRow == 2 || cruiser2_FirstColumn - cruiser2_LastColumn == 2 || cruiser2_FirstRow - cruiser2_LastRow == -2 || cruiser2_FirstColumn - cruiser2_LastColumn == -2) {
                if (cruiser2_FirstRow == cruiser2_LastRow) {
                    Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn].hasCruiser = true;
                        Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn].empty = false;
                    Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn + 1].hasCruiser = true;
                        Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn +1].empty = false;
                    Board.player_board[cruiser2_FirstRow][cruiser2_LastColumn].hasCruiser = true;
                        Board.player_board[cruiser2_FirstRow][cruiser2_LastColumn].empty = false;
                    Board.printOceanMap(true, Board.player_board);
                    setDestroyer();
                } else {
                    Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn].hasCruiser = true;
                        Board.player_board[cruiser2_FirstRow][cruiser2_FirstColumn].empty = false;
                    Board.player_board[cruiser2_FirstRow + 1][cruiser2_FirstColumn].hasCruiser = true;
                        Board.player_board[cruiser2_FirstRow + 1][cruiser2_FirstColumn].empty = false;
                    Board.player_board[cruiser2_LastRow][cruiser2_FirstColumn].hasCruiser = true;
                        Board.player_board[cruiser2_LastRow][cruiser2_FirstColumn].empty = false;
                    Board.printOceanMap(true, Board.player_board);
                    setDestroyer();
                }
            } else {
                System.out.printf("Invalid output. Cruiser's First Coordinate {%d, %d}, Battleship's Last Coordinate {%d, %d}", cruiser2_FirstRow, cruiser2_FirstColumn, cruiser2_LastRow, cruiser2_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setCruiser2();
            }
        } else {
            System.out.printf("Invalid output. Cruiser's First Coordinate {%d, %d}, Cruiser's Last Coordinate {%d, %d}", cruiser2_FirstRow, cruiser_FirstColumn, cruiser2_LastRow, cruiser2_LastColumn);
            Board.printOceanMap(true, Board.player_board);
            System.out.println();
            setCruiser2();
        }
    }

    public static void setDestroyer() {
        Scanner input = new Scanner(System.in);

        // Cruiser #2
        System.out.print("The Destroyer is 2 spaces, set row first space, Row: ");
        destroyer_FirstRow = input.nextInt();

        System.out.print("Set column of first space, Column: ");
        destroyer_FirstColumn = input.nextInt();

        System.out.print("Set row of last space, Row: ");
        destroyer_LastRow = input.nextInt();

        System.out.print("Set column of last space, Column: ");
        destroyer_LastColumn = input.nextInt();

        if (destroyer_FirstRow == destroyer_LastRow) {
            destroyer = new int[][]{
                    {destroyer_FirstRow, destroyer_FirstColumn},
                    {destroyer_FirstRow, destroyer_LastColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(destroyer));
            System.out.println();
        }

        if (destroyer_FirstColumn == destroyer_LastColumn) {
            destroyer = new int[][]{
                    {destroyer_FirstRow, destroyer_FirstColumn},
                    {destroyer_LastRow, destroyer_FirstColumn}
            };
            System.out.println();
            System.out.print(Arrays.deepToString(destroyer));
            System.out.println();
        }

        if (destroyer_FirstRow > 9 || destroyer_LastRow > 9 || destroyer_FirstColumn > 9 || destroyer_LastColumn > 9) {
            System.out.printf("Invalid output. Destroyer's First Coordinate {%d, %d}, Destroyer's Last Coordinate {%d, %d}", destroyer_FirstRow, destroyer_FirstColumn, destroyer_LastRow, destroyer_LastColumn);
            Board.printOceanMap(true, Board.player_board);
            System.out.println();
            setDestroyer();
        }

        if (destroyer_FirstRow == destroyer_LastRow) {
            if ((Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].hasCarrier || Board.player_board[destroyer_FirstRow][destroyer_LastColumn].hasCarrier) ||
                    ((Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].hasBattleship || Board.player_board[destroyer_FirstRow][destroyer_LastColumn].hasBattleship)) ||
                    ((Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].hasCruiser || Board.player_board[destroyer_FirstRow][destroyer_LastColumn].hasCruiser)) ||
                    ((Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].hasCruiser2 || Board.player_board[destroyer_FirstRow][destroyer_LastColumn].hasCruiser2))) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d}, Last Coordinate {%d, %d}", destroyer_FirstRow, destroyer_FirstColumn, destroyer_LastRow, destroyer_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setDestroyer();
            }
        }

        if (destroyer_FirstColumn == destroyer_LastColumn) {
            if ((Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].hasCarrier || Board.player_board[destroyer_LastRow][destroyer_FirstColumn].hasCarrier) ||
                    ((Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].hasBattleship || Board.player_board[destroyer_LastRow][destroyer_FirstColumn].hasBattleship)) ||
                    ((Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].hasCruiser || Board.player_board[destroyer_LastRow][destroyer_FirstColumn].hasCruiser)) ||
                    (Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].hasCruiser2 || Board.player_board[destroyer_LastRow][destroyer_FirstColumn].hasCruiser2)) {
                System.out.printf("Invalid output, overlaps with another ship. First Coordinate {%d, %d}, Last Coordinate {%d, %d}", destroyer_FirstRow, destroyer_FirstColumn, destroyer_LastRow, destroyer_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setDestroyer();
            }
        }

        if ((destroyer_FirstRow == destroyer_LastRow && destroyer_FirstColumn != destroyer_LastColumn) || ((destroyer_FirstColumn == destroyer_LastColumn && destroyer_FirstRow != destroyer_LastRow))) {
            if (destroyer_FirstRow - destroyer_LastRow == 1 || destroyer_FirstColumn - destroyer_LastColumn == 1 || destroyer_FirstRow - destroyer_LastRow == -1 || destroyer_FirstColumn - destroyer_LastColumn == -1) {
                if (destroyer_FirstRow == destroyer_LastRow) {
                    Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].hasDestroyer = true;
                        Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].empty = false;
                    Board.player_board[destroyer_FirstRow][destroyer_LastColumn].hasDestroyer = true;
                        Board.player_board[destroyer_FirstRow][destroyer_LastColumn].empty = false;
                    Board.printOceanMap(true, Board.player_board);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Main.response.equalsIgnoreCase("1P")) {
                        Main.ai();
                    }  else {
                        Main.doBattleship2();
                    }
                } else {
                    Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].hasDestroyer = true;
                        Board.player_board[destroyer_FirstRow][destroyer_FirstColumn].empty = false;
                    Board.player_board[destroyer_LastRow][destroyer_FirstColumn].hasDestroyer = true;
                        Board.player_board[destroyer_LastRow][destroyer_FirstColumn].empty = false;
                    Board.printOceanMap(true, Board.player_board);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Main.response.equalsIgnoreCase("1P")) {
                        Main.ai();
                    }  else {
                        Main.doBattleship2();
                    }
                }
            } else {
                System.out.printf("Invalid Output. Destroyer's First Coordinate {%d, %d}, Destroyer's Last Coordinate {%d, %d}", destroyer_FirstRow, destroyer_FirstColumn, destroyer_LastRow, destroyer_LastColumn);
                Board.printOceanMap(true, Board.player_board);
                System.out.println();
                setDestroyer();
            }
        } else {
            System.out.printf("Invalid Output. Destroyer's First Coordinate {%d, %d}, Destroyer's Last Coordinate {%d, %d}", destroyer_FirstRow, destroyer_FirstColumn, destroyer_LastRow, destroyer_LastColumn);
            Board.printOceanMap(true, Board.player_board);
            System.out.println();
            setDestroyer();
        }
    }
}
