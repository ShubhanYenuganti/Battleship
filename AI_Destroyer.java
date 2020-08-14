import java.util.Arrays;

public class AI_Destroyer {

    static int ai_Destroyer_FirstRow;
    static int ai_Destroyer_LastRow;
    static int ai_Destroyer_FirstColumn;
    static int ai_Destroyer_LastColumn;

    static int[][] ai_destroyer;
    static boolean isTrue;

    public static void ai_SetDestroyer() {

        do {
            ai_Destroyer_FirstRow = (int)(Math.random() * (8));
            ai_Destroyer_FirstColumn = ((int)(Math.random() * (9)) + 1);
            ai_Destroyer_LastRow = (int)(Math.random() * (8));
            ai_Destroyer_LastColumn = ((int)(Math.random() * (9)) + 1);

            if (ai_Destroyer_FirstRow == ai_Destroyer_LastRow) {
                if (!(Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].hasCarrier
                        || Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_LastColumn].hasCarrier)
                        && (!(Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].hasBattleship
                        || Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_LastColumn].hasBattleship))
                        && (!(Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].hasCruiser
                        || Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_LastColumn].hasCruiser))
                        && (!(Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].hasCruiser2
                        || Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_LastColumn].hasCruiser2))) {
                   if (ai_Destroyer_FirstColumn != ai_Destroyer_LastColumn) {
                       if (((ai_Destroyer_FirstColumn - ai_Destroyer_LastColumn) == -1)) {
                           Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].hasDestroyer = true;
                                Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].empty = false;

                           Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_LastColumn].hasDestroyer = true;
                                Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_LastColumn].empty = false;
                           isTrue = true;
                       }
                   }
                }
            } else {
                if (ai_Destroyer_FirstColumn == ai_Destroyer_LastColumn) {
                    if (!(Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].hasCarrier || Board.ai_board[ai_Destroyer_LastRow][ai_Destroyer_FirstColumn].hasCarrier) && (!(Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].hasBattleship || Board.ai_board[ai_Destroyer_LastRow][ai_Destroyer_FirstColumn].hasBattleship)) && (!(Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].hasCruiser || Board.ai_board[ai_Destroyer_LastRow][ai_Destroyer_FirstColumn].hasCruiser)) && (!(Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].hasCruiser2 || Board.ai_board[ai_Destroyer_LastRow][ai_Destroyer_FirstColumn].hasCruiser2))) {
                        if ((ai_Destroyer_FirstRow - ai_Destroyer_LastRow) == -1) {
                            Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].hasDestroyer = true;
                                Board.ai_board[ai_Destroyer_FirstRow][ai_Destroyer_FirstColumn].empty = false;

                            Board.ai_board[ai_Destroyer_LastRow][ai_Destroyer_FirstColumn].hasDestroyer = true;
                                Board.ai_board[ai_Destroyer_LastRow][ai_Destroyer_FirstColumn].empty = false;

                            isTrue = true;
                        }
                    }
                }
            }
        } while (!isTrue);

        if (ai_Destroyer_FirstRow == ai_Destroyer_LastRow) {
            ai_destroyer = new int[][] {
                    {ai_Destroyer_FirstRow, ai_Destroyer_FirstColumn},
                    {ai_Destroyer_FirstRow, ai_Destroyer_LastColumn}
            };
            System.out.println();
            System.out.print("AI's Destroyer:");
            System.out.print(Arrays.deepToString(ai_destroyer));
        }

        if (ai_Destroyer_FirstColumn == ai_Destroyer_LastColumn) {
            ai_destroyer = new int[][] {
                    {ai_Destroyer_FirstRow, ai_Destroyer_FirstColumn},
                    {ai_Destroyer_LastRow, ai_Destroyer_FirstColumn}
            };
            System.out.println();
            System.out.print("AI's Destroyer:");
            System.out.print(Arrays.deepToString(ai_destroyer));
        }
    }
}
