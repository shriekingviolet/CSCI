//Violet Johnson and Hailey Hanson
//JavaChess for Assignment 3
//Last modified 2018-10-21

import java.io.File;
import javax.imageio.ImageIO;


public class Queen extends ChessPiece {
    
    public Queen(int player){
        
        super(player);
        
        try{
            if(player == 0){
                super.chessImage = ImageIO.read(new File("black queen.png"));
            }
            else if(player == 1){
                super.chessImage = ImageIO.read(new File("white queen.png"));
            }
            
        }
        catch(Exception e){
            System.out.print("Error reading image files\n");
        }
    } 
}
