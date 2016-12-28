/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sudoku.gui.SudokuBoard;

/**
 *
 * @author varungoel
 */
public class GameController extends Application{
    
    static SudokuBoard sudokuBoard;
    static int[][] board;
    static ViewController viewController;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        getBoardReady();

        Scene scene = new Scene(sudokuBoard.getMainScene(), 700, 700);
        primaryStage.setScene(scene);
        //fixed dimensions for the board (650 * 650)
        primaryStage.setMaxHeight(700);
        primaryStage.setMaxWidth(700);
        primaryStage.setMinHeight(700);
        primaryStage.setMinWidth(700);

        primaryStage.show();
    }
    
    public void getBoardReady(){
        board = new int[9][9];
        viewController = new ViewController();
        sudokuBoard = new SudokuBoard();
        sudokuBoard.layoutGUI();
    }
    
}
