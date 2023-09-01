import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class LudoGame {
    static int player_number;
    static int sixCounter = 0;
    static boolean equalPosition = false;
    static String[][] square = new String[15][15];
    static String[][] border = new String[16][16];
    static String[] colorList = { "Green", "Blue", "Red", "Yellow" };
    static int[] endCounter = { 0, 0, 0, 0 };
    static ArrayList<Player> playerList = new ArrayList<Player>();

    //HOME POSITION FOR ALL TOKEN
    static int[][] greenHomePos = { { 2, 2 }, { 2, 3 }, { 3, 2 }, { 3, 3 } };
    static int[][] yellowHomePos = { { 2, 11 }, { 2, 12 }, { 3, 11 }, { 3, 12 } };
    static int[][] redHomePos = { { 11, 2 }, { 11, 3 }, { 12, 2 }, { 12, 3 } };
    static int[][] blueHomePos = { { 11, 11 }, { 11, 12 }, { 12, 11 }, { 12, 12 } };

    //SELECT TOKEN NAME
    static String[] greenToken = { "G1", "G2", "G3", "G4" };
    static String[] redToken = { "R1", "R2", "R3", "R4" };
    static String[] blueToken = { "B1", "B2", "B3", "B4" };
    static String[] yellowToken = { "Y1", "Y2", "Y3", "Y4" };

    //INITIALIZE TOKEN MOVEMENT PATH FOR ALL TOKEN
    static int[][] greenPath = { { 6, 1 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 },
            { 5, 6 }, { 4, 6 }, { 3, 6 }, { 2, 6 }, { 1, 6 }, { 0, 6 },
            { 0, 7 }, { 0, 8 }, { 1, 8 }, { 2, 8 }, { 3, 8 }, { 4, 8 }, { 5, 8 },
            { 6, 9 }, { 6, 10 }, { 6, 11 }, { 6, 12 }, { 6, 13 }, { 6, 14 },
            { 7, 14 }, { 8, 14 }, { 8, 13 }, { 8, 12 }, { 8, 11 }, { 8, 10 }, { 8, 9 },
            { 9, 8 }, { 10, 8 }, { 11, 8 }, { 12, 8 }, { 13, 8 }, { 14, 8 },
            { 14, 7 }, { 14, 6 }, { 13, 6 }, { 12, 6 }, { 11, 6 }, { 10, 6 }, { 9, 6 },
            { 8, 5 }, { 8, 4 }, { 8, 3 }, { 8, 2 }, { 8, 1 }, { 8, 0 },
            { 7, 0 }, { 7, 1 }, { 7, 2 }, { 7, 3 }, { 7, 4 }, { 7, 5 }, { 7, 6 } };

    static int[][] yellowPath = { { 1, 8 }, { 2, 8 }, { 3, 8 }, { 4, 8 }, { 5, 8 },
            { 6, 9 }, { 6, 10 }, { 6, 11 }, { 6, 12 }, { 6, 13 }, { 6, 14 },
            { 7, 14 }, { 8, 14 }, { 8, 13 }, { 8, 12 }, { 8, 11 }, { 8, 10 }, { 8, 9 },
            { 9, 8 }, { 10, 8 }, { 11, 8 }, { 12, 8 }, { 13, 8 }, { 14, 8 },
            { 14, 7 }, { 14, 6 }, { 13, 6 }, { 12, 6 }, { 11, 6 }, { 10, 6 }, { 9, 6 },
            { 8, 5 }, { 8, 4 }, { 8, 3 }, { 8, 2 }, { 8, 1 }, { 8, 0 },
            { 7, 0 }, { 6, 0 }, { 6, 1 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 },
            { 5, 6 }, { 4, 6 }, { 3, 6 }, { 2, 6 }, { 1, 6 }, { 0, 6 },
            { 0, 7 }, { 1, 7 }, { 2, 7 }, { 3, 7 }, { 4, 7 }, { 5, 7 }, { 6, 7 } };

    static int[][] redPath = { { 13, 6 }, { 12, 6 }, { 11, 6 }, { 10, 6 }, { 9, 6 },
            { 8, 5 }, { 8, 4 }, { 8, 3 }, { 8, 2 }, { 8, 1 }, { 8, 0 },
            { 7, 0 }, { 6, 0 }, { 6, 1 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 },
            { 5, 6 }, { 4, 6 }, { 3, 6 }, { 2, 6 }, { 1, 6 }, { 0, 6 },
            { 0, 7 }, { 0, 8 }, { 1, 8 }, { 2, 8 }, { 3, 8 }, { 4, 8 }, { 5, 8 },
            { 6, 9 }, { 6, 10 }, { 6, 11 }, { 6, 12 }, { 6, 13 }, { 6, 14 },
            { 7, 14 }, { 8, 14 }, { 8, 13 }, { 8, 12 }, { 8, 11 }, { 8, 10 }, { 8, 9 },
            { 9, 8 }, { 10, 8 }, { 11, 8 }, { 12, 8 }, { 13, 8 }, { 14, 8 },
            { 14, 7 }, { 13, 7 }, { 12, 7 }, { 11, 7 }, { 10, 7 }, { 9, 7 }, { 8, 7 } };

    static int[][] bluePath = { { 8, 13 }, { 8, 12 }, { 8, 11 }, { 8, 10 }, { 8, 9 },
            { 9, 8 }, { 10, 8 }, { 11, 8 }, { 12, 8 }, { 13, 8 }, { 14, 8 },
            { 14, 7 }, { 14, 6 }, { 13, 6 }, { 12, 6 }, { 11, 6 }, { 10, 6 }, { 9, 6 },
            { 8, 5 }, { 8, 4 }, { 8, 3 }, { 8, 2 }, { 8, 1 }, { 8, 0 },
            { 7, 0 }, { 6, 0 }, { 6, 1 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 },
            { 5, 6 }, { 4, 6 }, { 3, 6 }, { 2, 6 }, { 1, 6 }, { 0, 6 },
            { 0, 7 }, { 0, 8 }, { 1, 8 }, { 2, 8 }, { 3, 8 }, { 4, 8 }, { 5, 8 },
            { 6, 9 }, { 6, 10 }, { 6, 11 }, { 6, 12 }, { 6, 13 }, { 6, 14 },
            { 7, 14 }, { 7, 13 }, { 7, 12 }, { 7, 11 }, { 7, 10 }, { 7, 9 }, { 7, 8 } };

    public static void main(String[] args) {
        Scanner get_input = new Scanner(System.in);
        LudoBoard board = new LudoBoard(square, border);
        Random random = new Random();
        LudoGame myLudo = new LudoGame();

        System.out.print("How many player: ");
        player_number = get_input.nextInt();


        // INITIALIZING DATA TO TOKEN
        for (int i = 0; i < player_number; i++) {
            Player player = new Player();

            Token[] token_list = new Token[4];
            if (colorList[i] == "Green") {
                for (int j = 0; j < 4; j++) {
                    Token token = new Token();
                    token.token_name = greenToken[j];
                    token.X = greenHomePos[j][0];
                    token.Y = greenHomePos[j][1];
                    token_list[j] = token;
                }
            }

            if (colorList[i] == "Blue") {
                for (int j = 0; j < 4; j++) {
                    Token token = new Token();
                    token.token_name = blueToken[j];
                    token.X = blueHomePos[j][0];
                    token.Y = blueHomePos[j][1];
                    token_list[j] = token;
                }
            }

            if (colorList[i] == "Red") {
                for (int j = 0; j < 4; j++) {
                    Token token = new Token();
                    token.token_name = redToken[j];
                    token.X = redHomePos[j][0];
                    token.Y = redHomePos[j][1];
                    token_list[j] = token;
                }
            }

            if (colorList[i] == "Yellow") {
                for (int j = 0; j < 4; j++) {
                    Token token = new Token();
                    token.token_name = yellowToken[j];
                    token.X = yellowHomePos[j][0];
                    token.Y = yellowHomePos[j][1];
                    token_list[j] = token;
                }
            }

            player.player_name = colorList[i];
            player.token_list = token_list;

            playerList.add(player);
        }
        board.initializeHome(playerList, square);
        board.printBoard(border, square);

        Token token = new Token();
        boolean gameOver = true;
        while (gameOver) {

            for (int i = 0; i < player_number && gameOver; i++) {

                //FOR GIVING ANOTHER CHANCE FOR ROLLING DICE
                if (sixCounter > 0 || equalPosition) {
                    i--;
                    if (i == -1) {
                        i = player_number - 1;
                    }
                    equalPosition = false;
                }

                String choice;

                int randomNumber = random.nextInt(6) + 1;

                System.out.println("Player " + playerList.get(i).player_name + "'s Turn: " + randomNumber);

                if (randomNumber == 6) {

                    // SKIP FOR IMMEDIATE THIRD SIX
                    if (sixCounter == 2) {
                        sixCounter = 0;
                        continue;
                    }

                    while (true) {

                        //COMMAND FOR MOVING TOKEN IN HOME POSITION OR NOT
                        if (i == 0) {
                            System.out.print("Enter Your Choice (H1/H2/H3/H4 or G1/G2/G3/G4): ");
                        } else if (i == 1) {
                            System.out.print("Enter Your Choice (H1/H2/H3/H4 or B1/B2/B3/B4): ");
                        } else if (i == 2) {
                            System.out.print("Enter Your Choice (H1/H2/H3/H4 or R1/R2/R3/R4): ");
                        } else if (i == 3) {
                            System.out.print("Enter Your Choice (H1/H2/H3/H4 or Y1/Y2/Y3/Y4): ");
                        }
                        choice = get_input.next();
                        if (choice.length() == 2) {
                            if ((choice.charAt(0) == 'H' || ((i == 0 && choice.charAt(0) == 'G')
                                    || ((i == 1 && choice.charAt(0) == 'B') || (i == 2 && choice.charAt(0) == 'R')
                                            || (i == 3 && choice.charAt(0) == 'Y'))))
                                    &&
                                    (Character.getNumericValue(choice.charAt(1)) >= 1
                                            && Character.getNumericValue(choice.charAt(1)) <= 4)) {
                                break;
                            }
                        }
                    }

                    //WHEN DICE ROLLING FOR SIX AND CHANCE TO MOVE TOKEN FROM HOME
                    if (choice.charAt(0) == 'H') {

                        if ((playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                - 1].X == greenHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                        - 1].Y == greenHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                && playerList.get(i).player_name == "Green") {
                            token.takeFromHome(i, playerList, board, choice, greenPath, border, square);
                        } else if ((playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                - 1].X == yellowHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                        - 1].Y == yellowHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                && playerList.get(i).player_name == "Yellow") {
                            token.takeFromHome(i, playerList, board, choice, yellowPath, border, square);
                        } else if ((playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                - 1].X == blueHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                        - 1].Y == blueHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                && playerList.get(i).player_name == "Blue") {
                            token.takeFromHome(i, playerList, board, choice, bluePath, border, square);
                        } else if ((playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                - 1].X == redHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                        - 1].Y == redHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                && playerList.get(i).player_name == "Red") {
                            token.takeFromHome(i, playerList, board, choice, redPath, border, square);
                        }
                    } else if (((i == 0 && choice.charAt(0) == 'G') || ((i == 1 && choice.charAt(0) == 'B')
                            || (i == 2 && choice.charAt(0) == 'R') || (i == 3 && choice.charAt(0) == 'Y')))
                            && Character.getNumericValue(choice.charAt(1)) >= 1
                            && Character.getNumericValue(choice.charAt(1)) <= 4) {

                        // IF TOKEN IS NOT AT HOME, MOVE IT
                        if (!(playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                - 1].X == greenHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                        - 1].Y == greenHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                && playerList.get(i).player_name == "Green") {
                            token.moveToken(i, playerList, board, choice, greenPath, randomNumber, player_number,
                                    border, square, greenHomePos, blueHomePos, yellowHomePos, redHomePos, myLudo);
                        } else if (!(playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                - 1].X == yellowHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                        - 1].Y == yellowHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                && playerList.get(i).player_name == "Yellow") {
                            token.moveToken(i, playerList, board, choice, yellowPath, randomNumber, player_number,
                                    border, square, greenHomePos, blueHomePos, yellowHomePos, redHomePos, myLudo);
                        } else if (!(playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                - 1].X == blueHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                        - 1].Y == blueHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                && playerList.get(i).player_name == "Blue") {
                            token.moveToken(i, playerList, board, choice, bluePath, randomNumber, player_number, border,
                                    square, greenHomePos, blueHomePos, yellowHomePos, redHomePos, myLudo);
                        } else if (!(playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                - 1].X == redHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                        - 1].Y == redHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                && playerList.get(i).player_name == "Red") {
                            token.moveToken(i, playerList, board, choice, redPath, randomNumber, player_number, border,
                                    square, greenHomePos, blueHomePos, yellowHomePos, redHomePos, myLudo);
                        }
                    }

                    sixCounter++;

                } else {
                    sixCounter = 0;
                    boolean atleastOneOutOfHome = token.isOutOfHome(playerList, i, greenHomePos, redHomePos,
                            blueHomePos, yellowHomePos);

                    //WHEN ONE TOKEN AT LEAST OUT OF HOME, MOVE IT  
                    if (atleastOneOutOfHome) {
                        while (true) {
                            if (i == 0) {
                                System.out.print("Enter Your Choice(G1/G2/G3/G4): ");
                            } else if (i == 1) {
                                System.out.print("Enter Your Choice(B1/B2/B3/B4): ");
                            } else if (i == 2) {
                                System.out.print("Enter Your Choice(R1/R2/R3/R4): ");
                            } else if (i == 3) {
                                System.out.print("Enter Your Choice(Y1/Y2/Y3/Y4): ");
                            }

                            choice = get_input.next();
                            if (choice.length() == 2) {
                                if (((i == 0 && choice.charAt(0) == 'G') || ((i == 1 && choice.charAt(0) == 'B')
                                        || (i == 2 && choice.charAt(0) == 'R') || (i == 3 && choice.charAt(0) == 'Y')))
                                        && Character.getNumericValue(choice.charAt(1)) >= 1
                                        && Character.getNumericValue(choice.charAt(1)) <= 4) {
                                    break;
                                }
                            }
                        }
                        if (((i == 0 && choice.charAt(0) == 'G') || ((i == 1 && choice.charAt(0) == 'B')
                                || (i == 2 && choice.charAt(0) == 'R') || (i == 3 && choice.charAt(0) == 'Y')))
                                && Character.getNumericValue(choice.charAt(1)) >= 1
                                && Character.getNumericValue(choice.charAt(1)) <= 4) {
                            if (!(playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                    - 1].X == greenHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                    playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                            - 1].Y == greenHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                    && playerList.get(i).player_name == "Green") {
                                token.moveToken(i, playerList, board, choice, greenPath, randomNumber, player_number,
                                        border, square, greenHomePos, blueHomePos, yellowHomePos, redHomePos, myLudo);
                            } else if (!(playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                    - 1].X == yellowHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                    playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                            - 1].Y == yellowHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                    && playerList.get(i).player_name == "Yellow") {
                                token.moveToken(i, playerList, board, choice, yellowPath, randomNumber, player_number,
                                        border, square, greenHomePos, blueHomePos, yellowHomePos, redHomePos, myLudo);
                            } else if (!(playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                    - 1].X == blueHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                    playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                            - 1].Y == blueHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                    && playerList.get(i).player_name == "Blue") {
                                token.moveToken(i, playerList, board, choice, bluePath, randomNumber, player_number,
                                        border, square, greenHomePos, blueHomePos, yellowHomePos, redHomePos, myLudo);
                            } else if (!(playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                    - 1].X == redHomePos[Character.getNumericValue(choice.charAt(1)) - 1][0] &&
                                    playerList.get(i).token_list[Character.getNumericValue(choice.charAt(1))
                                            - 1].Y == redHomePos[Character.getNumericValue(choice.charAt(1)) - 1][1])
                                    && playerList.get(i).player_name == "Red") {
                                token.moveToken(i, playerList, board, choice, redPath, randomNumber, player_number,
                                        border, square, greenHomePos, blueHomePos, yellowHomePos, redHomePos, myLudo);
                            }
                        }
                    }

                }

                //TOKEN FOR LAST DESTINATION GOING ON 
                for (int l = 0; l < player_number; l++) {
                    for (int m = 0; m < 4; m++) {
                        if ((playerList.get(l).token_list[m].X == 7 && playerList.get(l).token_list[m].Y == 6) ||
                                (playerList.get(l).token_list[m].X == 7 && playerList.get(l).token_list[m].Y == 8) ||
                                (playerList.get(l).token_list[m].X == 6 && playerList.get(l).token_list[m].Y == 7) ||
                                (playerList.get(l).token_list[m].X == 8 && playerList.get(l).token_list[m].Y == 7)) {
                            endCounter[l]++;
                        }
                    }
                }

                for (int j = 0; j < player_number; j++) {
                    System.out.println((j + 1) + ". " + playerList.get(j).player_name + "\'s Destination Counter: "
                            + endCounter[j]);
                }

                System.out.print("Type \'n\' To Move Next: ");
                get_input.next();

                //UPDATE AND PRINT BOARD
                board.initializeHome(playerList, square);
                board.printBoard(border, square);

                for (int l = 0; l < player_number; l++) {
                    if (endCounter[l] == 4) {
                        System.out.println("Winner: " + playerList.get(l).player_name);
                        gameOver = false;
                        break;
                    }
                }

                //COUNTING LEADERBOARD FOR SELECTING WINNER
                endCounter[0] = 0;
                endCounter[1] = 0;
                endCounter[2] = 0;
                endCounter[3] = 0;

            }

        }
    }
}
