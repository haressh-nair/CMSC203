/*
 * Class: CMSC203 CRN33083
 * Instructor: Professor Monshi
 * Description: A rectangular plot of land defined by an upper-left corner (x, y) and dimensions (width, depth).
 * Due: 04/23/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Haressh Nair
 */

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    // Default constructor
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    // Copy constructor
    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    // Parameterized constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Determines if this plot overlaps another
    public boolean overlaps(Plot plot) {
        return !(plot.x >= this.x + this.width ||
                 plot.x + plot.width <= this.x ||
                 plot.y >= this.y + this.depth ||
                 plot.y + plot.depth <= this.y);
    }

    public boolean encompasses(Plot plot) {
        return (plot.x >= this.x &&
                plot.y >= this.y &&
                plot.x + plot.width <= this.x + this.width &&
                plot.y + plot.depth <= this.y + this.depth);
    }

    // Returns plot in string format: x,y,width,depth
    public String toString() {
        return this.x + "," + this.y + "," + this.width + "," + this.depth;
    }
}
