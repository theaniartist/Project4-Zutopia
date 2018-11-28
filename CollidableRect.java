/**
 * An abstract class that sets and returns respective x and y coordinates.
 */
public abstract class CollidableRect
{
	/*
	 *****************************************************************************************************************************************************
	 ***** INSTANCE VARIABLES ****************************************************************************************************************************
	 *****************************************************************************************************************************************************
	 */
	private double _x1, _y1, _x2, _y2;
	/*
	 *****************************************************************************************************************************************************
	 ***** PROTECTED METHODS *****************************************************************************************************************************
	 *****************************************************************************************************************************************************
	 */
	/**
	 * Sets the given parameter to be the first x-value.
	 * @param x1 first x value
	 */
	protected void setX1(double x1)
	{
		_x1 = x1;
	}
	/**
	 * Sets the given parameter to be the first y-value.
	 * @param y1 first y value
	 */
	protected void setY1(double y1)
	{
		_y1 = y1;
	}
	/**
	 * Sets the given parameter to be the second x value
	 * @param x2 second x value
	 */
	protected void setX2(double x2)
	{
		_x2 = x2;
	}
	/**
	 * Sets the given parameter to be the second y value.
	 * @param y2 second y value
	 */
	protected void setY2(double y2)
	{
		_y2 = y2;
	}
	/**
	 * Gets the first x value.
	 * @return first x value
	 */
	protected double getX1()
	{
		return _x1;
	}
	/**
	 * Gets the first y value.
	 * @return first y value
	 */
	protected double getY1()
	{
		return _y1;
	}
	/**
	 * Gets the second x value.
	 * @return second x value
	 */
	protected double getX2()
	{
		return _x2;
	}
	/**
	 * Gets the second y value.
	 * @return second y value
	 */
	protected double getY2()
	{
		return _y2;
	}
}