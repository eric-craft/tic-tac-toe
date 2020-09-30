package edu.wofford;

import java.util.*;


public class TicTacToeModel {

    // keeps up with player turn (X, O, None)
    private String playerTurn;

    private String[][] gameBoard;

    private String result;


    // Constructor
    public TicTacToeModel() {
        playerTurn = "X";
        gameBoard = new String[3][3];      
        //gameBoard = {{0,0,0}, {0,0,0}, {0,0,0}};  
    }


    // Methods:
    public String getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(String playerTurn) {
        this.playerTurn = playerTurn;
    }

    /*public String[][] getGameBoard() {
        return gameBoard;
    }*/

    public void setGameBoard(String[][] board) {
        gameBoard = board;
    }

    public String getGameBoardToString() {
        String[] result = new String[3];
        String row1 = Arrays.toString(gameBoard[0]);
        String row2 = Arrays.toString(gameBoard[1]);
        String row3 = Arrays.toString(gameBoard[2]);;
        result[0] = row1;
        result[1] = row2;
        result[2] = row3;
        return Arrays.toString(result);
    }

    public String[] getRow(int row) {
        return gameBoard[row];
    }

    public String[] getCol(int col) {
        String[] colVal = new String[3];
        for (int i = 0; i < gameBoard.length; i++) {
            colVal[i] = gameBoard[i][col];
        }
        return colVal;
    }



    public boolean playerMove(int row, int col) {
        // check to make sure row/col are valid and that spot isn't taken
        if (result == null) {
            if (gameBoard[row][col] == null) {
                gameBoard[row][col] = playerTurn;
                if (playerTurn == "X") {
                    playerTurn = "O";
                } else {
                    playerTurn = "X";
                }
            } else {
                return false;
            }
        } else {
            return false;
        }   
        return true;
    }

    public String getIndexValue(int row, int col) {
        return gameBoard[row][col];
    }

    public boolean isWinner() {
        if (gameBoard[0][0] == "X" && gameBoard[1][1] == "X" && gameBoard[2][2] == "X") {
            result = "X wins";
            return true;
        } else if (gameBoard[0][2] == "X" && gameBoard[1][1] == "X" && gameBoard[2][0] == "X") {
            result = "X wins";
            return true;
        } else if (gameBoard[0][0] == "O" && gameBoard[1][1] == "O" && gameBoard[2][2] == "O") {
            result = "O wins";
            return true;
        } else if (gameBoard[0][2] == "O" && gameBoard[1][1] == "O" && gameBoard[2][0] == "O") {
            result = "O wins";
            return true;
        } else if (gameBoard[0][0] == "X" && gameBoard[0][1] == "X" && gameBoard[0][2] == "X") {
            result = "X wins";
            return true;
        } else if (gameBoard[1][0] == "X" && gameBoard[1][1] == "X" && gameBoard[1][2] == "X") {
            result = "X wins";
            return true;
        } else if (gameBoard[2][0] == "X" && gameBoard[2][1] == "X" && gameBoard[2][2] == "X") {
            result = "X wins";
            return true;
        } else if (gameBoard[0][0] == "O" && gameBoard[0][1] == "O" && gameBoard[0][2] == "O") {
            result = "O wins";
            return true;
        } else if (gameBoard[1][0] == "O" && gameBoard[1][1] == "O" && gameBoard[1][2] == "O") {
            result = "O wins";
            return true;
        } else if (gameBoard[2][0] == "O" && gameBoard[2][1] == "O" && gameBoard[2][2] == "O") {
            result = "O wins";
            return true;
        } else if (gameBoard[0][0] == "X" && gameBoard[1][0] == "X" && gameBoard[2][0] == "X") {
            result = "X wins";
            return true;
        } else if (gameBoard[0][1] == "X" && gameBoard[1][1] == "X" && gameBoard[2][1] == "X") {
            result = "X wins";
            return true;
        } else if (gameBoard[0][2] == "X" && gameBoard[1][2] == "X" && gameBoard[2][2] == "X") {
            result = "X wins";
            return true;
        } else if (gameBoard[0][0] == "O" && gameBoard[1][0] == "O" && gameBoard[2][0] == "O") {
            result = "O wins";
            return true;
        } else if (gameBoard[0][1] == "O" && gameBoard[1][1] == "O" && gameBoard[2][1] == "O") {
            result = "O wins";
            return true;
        } else if (gameBoard[0][2] == "O" && gameBoard[1][2] == "O" && gameBoard[2][2] == "O") {
            result = "O wins";
            return true;
        } else if (gameBoard[0][0] != null && gameBoard[0][1] != null && gameBoard[0][2] != null && gameBoard[1][0] != null && gameBoard[1][1] != null && gameBoard[1][2] != null && gameBoard[2][0] != null && gameBoard[2][1] != null && gameBoard[2][2] != null) {
            result = "Tie";
            return true;
        } else {
          return false;
        }
    }

    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }

    public String printConsoleBoard() {
        String[][] gameBoardStr = new String[3][3];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == null) {
                    gameBoardStr[i][j] = " ";
                } else {
                    gameBoardStr[i][j] = gameBoard[i][j];
                }
            }
        }
        String res = gameBoardStr[0][0] + "|" + gameBoardStr[0][1] + "|" + gameBoardStr[0][2] + "\n" + "-----" + "\n" + gameBoardStr[1][0] + "|" + gameBoardStr[1][1] + "|" + gameBoardStr[1][2] + "\n" + "-----" + "\n" + gameBoardStr[2][0] + "|" + gameBoardStr[2][1] + "|" + gameBoardStr[2][2] + "\n";
        return res;
    }

}