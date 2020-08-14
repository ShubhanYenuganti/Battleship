import java.util.Arrays;

public class AI_Cruiser2 {

    static int ai_Cruiser2_FirstRow;
    static int ai_Cruiser2_LastRow;
    static int ai_Cruiser2_FirstColumn;
    static int ai_Cruiser2_LastColumn;

    static int[][] ai_cruiser2;
    static boolean isTrue;

    public static void ai_SetCruiser2() {

        do {
            ai_Cruiser2_FirstRow = (int) (Math.random() * (8));
            ai_Cruiser2_LastRow = ((int) (Math.random() * (9)) + 1);
            ai_Cruiser2_FirstColumn = (int) (Math.random() * (8));
            ai_Cruiser2_LastColumn = ((int) (Math.random() * (9)) + 1);

            if (ai_Cruiser2_FirstRow == ai_Cruiser2_LastRow) {
                if (!(Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn].hasCruiser || Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn + 1].hasCruiser || Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_LastColumn].hasCruiser) && (!(Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn].hasBattleship || Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn + 1].hasBattleship || Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_LastColumn].hasBattleship)) && (!(Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn].hasCarrier || Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn + 1].hasCarrier || Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_LastColumn].hasCarrier))) {
                    if (ai_Cruiser2_FirstColumn != ai_Cruiser2_LastColumn) {
                        if (((ai_Cruiser2_FirstColumn - ai_Cruiser2_LastColumn) == -2)) {
                                Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn].hasCruiser2 = true;
                                    Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn].empty = false;

                                Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn + 1].hasCruiser2 = true;
                                    Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn +1].empty = false;

                                Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_LastColumn].hasCruiser2 = true;
                                    Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_LastColumn].empty = false;
                            isTrue = true;
                        }
                    }
                }
            } else {
                if (ai_Cruiser2_FirstColumn == ai_Cruiser2_LastColumn) {
                    if (!(Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn].hasCarrier || Board.ai_board[ai_Cruiser2_FirstRow + 1][ai_Cruiser2_FirstColumn].hasCarrier || Board.ai_board[ai_Cruiser2_LastRow][ai_Cruiser2_FirstColumn].hasCarrier) && (!(Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn].hasBattleship || Board.ai_board[ai_Cruiser2_FirstRow + 1][ai_Cruiser2_FirstColumn].hasBattleship || Board.ai_board[ai_Cruiser2_LastRow][ai_Cruiser2_FirstColumn].hasBattleship)) && (!(Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn].hasCruiser || Board.ai_board[ai_Cruiser2_FirstRow + 1][ai_Cruiser2_FirstColumn].hasCruiser || Board.ai_board[ai_Cruiser2_LastRow][ai_Cruiser2_FirstColumn].hasCruiser))) {
                        if ((ai_Cruiser2_FirstRow - ai_Cruiser2_LastRow) == -2) {
                            Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn].hasCruiser2 = true;
                                Board.ai_board[ai_Cruiser2_FirstRow][ai_Cruiser2_FirstColumn].empty = false;

                            Board.ai_board[ai_Cruiser2_FirstRow + 1][ai_Cruiser2_FirstColumn].hasCruiser2 = true;
                                Board.ai_board[ai_Cruiser2_FirstRow +1][ai_Cruiser2_FirstColumn].empty = false;

                            Board.ai_board[ai_Cruiser2_LastRow][ai_Cruiser2_FirstColumn].hasCruiser2 = true;
                                Board.ai_board[ai_Cruiser2_LastRow][ai_Cruiser2_FirstColumn].empty = false;

                            isTrue = true;
                        }
                    }
                }
            }
        } while (!isTrue);

        if (ai_Cruiser2_FirstRow == ai_Cruiser2_LastRow) {
            ai_cruiser2 = new int[][]{
                    {ai_Cruiser2_FirstRow, ai_Cruiser2_FirstColumn},
                    {ai_Cruiser2_FirstRow, ai_Cruiser2_FirstColumn + 1},
                    {ai_Cruiser2_FirstRow, ai_Cruiser2_LastColumn}
            };
            System.out.println();
            System.out.print("AI's Cruiser #2:");
            System.out.print(Arrays.deepToString(ai_cruiser2));
        }

        if (ai_Cruiser2_FirstColumn == ai_Cruiser2_LastColumn) {
            ai_cruiser2 = new int[][]{
                    {ai_Cruiser2_FirstRow, ai_Cruiser2_FirstColumn},
                    {ai_Cruiser2_FirstRow + 1, ai_Cruiser2_FirstColumn},
                    {ai_Cruiser2_LastRow, ai_Cruiser2_FirstColumn}
            };
            System.out.println();
            System.out.print("AI's Cruiser #2:");
            System.out.print(Arrays.deepToString(ai_cruiser2));
        }
    }
}
