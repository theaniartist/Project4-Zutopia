import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.scene.input.MouseEvent;
import javafx.event.*;
import java.util.*;

public class GameImpl extends Pane implements Game {
	/*
	 *****************************************************************************************************************************************************
	 ***** ENUMERATIONS **********************************************************************************************************************************
	 *****************************************************************************************************************************************************
	 */
	/**
	 * Defines different states of the game.
	 */
	public enum GameState 
	{
		WON, LOST, ACTIVE, NEW
	}
	/*
	 *****************************************************************************************************************************************************
	 ***** CONSTANTS *************************************************************************************************************************************
	 *****************************************************************************************************************************************************
	 */
	/**
	 * The width of the game board.
	 */
	public static final int WIDTH = 400;
	/**
	 * The height of the game board.
	 */
	public static final int HEIGHT = 600;

	/**
	 * The height of where the images start
	 */
	public static final int NEW_HEIGHT = HEIGHT / 2;
	/*
	 *****************************************************************************************************************************************************
	 ***** INSTANCE VARIABLES / CONSTRUCTOR **************************************************************************************************************
	 *****************************************************************************************************************************************************
	 */
	private Ball ball;
	private Paddle paddle;
	private Animal[] animals = new Animal[16];
	private AudioClip backgroundMusic = null;
	private int ballBounceCount = 0;
	private int animalsRemaining = animals.length;
	/**
	 * Constructs a new GameImpl.
	 */
	public GameImpl () {
		setStyle("-fx-background-color: white;");

		restartGame(GameState.ACTIVE);
	}
	/*
	 *****************************************************************************************************************************************************
	 ***** PUBLIC METHODS ********************************************************************************************************************************
	 *****************************************************************************************************************************************************
	 */
	/**
	 * @return Returns the name of the game.
	 */
	public String getName () {
		return "Zutopia";
	}
	/**
	 * @return Returns the object calling this method.
	 */
	public Pane getPane () {
		return this;
	}
	/**
	 * Clears the board with whatever given state that has been passed in.
	 * @param state the state of the game currently
	 */
	private void restartGame (GameState state) {
		getChildren().clear();  // remove all components from the game

		// Create and add ball
		ball = new Ball();
		getChildren().add(ball.getCircle());  // Add the ball to the game board

		// Create and add paddle
		paddle = new Paddle();
		getChildren().add(paddle.getRectangle());  // Add the paddle to the game board
		
		//Creates a 4x4 board of images
		Image duck = new Image("duck.jpg");
		Image goat = new Image("goat.jpg");
		Image horse = new Image("horse.jpg");
		
		String duckSound = "quack.wav";
		String horseSound = "whinny.wav";
		String goatSound = "bleat.wav";
		
		//FIRST ROW
		animals[0] = new Animal(duck, duckSound, WIDTH/4 - 50, NEW_HEIGHT/12);
		animals[1] = new Animal(goat, goatSound, WIDTH/4 + 35, NEW_HEIGHT/12);
		animals[2] = new Animal(horse, horseSound,  WIDTH/2 + 25, NEW_HEIGHT/12);
		animals[3] = new Animal(duck, duckSound, (WIDTH/4)*3 + 25, NEW_HEIGHT/12);
		
		//SECOND ROW
		animals[4] = new Animal(goat, goatSound, WIDTH/4 - 50, NEW_HEIGHT/3);
		animals[5] = new Animal(horse, horseSound, WIDTH/4 + 35, NEW_HEIGHT/3);
		animals[6] = new Animal(duck, duckSound, WIDTH/2 + 25, NEW_HEIGHT/3);
		animals[7] = new Animal(goat, goatSound, (WIDTH/4)*3 + 25, NEW_HEIGHT/3);
		
		//THIRD ROW.
		animals[8] = new Animal(horse, horseSound, WIDTH/4 - 50, NEW_HEIGHT/3 + 75);
		animals[9] = new Animal(duck, duckSound, WIDTH/4 + 35, NEW_HEIGHT/3 + 75);
		animals[10] = new Animal(goat, goatSound, WIDTH/2 + 25, NEW_HEIGHT/3 + 75);
		animals[11] = new Animal(horse, horseSound, (WIDTH/4)*3 + 25, NEW_HEIGHT/3 + 75);
		
		//FOURTH ROW.
		animals[12] = new Animal(duck, duckSound, WIDTH/4 - 50, NEW_HEIGHT/2 + 100);
		animals[13] = new Animal(goat, goatSound, WIDTH/4 + 35, NEW_HEIGHT/2 + 100);
		animals[14] = new Animal(horse, horseSound, WIDTH/2 + 25, NEW_HEIGHT/2 + 100);
		animals[15] = new Animal(duck, duckSound, (WIDTH/4)*3 + 25, NEW_HEIGHT/2 + 100);

		for(int i = 0; i < animals.length; i++)
		{
			getChildren().add(animals[i].getSprite());
		}
		
		if(backgroundMusic != null)
		{
			backgroundMusic.stop();
		}
		backgroundMusic = new AudioClip(getClass().getClassLoader().getResource("Old MacDonald Had a Farm.wav").toString());
		backgroundMusic.play();
		
		// Add start message
		final String message;
		if (state == GameState.LOST) {
			message = "Game Over\n";
		} else if (state == GameState.WON) {
			message = "You won!\n";
		} else {
			message = "";
		}
		final Label startLabel = new Label(message + "Click mouse to start");
		startLabel.setLayoutX(WIDTH / 2 - 50);
		startLabel.setLayoutY(HEIGHT / 2 + 100);
		getChildren().add(startLabel);

		// Add event handler to start the game
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle (MouseEvent e) {
				GameImpl.this.setOnMouseClicked(null);

				// As soon as the mouse is clicked, remove the startLabel from the game board
				getChildren().remove(startLabel);
				run();
			}
		});

		// Add another event handler to steer paddle...
		setOnMouseMoved(new EventHandler<MouseEvent>()
				{
					@Override
					public void handle(MouseEvent event)
					{
						paddle.moveTo(event.getX(), event.getY());
					}
				});
	}
	/**
	 * Begins the game-play by creating and starting an AnimationTimer.
	 */
	public void run () {
		// Instantiate and start an AnimationTimer to update the component of the game.
		new AnimationTimer () {
			private long lastNanoTime = -1;
			public void handle (long currentNanoTime) {
				if (lastNanoTime >= 0) {  // Necessary for first clock-tick.
					GameState state;
					if ((state = runOneTimestep(currentNanoTime - lastNanoTime)) != GameState.ACTIVE) {
						// Once the game is no longer ACTIVE, stop the AnimationTimer.
						stop();
						// Restart the game, with a message that depends on whether
						// the user won or lost the game.
						restartGame(state);
					}
				}
				// Keep track of how much time actually transpired since the last clock-tick.
				lastNanoTime = currentNanoTime;
			}
		}.start();
	}
	/**
	 * Updates the state of the game at each timestep. In particular, this method should
	 * move the ball, check if the ball collided with any of the animals, walls, or the paddle, etc.
	 * @param deltaNanoTime how much time (in nanoseconds) has transpired since the last update
	 * @return the current game state
	 */
	public GameState runOneTimestep (long deltaNanoTime) {
		ball.updatePosition(deltaNanoTime);
		if(ball.intersect(paddle))
		{
			ball.resolve_collision(paddle);
		}
		
		for(int i = 0; i < animals.length; i++)
		{
			if(animals[i] != null)
			{
				if(ball.intersect(animals[i]))
				{
					ball.resolve_collision(animals[i]);
					getChildren().remove(animals[i].getSprite());
					animals[i] = null;
					animalsRemaining--;
					
					if(animalsRemaining == 0)
					{
						animalsRemaining = animals.length;
						ballBounceCount = 0;
						return GameState.WON;
					}
				}
			}
		}

		if (ball.getY() + Ball.BALL_RADIUS > HEIGHT) {
			ballBounceCount++;
			if (ballBounceCount == 5) {
				ballBounceCount = 0;
				animalsRemaining = animals.length;
				return GameState.LOST;
			}
		}

		return GameState.ACTIVE;
	}
}