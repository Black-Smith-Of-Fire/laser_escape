package org.blacksmith.components;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteSheetAnimator implements Animator {
    int delayInMS;

    Image[] sprites;
    int imageNum;
    long lastUpdate;

    public SpriteSheetAnimator(Image sheet, int width, int height, int delayInMs) {
        this.delayInMS = delayInMs;
        lastUpdate = System.currentTimeMillis();

        BufferedImage bufferedImage = toBufferedImage(sheet);

        int sheetWidth = sheet.getWidth(null);
        int numSprites = (int)(sheetWidth/width);

        sprites = new Image[numSprites];
        for (int i = 0; i < numSprites; i++) {
            sprites[i] = bufferedImage.getSubimage(i*width, 0, width, height);
        }
    }

    public Image getImage() {
        if ((lastUpdate+delayInMS) < System.currentTimeMillis()) {
            lastUpdate = System.currentTimeMillis();
            imageNum++;
            if (imageNum>=sprites.length) {
                imageNum = 0;
            }
        }
        return sprites[imageNum];
    }

    @Override
    public int getWidth() {
        return sprites[0].getWidth(null);
    }

    @Override
    public int getHeight() {
        return sprites[0].getWidth(null);
    }

    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}
