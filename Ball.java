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
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
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
	
	public void resolve_collision(CollidableRect otherBoundingBox)
	{
		double cornerCone = BALL_RADIUS / 2;
		boolean extremeUpperRight = getX() - cornerCone > otherBoundingBox.getX2() && getY() + cornerCone < otherBoundingBox.getY1();
		boolean extremeLowerRight = getX() - cornerCone > otherBoundingBox.getX2() && getY() - cornerCone > otherBoundingBox.getY2();
		boolean extremeUpperLeft = getX() + cornerCone < otherBoundingBox.getX1() && getY() + cornerCone < otherBoundingBox.getY1();
		boolean extremeLowerLeft = getX() + cornerCone < otherBoundingBox.getX1() && getY() - cornerCone > otherBoundingBox.getY2();
		
		if(extremeUpperRight || extremeLowerRight || extremeUpperLeft || extremeLowerLeft)
		{
			vx = -vx;
			vy = -vy;
		}
		else if(getY() > otherBoundingBox.getY1() && getY() < otherBoundingBox.getY2())
		{
			vx = -vx;
		}
		else
		{
			vy = -vy;
		}
	}
}