import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


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
	
	public ImageView getSprite()
	{
		return sprite;
	}
}
