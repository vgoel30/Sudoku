/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;
import sudoku.gui.SudokuBoard;

/**
 *
 * @author varungoel
 */
public class GameController extends Application{
    static final int SIZE = 750;
    
    static SudokuBoard sudokuBoard;
    //the board's current state
    static int[][] userBoard;
    static ViewController viewController;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        getBoardReady();
        
        //when the one of the level button is clicked
        
        //easy
        sudokuBoard.getEasyButton().setOnAction(e -> {
            try {
                viewController.newGrid(GameController.userBoard, sudokuBoard.getTextAreas(), 0);
            } catch (IOException ex) {
                System.out.println("Invalid easy file");
            } catch (ParseException ex) {
                System.out.println("Invalid format in easy file");
            }
        });
        
        //medium
        sudokuBoard.getMediumButton().setOnAction(e -> {
            try {
                viewController.newGrid(GameController.userBoard, sudokuBoard.getTextAreas(), 1);
            } catch (IOException ex) {
                System.out.println("Invalid medium file");
            } catch (ParseException ex) {
                System.out.println("Invalid format in medium file");
            }
        });
        
        //hard
        sudokuBoard.getHardButton().setOnAction(e -> {
            try {
                viewController.newGrid(GameController.userBoard, sudokuBoard.getTextAreas(), 2);
            } catch (IOException ex) {
                System.out.println("Invalid hard file");
            } catch (ParseException ex) {
                System.out.println("Invalid format in hard file");
            }
        });

        Scene scene = new Scene(sudokuBoard.getMainScene(), SIZE, SIZE);
        primaryStage.setScene(scene);
        //fixed dimensions for the board 
        primaryStage.setMaxHeight(SIZE);
        primaryStage.setMaxWidth(SIZE);
        primaryStage.setMinHeight(SIZE);
        primaryStage.setMinWidth(SIZE);

        primaryStage.show();
    }
    
    public void getBoardReady(){
        userBoard = new int[9][9];
        viewController = new ViewController();
        sudokuBoard = new SudokuBoard();
        sudokuBoard.layoutGUI();
    }
    
}
