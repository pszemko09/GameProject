package com.game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Klasa zawierająca główny mechanizm ładowania plików graficznych
 * do programu
 */
public class ImageLoader {

    private BufferedImage image;

    /**
     * Metoda ładująca wybrany plik graficzny do programu
     * @parm path ścieżka wskazująca lokalizację pliku
     */
    public BufferedImage loadImage(String path) {
        try{
           image = ImageIO.read(getClass().getResourceAsStream(path));
           return image;
        }

        catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        return image;
    }
}