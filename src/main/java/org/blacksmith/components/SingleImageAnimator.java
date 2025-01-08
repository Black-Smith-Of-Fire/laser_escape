package org.blacksmith.components;

import java.awt.*;

public class SingleImageAnimator implements Animator {

    Image image;
    public SingleImageAnimator(Image image) {
        this.image = image;
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
