/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import org.json.simple.parser.ParseException;
import sudoku.file.FileManager;

/**
 *
 * @author varungoel
 */
public class ViewController {
    
    private static Random rand;
    private static FileManager fileManager;
    
    public void attachEventHandlers(ArrayList<Pane> cells){
        for(Pane cell : cells){
            cell.setOnMouseClicked(e ->{
                System.out.println(cell.getId());
            });
        }
    }
    
    public void attachTextEventHandlers(ArrayList<TextArea> textAreas){
        for(TextArea textArea : textAreas){
            textArea.textProperty().addListener((final ObservableValue<? extends String> observable, final String oldValue, final String newValue) -> {
                // if the length is greater than 1, it's an invalid input
                if(newValue.length() > 1)
                    textArea.setText(oldValue);
                //make sure that the user is actually providing a +ve number greater than 0 as an input
                if(newValue.length() > 0){
                    if(!Character.isDigit(newValue.charAt(0)) || newValue.charAt(0) == '0'){
                        textArea.setText("");
                    }
                } 
            });
        }
    }
    
    
    public void newEasyGrid(int[][] grid, ArrayList<TextArea> textAreas) throws IOException, ParseException{
        rand = new Random();
        int puzzleIndex = rand.nextInt(5) + 1;
        String fileName = "easy/" + puzzleIndex + ".json";
        fileManager = new FileManager();
        fileManager.parseGridFile(grid, fileName);
        
        int counter = 0;
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(grid[i][j] == 0){
                    textAreas.get(counter).setText("");
                    textAreas.get(counter).setDisable(false);
                }
                else{
                    textAreas.get(counter).setText(grid[i][j] + "");
                    textAreas.get(counter).setDisable(true);
                }
                System.out.print(grid[i][j] + " ");
                counter++;
            }
            System.out.println();
        }
    }
}
