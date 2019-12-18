/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris.pupil_detection;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Aleksa
 */



public class ViewImage {
    
      public ViewImage(BufferedImage img){
    
         JFrame f = new JFrame();
         f.setLocation(450, 350);
	    JLabel l = new JLabel();
            l.setLocation((int)f.getWidth()/2, (int)f.getHeight()/2);
	    l.setIcon(new ImageIcon(img));
	    f.getContentPane().add(l);
	    f.pack();
	    f.show();
    }
          
}
