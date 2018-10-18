//Violet Johnson and Hailey Hanson
//JavaChess for Assignment 3
//Last modified 2018-10-18

public class ChessLogic {
    
    private int rows;
    private int cols;
    
    //will probably have to be an array list of pieces
    //or maybe that will be seperate?
    private int[][] board;
    
    public ChessLogic(int r, int c){
        
        rows = r;
        cols = c;
        board = new int[rows][cols];
    }
    
    public int getRows(){
        return rows;
    }
    
    public int getCols(){
        return cols;
    }
    
}
