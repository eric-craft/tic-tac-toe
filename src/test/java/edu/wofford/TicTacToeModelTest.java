package edu.wofford;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TicTacToeModelTest {
   @Test
   public void testConstructor() {
       TicTacToeModel tic = new TicTacToeModel(); 
       assertThat(tic.getPlayerTurn(), is("X"));
       assertThat(tic.getGameBoardToString(), is("[[null, null, null], [null, null, null], [null, null, null]]"));
   }

   @Test
   public void testSetPlayer() {
       TicTacToeModel tic = new TicTacToeModel(); 
       tic.setPlayerTurn("O");
       assertThat(tic.getPlayerTurn(), is("O"));
   }

   @Test
   public void testGameBoard() {
       TicTacToeModel tic = new TicTacToeModel(); 
       String[][] testArr = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
       tic.setGameBoard(testArr);
       assertThat(tic.getGameBoardToString(), is("[[1, 2, 3], [4, 5, 6], [7, 8, 9]]"));
   }

   @Test
   public void testGetRowCol() {
       TicTacToeModel tic = new TicTacToeModel(); 
       String[][] testArr = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
       tic.setGameBoard(testArr);
       String[] rowRet = {"4", "5", "6"};
       String[] colRet = {"2", "5", "8"};
       assertThat(tic.getRow(1), is(rowRet));
       assertThat(tic.getCol(1), is(colRet));
   }

   @Test
   public void testPlayerMove() {
       TicTacToeModel tic = new TicTacToeModel(); 
       assertTrue(tic.playerMove(0, 1));
       assertThat(tic.getIndexValue(0,1), is("X"));

       tic.playerMove(0, 1);
       assertThat(tic.playerMove(0, 1), is(false));

       tic.setPlayerTurn("O");
       tic.playerMove(0, 2);
       assertThat(tic.getIndexValue(0,2), is("O"));

       tic.setResult("X wins");
       assertFalse(tic.playerMove(1, 1));
   }

   @Test
   public void testWinner() {
       // X first row
       TicTacToeModel tic = new TicTacToeModel(); 
       tic.playerMove(0, 1);
       tic.playerMove(2, 2);
       tic.playerMove(0, 2);
       tic.playerMove(1, 2);
       tic.playerMove(0, 0);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("X wins"));

       // X second row
       tic = new TicTacToeModel(); 
       tic.playerMove(1, 0);
       tic.playerMove(0, 1);
       tic.playerMove(1, 2);
       tic.playerMove(2, 1);
       tic.playerMove(2, 2);
       tic.playerMove(0, 2);
       tic.playerMove(1, 1);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("X wins"));

       // X third row
       tic = new TicTacToeModel(); 
       tic.playerMove(2, 0);
       tic.playerMove(0, 0);
       tic.playerMove(2, 1);
       tic.playerMove(1, 2);
       tic.playerMove(2, 2);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("X wins"));

       // O first row
       tic = new TicTacToeModel(); 
       tic.playerMove(1, 0);
       tic.playerMove(0, 0);
       tic.playerMove(1, 2);
       tic.playerMove(0, 1);
       tic.playerMove(2, 2);
       tic.playerMove(0, 2);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("O wins"));

       // O second row
       tic = new TicTacToeModel(); 
       tic.playerMove(0, 1);
       tic.playerMove(1, 2);
       tic.playerMove(0, 2);
       tic.playerMove(1, 0);
       tic.playerMove(2, 2);
       tic.playerMove(1, 1);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("O wins"));

       // O third row
       tic = new TicTacToeModel(); 
       tic.playerMove(1, 0);
       tic.playerMove(2, 0);
       tic.playerMove(1, 1);
       tic.playerMove(2, 1);
       tic.playerMove(0, 0);
       tic.playerMove(2, 2);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("O wins"));

       // X first col
       tic = new TicTacToeModel(); 
       tic.playerMove(0, 0);
       tic.playerMove(2, 2);
       tic.playerMove(1, 0);
       tic.playerMove(1, 1);
       tic.playerMove(2, 0);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("X wins"));

       // X second col
       tic = new TicTacToeModel(); 
       tic.playerMove(1, 1);
       tic.playerMove(1, 0);
       tic.playerMove(0, 1);
       tic.playerMove(2, 0);
       tic.playerMove(2, 1);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("X wins"));

       // X third col
       tic = new TicTacToeModel(); 
       tic.playerMove(0, 2);
       tic.playerMove(1, 1);
       tic.playerMove(1, 2);
       tic.playerMove(0, 0);
       tic.playerMove(2, 2);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("X wins"));

       // O first col
       tic = new TicTacToeModel(); 
       tic.playerMove(1, 1);
       tic.playerMove(0, 0);
       tic.playerMove(2, 1);
       tic.playerMove(1, 0);
       tic.playerMove(2, 2);
       tic.playerMove(2, 0);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("O wins"));

       // O second col
       tic = new TicTacToeModel(); 
       tic.playerMove(0, 0);
       tic.playerMove(0, 1);
       tic.playerMove(0, 2);
       tic.playerMove(1, 1);
       tic.playerMove(2, 0);
       tic.playerMove(2, 1);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("O wins"));

       // O third col
       tic = new TicTacToeModel(); 
       tic.playerMove(1, 0);
       tic.playerMove(0, 2);
       tic.playerMove(2, 1);
       tic.playerMove(2, 2);
       tic.playerMove(2, 0);
       tic.playerMove(1, 2);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("O wins"));

       // X diag left->right
       tic = new TicTacToeModel(); 
       tic.playerMove(0, 0);
       tic.playerMove(2, 0);
       tic.playerMove(1, 1);
       tic.playerMove(0, 2);
       tic.playerMove(2, 2);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("X wins"));

       // X diag right->left
       tic = new TicTacToeModel(); 
       tic.playerMove(0, 2);
       tic.playerMove(0, 0);
       tic.playerMove(1, 1);
       tic.playerMove(2, 1);
       tic.playerMove(2, 0);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("X wins"));

       // O diag left->right
       tic = new TicTacToeModel(); 
       tic.playerMove(0, 1);
       tic.playerMove(0, 0);
       tic.playerMove(2, 0);
       tic.playerMove(1, 1);
       tic.playerMove(1, 0);
       tic.playerMove(2, 2);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("O wins"));

       // O diag right->left
       tic = new TicTacToeModel(); 
       tic.playerMove(0, 0);
       tic.playerMove(2, 0);
       tic.playerMove(2, 1);
       tic.playerMove(0, 2);
       tic.playerMove(2, 2);
       tic.playerMove(1, 1);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("O wins"));

       // Tie
       tic = new TicTacToeModel();
       tic.playerMove(1, 1);
       tic.playerMove(0, 0);
       tic.playerMove(0, 2);
       tic.playerMove(2, 0);
       tic.playerMove(1, 0);
       tic.playerMove(1, 2);
       tic.playerMove(0, 1);
       tic.playerMove(2, 1);
       tic.playerMove(2, 2);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("Tie"));

       // X on last spot
       tic = new TicTacToeModel();
       tic.playerMove(1, 1);
       tic.playerMove(0, 0);
       tic.playerMove(0, 2);
       tic.playerMove(2, 0);
       tic.playerMove(1, 0);
       tic.playerMove(1, 2);
       tic.playerMove(0, 1);
       tic.playerMove(2, 2);
       tic.playerMove(2, 1);
       assertTrue(tic.isWinner());
       assertThat(tic.getResult(), is("X wins"));

       // null remaining + no winner
       tic = new TicTacToeModel();
       tic.playerMove(0, 1);
       assertFalse(tic.isWinner());
   }

   @Test 
   public void testPrintConsoleBoard() {
       TicTacToeModel tic = new TicTacToeModel();
       tic.playerMove(1, 1);
       tic.playerMove(0, 0);
       tic.playerMove(0, 2);
       tic.playerMove(2, 0);
       tic.playerMove(1, 0);
       tic.playerMove(1, 2);
       tic.playerMove(0, 1);
       tic.playerMove(2, 2);
       assertThat(tic.printConsoleBoard(), is("O|X|X\n-----\nX|X|O\n-----\nO| |O\n"));
   }
}