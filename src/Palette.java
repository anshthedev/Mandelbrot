import java.awt.Color;

public class Palette {
    
    private int colorScheme;
    public final int ITERATION_LIMIT = 500;

    public Palette(int colorScheme){
        this.colorScheme = colorScheme;
    }

    public Color mapColor(int n){
        if(this.colorScheme == 1){
            return map1(n);
        }

        return map0(n);
    }

    private Color map0(int n){
        if(n<0){
            return Color.BLACK;
        }else{
            return Color.WHITE;
        }
    }

    private Color map1(int n) {

        if(n<0){
            return Color.BLACK;
        }

        double normedX = 1.0 * n/Mandelbrot.iterationLimit;

        int red = (int) (255 * normedX);
        int green = (int)Math.abs(127.5*Math.sin(.01256637061  * (n-ITERATION_LIMIT/4))+127.5);
        int blue = 255 - (int)(255 * normedX);
        return new Color(red, green, blue);
    }
}
