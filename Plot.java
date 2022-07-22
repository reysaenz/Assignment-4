

public class Plot {
	private int x;
	private int y;
	private int width =0;
	private int depth = 0;
	Plot()
	{
		this.width = 1;
		this.depth = 1;
	}
	Plot(Plot p)
	{
		 p = new Plot();
	}
	Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	public boolean encompasses(Plot plot)
	{
		int checker = 0;
		int one = this.getX();
		int two = plot.getX();
		int three = this.getX();
		int four = this.getY();
		int five = plot.getY();
		int six = this.getY();
		
		if(one + this.getWidth()>two) {
			checker = 1;
		}
		if(four + this.getDepth() > five)
		{
			checker = 1;
		}
		if(one >= two ||two <= three)
		{
			checker = 1;
		}
		if(four >= five|| five <= six)
		{
			checker  = 1;
		}
		System.out.println("Encompasses: this.X"+one+"P.X"+two);
		return checker == 0? false : true;
		
		
	}
	public boolean overlaps(Plot plot)
	{
		int checker = 0;
		int one = this.getX(); 
		int two = plot.getX();
		int three = this.getX() + this.getWidth(); 
		int four = this.getY(); 
		int five = plot.getY();
		int six = this.getY() + this.getDepth();
		
		if (one >= two || two <= three) { 
			checker = 1; 
		}
		
		if (four >= five || five <= six) { 
			checker = 1; 
		}

		return checker == 0 ? false : true;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String toString() {
		String s = "";
		s += "(" + this.getX() + ", " + this.getY() + ")";
		s += "\n" + "Width: " + this.getWidth();
		s += "\n" + "Depth:" + this.getDepth();
		return s;
	}

}