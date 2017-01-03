/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.file;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author varungoel
 */
public class FileManager {
    
    /**
     * Method to read the JSON file that has the sudoku grid
     * @param grid is the 2D array that will be filled from the file
     * @param fileName is the JSON file's name
     * @throws IOException
     * @throws ParseException 
     */
    public void parseGridFile(int[][] grid, String fileName) throws IOException, ParseException{
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray)parser.parse(new FileReader(fileName));
        
        //These will be used to fill the grid
        int column = 0;
        int row = 0;
        
        //Go thorugh all the cell 'objects' in the json file
        for(Object jsonObject: jsonArray){
            String jsonString = (String)jsonObject;
            
            //check if it is an empty cell
            if(!jsonString.contains("null")){
                //Get the value of the cell
                int value = jsonString.split(",")[2].charAt(11);
                //get the integer value from the ascii character
                value -= 48;
                //Assign the value to that cell
                grid[row][column] = value;
            }
            else{
                grid[row][column] = 0;
            }
            
            //once a full row has been filled (all 9 columns), go to the next row 
            if(++column == 9){
                column = 0;
                row++;
            }
        }
        
        
    }
}
