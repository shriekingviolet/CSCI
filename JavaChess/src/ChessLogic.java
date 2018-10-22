//Violet Johnson and Hailey Hanson
//JavaChess for Assignment 3
//Last modified 2018-10-21

import java.util.*;

public class ChessLogic {
    
    private int rows;
    private int cols;
    
    private ChessPiece[][] board;
    
    public ChessLogic(int r, int c){
        
        rows = r;
        cols = c;
        board = new ChessPiece[rows][cols];
        
        board[0][0] = new Rook(0);
        board[0][1] = new Knight(0);
        board[0][2] = new Bishop(0);
        board[0][3] = new Queen(0);
        board[0][4] = new King(0);
        board[0][5] = new Bishop(0);
        board[0][6] = new Knight(0);
        board[0][7] = new Rook(0);
        
        board[1][0] = new Pawn(0);
        board[1][1] = new Pawn(0);
        board[1][2] = new Pawn(0);
        board[1][3] = new Pawn(0);
        board[1][4] = new Pawn(0);
        board[1][5] = new Pawn(0);
        board[1][6] = new Pawn(0);
        board[1][7] = new Pawn(0);
        
        board[6][0] = new Pawn(1);
        board[6][1] = new Pawn(1);
        board[6][2] = new Pawn(1);
        board[6][3] = new Pawn(1);
        board[6][4] = new Pawn(1);
        board[6][5] = new Pawn(1);
        board[6][6] = new Pawn(1);
        board[6][7] = new Pawn(1);
        
        board[7][0] = new Rook(1);
        board[7][1] = new Knight(1);
        board[7][2] = new Bishop(1);
        board[7][3] = new Queen(1);
        board[7][4] = new King(1);
        board[7][5] = new Bishop(1);
        board[7][6] = new Knight(1);
        board[7][7] = new Rook(1);
    }
    
    public ChessPiece checkForPiece(int row, int col){
        if(board[row][col] != null){
            return board[row][col];
        }
        else{
            return new EmptyPiece(0);
        }
    }
    
    public int getRows(){
        return rows;
    }
    
    public int getCols(){
        return cols;
    }
    
}
