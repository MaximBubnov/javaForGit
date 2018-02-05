package forOther;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Fractral extends JPanel{
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.RED);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   //сглаживание
        DrCirc(300, 300, 200, g);           //центр и размер фрактала
    }

    public void DrCirc(double x, double y, int size, Graphics g) {
        int N = 6, c = 3, rad = 0, den = 0;
        //всего получится (N+1) окружность
        //новые окружности будут иметь радиус size/c
        if (size > 0) {
            rad = Math.round(size/c);       //уменьшаем радиус
            den = Math.round(size*(c-1)/c);
            DrCirc(x, y, rad, g);           //центральная окружность
            for(int i = 0; i < N; i++){     //все остальные окружности
                DrCirc(x - Math.round(den*Math.sin(2*Math.PI/N*i)), y + Math.round(den*Math.cos(2*Math.PI/N*i)), rad, g);
            }
            g.drawOval((int)x-size, (int)y-size, 2*size, 2*size);
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("CircFract");
        window.setSize(600, 600);
        window.setContentPane(new Fractral());
        window.setBackground(Color.WHITE);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
