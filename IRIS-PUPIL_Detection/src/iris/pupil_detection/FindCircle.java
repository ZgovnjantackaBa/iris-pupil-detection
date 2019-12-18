/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris.pupil_detection;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author Aleksa
 */
public class FindCircle {

    private Point irisCP;
    private int irisRadius;
    private Point pupilCP;
    private int pupilRadius;
    private BufferedImage htIrisImage;
    private BufferedImage htPupilImage;
    private int width;
    private int height;
    private ArrayList<Integer> irisList;
    private HashMap<Integer, Point> irisMap;
    private ArrayList<Point> pupilList;
    private HashMap<Point, Integer> pupilMap;
    
    public FindCircle(BufferedImage htIrisImage, BufferedImage htPupilImage){
        this.htIrisImage = htIrisImage;
        this.htPupilImage = htPupilImage;
        width = htIrisImage.getWidth();
        height = htIrisImage.getHeight();
        irisList = new ArrayList<>();
        irisMap = new HashMap<>();
        pupilList = new ArrayList<>();
        pupilMap = new HashMap<>();
                
    }
    
    public void iris(){
        
        for(int radius = 8; radius < 75; radius++){
            for(int y = radius + 2; y < height - radius - 2; y++){
                for(int x = radius + 2; x < width - radius - 2; x++){
                   if(isIris(radius, x, y)){
                   //    System.out.println("xCoor: " + x + "\tyCoor: " + y + "\tradius: " + radius);
                       irisList.add(radius);
                       irisMap.put(radius, new Point(x, y));
                   }
                     
                }
            }
        }    
    }
    
    private boolean irisColor(int pixel){
        
        Color c = new Color(pixel);
        
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
    
        if(red < 120 && green < 120 && blue < 120){
            return false;
        }
        
        return true;
    }
    
    private boolean isIris(int radius, int x, int y){
        
        for(int i = 0; i < 8 * radius; i++){
            
            double theta = ((double)(Math.PI) * i)/(double) (8 * radius);
                      
            int  xLoc = (int)Math.round(x + (double)radius * Math.cos(theta));
            int  yLoc = (int)Math.round(y + (double)radius*Math.sin(theta));
                        
                if(!irisColor(htIrisImage.getRGB(xLoc - 1, yLoc)) && !irisColor(htIrisImage.getRGB(xLoc - 1, yLoc - 1)) &&
                   !irisColor(htIrisImage.getRGB(xLoc - 1, yLoc + 1)) && !irisColor(htIrisImage.getRGB(xLoc, yLoc - 1)) &&
                   !irisColor(htIrisImage.getRGB(xLoc, yLoc)) && !irisColor(htIrisImage.getRGB(xLoc, yLoc + 1)) &&
                   !irisColor(htIrisImage.getRGB(xLoc + 1, yLoc - 1)) && !irisColor(htIrisImage.getRGB(xLoc + 1, yLoc)) &&
                   !irisColor(htIrisImage.getRGB(xLoc + 1, yLoc + 1))){
                    return false;
                } 
          /*  if(!irisColor(htPupilImage.getRGB(xLoc - 2, yLoc - 2)) && !irisColor(htIrisImage.getRGB(xLoc - 2, yLoc - 1)) &&
                   !irisColor(htIrisImage.getRGB(xLoc - 2, yLoc)) && !irisColor(htIrisImage.getRGB(xLoc - 2, yLoc + 1)) &&
                   !irisColor(htIrisImage.getRGB(xLoc - 2, yLoc + 2)) &&  
                   !irisColor(htIrisImage.getRGB(xLoc - 1, yLoc)) && !irisColor(htIrisImage.getRGB(xLoc - 1, yLoc - 1)) &&
                   !irisColor(htIrisImage.getRGB(xLoc - 1, yLoc - 2)) && !irisColor(htIrisImage.getRGB(xLoc - 1, yLoc + 2)) &&  
                   !irisColor(htIrisImage.getRGB(xLoc - 1, yLoc + 1)) && !irisColor(htIrisImage.getRGB(xLoc, yLoc - 1)) &&
                   !irisColor(htIrisImage.getRGB(xLoc, yLoc - 2)) && !irisColor(htIrisImage.getRGB(xLoc, yLoc + 2)) &&  
                   !irisColor(htIrisImage.getRGB(xLoc, yLoc)) && !irisColor(htIrisImage.getRGB(xLoc, yLoc + 1)) &&
                   !irisColor(htIrisImage.getRGB(xLoc + 1, yLoc - 1)) && !irisColor(htIrisImage.getRGB(xLoc + 1, yLoc)) &&
                   !irisColor(htIrisImage.getRGB(xLoc + 1, yLoc - 2)) && !irisColor(htIrisImage.getRGB(xLoc + 1, yLoc + 2)) && 
                   !irisColor(htIrisImage.getRGB(xLoc + 1, yLoc + 1)) && !irisColor(htIrisImage.getRGB(xLoc + 2, yLoc - 2)) &&
                   !irisColor(htIrisImage.getRGB(xLoc + 2, yLoc - 1)) && !irisColor(htIrisImage.getRGB(xLoc + 2, yLoc)) && 
                   !irisColor(htIrisImage.getRGB(xLoc + 2, yLoc + 1)) && !irisColor(htIrisImage.getRGB(xLoc + 2, yLoc + 2))){
                return false;
            }*/
        }
        
        return true;
    }
    
