import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class shooting {

    private static int row;
    private static int column;

    public static void checkBoard_Player1() {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to see your layout?, (yes) or (no) ");
        String resp = input.nextLine();

        if (resp.equals("yes")) {
            Board.printOceanMap(true, Board.player_board);
        } else {
            System.out.print("Continuing ... ");
        }
    }

    public static void checkBoard_Player2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to see your layout?, (yes) or (no) ");
        String resp = input.nextLine();

        if (resp.equals("yes")) {
            Board.printOceanMap(true, Board.player2_board);
        } else {
            System.out.print("Continuing ... ");
        }
    }


    public static void player1_shooting() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println();
            System.out.print("PLAYER 1 IS SHOOTING");
            System.out.println();
            Board.printOceanMap(false, Board.player2_board);

            System.out.print("Row: ");
            int row = input.nextInt();

            System.out.print("Column: ");
            int column = input.nextInt();

            if (Board.player2_board[row][column].hasCarrier || Board.player2_board[row][column].hasBattleship || Board.player2_board[row][column].hasCruiser || Board.player2_board[row][column].hasCruiser2 || Board.player2_board[row][column].hasDestroyer) {
                System.out.printf("You hit a ship {%d,%d}", row, column);
                Board.player2_board[row][column].madeShot = true;
                Board.printOceanMap(false, Board.player2_board);
            }

            if (Board.player2_board[row][column].empty) {
                System.out.printf("You missed! {%d,%d}", row, column);
                Board.player2_board[row][column].missedShot = true;
                Board.printOceanMap(false, Board.player2_board);
            }

            checkBoard_Player1();

            String message = "You have sunk no ships";

            if (checkSunkBattleship() || checkSunkCarrier() || checkSunkCruiser1() || checkSunkCruiser2() || checkSunkDestroyer()) {
                message = "You have sunk the following ships: ";
                if (checkSunkBattleship()) {
                    message = message + "Battleship, ";
                    Main.player_Ships_Sunk++;
                }
                if (checkSunkCarrier()) {
                    message = message + "Carrier, ";
                    Main.player_Ships_Sunk++;
                }
                if (checkSunkCruiser1()) {
                    message = message + "Cruiser1, ";
                    Main.player_Ships_Sunk++;
                }
                if (checkSunkCruiser2()) {
                    message = message + "Cruiser2, ";
                    Main.player_Ships_Sunk++;
                }
                if (checkSunkDestroyer()) {
                    message = message + "Destroyer, ";
                    Main.player_Ships_Sunk++;

                }
                message = message.substring(0, message.length() - 2);
            }
            System.out.println(message);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player2_Shooting();

        } while (Main.player_Ships_Sunk != 5 || Main.player2_Ships_Sunk != 5);
    }

    private static boolean checkSunkCarrier() {
        for (int i = 0; i < 5; i++) {
            if (!Board.player2_board[battleship_player2.carrier_player2[i][0]][battleship_player2.carrier_player2[i][1]].madeShot) {
                return false;
            }
        }
        return true;

    }

    private static boolean checkSunkBattleship() {
        for (int i = 0; i < 4; i++) {
            if (!Board.player2_board[battleship_player2.battleship_player2[i][0]][battleship_player2.battleship_player2[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkCruiser1() {
        for (int i = 0; i < 3; i++) {
            if (!Board.player2_board[battleship_player2.cruiser_player2[i][0]][battleship_player2.cruiser_player2[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkCruiser2() {
        for (int i = 0; i < 3; i++) {
            if (!Board.player2_board[battleship_player2.cruiser2_player2[i][0]][battleship_player2.cruiser2_player2[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkDestroyer() {
        for (int i = 0; i < 2; i++) {
            if (!Board.player2_board[battleship_player2.destroyer_player2[i][0]][battleship_player2.destroyer_player2[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }


    public static void player2_Shooting() {

        Scanner input = new Scanner(System.in);
        do {
            System.out.println();
            System.out.print("PLAYER 2 IS SHOOTING");
            System.out.println();
            Board.printOceanMap(false, Board.player_board);

            System.out.print("Row: ");
            int row = input.nextInt();

            System.out.print("Column: ");
            int column = input.nextInt();

            if (Board.player_board[row][column].hasCarrier || Board.player_board[row][column].hasBattleship || Board.player_board[row][column].hasCruiser || Board.player_board[row][column].hasCruiser2 || Board.player_board[row][column].hasDestroyer) {
                System.out.printf("You hit a ship {%d,%d}", row, column);
                Board.player_board[row][column].madeShot = true;
                Board.printOceanMap(false, Board.player_board);
            }

            if (Board.player_board[row][column].empty) {
                System.out.printf("You missed! {%d,%d}", row, column);
                Board.player_board[row][column].missedShot = true;
                Board.printOceanMap(false, Board.player_board);
            }

            checkBoard_Player2();

            String message = "You have sunk no ships";
            if (checkSunkBattleship2() || checkSunkCarrier2() || checkSunkCruiser1_2() || checkSunkCruiser2_2() || checkSunkDestroyer2()) {
                message = "You have sunk the following ships: ";
                if (checkSunkBattleship2()) {
                    message = message + "Battleship, ";
                    Main.player2_Ships_Sunk++;
                }
                if (checkSunkCarrier2()) {
                    message = message + "Carrier, ";
                    Main.player2_Ships_Sunk++;
                }
                if (checkSunkCruiser1_2()) {
                    message = message + "Cruiser1, ";
                    Main.player2_Ships_Sunk++;
                }
                if (checkSunkCruiser2_2()) {
                    message = message + "Cruiser2, ";
                    Main.player2_Ships_Sunk++;
                }
                if (checkSunkDestroyer2()) {
                    message = message + "Destroyer, ";
                    Main.player2_Ships_Sunk++;
                }
                message = message.substring(0, message.length() - 2);
            }
            System.out.println(message);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player1_shooting();

        } while (Main.player2_Ships_Sunk != 5);

    }

    private static boolean checkSunkCarrier2() {
        for (int i = 0; i < 5; i++) {
            if (!Board.player_board[Battleship.carrier[i][0]][Battleship.carrier[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkBattleship2() {
        for (int i = 0; i < 4; i++) {
            if (!Board.player_board[Battleship.battleship[i][0]][Battleship.battleship[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkCruiser1_2() {
        for (int i = 0; i < 3; i++) {
            if (!Board.player_board[Battleship.cruiser[i][0]][Battleship.cruiser[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkCruiser2_2() {
        for (int i = 0; i < 3; i++) {
            if (!Board.player_board[Battleship.cruiser2[i][0]][Battleship.cruiser2[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkDestroyer2() {
        for (int i = 0; i < 2; i++) {
            if (!Board.player_board[Battleship.destroyer[i][0]][Battleship.destroyer[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    public static void ai_shooting() {
        do {

            row = (int) (Math.random() * (9));
            column = (int) (Math.random() * (9));

            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    if (Board.player_board[x][y].madeShot && Board.player_board[x + 1][y].empty && (x+1 != 10) && !Board.player_board[x+1][y].hasBeenHit) {
                        row = x + 1;
                        column = y;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x + 1][y].madeShot && (x+2 != 10) && !Board.player_board[x +2][y].hasBeenHit) {
                        row = x + 2;
                        column = y;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x + 2][y].madeShot && (x+3 != 10) && !Board.player_board[x + 3][y].hasBeenHit) {
                        row = x + 3;
                        column = y;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x + 3][y].madeShot && (x+4 != 10) && !Board.player_board[x+4][y].hasBeenHit) {
                        row = x + 4;
                        column = y;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x + 1][y].missedShot && (x-1 != -1) && !Board.player_board[x-1][y].hasBeenHit) {
                        row = x - 1;
                        column = y;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x - 1][y].madeShot && (x-2 != -1) && !Board.player_board[x-2][y].hasBeenHit) {
                        row = x - 2;
                        column = y;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x - 2][y].madeShot && (x-3 != -1) && !Board.player_board[x-3][y].hasBeenHit) {
                        row = x - 3;
                        column = y;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x - 3][y].madeShot && (x-4 != -1) && !Board.player_board[x-4][y].hasBeenHit) {
                        row = x - 4;
                        column = y;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x - 1][y].missedShot && (y+1 != 10) && !Board.player_board[x][y+1].hasBeenHit ) {
                        row = x;
                        column = y + 1;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x][y + 1].madeShot && (y+2 != 10) && !Board.player_board[x][y+2].hasBeenHit) {
                        row = x;
                        column = y + 2;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x][y + 2].madeShot && (y+3 != 10) && !Board.player_board[x][y+3].hasBeenHit) {
                        row = x;
                        column = y + 3;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x][y + 3].madeShot && (y+4 != 10) && !Board.player_board[x][y+4].hasBeenHit) {
                        row = x;
                        column = y + 4;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x][y + 1].missedShot && (y-1 > -1) && !Board.player_board[x][y-1].hasBeenHit) {
                        row = x;
                        column = y - 1;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x][y - 1].madeShot && (y-2 > -1) && !Board.player_board[x][y-2].hasBeenHit) {
                        row = x;
                        column = y - 2;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x][y - 2].madeShot && (y-3 > -1) && !Board.player_board[x][y-3].hasBeenHit) {
                        row = x;
                        column = y - 3;
                    } else if (Board.player_board[x][y].madeShot && Board.player_board[x][y - 3].madeShot && (y-4 > -1) && !Board.player_board[x][y-4].hasBeenHit) {
                        row = x;
                        column = y - 4;
                    }
                }
            }

                if (Board.player_board[row][column].missedShot) {
                    row = (int) (Math.random() * (9));
                    column = (int) (Math.random() * (9));
                }

                if (Board.player_board[row][column].hasCarrier || Board.player_board[row][column].hasBattleship || Board.player_board[row][column].hasCruiser || Board.player_board[row][column].hasCruiser2 || Board.player_board[row][column].hasDestroyer) {
                    System.out.printf("AI has hit a ship! {%d,%d}  ", row, column);
                    Board.player_board[row][column].madeShot = true;
                    Board.player_board[row][column].empty = false;
                    Board.player_board[row][column].hasBeenHit = true;
                } else {
                    System.out.printf("AI missed! {%d,%d}  ", row, column);
                    Board.player_board[row][column].missedShot = true;
                    Board.player_board[row][column].empty = false;
                    Board.player_board[row][column].hasBeenHit = true;
                }

                String message = "You have sunk no ships";
                if (checkSunkBattleship2() || checkSunkCarrier2() || checkSunkCruiser1_2() || checkSunkCruiser2_2() || checkSunkDestroyer2()) {
                    message = "You have sunk the following ships: ";
                    if (checkSunkBattleship3()) {
                        message = message + "Battleship, ";
                        Main.player2_Ships_Sunk++;
                    }
                    if (checkSunkCarrier3()) {
                        message = message + "Carrier, ";
                        Main.player2_Ships_Sunk++;
                    }
                    if (checkSunkCruiser1_3()) {
                        message = message + "Cruiser1, ";
                        Main.player2_Ships_Sunk++;
                    }
                    if (checkSunkCruiser2_3()) {
                        message = message + "Cruiser2, ";
                        Main.player2_Ships_Sunk++;
                    }
                    if (checkSunkDestroyer3()) {
                        message = message + "Destroyer, ";
                        Main.player2_Ships_Sunk++;
                    }
                    message = message.substring(0, message.length() - 2);
                }

                System.out.println(message);

                reg_shooting();
            }
            while (Main.player2_Ships_Sunk != 5 || Main.player_Ships_Sunk != 5) ;
        }

        private static boolean checkSunkCarrier3() {
            for (int i = 0; i < 5; i++) {
                if (!Board.player_board[Battleship.carrier[i][0]][Battleship.carrier[i][1]].madeShot) {
                    return false;
                }
            }
            if (Battleship.carrier_FirstRow == Battleship.carrier_LastRow) {
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_FirstColumn + 1].hasBeenSunk = true;
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_FirstColumn +2].hasBeenSunk = true;
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_LastColumn -1].hasBeenSunk = true;
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_LastColumn].hasBeenSunk = true;
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_FirstColumn].madeShot = false;
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_FirstColumn + 1].madeShot = false;
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_FirstColumn +2].madeShot = false;
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_LastColumn -1].madeShot = false;
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_LastColumn].madeShot = false;
            } else {
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.carrier_FirstRow + 1][Battleship.carrier_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.carrier_FirstRow + 2][Battleship.carrier_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.carrier_LastRow - 1][Battleship.carrier_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.carrier_LastRow][Battleship.carrier_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.carrier_FirstRow][Battleship.carrier_FirstColumn].madeShot = false;
                Board.player_board[Battleship.carrier_FirstRow + 1][Battleship.carrier_FirstColumn].madeShot = false;
                Board.player_board[Battleship.carrier_FirstRow + 2][Battleship.carrier_FirstColumn].madeShot = false;
                Board.player_board[Battleship.carrier_LastRow - 1][Battleship.carrier_FirstColumn].madeShot = false;
                Board.player_board[Battleship.carrier_LastRow][Battleship.carrier_FirstColumn].madeShot = false;
            }
            return true;
        }

        private static boolean checkSunkBattleship3() {
            for (int i = 0; i < 4; i++) {
                if (!Board.player_board[Battleship.battleship[i][0]][Battleship.battleship[i][1]].madeShot) {
                    return false;
                }
            }
            if (Battleship.battleship_FirstRow == Battleship.battleship_LastRow) {
                Board.player_board[Battleship.battleship_FirstRow][Battleship.battleship_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.battleship_FirstRow][Battleship.battleship_FirstColumn + 1].hasBeenSunk = true;
                Board.player_board[Battleship.battleship_FirstRow][Battleship.battleship_LastColumn - 1].hasBeenSunk = true;
                Board.player_board[Battleship.battleship_FirstRow][Battleship.battleship_LastColumn].hasBeenSunk = true;
                Board.player_board[Battleship.battleship_FirstRow][Battleship.battleship_FirstColumn].madeShot = false;
                Board.player_board[Battleship.battleship_FirstRow][Battleship.battleship_FirstColumn + 1].madeShot = false;
                Board.player_board[Battleship.battleship_FirstRow][Battleship.battleship_LastColumn - 1].madeShot = false;
                Board.player_board[Battleship.battleship_FirstRow][Battleship.battleship_LastColumn].madeShot = false;
            } else {
                Board.player_board[Battleship.battleship_FirstRow][Battleship.battleship_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.battleship_FirstRow + 1][Battleship.battleship_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.battleship_LastRow - 1][Battleship.battleship_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.battleship_LastRow][Battleship.battleship_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.battleship_FirstRow][Battleship.battleship_FirstColumn].madeShot = false;
                Board.player_board[Battleship.battleship_FirstRow + 1][Battleship.battleship_FirstColumn].madeShot = false;
                Board.player_board[Battleship.battleship_LastRow - 1][Battleship.battleship_FirstColumn].madeShot = false;
                Board.player_board[Battleship.battleship_LastRow][Battleship.battleship_FirstColumn].madeShot = false;
            }
            return true;
        }

        private static boolean checkSunkCruiser1_3() {
            for (int i = 0; i < 3; i++) {
                if (!Board.player_board[Battleship.cruiser[i][0]][Battleship.cruiser[i][1]].madeShot) {
                    return false;
                }
            }

            if (Battleship.cruiser_FirstRow == Battleship.cruiser_LastRow) {
                Board.player_board[Battleship.cruiser_FirstRow][Battleship.cruiser_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser_FirstRow][Battleship.cruiser_FirstColumn +1].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser_FirstRow][Battleship.cruiser_LastColumn].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser_FirstRow][Battleship.cruiser_FirstColumn].madeShot = false;
                Board.player_board[Battleship.cruiser_FirstRow][Battleship.cruiser_FirstColumn +1].madeShot = false;
                Board.player_board[Battleship.cruiser_FirstRow][Battleship.cruiser_LastColumn].madeShot = false;
            } else {
                Board.player_board[Battleship.cruiser_FirstRow][Battleship.cruiser_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser_FirstRow + 1][Battleship.cruiser_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser_LastRow][Battleship.cruiser_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser_FirstRow][Battleship.cruiser_FirstColumn].madeShot = false;
                Board.player_board[Battleship.cruiser_FirstRow + 1][Battleship.cruiser_FirstColumn].madeShot = false;
                Board.player_board[Battleship.cruiser_LastRow][Battleship.cruiser_FirstColumn].madeShot = false;
            }

            return true;
        }

        private static boolean checkSunkCruiser2_3() {
            for (int i = 0; i < 3; i++) {
                if (!Board.player_board[Battleship.cruiser2[i][0]][Battleship.cruiser2[i][1]].madeShot) {
                    return false;
                }
            }

            if (Battleship.cruiser2_FirstRow == Battleship.cruiser2_LastRow) {
                Board.player_board[Battleship.cruiser2_FirstRow][Battleship.cruiser2_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser2_FirstRow][Battleship.cruiser2_FirstColumn +1].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser2_FirstRow][Battleship.cruiser2_LastColumn].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser2_FirstRow][Battleship.cruiser2_FirstColumn].madeShot = false;
                Board.player_board[Battleship.cruiser2_FirstRow][Battleship.cruiser2_FirstColumn +1].madeShot = false;
                Board.player_board[Battleship.cruiser2_FirstRow][Battleship.cruiser2_LastColumn].madeShot = false;
            } else {
                Board.player_board[Battleship.cruiser2_FirstRow][Battleship.cruiser2_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser2_FirstRow + 1][Battleship.cruiser2_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser2_LastRow][Battleship.cruiser2_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.cruiser2_FirstRow][Battleship.cruiser2_FirstColumn].madeShot = false;
                Board.player_board[Battleship.cruiser2_FirstRow + 1][Battleship.cruiser2_FirstColumn].madeShot = false;
                Board.player_board[Battleship.cruiser2_LastRow][Battleship.cruiser2_FirstColumn].madeShot = false;
            }

            return true;
        }

        private static boolean checkSunkDestroyer3() {
            for (int i = 0; i < 2; i++) {
                if (!Board.player_board[Battleship.destroyer[i][0]][Battleship.destroyer[i][1]].madeShot) {
                    return false;
                }
            }
            if (Battleship.destroyer_FirstRow == Battleship.destroyer_LastRow) {
                Board.player_board[Battleship.destroyer_FirstRow][Battleship.destroyer_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.destroyer_FirstRow][Battleship.destroyer_LastColumn].hasBeenSunk = true;
                Board.player_board[Battleship.destroyer_FirstRow][Battleship.destroyer_FirstColumn].madeShot = false;
                Board.player_board[Battleship.destroyer_FirstRow][Battleship.destroyer_LastColumn].madeShot = false;
            } else {
                Board.player_board[Battleship.destroyer_FirstRow][Battleship.destroyer_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.destroyer_LastRow][Battleship.destroyer_FirstColumn].hasBeenSunk = true;
                Board.player_board[Battleship.destroyer_FirstRow][Battleship.destroyer_FirstColumn].madeShot = false;
                Board.player_board[Battleship.destroyer_LastRow][Battleship.destroyer_FirstColumn].madeShot = false;
            }
            return true;
        }

    public static void reg_shooting() {
        Scanner input = new Scanner(System.in);
        do {
            Board.printOceanMap(false, Board.ai_board);

            System.out.print("Row: ");
            int row = input.nextInt();

            System.out.print("Column: ");
            int column = input.nextInt();

            if (Board.ai_board[row][column].hasCarrier || Board.ai_board[row][column].hasBattleship || Board.ai_board[row][column].hasCruiser || Board.ai_board[row][column].hasCruiser2 || Board.ai_board[row][column].hasDestroyer) {
                System.out.printf("You hit a ship! {%d,%d}", row, column);
                Board.ai_board[row][column].madeShot = true;
                Board.printOceanMap(false, Board.ai_board);
            } else if (Board.ai_board[row][column].empty) {
                System.out.printf("You missed! {%d,%d}", row, column);
                Board.ai_board[row][column].missedShot = true;
                Board.printOceanMap(false, Board.ai_board);
            }

            checkBoard_Player1();

            String message = "You have sunk no ships";
            if (checkSunkAI_Battleship() || checkSunkAI_Carrier() || checkSunkAI_Cruiser() || checkSunkAI_Cruiser2() || checkSunkAI_Destroyer()) {
                message = "You have sunk the following ships: ";
                if (checkSunkAI_Battleship()) {
                    message = message + "Battleship, ";
                    Main.player_Ships_Sunk++;
                }
                if (checkSunkAI_Carrier()) {
                    message = message + "Carrier, ";
                    Main.player_Ships_Sunk++;
                }
                if (checkSunkAI_Cruiser()) {
                    message = message + "Cruiser1, ";
                    Main.player_Ships_Sunk++;
                }
                if (checkSunkAI_Cruiser2()) {
                    message = message + "Cruiser2, ";
                    Main.player_Ships_Sunk++;
                }
                if (checkSunkAI_Destroyer()) {
                    message = message + "Destroyer, ";
                    Main.player_Ships_Sunk++;

                }
                message = message.substring(0, message.length() - 2);
            }
            System.out.println(message);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ai_shooting();
        } while (Main.player2_Ships_Sunk != 5 || Main.player_Ships_Sunk != 5);
    }

    private static boolean checkSunkAI_Carrier() {
        for (int i = 0; i < 5; i++) {
            if (!Board.ai_board[AI_Carrier.ai_carrier[i][0]][AI_Carrier.ai_carrier[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkAI_Battleship() {
        for (int i = 0; i < 4; i++) {
            if (!Board.ai_board[AI_Battleship.ai_battleship[i][0]][AI_Battleship.ai_battleship[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkAI_Cruiser() {
        for (int i = 0; i < 3; i++) {
            if (!Board.ai_board[AI_Cruiser.ai_Cruiser[i][0]][AI_Cruiser.ai_Cruiser[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkAI_Cruiser2() {
        for (int i = 0; i < 3; i++) {
            if (!Board.ai_board[AI_Cruiser2.ai_cruiser2[i][0]][AI_Cruiser2.ai_cruiser2[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSunkAI_Destroyer() {
        for (int i = 0; i < 2; i++) {
            if (!Board.ai_board[AI_Destroyer.ai_destroyer[i][0]][AI_Destroyer.ai_destroyer[i][1]].madeShot) {
                return false;
            }
        }
        return true;
    }

}


