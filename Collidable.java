
public abstract class Collidable 
{
	private double _x1, _y1, _x2, _y2;
	
	public Collidable(double x1, double y1, double x2, double y2)
	{
		_x1 = x1;
		_y1 = y1;
		_x2 = x2;
		_y2 = y2;
	}

	public abstract boolean intersect(Collidable object);
	
	public double distanceTo(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	
	public void setX1(double x1)
	{
		_x1 = x1;
	}
	
	public void setY1(double y1)
	{
		_y1 = y1;
	}
	
	public void setX2(double x2)
	{
		_x2 = x2;
	}
	
	public void setY2(double y2)
	{
		_y2 = y2;
	}
	
	public double getX1()
	{
		return _x1;
	}
	
	public double getY1()
	{
		return _y1;
	}
	
	public double getX2()
	{
		return _x2;
	}
	
	public double getY2()
	{
		return _y2;
	}
}
