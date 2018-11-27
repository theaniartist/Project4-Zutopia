import java.awt.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Class that implements a ball with a position and velocity.
 */
public class Ball
{
	// Constants
	/**
	 * The radius of the ball.
	 */
	public static final int BALL_RADIUS = 8;
	/**
	 * The initial velocity of the ball in the x direction.
	 */
	public static final double INITIAL_VX = 1e-7;
	/**
	 * The initial velocity of the ball in the y direction.
	 */
	public static final double INITIAL_VY = 1e-7;

	// Instance variables
	// (x,y) is the position of the center of the ball.
	private double x, y;
	private double vx, vy;
	private Circle circle;

	/**
	 * Constructs a new Ball object at the centroid of the game board
	 * with a default velocity that points down and right.
	 */
	public Ball () 
	{
		x = GameImpl.WIDTH/2;
		y = GameImpl.HEIGHT/2;
		vx = INITIAL_VX;
		vy = INITIAL_VY;

		circle = new Circle(BALL_RADIUS, BALL_RADIUS, BALL_RADIUS); //Places ball top left.
		circle.setLayoutX(x - BALL_RADIUS);
		circle.setLayoutY(y - BALL_RADIUS);
		circle.setFill(Color.BLACK);
	}

	/**
	 * Checks if the ball has collided with the left/right wall of the screen. Collision
	 * occurs when the x-coordinate plus the ball's radius is greater than the screen's width
	 * or if the width of the screen minus the ball's radius is less than 0.
	 * @return true if the ball has collided with left or right of the screen.
	 */

	private boolean horizontalWallCollision()
	{
		if(x + BALL_RADIUS > GameImpl.WIDTH || x - BALL_RADIUS < 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Checks if the ball has collided with the top/bottom wall of the screen. Collision
	 * occurs when the y-coordinate plus the ball's radius is greater than the screen's height
	 * or if the height of the screen minus the ball's radius is less than 0.
	 * @return true if the ball has collided with the top or bottom of the screen.
	 */
	
	private boolean verticalWallCollision()
	{
		if(y + BALL_RADIUS > GameImpl.HEIGHT || y - BALL_RADIUS < 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @return the Circle object that represents the ball on the game board.
	 */
	public Circle getCircle () 
	{
		return circle;
	}

	/**
	 * Updates the position of the ball, given its current position and velocity,
	 * based on the specified elapsed time since the last update.
	 * @param deltaNanoTime the number of nanoseconds that have transpired since the last update
	 */
	public void updatePosition (long deltaNanoTime) 
	{
		if(horizontalWallCollision())
		{
			vx = -vx;
		}
		if(verticalWallCollision())
		{
			vy = -vy;
		}
		
		double dx = vx * deltaNanoTime;
		double dy = vy * deltaNanoTime;
		x += dx;
		y += dy;
		
		circle.setTranslateX(x - (circle.getLayoutX() + BALL_RADIUS));
		circle.setTranslateY(y - (circle.getLayoutY() + BALL_RADIUS));
	}

	/**
	 * Gets the X coordinate of the ball.
	 * @return X coordinate of the ball.
	 */

	public double getX()
	{
		return x;
	}

	/**
	 * Gets the Y coordinate of the ball.
	 * @return Y coordinate of the ball.
	 */
	
	public double getY()
	{
		return y;
	}


	/**
	 * Method checks if the ball has "intersected" with an object (paddle, images, walls, etc) on
	 * the board. Compares the ball's x and y values to the object's x and y values that it is going
	 * to collide with and calculates the distance of it.
	 * @param other the object that would be intersecting with the ball (paddle, images, walls, etc).
	 * @return true if the distance is less than the ball's radius.
	 */

	public boolean intersect(CollidableRect other)
	{
		double closestX = getX();
		double closestY = getY();
		
		if(getX() < other.getX1())
		{
			closestX = other.getX1();
		}
		if(getX() > other.getX2())
		{
			closestX = other.getX2();
		}
		
		if(getY() < other.getY1())
		{
			closestY = other.getY1();
		}
		if(getY() > other.getY2())
		{
			closestY = other.getY2();
		}
		
		double distanceTo = Utility.distanceTo(closestX, closestY, x, y);
		
		if(distanceTo < BALL_RADIUS)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Method causes the ball to "bounce back" (velocity of both x and y becomes negative) if it hits
	 * one of the four corners of the screen. Also bounces back when it has collided with an object on
	 * the board (paddle, images, walls , etc). Increases the ball's velocity (both x and y)
	 * if it has hit one of the animal images on the board.
	 * @param other the object's bounding box
	 */
	
	public void resolve_collision(CollidableRect other)
	{
		double cornerCone = BALL_RADIUS / 2;
		boolean extremeUpperRight = getX() - cornerCone > other.getX2() && getY() + cornerCone < other.getY1();
		boolean extremeLowerRight = getX() - cornerCone > other.getX2() && getY() - cornerCone > other.getY2();
		boolean extremeUpperLeft = getX() + cornerCone < other.getX1() && getY() + cornerCone < other.getY1();
		boolean extremeLowerLeft = getX() + cornerCone < other.getX1() && getY() - cornerCone > other.getY2();
		
		if(other instanceof Animal)
		{
			vx = vx * 1.2;
			vy = vy * 1.2;
		}
		if(extremeUpperRight || extremeLowerRight || extremeUpperLeft || extremeLowerLeft)
		{
			vx = -vx;
			vy = -vy;
		}
		else if(getY() > other.getY1() && getY() < other.getY2())
		{
			vx = -vx;
		}
		else
		{
			vy = -vy;
		}
	}
}