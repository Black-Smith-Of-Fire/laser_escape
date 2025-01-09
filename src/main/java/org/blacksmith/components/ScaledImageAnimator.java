package org.blacksmith.components;

import java.awt.*;

public class ScaledImageAnimator implements Animator {

    Image image;
    public ScaledImageAnimator(Image image, float scalingFactor) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        int scaledWidth = (int)((width/2)+((width/2)*scalingFactor));
        int scaledHeigth = (int)((height/2)+((height/2)*scalingFactor));
        Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeigth   , Image.SCALE_FAST);
        this.image = scaledImage;
    }


    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public int getWidth() {
        return image.getWidth(null);
    }

    @Override
    public int getHeight() {
        return image.getHeight(null);
    }
}
