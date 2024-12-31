package org.blacksmith;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawImageOnCavas implements Runnable {
    private Game game;
    private Thread t;
    private boolean running;
    public int dai, rong;
    private String tuade;
    private BufferStrategy bs;
    private Graphics g;
    private BufferedImage testImage;

    public DrawImageOnCavas(String tuade, int dai, int rong) {
        this.dai = dai;
        this.rong = rong;
        this.tuade = tuade;

    }

    @Override
    public void run() {
        init();
        System.err.println("run..." + running);
        while (running) {
            //System.err.println("run..." + running);
            tick();
            render();
        }
        //stop();
    }

    private void render() {
        bs = game.getCanvas().getBufferStrategy();

        if (bs == null) {
            System.out.println("bs is null....");
            game.getCanvas().createBufferStrategy(3);
            return;
        }


        g = game.getCanvas().getGraphics();
        g.drawImage(testImage, 20, 20, null);
    }

    private void tick() {

    }

    private static final class ImageLoader
    {

        static BufferedImage loadImage(String fileName)
        {
            BufferedImage bi = null;
            //System.err.println("....setimg...." + fileName);

            try {
                bi = ImageIO.read(new File(fileName));

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Image could not be read");
                System.exit(1);
            }

            return bi;
        }
    }

    private void init() {
        game = new Game();
        testImage = ImageLoader.loadImage("characters/hero/happy_hero.png");
    }

    public synchronized void start() {
        if (running) return;
        running = true;
        t = new Thread(this);
        t.start();

    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            t.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}
