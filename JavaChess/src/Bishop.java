//Violet Johnson and Hailey Hanson
//JavaChess for Assignment 3
//Last modified 2018-10-21

import java.io.File;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author McNeese
 */
public class Bishop extends ChessPiece {
    
    public Bishop(int player){
        
        super(player);
        
        try{
            if(player == 0){
                super.chessImage = ImageIO.read(new File("black bishop.png"));
            }
            else if(player == 1){
                super.chessImage = ImageIO.read(new File("white bishop.png"));
            }
            
        }
        catch(Exception e){
            System.out.print("Error reading image files\n");
        }
    }
}
