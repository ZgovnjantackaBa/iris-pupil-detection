/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris.pupil_detection;

import java.awt.image.BufferedImage;

/**
 *
 * @author Aleksa
 */
public class CompareImage {
    
    public static boolean isKnown(BufferedImage newUser, BufferedImage userFromDataBase){
        
        if(newUser.getWidth() != userFromDataBase.getWidth() || newUser.getHeight() != userFromDataBase.getHeight()){
            return false;
        }
        for(int y = 0; y < newUser.getHeight(); y++){
            for(int x = 0; x < newUser.getWidth(); x++){
                if(newUser.getRGB(x, y) != userFromDataBase.getRGB(x, y))
                    return false;
            }
        }
        
        return true;
    }
    
    
}
