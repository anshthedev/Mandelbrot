import javax.swing.JFrame;

public class ColorVisRunner {

  public static void main(String[] args) {
    JFrame f = new JFrame("Color Visualizer"); 
    ColorVisualizer p = new ColorVisualizer();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(p);
    f.pack();
    f.setVisible(true);
  }
}