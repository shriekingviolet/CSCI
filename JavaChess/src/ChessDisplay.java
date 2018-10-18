//Violet Johnson and Hailey Hanson
//JavaChess for Assignment 3
//Last modified 2018-10-18

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessDisplay extends JPanel {
    
    private int xStart = 50;
    private int yStart = 50;
    private int squareSize = 50;
    
    ChessLogic logic;
    
    Color[] colors = {Color.black, Color.white};
    
    public ChessDisplay(ChessLogic l){
        
        logic = l;
    }
    
    public void paintComponents(Graphics g){
        
        super.paintComponents(g);
        
        int x = 0;
            int y = yStart;
            int row = 0;
            int col = 0;
        
            for(row = 0; row < logic.getRows();row++)
            {   
                x = xStart;
            
                for(col = 0; col < logic.getCols();col++)
                {
                    g.setColor(colors[(row+col)%2]);
                    g.fillRect(x, y, squareSize, squareSize);
                
                    //this bit is for tokens, will implement later?
                    /*if(logic.checkForToken(row, col)){
                        int tokenSize = (int)(squareSize*tokenScale);
                        int tokenIndent = (squareSize - tokenSize)/2;
                        g.setColor(tokenColor);
                        g.fillRect(x + tokenIndent, y + tokenIndent, tokenSize, tokenSize);
                    }*/
                    
                    x += squareSize;
                }
                y += squareSize;
            }
    }
    
}
