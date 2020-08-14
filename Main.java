import java.util.Scanner;

public class Main {

    static String response;
    static int player_Ships_Sunk = 0;
    static int ai_Ships_Sunk = 0;
    static int player2_Ships_Sunk = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Battleship by Shubhan Yenuganti");

        System.out.println("Play battleship: (1P/2P) : ");
        response = input.nextLine();

        if (response.equalsIgnoreCase("1P")) {
            Game();
        } else if (response.equalsIgnoreCase(("2P"))) {
            Game2();
        } else {
            System.out.print("Type in '1P' to play by yourself or '2P' to play with a friend");
        }
    }

    public static void Game() {
        do {
            Board.setBoard();
            Board.printOceanMap(true, Board.player_board);
            doBattleship();
            ai();
        }
        while (player_Ships_Sunk != 5 || ai_Ships_Sunk != 5);
    }

    public static void Game2() {
        do {
            Board.setBoard();
            Board.printOceanMap(true, Board.player_board);
            doBattleship();
            doBattleship2();
            shooting();
        } while (player_Ships_Sunk != 5 || player2_Ships_Sunk != 5);
    }

    public static void doBattleship() {
        Battleship.setCarrier();
        Battleship.setBattleship();
        Battleship.setCruiser();
        Battleship.setDestroyer();
        Battleship.setDestroyer();
    }

    public static void doBattleship2() {
        Board.setOpponentBoard();
        Board.printOceanMap(true, Board.player2_board);
        battleship_player2.player2_setCarrier();
        battleship_player2.player2_setBattleship();
        battleship_player2.player2_setCruiser();
        battleship_player2.player2_setCruiser2();
        battleship_player2.player2_setDestroyer();
    }

    public static void shooting() {
        Board.printOceanMap(false, Board.player2_board);
        shooting.player1_shooting();
    }

    public static void ai() {
        Board.setAi_board();
        AI_Carrier.ai_SetCarrier();
        AI_Battleship.ai_SetBattleship();
        AI_Cruiser.ai_SetCruiser();
        AI_Cruiser2.ai_SetCruiser2();
        AI_Destroyer.ai_SetDestroyer();
        Board.printOceanMap(false, Board.ai_board);
        shooting.reg_shooting();
    }

}
