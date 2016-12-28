/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.gui;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sudoku.controller.ViewController;

/**
 *
 * @author varungoel
 */
public class SudokuBoard { 
    ViewController viewController;
    
    VBox mainScene;
    VBox boardContainer; 
    
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
    
    public void layoutGUI(){
        viewController = new ViewController();
        
        mainScene = new VBox();
        boardContainer = new VBox();
        
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
        
        //set up all the rows of the grid
        for(int i = 0; i < 9; i++)
            makeRow(i);
        
        for (HBox row : rows) {
            row.setMinSize(540, 60);
            row.setMaxSize(540, 60);
        }
        
        mainScene.getChildren().add(boardContainer);
        mainScene.setPadding(new Insets(80,20,20,100));
    }
    
    public void makeRow(int rowNumber){
        String cssString;
        
        int i;
        //make all the 9 cells in a row
        for(i = 0; i < 9; i++){
            
            AnchorPane cell = new AnchorPane();
            rows.get(rowNumber).getChildren().add(cell);
            //set the id of this cell (row+col)
            cell.setId(rowNumber + "" + i);
            cells.add(cell);
            cell.setMinSize(60, 60);
            cell.setMaxSize(60, 60);
            
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

    public void setBoardContainer(VBox boardContainer) {
        this.boardContainer = boardContainer;
    }

    public HBox getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(HBox firstRow) {
        this.firstRow = firstRow;
    }

    public HBox getSecondRow() {
        return secondRow;
    }

    public void setSecondRow(HBox secondRow) {
        this.secondRow = secondRow;
    }

    public HBox getThirdRow() {
        return thirdRow;
    }

    public void setThirdRow(HBox thirdRow) {
        this.thirdRow = thirdRow;
    }

    public HBox getFourthRow() {
        return fourthRow;
    }

    public void setFourthRow(HBox fourthRow) {
        this.fourthRow = fourthRow;
    }

    public HBox getFifthRow() {
        return fifthRow;
    }

    public void setFifthRow(HBox fifthRow) {
        this.fifthRow = fifthRow;
    }

    public HBox getSixthRow() {
        return sixthRow;
    }

    public void setSixthRow(HBox sixthRow) {
        this.sixthRow = sixthRow;
    }

    public HBox getSeventhRow() {
        return seventhRow;
    }

    public void setSeventhRow(HBox seventhRow) {
        this.seventhRow = seventhRow;
    }

    public HBox getEighthRow() {
        return eighthRow;
    }

    public void setEighthRow(HBox eighthRow) {
        this.eighthRow = eighthRow;
    }

    public HBox getNinthRow() {
        return ninthRow;
    }

    public void setNinthRow(HBox ninthRow) {
        this.ninthRow = ninthRow;
    }

    public ArrayList<HBox> getRows() {
        return rows;
    }

    public void setRows(ArrayList<HBox> rows) {
        this.rows = rows;
    }

    public ArrayList<Pane> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Pane> cells) {
        this.cells = cells;
    }
    
    
}
