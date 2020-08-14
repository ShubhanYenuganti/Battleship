import java.util.Arrays;

public class AI_Carrier {

        static int ai_Carrier_FirstRow;
        static int ai_Carrier_LastRow;
        static int ai_Carrier_FirstColumn;
        static int ai_Carrier_LastColumn;

        static int[][] ai_Carrier;
        static boolean isTrue;

        public static void ai_SetCarrier() {

            do {
                ai_Carrier_FirstRow = (int) (Math.random() * (8));
                ai_Carrier_LastRow = ((int) (Math.random() * (9)) + 1);
                ai_Carrier_FirstColumn = (int) (Math.random() * (8));
                ai_Carrier_LastColumn = ((int) (Math.random() * (9)) + 1);

                if (ai_Carrier_FirstRow == ai_Carrier_LastRow) {
                    if (ai_Carrier_FirstColumn != ai_Carrier_LastColumn) {
                        if (((ai_Carrier_FirstColumn - ai_Carrier_LastColumn) == -4) || ((ai_Carrier_FirstColumn - ai_Carrier_LastColumn) == 4)) {
                            Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_FirstColumn].hasBattleship = true;
                            Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_FirstColumn].empty = false;

                            Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_FirstColumn + 1].hasBattleship = true;
                            Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_FirstColumn + 1].empty = false;

                            Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_FirstColumn + 2].hasBattleship = true;
                            Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_FirstColumn + 2].empty = false;

                            Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_LastColumn -1].hasBattleship = true;
                            Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_LastColumn -1].empty = false;

                            Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_LastColumn].hasBattleship = true;
                            Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_LastColumn].empty = false;
                            isTrue = true;
                        }
                    }
                } else {
                    if ((ai_Carrier_FirstRow - ai_Carrier_LastRow) == -4 || ((ai_Carrier_FirstRow - ai_Carrier_LastRow) == 4)) {
                        Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_FirstColumn].hasBattleship = true;
                        Board.ai_board[ai_Carrier_FirstRow][ai_Carrier_FirstColumn].empty = false;

                        Board.ai_board[ai_Carrier_FirstRow + 1][ai_Carrier_FirstColumn].hasBattleship = true;
                        Board.ai_board[ai_Carrier_FirstRow + 1][ai_Carrier_FirstColumn].empty = false;

                        Board.ai_board[ai_Carrier_FirstRow + 2][ai_Carrier_FirstColumn].hasBattleship = true;
                        Board.ai_board[ai_Carrier_FirstRow + 2][ai_Carrier_FirstColumn].empty = false;

                        Board.ai_board[ai_Carrier_LastRow -1][ai_Carrier_FirstColumn].hasBattleship = true;
                        Board.ai_board[ai_Carrier_LastRow -1][ai_Carrier_FirstColumn].empty = false;

                        Board.ai_board[ai_Carrier_LastRow][ai_Carrier_FirstColumn].hasBattleship = true;
                        Board.ai_board[ai_Carrier_LastRow][ai_Carrier_FirstColumn].empty = false;

                        isTrue = true;
                    }
                }
            } while (!isTrue);

            if (ai_Carrier_FirstRow == ai_Carrier_LastRow) {
                ai_Carrier = new int[][]{
                        {ai_Carrier_FirstRow, ai_Carrier_FirstColumn},
                        {ai_Carrier_FirstRow, ai_Carrier_FirstColumn + 1},
                        {ai_Carrier_FirstRow, ai_Carrier_FirstColumn +2},
                        {ai_Carrier_FirstRow, ai_Carrier_LastColumn - 1},
                        {ai_Carrier_FirstRow, ai_Carrier_LastColumn}
                };
                System.out.println();
                System.out.print("AI's Carrier :");
                System.out.print(Arrays.deepToString(ai_Carrier));
            }

            if (ai_Carrier_FirstColumn == ai_Carrier_LastColumn) {
                ai_Carrier = new int[][]{
                        {ai_Carrier_FirstRow, ai_Carrier_FirstColumn},
                        {ai_Carrier_FirstRow + 1, ai_Carrier_FirstColumn},
                        {ai_Carrier_FirstRow + 2, ai_Carrier_FirstColumn},
                        {ai_Carrier_LastRow - 1, ai_Carrier_FirstColumn},
                        {ai_Carrier_LastRow, ai_Carrier_FirstColumn}
                };
                System.out.println();
                System.out.print("AI's Carrier :");
                System.out.print(Arrays.deepToString(ai_Carrier));
            }
        }
    }
