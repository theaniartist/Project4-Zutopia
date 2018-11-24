import java.awt.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Class that implements a ball with a position and velocity.
 */
public class Ball extends Collidable
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
		super(GameImpl.WIDTH / 2 - BALL_RADIUS, GameImpl.HEIGHT / 2 - BALL_RADIUS, GameImpl.WIDTH / 2 + BALL_RADIUS, GameImpl.HEIGHT / 2 + BALL_RADIUS);
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
		if(getX2() >= GameImpl.WIDTH || getX1() <= 0)
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
		if(getY2() >= GameImpl.HEIGHT || getY1() <= 0)
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
		setX1(x - BALL_RADIUS);
		setY1(y - BALL_RADIUS);
		setX2(x + BALL_RADIUS);
		setY2(y + BALL_RADIUS);
	}
	
	@Override
	public boolean intersect(Collidable other)
	{
		double closestX = x;
		double closestY = y;
		
		if(x < other.getX1())
		{
			closestX = other.getX1();
		}
		if(x > other.getX2())
		{
			closestX = other.getX2();
		}
		
		if(y < other.getY1())
		{
			closestY = other.getY1();
		}
		if(y > other.getY2())
		{
			closestY = other.getY2();
		}
		
		double distanceTo = distanceTo(closestX, x, closestY, y);
		
		if(distanceTo < BALL_RADIUS)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}