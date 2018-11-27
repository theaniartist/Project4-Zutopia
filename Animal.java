import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A class that displays the board images (duck, goat, and horse) at their respective x and y positions.
 */


public class Animal extends CollidableRect
{
	private ImageView sprite = new ImageView();
	
	public Animal(Image image, double x, double y)
	{
		sprite.setImage(image);
		sprite.setLayoutX(x);
		sprite.setLayoutY(y);
		setX1(x);
		setY1(y);
		setX2(x + image.getWidth());
		setY2(y + image.getHeight());
	}

	/**
	 * Returns the respective image (duck, goat, horse).
	 * @return the respective image (duck, goat, horse).
	 */

	public ImageView getSprite()
	{
		return sprite;
	}
}
