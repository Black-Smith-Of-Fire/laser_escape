package Experimental_code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    static Lasers laser;
    public static void main(String[] args) {
         laser = new Lasers(0,0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        laser.move();
    }
}
