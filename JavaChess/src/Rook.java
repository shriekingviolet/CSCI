//Violet Johnson and Hailey Hanson
//JavaChess for Assignment 3
//Last modified 2018-10-21

import java.io.File;
import javax.imageio.ImageIO;


public class Rook extends ChessPiece {
    
    public Rook(int player){
        
        super(player);
        
        try{
            if(player == 0){
                super.chessImage = ImageIO.read(new File("black rook.png"));
            }
            else if(player == 1){
                super.chessImage = ImageIO.read(new File("white rook.png"));
            }
            
        }
        catch(Exception e){
            System.out.print("Error reading image files\n");
        }
    }
}
