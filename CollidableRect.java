/**
 * An abstract class that sets and returns respective x and y coordinates of whichever class that
 * it is being extended off of.
 */
public abstract class CollidableRect
{
	private double _x1, _y1, _x2, _y2;
	
	public CollidableRect(double x1, double y1, double x2, double y2)
	{
		_x1 = x1;
		_y1 = y1;
		_x2 = x2;
		_y2 = y2;
	}

	/**
	 * Sets the given parameter to be the first x-value.
	 * @param x1 first x value
	 */
	public void setX1(double x1)
	{
		_x1 = x1;
	}

	/**
	 * Sets the given parameter to be the first y-value.
	 * @param y1 first y value
	 */
	
	public void setY1(double y1)
	{
		_y1 = y1;
	}

	/**
	 * Sets the given parameter to be the second x value
	 * @param x2 second x value
	 */
	
	public void setX2(double x2)
	{
		_x2 = x2;
	}

	/**
	 * Sets the given parameter to be the second y value.
	 * @param y2 second y value
	 */
	
	public void setY2(double y2)
	{
		_y2 = y2;
	}

	/**
	 * Gets the first x value.
	 * @return first x value
	 */
	
	public double getX1()
	{
		return _x1;
	}

	/**
	 * Gets the first y value.
	 * @return first y value
	 */
	
	public double getY1()
	{
		return _y1;
	}

	/**
	 * Gets the second x value.
	 * @return second x value
	 */
	
	public double getX2()
	{
		return _x2;
	}

	/**
	 * Gets the second y value.
	 * @return second y value
	 */
	
	public double getY2()
	{
		return _y2;
	}
}