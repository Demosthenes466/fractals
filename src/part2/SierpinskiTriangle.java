package part2;
import java.awt.Color;
import java.awt.geom.Point2D;
import draw.StdDraw;


public class SierpinskiTriangle { 
   
	private Point2D.Double top, right, left;
	private Color background = new Color(34, 129, 34);
	private Color foreground = StdDraw.YELLOW;
	
	public SierpinskiTriangle() {
		StdDraw.setXscale(0, 150); 
		StdDraw.setYscale(75, 150); 
		
		top = new Point2D.Double(75, 150);
		right = new Point2D.Double(150, 75);
		left = new Point2D.Double(0, 75);
		 
		StdDraw.clear(StdDraw.GRAY); 
	}
   
	public void sierpinski(Point2D.Double a, Point2D.Double b, Point2D.Double c, int n) {
		Point2D.Double newA = new Point2D.Double(Math.abs((c.x+a.x)/2), Math.abs((c.y+a.y)/2));
		Point2D.Double newB = new Point2D.Double(Math.abs((a.x+b.x)/2), Math.abs((a.y+b.y)/2));
		Point2D.Double newC = new Point2D.Double(Math.abs((b.x+c.x)/2), Math.abs((b.y+c.y)/2));

		   drawTriangle(a, b, c, StdDraw.BLACK);
		   n--;
		if (n <= 0 ) {
		   drawTriangle(a, newA, newB, Color.WHITE);   
		   drawTriangle(newA, newC, c, Color.WHITE);
		   drawTriangle(newB, b, newC, Color.WHITE);
		} else {
			sierpinski(a, newA, newB, n); 
			sierpinski(newA, newC, c, n);
			sierpinski(newB, b, newC, n);
		}
		
		
	   
	




	   System.out.println(newC);

    }
   
	public void drawTriangle(Point2D.Double a, Point2D.Double b, Point2D.Double c, Color color) {
	   double[] x = {a.x, b.x, c.x};
	   double[] y = {a.y, b.y, c.y};
	   StdDraw.setPenColor(color);
	   StdDraw.filledPolygon(x, y);
	}
	
	public void draw(int n) {
		sierpinski(top, right, left, n);
	}
	
	
	
	public static void main(String[] args) { 
		SierpinskiTriangle triangle = new SierpinskiTriangle();
		triangle.draw(100);
	}
}
