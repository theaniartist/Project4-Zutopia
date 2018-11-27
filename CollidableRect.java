
public abstract class CollidableRect
{
	private double _x1, _y1, _x2, _y2;

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