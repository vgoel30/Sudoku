/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.controller;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import sudoku.file.FileManager;


/**
 *
 * @author varungoel
 */
public class Solver {
    final static int UNASSIGNED = 0;
    final static int N = 9;
    
    boolean solveSudoku(int[][] grid){
        //Get the array from the method
        int[] resultArray = findUnassignedLocation(grid);
        
        //if no unassigned box was found, the grid need not be solved. 
        if(resultArray[2] == 0)
            return true;
        
        //Get the row and columns from the result array
        int row = resultArray[0];
        int col = resultArray[1];
        
        int number;
        //Go through all the numbers and simulate the move
        for(number = 1; number <= N; number++){
            //check if this assignment is legal
            if(isLegal(grid, row, col, number)){
                //simulate the move
                grid[row][col] = number;
                //now check if there exists a solution for the given state 
                if(solveSudoku(grid))
                    return true;
                
                //if there lies no success from here, undo the move
                grid[row][col] = UNASSIGNED;
            }
        }
        return false;
    }
    
    /**
     * Will find a cell which is currently empty
     * @param grid is the current state of the sudoku grid
     * @return an int array of size 3 which will have the row and column number and a boolean value to indicate if an unassigned place was found
     */
    int[] findUnassignedLocation(int[][] grid){
        //Will fill this array with row, column, boolean value
        int[] toReturn = new int[3];
        
        int row, column = 0;
        
        for(row = 0; row < N; row++){
            for(column = 0; column < N; column++){
                if(grid[row][column] == UNASSIGNED){
                    toReturn[0] = row;
                    toReturn[1] = column;
                    toReturn[2] = 1;
                    return toReturn;
                }
            }
        }
        toReturn[0] = row;
        toReturn[1] = column;
        toReturn[2] = 0;
        return toReturn;
    }
    
    /**
     * Checks if a number exists in a particular row
     * @param grid is the sudoku grid
     * @param row is the row number
     * @param target is the number we are looking for
     * @return whether the number exists in the row or not
     */
    boolean usedInRow(int[][] grid, int row, int target){
        int column;
        for(column = 0; column < N; column++){
            if(grid[row][column] == target)
                return true;
        }
        return false;
    }
    
    /**
     * Checks if a  number exists in a particular column
     * @param grid is the sudoku grid
     * @param column is the column number
     * @param target is the number we seek
     * @return whether the number exists in the column or not
     */
    boolean usedInColumn(int[][] grid, int column, int target){
        int row;
        for(row = 0; row < N; row++){
            if(grid[row][column] == target)
                return true;
        }
        return false;
    }
    
    /**
     * Looks for the target element in a particular (3 * 3) subgrid
     * @param grid is the sudoku grid
     * @param startRow is the starting row of the sub grid
     * @param startColumn is the starting column of the sub grid
     * @param target is the element we seek
     * @return whether the number exists in the subgrid or not
     */
    boolean usedInSubGrid(int[][] grid, int startRow, int startColumn, int target){
        int row, column;
        
        for(row = 0; row < 3; row++){
            for(column = 0; column < 3; column++){
                if(grid[row + startRow][column + startColumn] == target)
                    return true;
            }
        }
        return false;
    }
    
    /**
     * Checks whether a number assignment move is legal
     * @param grid is the sudoku grid
     * @param row is the row number
     * @param column is the column number
     * @param number is the number that will be assigned to the cell
     * @return the legality of the move
     */
    boolean isLegal(int[][] grid, int row, int column, int number){
        return !usedInColumn(grid, column, number) && !usedInRow(grid, row, number) && !usedInSubGrid(grid, row - row%3, column - column%3, number);
    }
    
    static void printGrid(int[][] grid){
        for (int row = 0; row < N; row++){
            for (int column = 0; column < N; column++)
                System.out.print(grid[row][column] + " ");
        System.out.println();
        }
    }
    
//    public static void main(String[] args) throws IOException, ParseException{
//        FileManager fileManager = new FileManager();
//        
//        int[][] grid = new int[N][N];
//        fileManager.parseGridFile(grid, "hard/1.json");
//        
//        
//        Solver Solver = new Solver();
//        Solver.solveSudoku(grid);
//        printGrid(grid);
//    }
}
