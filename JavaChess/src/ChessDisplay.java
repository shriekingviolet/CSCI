//Violet Johnson and Hailey Hanson
//JavaChess for Assignment 3
//Last modified 2018-10-21

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ChessDisplay extends JPanel{
    
    private int xStart = 150;
    private int yStart = 150;
    private int squareSize = 80;
    
    ChessLogic logic;
    
    Color[] colors = {Color.lightGray, Color.yellow};
    
    int clickedRow, clickedCol;
    
    
    private BufferedImage blackKing;
    
    public ChessDisplay(ChessLogic l){
        
        logic = l;
        
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                processClick(me);
            }
        });
        

    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        int x = 0;
        int y = yStart;
        int row = 0;
        int col = 0;
        ChessPiece squarePiece = new ChessPiece(1);
        
        for(row = 0; row < logic.getRows();row++){   
            x = xStart;
            
            for(col = 0; col < logic.getCols();col++){
                g.setColor(colors[(row+col)%2]);
                g.fillRect(x, y, squareSize, squareSize);
                
                    
                squarePiece = logic.checkForPiece(row, col);
                
                if(squarePiece.getImage() != null){
                    g.drawImage(squarePiece.getImage(), x, y, this);
                }
                
                x += squareSize;
            }
            y += squareSize;
        }
        
        
    }
    
    public void processClick(MouseEvent me){
            
        int clickedX = me.getX();
        int clickedY = me.getY();
        
        
        //outputs only for demo purposes
        if(clickedX < xStart || clickedY < yStart || clickedX > xStart + logic.getCols()*squareSize || clickedY > yStart + logic.getRows()*squareSize){
            System.err.print("Error: Click not on board\n\n");
        }
        else{
            clickedRow = (clickedY - yStart) / squareSize;
            clickedCol = (clickedX - xStart) / squareSize;
            System.out.print("You clicked on row: " + (clickedRow + 1) + " and col: " + (clickedCol + 1) + "\n\n");
            //logic.makeMove(clickedRow,clickedCol);
        }
            
        System.out.print("Mouse clicked at " + me.getX() + ", " + me.getY() + "\n");
            
        repaint();
    }
}
