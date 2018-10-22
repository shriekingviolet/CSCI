//Violet Johnson and Hailey Hanson
//JavaChess for Assignment 3
//Last modified 2018-10-21

import java.io.File;
import javax.imageio.ImageIO;


public class Knight extends ChessPiece {
    
    public Knight(int player){
        
        super(player);
        
        try{
            if(player == 0){
                super.chessImage = ImageIO.read(new File("black knight.png"));
            }
            else if(player == 1){
                super.chessImage = ImageIO.read(new File("white knight.png"));
            }
            
        }
        catch(Exception e){
            System.out.print("Error reading image files\n");
        }
    }
}
