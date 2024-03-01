import javax.swing.JFrame;

public class FractalRunner {
    public static void main(String[] args) {
        JFrame f = new JFrame("Mandelbrot");
        FractalPanel p = new FractalPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.pack();
        f.setVisible(true);
        p.setFocusable(true);
        p.requestFocusInWindow();
    }
}