import java.util.Arrays;

public class AI_Cruiser {

    static int ai_Cruiser_FirstRow;
    static int ai_Cruiser_LastRow;
    static int ai_Cruiser_FirstColumn;
    static int ai_Cruiser_LastColumn;

    static int[][] ai_Cruiser;
    static boolean isTrue;

    public static void ai_SetCruiser() {

        do {
            ai_Cruiser_FirstRow = (int) (Math.random() * (8));
            ai_Cruiser_LastRow = ((int) (Math.random() * (9)) + 1);
            ai_Cruiser_FirstColumn = (int) (Math.random() * (8));
            ai_Cruiser_LastColumn = ((int) (Math.random() * (9)) + 1);

            if (ai_Cruiser_FirstRow == ai_Cruiser_LastRow) {
                if (!(Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn].hasCruiser
                        || Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn + 1].hasCruiser
                        || Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_LastColumn].hasCruiser)
                        && (!(Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn].hasBattleship
                        || Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn + 1].hasBattleship
                        || Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_LastColumn].hasBattleship))
                        && (!(Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn].hasCarrier
                        || Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn + 1].hasCarrier
                        || Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_LastColumn].hasCarrier))) {
                    if (ai_Cruiser_FirstColumn != ai_Cruiser_LastColumn) {
                        if (((ai_Cruiser_FirstColumn - ai_Cruiser_LastColumn) == -2)) {
                            Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn].hasCruiser = true;
                            Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn].empty = false;

                            Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn + 1].hasCruiser = true;
                            Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn + 1].empty = false;

                            Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_LastColumn].hasCruiser = true;
                            Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_LastColumn].empty = false;
                            isTrue = true;
                        }
                    }
                }
            } else {
                if (ai_Cruiser_FirstColumn == ai_Cruiser_LastColumn) {
                    if (!(Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn].hasCarrier || Board.ai_board[ai_Cruiser_FirstRow + 1][ai_Cruiser_FirstColumn].hasCarrier || Board.ai_board[ai_Cruiser_LastRow][ai_Cruiser_FirstColumn].hasCarrier) && (!(Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn].hasBattleship || Board.ai_board[ai_Cruiser_FirstRow + 1][ai_Cruiser_FirstColumn].hasBattleship || Board.ai_board[ai_Cruiser_LastRow][ai_Cruiser_FirstColumn].hasBattleship)) && (!(Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn].hasCruiser || Board.ai_board[ai_Cruiser_FirstRow + 1][ai_Cruiser_FirstColumn].hasCruiser || Board.ai_board[ai_Cruiser_LastRow][ai_Cruiser_FirstColumn].hasCruiser))) {
                        if ((ai_Cruiser_FirstRow - ai_Cruiser_LastRow) == -2) {
                            Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn].hasCruiser = true;
                            Board.ai_board[ai_Cruiser_FirstRow][ai_Cruiser_FirstColumn].empty = false;

                            Board.ai_board[ai_Cruiser_FirstRow + 1][ai_Cruiser_FirstColumn].hasCruiser = true;
                            Board.ai_board[ai_Cruiser_FirstRow + 1][ai_Cruiser_FirstColumn].empty = false;

                            Board.ai_board[ai_Cruiser_LastRow][ai_Cruiser_FirstColumn].hasCruiser = true;
                            Board.ai_board[ai_Cruiser_LastRow][ai_Cruiser_FirstColumn].empty = false;

                            isTrue = true;
                        }
                    }
                }
            }
        } while (!isTrue);

        if (ai_Cruiser_FirstRow == ai_Cruiser_LastRow) {
            ai_Cruiser = new int[][]{
                    {ai_Cruiser_FirstRow, ai_Cruiser_FirstColumn},
                    {ai_Cruiser_FirstRow, ai_Cruiser_FirstColumn + 1},
                    {ai_Cruiser_FirstRow, ai_Cruiser_LastColumn}
            };
            System.out.println();
            System.out.print("AI's Cruiser #1:");
            System.out.print(Arrays.deepToString(ai_Cruiser));
        }

        if (ai_Cruiser_FirstColumn == ai_Cruiser_LastColumn) {
            ai_Cruiser = new int[][]{
                    {ai_Cruiser_FirstRow, ai_Cruiser_FirstColumn},
                    {ai_Cruiser_FirstRow + 1, ai_Cruiser_FirstColumn},
                    {ai_Cruiser_LastRow, ai_Cruiser_FirstColumn}
            };
            System.out.println();
            System.out.print("AI's Cruiser #1:");
            System.out.print(Arrays.deepToString(ai_Cruiser));
        }
    }
}
