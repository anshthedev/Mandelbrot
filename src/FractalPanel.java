import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FractalPanel extends JPanel implements MouseListener {

    int width = 600;
    int height = 400;

    View panel;
    Palette palette;
    
    public FractalPanel() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);

        // initialize the needed objects
        panel = new View(width, height);
        palette = new Palette(1);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        // paints the array pixels onto the screen
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                //translate this x,y coordinte to a single complex number
                Complex complexPoint = panel.translate(x, y);
                //calculate mandlebort iterations for the complex number
                int iterations = Mandelbrot.testPoint(complexPoint);
                //normalize that number of iterations into a double from 0.0 to 1.0
                //use number to get color from pattle class

                g.setColor(palette.mapColor(iterations));
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        int clickX = e.getX();
        int clickY = e.getY();

        //TODO: Change 10 into variables
        Complex TL = panel.translate(clickX + width/10, clickY + height/10);
        Complex BR = panel.translate(clickX - width/10, clickY - height/10);
        panel.setComplexCorners(TL, BR);
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
        // called when the mouse enters the window
    }
        
    public void mouseExited(MouseEvent e) {
        // called when the mouse leaves the window
    }
        
    public void mousePressed(MouseEvent e) {

        // set a variable based on mouse coordinates
        // or check a condition based on mouse coordinates
    }

    public void mouseReleased(MouseEvent e) {
        int releaseX = e.getX();
        int releaseY = e.getY();
        // set a variable based on mouse coordinates
        // or check a condition based on mouse coordinates
    }
}