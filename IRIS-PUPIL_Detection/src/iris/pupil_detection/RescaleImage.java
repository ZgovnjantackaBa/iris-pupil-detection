/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris.pupil_detection;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author Aleksa
 */
public class RescaleImage {
    
    public static BufferedImage scale(BufferedImage sbi) {
   
        int dWidth = 256,dHeight = 160;
        double fWidth = 1.0, fHeight = 1.0;
        BufferedImage dbi = null;
    if(sbi != null) {
        dbi = new BufferedImage(dWidth, dHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = dbi.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
        g.drawRenderedImage(sbi, at);
    }
    return dbi;
}
    
    
    
}
