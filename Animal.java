import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

/**
 * A class that displays the board images (duck, goat, and horse) at their respective x and y positions.
 */
public class Animal extends CollidableRect
{
	/*
	 *****************************************************************************************************************************************************
	 ***** INSTANCE VARIABLES / CONSTRUCTORS ************************************************************************************************************
	 *****************************************************************************************************************************************************
	 */
	private ImageView sprite = new ImageView();
	private final AudioClip soundEffect;  
	
	public Animal(Image image, String soundEffectPath, double x, double y)
	{
		sprite.setImage(image);
		sprite.setLayoutX(x);
		sprite.setLayoutY(y);
		setX1(x);
		setY1(y);
		setX2(x + image.getWidth());
		setY2(y + image.getHeight());
		soundEffect = new AudioClip(getClass().getClassLoader().getResource(soundEffectPath).toString());
	}
	/*
	 *****************************************************************************************************************************************************
	 ***** PUBLIC METHODS ********************************************************************************************************************************
	 *****************************************************************************************************************************************************
	 */
	/**
	 * Returns the respective image (duck, goat, horse).
	 * @return the respective image (duck, goat, horse).
	 */
	public ImageView getSprite()
	{
		return sprite;
	}
	
	/**
	 * Returns the respective sound (duck, goat, horse).
	 * @return the respective sound (duck, goat, horse).
	 */
	public void playSoundEffect()
	{
		soundEffect.play();
	}
}
