/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris.pupil_detection;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Aleksa
 */
public class IRISPUPIL_Detection {

        private BufferedImage img, bimg;
        private BufferedImage iris, pupil, htIris, htPupil;
        private BufferedImage iris_pupil_detected;
        private BufferedImage eyeDetected;
        private BufferedImage projectImage;
        private BufferedImage wholeImage;
        private Point irisCP;
        private int irisRadius;
        private int pupilRadius;
        private Point pupilCP;
        private Utils utils;


    public IRISPUPIL_Detection(BufferedImage img, BufferedImage bimg, BufferedImage iris_pupil_detected, BufferedImage projectImage, BufferedImage wholeImage) {
        this.img = img;
        this.bimg = bimg;
        this.iris_pupil_detected = iris_pupil_detected;
        this.projectImage = projectImage;
        this.wholeImage = wholeImage;
        this.utils = new Utils();
        detectEye(img);
         
    }
    
    private void detectEye(BufferedImage img){
        
        Canny can = new Canny();
        this.iris = can.cannyiris(img);
        BufferedImage cannyedIris = this.iris;
        this.pupil = can.cannypupil(bimg);
        BufferedImage cannyedPupil = this.pupil;
        
        HoughTransform ht = new HoughTransform(cannyedPupil);
        this.htPupil = ht.getProjectImage();
        ht = new HoughTransform(cannyedIris);
        htIris = ht.getProjectImage();
        
       FindCircle fic = new  FindCircle(htIris, htPupil);
       fic.iris();
       fic.setIrisInfo();
       irisCP = fic.getIrisCenter();
       irisRadius = fic.getIrisRadius();
       fic.pupil();
       pupilRadius = fic.getPupilRadius();
       pupilCP = fic.getPupilCenter();
       
       eyeDetected = utils.drawCircle(iris_pupil_detected, irisRadius, (int)irisCP.getX(),(int) irisCP.getY());
       eyeDetected = utils.drawJusteye(iris_pupil_detected);
       eyeDetected = utils.drawCircle(iris_pupil_detected, pupilRadius, (int)pupilCP.getX(),(int) pupilCP.getY());
       eyeDetected = utils.drawCross(iris_pupil_detected, pupilCP);

       wholeImage = utils.drawCircle(wholeImage, irisRadius, (int)irisCP.getX(),(int) irisCP.getY());
       wholeImage = utils.drawCircle(wholeImage, pupilRadius, (int)pupilCP.getX(),(int) pupilCP.getY());
       wholeImage = utils.drawCross(wholeImage, pupilCP);
              }

    public BufferedImage getImg() {
        return img;
    }

    public BufferedImage getIris() {
        return iris;
    }

    public BufferedImage getPupil() {
        return pupil;
    }

    public BufferedImage getHtIris() {
        return htIris;
    }

    public BufferedImage getHtPupil() {
        return htPupil;
    }

    public BufferedImage getIris_pupil_detected() {
        return iris_pupil_detected;
    }

    public BufferedImage getEyeDetected() {
        return eyeDetected;
    }

    public Point getIrisCP() {
        return irisCP;
    }

    public int getIrisRadius() {
        return irisRadius;
    }

    public int getPupilRadius() {
        return pupilRadius;
    }

    public Point getPupilCP() {
        return pupilCP;
    }

    public BufferedImage getProjectImage() {
        return projectImage;
    }

    public BufferedImage getWholeImage() {
        return wholeImage;
    }
    
    
}
