/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.controller;

import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 *
 * @author varungoel
 */
public class ViewController {
    
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
                //make sure that the user is actually providing a number as an input
                if(newValue.length() > 0){
                    if(!Character.isDigit(newValue.charAt(0)))
                    textArea.setText("");
                } 
            });
        }
    }
    
}
