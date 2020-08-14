import java.util.Arrays;

public class AI_Battleship {

    static int ai_Battleship_FirstRow;
    static int ai_Battleship_LastRow;
    static int ai_Battleship_FirstColumn;
    static int ai_Battleship_LastColumn;

    static int[][] ai_Battleship;
    static boolean isTrue;

    public static void ai_SetBattleship() {

        do {
            ai_Battleship_FirstRow = (int) (Math.random() * (8));
            ai_Battleship_LastRow = ((int) (Math.random() * (9)) + 1);
            ai_Battleship_FirstColumn = (int) (Math.random() * (8));
            ai_Battleship_LastColumn = ((int) (Math.random() * (9)) + 1);

            if (ai_Battleship_FirstRow == ai_Battleship_LastRow) {
                if (!(Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_FirstColumn].hasCarrier
                        || Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_FirstColumn + 1].hasCarrier
                        || Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_LastColumn - 1].hasCarrier
                        || Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_LastColumn].hasCarrier)) {
                    if (ai_Battleship_FirstColumn != ai_Battleship_LastColumn) {
                        if (((ai_Battleship_FirstColumn - ai_Battleship_LastColumn) == -3) || ((ai_Battleship_FirstColumn - ai_Battleship_LastColumn) == 3)) {
                            Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_FirstColumn].hasBattleship = true;
                            Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_FirstColumn].empty = false;

                            Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_FirstColumn + 1].hasBattleship = true;
                            Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_FirstColumn + 1].empty = false;

                            Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_LastColumn -1].hasBattleship = true;
                            Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_LastColumn -1].empty = false;

                            Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_LastColumn].hasBattleship = true;
                            Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_LastColumn].empty = false;
                            isTrue = true;
                        }
                    }
                }
            } else {
                if (ai_Battleship_FirstColumn == ai_Battleship_LastColumn) {
                    if (!(Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_FirstColumn].hasCarrier
                            || Board.ai_board[ai_Battleship_FirstRow + 1][ai_Battleship_FirstColumn].hasCarrier
                            || Board.ai_board[ai_Battleship_LastRow -1][ai_Battleship_FirstColumn].hasCarrier
                            || Board.ai_board[ai_Battleship_LastRow][ai_Battleship_FirstColumn].hasCarrier)) {
                        if ((ai_Battleship_FirstRow - ai_Battleship_LastRow) == -3 || ((ai_Battleship_FirstRow - ai_Battleship_LastRow) == 3)) {
                            Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_FirstColumn].hasBattleship = true;
                            Board.ai_board[ai_Battleship_FirstRow][ai_Battleship_FirstColumn].empty = false;

                            Board.ai_board[ai_Battleship_FirstRow + 1][ai_Battleship_FirstColumn].hasBattleship = true;
                            Board.ai_board[ai_Battleship_FirstRow + 1][ai_Battleship_FirstColumn].empty = false;

                            Board.ai_board[ai_Battleship_LastRow -1][ai_Battleship_FirstColumn].hasBattleship = true;
                            Board.ai_board[ai_Battleship_LastRow -1][ai_Battleship_FirstColumn].empty = false;

                            Board.ai_board[ai_Battleship_LastRow][ai_Battleship_FirstColumn].hasBattleship = true;
                            Board.ai_board[ai_Battleship_LastRow][ai_Battleship_FirstColumn].empty = false;

                            isTrue = true;
                        }
                    }
                }
            }
        } while (!isTrue);

        if (ai_Battleship_FirstRow == ai_Battleship_LastRow) {
            ai_Battleship = new int[][]{
                    {ai_Battleship_FirstRow, ai_Battleship_FirstColumn},
                    {ai_Battleship_FirstRow, ai_Battleship_FirstColumn + 1},
                    {ai_Battleship_FirstRow, ai_Battleship_LastColumn - 1},
                    {ai_Battleship_FirstRow, ai_Battleship_LastColumn}
            };
            System.out.println();
            System.out.print("AI's Battleship :");
            System.out.print(Arrays.deepToString(ai_Battleship));
        }

        if (ai_Battleship_FirstColumn == ai_Battleship_LastColumn) {
            ai_Battleship = new int[][]{
                    {ai_Battleship_FirstRow, ai_Battleship_FirstColumn},
                    {ai_Battleship_FirstRow + 1, ai_Battleship_FirstColumn},
                    {ai_Battleship_LastRow - 1, ai_Battleship_FirstColumn},
                    {ai_Battleship_LastRow, ai_Battleship_FirstColumn}
            };
            System.out.println();
            System.out.print("AI's Battleship :");
            System.out.print(Arrays.deepToString(ai_Battleship));
        }
    }
}
