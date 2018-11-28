/**
 * A class that calculates the distance between two given points.
 * @return The distance between two points.
 */
public class Utility 
{
	public static double distanceTo(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
