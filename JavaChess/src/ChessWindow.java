//Violet Johnson and Hailey Hanson
//JavaChess for Assignment 3
//Last modified 2018-10-21

//Todo:
//Add mouselistner
//Create an array of piece objects
//Draw pieces with game board on launch
//Movement system

import javax.swing.*;

public class ChessWindow extends JFrame {
    
    private int windowWidth = 1000;
    private int windowHeight = 1000;
    ChessDisplay display;
    ChessLogic logic;
    private int boardRows = 8;
    private int boardHeight = 8;
    
    public ChessWindow(){
        
            this.setTitle("Java Chess");
	    this.setSize(windowWidth, windowHeight);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
            logic = new ChessLogic(boardRows, boardHeight);
            display = new ChessDisplay(logic);
            this.add(display);
            this.setVisible(true);
    }
    
    public static void main(String[] args){
        
        ChessWindow cw = new ChessWindow();
    }
    
}
