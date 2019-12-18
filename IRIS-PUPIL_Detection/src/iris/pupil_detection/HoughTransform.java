/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris.pupil_detection;


import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Aleksa
 */
public class HoughTransform {
    
    BufferedImage testImage;
    BufferedImage projectImage;
    BufferedImage realImage;
    
    public HoughTransform(BufferedImage img){
        this.realImage = img;
        projectImage = new BufferedImage(realImage.getWidth(), realImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        doHoughTransform();
        
        
    }
    
    private void doHoughTransform(){
        
        testImage = realImage;
        int min = 1;
        int maxGval = 0;
        int[][] edgeColors = new int[testImage.getWidth()][testImage.getHeight()];
        int maxGradient = -1;
        
        for (int y = 1 ; y < testImage.getHeight() - 1; y++){
            for(int x = 1; x < testImage.getWidth() - 1; x++){
                    
                int val00 = getGrayScale(testImage.getRGB(x - 1, y - 1));
                int val01 = getGrayScale(testImage.getRGB(x - 1, y));
                int val02 = getGrayScale(testImage.getRGB(x - 1, y + 1));

                int val10 = getGrayScale(testImage.getRGB(x, y - 1));
                int val11 = getGrayScale(testImage.getRGB(x, y));
                int val12 = getGrayScale(testImage.getRGB(x, 1 + y));

                int val20 = getGrayScale(testImage.getRGB(x + 1, y - 1));
                int val21 = getGrayScale(testImage.getRGB(x + 1, y));
                int val22 = getGrayScale(testImage.getRGB(x + 1, y + 1));
                    
                int gx=(((-1*val00)+(0*val01)+(1*val02))+((-2*val10)+(0*val11)+(2*val12))+((-1*val20)+(0*val21)+(1*val22)));
                int gy=(((-1*val00)+(-2*val01)+(-1*val02))+((0*val10)+(0*val11)+(0*val12))+((1*val20)+(2*val21)+(1*val22)));
                    
                    //int g= (int) Math.sqrt(gx*gx+gy*gy);
                    int g = (int)((Math.abs(gx)+Math.abs(gy))/(double)2.0);
                    
                   if(maxGradient < g) {
                    maxGradient = g;
                }

                edgeColors[x][y] = g;
                    
                }
            }
        
              double scale = 255.0 / maxGradient;

        for (int i = min; i < testImage.getWidth() - min; i++) {
            for (int j = min; j < testImage.getHeight() - min; j++) {
                int edgeColor = edgeColors[i][j];
                edgeColor = (int)(edgeColor * scale);
                edgeColor = 0xff000000 | (edgeColor << 16) | (edgeColor << 8) | edgeColor;

               projectImage.setRGB(i, j, edgeColor);
            }}
                
    }

    private int getGrayScale(int rgb){
    
    Color c = new Color(rgb);
    
    int r, g, b;
    r = c.getRed();
    g = c.getGreen();
    b = c.getBlue();
    
    int grey = (int)(0.2126 * r + 0.7152 * g + 0.0722 * b);
    
    return grey;
    }

    public BufferedImage getRealImage(){
    return realImage;
    }
    
    public BufferedImage getTestImage(){
    return testImage;
    }
    
    public BufferedImage getProjectImage(){
    return projectImage;
    }

}
