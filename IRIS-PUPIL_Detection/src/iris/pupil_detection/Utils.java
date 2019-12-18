/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris.pupil_detection;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Aleksa
 */
public class Utils {
    
   private ArrayList<Point> kruznica;
   private int irisRadius;
   
    public Utils() {
   
        kruznica = new ArrayList<>();
    }
   
     public BufferedImage drawCircle(BufferedImage test, int r, int xx, int yy){
    
   int radius = r;
   Point p = new Point(xx, yy);
   BufferedImage s = test;
   final int KEY_WIDTH = test.getWidth();
   final int KEY_HEIGHT = test.getHeight();
   
   int xLoc = 0, yLoc = 0;
   
   for(double i = 0; i < radius * 8; i++){
       double theta = ((double)(2.0 * Math.PI) * i) / (double) (radius * 8);
   
   for(int y = 0; y < KEY_HEIGHT; y++){
   for(int x = 0; x < KEY_WIDTH; x++){
       
       xLoc = (int)Math.round(((double)p.getX() + (double)radius*Math.cos(theta)));
       yLoc = (int)Math.round(((double)p.getY() + (double)radius*Math.sin(theta)));
           
       s.setRGB(xLoc, yLoc, 255*256*256*256 + 0*256*256 + 200*256 + 0);
       
             }
        }
        
        kruznica.add(new Point(xLoc, yLoc));
     }
        return s;
    
    }

    public BufferedImage drawCirclees(BufferedImage bimg, Point cp, int i, Color c){
    
    Graphics2D g2 = bimg.createGraphics();
    g2.setColor(c);
    g2.drawOval((int)cp.getX()-i, (int)cp.getY()-i, i*2, i*2);
    
    return bimg;
    }

    public BufferedImage drawCross(BufferedImage image, Point cp){
        
        int xx = (int) cp.getX();
        int yy = (int) cp.getY();
        BufferedImage crossImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        Point cross[] = new Point[21];
        cross[0] = new Point(xx - 2, yy);
        cross[1] = new Point(xx - 1, yy);
        cross[2] = new Point(xx, yy);
        cross[3] = new Point(xx + 1, yy);
        cross[4] = new Point(xx + 2, yy);
        cross[5] = new Point(xx, yy - 2);
        cross[6] = new Point(xx, yy - 1);
        cross[7] = new Point(xx, yy + 1);
        cross[8] = new Point(xx, yy + 2);
        cross[9] = new Point(xx - 4, yy);
        cross[10] = new Point(xx + 4, yy);
        cross[11] = new Point(xx, yy - 4);
        cross[12] = new Point(xx, yy + 4);
        cross[13] = new Point(xx - 6, yy);
        cross[14] = new Point(xx - 8, yy);
        cross[15] = new Point(xx + 6, yy);
        cross[16] = new Point(xx + 8, yy);
        cross[17] = new Point(xx, yy - 6);
        cross[18] = new Point(xx, yy - 8);
        cross[19] = new Point(xx, yy + 6);
        cross[20] = new Point(xx, yy + 8); 
        
         for(int k = 0; k < cross.length; k++){
             for(int y = 0; y < image.getHeight(); y++){
                 for(int x = 0; x < image.getWidth(); x++){
                
                     if(y == (int)cross[k].getY() && x == (int)cross[k].getX()) {
                         image.setRGB((int)cross[k].getX(), (int)cross[k].getY(), 255 * 256*256*256 + 220 * 256*256 + 20 * 256 + 60);
                     }
                 }
             }
        }
        
        return image;
    }
    
    public Point[] getCircles(){
        Point circles[] = new Point[kruznica.size()];
        for(int k = 0; k < kruznica.size(); k++){
            circles[k] = kruznica.get(k);
        }
    
        return circles;
    }
    
  public BufferedImage drawJusteye(BufferedImage k){
      
      BufferedImage s = k;
      
      for(int y = 0; y < k.getHeight(); y++){
          for(int x = 0; x < k.getWidth(); x++){
              
              Point[] niz = getCircles();
              
              for(int i = 0; i < niz.length; i++){
                  
                  if(i <= (int)(niz.length / 4)){
                      if(x > niz[i].getX() && y > niz[i].getY()){
                          s.setRGB(x, y, 0 *256*256*256 + 255*256*256 + 255*256 + 255);
                      }
                  }else if(i >= (int)(niz.length / 4) && i <= (int)(niz.length / 2)){
                       if(x < niz[i].getX() && y > niz[i].getY()){
                          s.setRGB(x, y, 0 *256*256*256 + 255*256*256 + 255*256 + 255);
                      }
                  }else if(i >= (int)(niz.length / 2) && i <= (int)(niz.length  * 3 / 4)){
                       if(x < niz[i].getX() && y < niz[i].getY()){
                          s.setRGB(x, y, 0 *256*256*256 + 255*256*256 + 255*256 + 255);
                          }
                  }else if(i >= (int)(niz.length  * 3 / 4)){
                       if(x > niz[i].getX() && y < niz[i].getY()){
                          s.setRGB(x, y, 0 *256*256*256 + 255*256*256 + 255*256 + 255);
                          }
                  }
              
              
              }
          }
    }
      return s;
  }
    
}
