/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.gui;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sudoku.controller.ViewController;

/**
 *
 * @author varungoel
 */
public class SudokuBoard { 
    ViewController viewController;
    
    VBox mainScene;
    VBox boardContainer;
    
    HBox levelSwitchesRow;
    Button easyButton;
    Button mediumButton;
    Button hardButton;
    Button solveButton;
    
    //All the rows of the grid
    HBox firstRow;
    HBox secondRow;
    HBox thirdRow;
    HBox fourthRow;
    HBox fifthRow;
    HBox sixthRow;
    HBox seventhRow;
    HBox eighthRow;
    HBox ninthRow;
    
    ArrayList<HBox> rows;
    ArrayList<Pane> cells;
    ArrayList<TextArea> textAreas;
    
    public void layoutGUI(){
        viewController = new ViewController();
        
        mainScene = new VBox(30);
        boardContainer = new VBox();
        
        levelSwitchesRow = new HBox(30);
        
        easyButton = new Button("Easy");
        mediumButton = new Button("Medium");
        hardButton = new Button("Hard");
        solveButton = new Button("Solve");
        
        levelSwitchesRow.getChildren().add(easyButton);
        levelSwitchesRow.getChildren().add(mediumButton);
        levelSwitchesRow.getChildren().add(hardButton);
        levelSwitchesRow.getChildren().add(solveButton);
        
        firstRow = new HBox();
        secondRow = new HBox();
        thirdRow = new HBox();
        fourthRow = new HBox();
        fifthRow = new HBox();
        sixthRow = new HBox();
        seventhRow = new HBox();
        eighthRow = new HBox();
        ninthRow = new HBox();
                 
        //all the rows in the grid
        rows = new ArrayList<>(Arrays.asList(firstRow, secondRow, thirdRow, fourthRow, fifthRow, sixthRow, seventhRow, eighthRow, ninthRow));
        
        //add all the rows to the board
        for(HBox row : rows){
            boardContainer.getChildren().add(row);
        }
        
        cells = new ArrayList<>();
        textAreas = new ArrayList<>();
        
        //set up all the rows of the grid
        for(int i = 0; i < 9; i++)
            makeRow(i);
        
        for (HBox row : rows){
            row.setMinSize(540, 60);
            row.setMaxSize(540, 60);
        }
        
        mainScene.getChildren().add(boardContainer);
        mainScene.getChildren().add(levelSwitchesRow);
        mainScene.setPadding(new Insets(80,20,20,100));
        
        viewController.attachEventHandlers(cells);
        viewController.attachTextEventHandlers(textAreas);
    }
    
    public void makeRow(int rowNumber){
        String cssString;
        
        int i;
        //make all the 9 cells in a row
        for(i = 0; i < 9; i++){
            
            StackPane cell = new StackPane();
            rows.get(rowNumber).getChildren().add(cell);
            //set the id of this cell (row+col)
            cell.setId(rowNumber + "" + i);
            cells.add(cell);
            cell.setMinSize(59, 59);
            cell.setMaxSize(59, 59);
            //Add the text area for the cell
            TextArea text = new TextArea();
            textAreas.add(text);
            text.setMinSize(59, 59);
            text.setMaxSize(59, 59);
            text.setFont(Font.font("Tahoma", FontWeight.BLACK, 28));
            text.setText("0");
            text.setDisable(true);
            cell.getChildren().add(text);
            
            if(rowNumber == 0){
               if((i + 1) % 3 == 0){
                   cssString = "-fx-border-color: black;\n"
                + "-fx-border-width: 2 4 2 2;\n" + "-fx-border-style: solid;\n";
               }
               else{
                 cssString = "-fx-border-color: black;\n"
                + "-fx-border-width: 2 2 2 2;\n" + "-fx-border-style: solid;\n";  
               }
            }
            else{
                if((rowNumber + 1) % 3 == 0 && (i + 1) % 3 == 0){
                    cssString = "-fx-border-color: black;\n"
                + "-fx-border-width: 0 4 4 2;\n" + "-fx-border-style: solid;\n";
                }
                
                else if((rowNumber + 1) % 3 == 0){
                    cssString = "-fx-border-color: black;\n"
                + "-fx-border-width: 0 2 4 2;\n" + "-fx-border-style: solid;\n";
                }
     
                else if((i + 1) % 3 == 0){
                    cssString = "-fx-border-color: black;\n"
                + "-fx-border-width: 0 4 2 2;\n" + "-fx-border-style: solid;\n";
                }
                
                else{
                    cssString = "-fx-border-color: black;\n"
                + "-fx-border-width: 0 2 2 2;\n" + "-fx-border-style: solid;\n";
                }
            }
            cell.setStyle(cssString);
        }
    }

    public ViewController getViewController() {
        return viewController;
    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

    public VBox getMainScene() {
        return mainScene;
    }

    public void setMainScene(VBox mainScene) {
        this.mainScene = mainScene;
    }

    public VBox getBoardContainer() {
        return boardContainer;
    }


    public HBox getFirstRow() {
        return firstRow;
    }

    public HBox getSecondRow() {
        return secondRow;
    }


    public HBox getThirdRow() {
        return thirdRow;
    }



    public HBox getFourthRow() {
        return fourthRow;
    }



    public HBox getFifthRow() {
        return fifthRow;
    }

 
    public HBox getSixthRow() {
        return sixthRow;
    }


    public HBox getSeventhRow() {
        return seventhRow;
    }



    public HBox getEighthRow() {
        return eighthRow;
    }



    public HBox getNinthRow() {
        return ninthRow;
    }

  

    public ArrayList<HBox> getRows() {
        return rows;
    }



    public ArrayList<Pane> getCells() {
        return cells;
    }

 

    public HBox getLevelSwitchesRow() {
        return levelSwitchesRow;
    }

  

    public Button getEasyButton() {
        return easyButton;
    }

    

    public Button getMediumButton() {
        return mediumButton;
    }

    

    public Button getHardButton() {
        return hardButton;
    }

    
    public Button getSolveButton() {
        return solveButton;
    }

  
    public ArrayList<TextArea> getTextAreas() {
        return textAreas;
    }

    
        
}
