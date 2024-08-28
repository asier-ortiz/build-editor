package util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class methodsUtil {

    public static ImageIcon resizeImageIcon(ImageIcon imageIcon, int width, int height) {
        Image img = imageIcon.getImage();
        Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }

    public static ImageIcon getIconFromUrl(String imageUrl) {
        URL url = null;
        BufferedImage bufferedImage = null;
        try {
            url = new URL(imageUrl);
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
        if (url != null) {
            try {
                bufferedImage = ImageIO.read(url);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (bufferedImage != null) {
            return new ImageIcon(bufferedImage);
        } else {
            return new ImageIcon(".\\src\\resources\\empty_skill.png");
        }
    }


}