    public void setIrisInfo(){
        setIrisRadius();
        setIrisCenter();
    }
    
    private void setIrisRadius(){
        
        int radius = 0;
        
        for(int i = 0; i < irisList.size(); i++){
            if(irisList.get(i) > radius){
                radius = irisList.get(i);
            }
        }
        this.irisRadius = radius;
    }
    
    private void setIrisCenter(){
        
        Point cp = new Point(0, 0);
        
        for(int j = 0; j < irisMap.size(); j++){
          cp = irisMap.get(irisRadius);
        }
        this.irisCP = cp;
    }
    
    public int getIrisRadius(){
        return this.irisRadius;
    }
    
    public Point getIrisCenter(){
        return this.irisCP;
    }
    
   /* public void pupil(){
        
        for(int radius = 3; radius < 25; radius ++){
            for(int y = radius + 1; y < height - radius - 1; y++){
                for(int x = radius + 1; x < width - radius - 1; x++){
                    
                    if(isPupil(radius, x, y)){
                       
                       pupilCP = new Point(x, y);
                       pupilRadius = radius;
                       // System.out.println("radius" +radius + "\tx: " + x + "\ty:" +y) ;
                    }
                    
                }
            }
        }
        
    }*/
    
    public void pupil(){
        
        int bound = 4;
        
        for(int radius = 3; radius < 30; radius ++){
            for(int y = (int)irisCP.getY() - bound; y < (int)irisCP.getY() + bound; y++){
                for(int x = (int)irisCP.getX() - bound; x < (int)irisCP.getX() + bound; x++){
                    
                    if(isPupil(radius, x, y, 1)){
                       
                       pupilCP = new Point(x, y);
                       pupilRadius = radius;
                       
                       // System.out.println("radius" +radius + "\tx: " + x + "\ty:" +y) ;
                    }
                    
                    
                }
            }
        }
        if(getPupilRadius() < 5){
               for(int radius = 3; radius < 30; radius ++){
            for(int y = (int)irisCP.getY() - bound; y < (int)irisCP.getY() + bound; y++){
                for(int x = (int)irisCP.getX() - bound; x < (int)irisCP.getX() + bound; x++){
                    
                    if(isPupil(radius, x, y, 2)){
                       
                       pupilCP = new Point(x, y);
                       pupilRadius = radius;
                       
                       // System.out.println("radius" +radius + "\tx: " + x + "\ty:" +y) ;
                    }
                    
                    
                }
            }
        }
        }
    }
    
