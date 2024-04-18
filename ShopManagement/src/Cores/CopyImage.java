package Cores;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CopyImage {
    //Resize a picture to fit a JLabel
    //https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel/16345968
    public static Image resizeImage(String url,JLabel image) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
        Image dimg = img.getScaledInstance(image.getWidth(), image.getHeight(),
        Image.SCALE_SMOOTH);
        return dimg;
    }
    
    //Copy image form outside into source code
    //https://stackoverflow.com/questions/24807725/how-to-make-an-exact-copy-of-image-in-java
    public static boolean copyImage(String url){
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(new File(url));
            os = new FileOutputStream(new File(".\\src\\images\\product\\" + getNameImage(url)));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
    
    //Get name image from url
    public static String getNameImage(String url){
        int i = url.length()-1;
        while(i>=0 && url.charAt(i) != '\\'){
            i--;
        }
        return i < 0 ? "":url.substring(i+1,url.length()).replaceAll("\\s+","");
    }
    
    //Get extension image from url
    public static String getExtension(String url){
        int i = url.length()-1;
        while(i>=0 && url.charAt(i) != '.'){
            i--;
        }
        return i < 0 ? "":url.substring(i+1,url.length());
    }

    public static int deleteFile(String path) {
        int kq = 0;
        File file = new File(path);
        if(file.delete())
        {
            System.out.println("File deleted successfully");
            kq = 1;
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
        return kq;
    }
}
