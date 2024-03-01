import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class FractalPanel extends JPanel implements KeyListener,MouseListener {

    int width;
    int height;
    View panel;
    Palette palette;
    Complex zoomPoint;
    int screenshotCount;
    boolean isAutoZooming;
    final int CLICK_ZOOM_FACTOR;
    final double AUTO_ZOOM_FACTOR;

    
    public FractalPanel() {
        width = 600;
        height = 400;

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);

        AUTO_ZOOM_FACTOR = 2.5;
        CLICK_ZOOM_FACTOR = 5;

        screenshotCount = 0;
        isAutoZooming = false;
        panel = new View(width, height);
        palette = new Palette(1);
        zoomPoint = new Complex(-0.7476227520148365, -0.09424193513025199);

        addMouseListener(this);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Complex complexPoint = panel.translate(x, y);

                int iterations = Mandelbrot.testPoint(complexPoint);

                g.setColor(palette.mapColor(iterations));
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        int clickX = e.getX();
        int clickY = e.getY();

        Complex TL = panel.translate(clickX - width/CLICK_ZOOM_FACTOR, clickY - height/CLICK_ZOOM_FACTOR);
        Complex BR = panel.translate(clickX + width/CLICK_ZOOM_FACTOR, clickY + height/CLICK_ZOOM_FACTOR);
        panel.setComplexCorners(TL, BR);

        Mandelbrot.iterationLimit += 10;
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            System.exit(0);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (!isAutoZooming) {
                isAutoZooming = true;
                new Thread(this::autoZoom).start(); // start autoZoom in a separate thread
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            Mandelbrot.iterationLimit += 100;
            System.out.println(Mandelbrot.iterationLimit);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_SHIFT && !isAutoZooming){
            captureScreenshot();
        }
    }
    
    private void autoZoom() {
        int x;
        int y;
        int x2;
        int y2;
          
        x = (int)(panel.getX(zoomPoint) - width / AUTO_ZOOM_FACTOR);
        y = (int)(panel.getY(zoomPoint) - height / AUTO_ZOOM_FACTOR);
        x2 = (int)(panel.getX(zoomPoint) + width / AUTO_ZOOM_FACTOR);
        y2 = (int)(panel.getY(zoomPoint) + height / AUTO_ZOOM_FACTOR);

        captureScreenshot();

        Complex TL = panel.translate(x, y);
        Complex BR = panel.translate(x2, y2);
        panel.setComplexCorners(TL, BR);

        repaint();

        // adding a small delay between frames
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        isAutoZooming = false;
    }

        private void captureScreenshot() {
        BufferedImage screenshot = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = screenshot.createGraphics();

        paintComponent(g2d);

        g2d.dispose();

        try {
            // save the screenshot to disk
            File outputFile = new File("screenshot" + screenshotCount + ".png");
            ImageIO.write(screenshot, "png", outputFile);

            //makes sure there are no duplicate files
            screenshotCount++;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Unused Methods
    public void keyReleased(KeyEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void keyTyped(KeyEvent e) {}
}