    private boolean isPupil(int radius, int x, int y, int choise){
        
         for(int i = 0; i < 8 * radius; i++){
            
            double theta = ((double)(2.0 * Math.PI)*i)/(double) (8 * radius);
                      
            int  xLoc = (int)Math.round(x + (double)radius * Math.cos(theta));
            int  yLoc = (int)Math.round(y + (double)radius*Math.sin(theta));
             if(choise == 1){
          if(!pupilColor(htPupilImage.getRGB(xLoc - 1, yLoc)) && !pupilColor(htPupilImage.getRGB(xLoc - 1, yLoc - 1)) &&
                   !pupilColor(htPupilImage.getRGB(xLoc - 1, yLoc + 1)) && !pupilColor(htPupilImage.getRGB(xLoc, yLoc - 1)) &&
                   !pupilColor(htPupilImage.getRGB(xLoc, yLoc)) && !pupilColor(htPupilImage.getRGB(xLoc, yLoc + 1)) &&
                   !pupilColor(htPupilImage.getRGB(xLoc + 1, yLoc - 1)) && !pupilColor(htPupilImage.getRGB(xLoc + 1, yLoc)) &&
                  !pupilColor(htPupilImage.getRGB(xLoc + 1, yLoc + 1))){
                    return false;
                }
    }
             if(choise == 2){
               if(  !pupilColor(htPupilImage.getRGB(xLoc - 2, yLoc - 2)) && !pupilColor(htPupilImage.getRGB(xLoc - 2, yLoc - 1)) &&
                   !pupilColor(htPupilImage.getRGB(xLoc - 2, yLoc)) && !pupilColor(htPupilImage.getRGB(xLoc - 2, yLoc + 1)) &&
                   !pupilColor(htPupilImage.getRGB(xLoc - 2, yLoc + 2)) &&  
                   !pupilColor(htPupilImage.getRGB(xLoc - 1, yLoc)) && !pupilColor(htPupilImage.getRGB(xLoc - 1, yLoc - 1)) &&
                   !pupilColor(htPupilImage.getRGB(xLoc - 1, yLoc - 2)) && !pupilColor(htPupilImage.getRGB(xLoc - 1, yLoc + 2)) &&  
                   !pupilColor(htPupilImage.getRGB(xLoc - 1, yLoc + 1)) && !pupilColor(htPupilImage.getRGB(xLoc, yLoc - 1)) &&
                   !pupilColor(htPupilImage.getRGB(xLoc, yLoc - 2)) && !pupilColor(htPupilImage.getRGB(xLoc, yLoc + 2)) &&  
                   !pupilColor(htPupilImage.getRGB(xLoc, yLoc)) && !pupilColor(htPupilImage.getRGB(xLoc, yLoc + 1)) &&
                   !pupilColor(htPupilImage.getRGB(xLoc + 1, yLoc - 1)) && !pupilColor(htPupilImage.getRGB(xLoc + 1, yLoc)) &&
                   !pupilColor(htPupilImage.getRGB(xLoc + 1, yLoc - 2)) && !pupilColor(htPupilImage.getRGB(xLoc + 1, yLoc + 2)) && 
                   !pupilColor(htPupilImage.getRGB(xLoc + 1, yLoc + 1)) && !pupilColor(htPupilImage.getRGB(xLoc + 2, yLoc - 2)) &&
                   !pupilColor(htPupilImage.getRGB(xLoc + 2, yLoc - 1)) && !pupilColor(htPupilImage.getRGB(xLoc + 2, yLoc)) && 
                   !pupilColor(htPupilImage.getRGB(xLoc + 2, yLoc + 1)) && !pupilColor(htPupilImage.getRGB(xLoc + 2, yLoc + 2))){
                    return false;
                
                 }
          }
          
        }
        return true;
    }
    
       private boolean pupilColor(int pixel){
        
        Color c = new Color(pixel);
        
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
    
        if(red < 1 && green < 1 && blue < 1){
            return false;
        }
        
        return true;
    }
    
       public void setPupilInfo(){
           setPupilCenter();
           setPupilRadius();
    }
    
    private void setPupilRadius(){
        
        int radius = 0;
        System.out.println(pupilMap.get(pupilCP));
        radius = pupilMap.get(pupilCP);

        this.pupilRadius = radius;
    }
    
    private void setPupilCenter(){
        Point cp = new Point(0, 0);
        for (int k = 0; k <pupilList.size(); k++){
            if(pupilList.get(k) == irisCP){
                pupilCP = pupilList.get(k);
                break;
            }else if(pupilList.get(k).getX() == irisCP.getX() - 1 && pupilList.get(k).getY() == irisCP.getY() - 1 ||
                    pupilList.get(k).getX() == irisCP.getX() - 1 && pupilList.get(k).getY() == irisCP.getY() ||
                    pupilList.get(k).getX() == irisCP.getX() - 1 && pupilList.get(k).getY() == irisCP.getY() + 1 ||
                    pupilList.get(k).getX() == irisCP.getX() && pupilList.get(k).getY() == irisCP.getY() -1 ||
                     pupilList.get(k).getX() == irisCP.getX() && pupilList.get(k).getY() == irisCP.getY() ||
                     pupilList.get(k).getX() == irisCP.getX() && pupilList.get(k).getY() == irisCP.getY() + 1 ||
                     pupilList.get(k).getX() == irisCP.getX() + 1 && pupilList.get(k).getY() == irisCP.getY() - 1 ||
                    pupilList.get(k).getX() == irisCP.getX() + 1 && pupilList.get(k).getY() == irisCP.getY() || 
                    pupilList.get(k).getX() == irisCP.getX() + 1 && pupilList.get(k).getY() == irisCP.getY() + 1){
                pupilCP = pupilList.get(k);
            }
        }
    }
    
    public int getPupilRadius(){
        return this.pupilRadius;
    }
    
    public Point getPupilCenter(){
        return this.pupilCP;
    }
    
    
}
