import java.awt.Label;
import javafx.scene.Node;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class ImageLoader {
	
	//Constants
	
	public static final int NEW_HEIGHT = GameImpl.HEIGHT/2;
	
	private Image duckImage;
	private Image goatImage;
	private Image horseImage;
	
	private ImageView _duckIV;
	private ImageView _goatIV;
	private ImageView _horseIV;
	
	private ImageView _duckIV2;
	private ImageView _goatIV2;
	private ImageView _horseIV2;
	
	private ImageView _duckIV3;
	private ImageView _goatIV3;
	private ImageView _horseIV3;
	
	private ImageView _duckIV4;
	private ImageView _goatIV4;
	private ImageView _horseIV4;
	
	private ImageView duckIV;
	private ImageView goatIV;
	private ImageView horseIV;
	
	private ImageView _duckIV12;
	
	private ImageView board;
	
	public ImageLoader () {
		
		duckImage = new Image ("file:///C:/Users/aniartist/Documents/Zutopia/Project4/duck.jpg");
		goatImage = new Image("file:///C:/Users/aniartist/Documents/Zutopia/Project4/goat.jpg");
		horseImage = new Image("file:///C:/Users/aniartist/Documents/Zutopia/Project4/horse.jpg");
		
		duckIV = new ImageView();
		duckIV.setImage(duckImage);
		
		goatIV = new ImageView();
		goatIV.setImage(goatImage);		
		
		horseIV = new ImageView();
		horseIV.setImage(horseImage);
		
		_duckIV = new ImageView();
		_duckIV.setImage(duckImage);
		
		_goatIV = new ImageView();
		_goatIV.setImage(goatImage);
		
		_horseIV = new ImageView();
		_horseIV.setImage(horseImage);
		
		_duckIV2 = new ImageView();
		_duckIV2.setImage(duckImage);
		
		_goatIV2 = new ImageView();
		_goatIV2.setImage(goatImage);
		
		_horseIV2 = new ImageView();
		_horseIV2.setImage(horseImage);
		
		_duckIV3 = new ImageView();
		_duckIV3.setImage(duckImage);
		
		_goatIV3 = new ImageView();
		_goatIV3.setImage(goatImage);
		
		_horseIV3 = new ImageView();
		_horseIV3.setImage(horseImage);
		
		_duckIV4 = new ImageView();
		_duckIV4.setImage(duckImage);
		
		_goatIV4 = new ImageView();
		_goatIV4.setImage(goatImage);
		
		_horseIV4 = new ImageView();
		_horseIV4.setImage(horseImage);
		
		_duckIV12 = new ImageView();
		_duckIV12.setImage(duckImage);
		
				//FIRST ROW
				
				//first duck image, first row
				_duckIV.setLayoutX(GameImpl.WIDTH/4 - 50);
				_duckIV.setLayoutY(NEW_HEIGHT/12);
				
				//second goat image, first row
				_goatIV2.setLayoutX((GameImpl.WIDTH/4) + 35);
				_goatIV2.setLayoutY(NEW_HEIGHT/12);
				
				//third horse image, first row
				_horseIV3.setLayoutX((GameImpl.WIDTH/2) + 25);
				_horseIV3.setLayoutY(NEW_HEIGHT/12);
				
				//fourth duck image, first row
				_duckIV4.setLayoutX((GameImpl.WIDTH/4)*3 + 25);
				_duckIV4.setLayoutY(NEW_HEIGHT/12);
				
				
				//SECOND ROW
				
				//first goat image, second row
				_goatIV.setLayoutX(GameImpl.WIDTH/4 - 50);
				_goatIV.setLayoutY(NEW_HEIGHT/3);
				
				//second horse image, second row 
				_horseIV2.setLayoutX((GameImpl.WIDTH/4) + 35);
				_horseIV2.setLayoutY(NEW_HEIGHT/3);
				
				//third duck image, second row
				_duckIV3.setLayoutX((GameImpl.WIDTH/2) + 25);
				_duckIV3.setLayoutY(NEW_HEIGHT/3);
				
				//fourth goat image, second row
				_goatIV4.setLayoutX((GameImpl.WIDTH/4)*3 + 25);
				_goatIV4.setLayoutY(NEW_HEIGHT/3);
				
				
				//THRID ROW
				
				//first horse image, third row
				_horseIV.setLayoutX(GameImpl.WIDTH/4 - 50);
				_horseIV.setLayoutY((NEW_HEIGHT/3) + 75);
			
				//second duck image, third row 
				_duckIV2.setLayoutX((GameImpl.WIDTH/4) + 35);
				_duckIV2.setLayoutY((NEW_HEIGHT/3) + 75);
				
				//third goat image, third row
				_goatIV3.setLayoutX((GameImpl.WIDTH/2) + 25);
				_goatIV3.setLayoutY((NEW_HEIGHT/3) + 75);
				
				//fourth horse image, third row
				_horseIV4.setLayoutX((GameImpl.WIDTH/4)*3 + 25);
				_horseIV4.setLayoutY((NEW_HEIGHT/3) + 75);
		
				
				//FOURTH ROW
				
				//first duck image, fourth row
				_duckIV12.setLayoutX(GameImpl.WIDTH/4 - 50);
				_duckIV12.setLayoutY((NEW_HEIGHT/2) + 100);
				
				//second goat image, fourth row 
				_goatIV.setLayoutX((GameImpl.WIDTH/4) + 35);
				_goatIV.setLayoutY((NEW_HEIGHT/2) + 100);
				
				//third horse image, fourth row
				horseIV.setLayoutX((GameImpl.WIDTH/2) + 25);
				horseIV.setLayoutY((NEW_HEIGHT/2) + 100);
				
				//fourth duck image, fourth row
				duckIV.setLayoutX((GameImpl.WIDTH/4)*3 + 25);
				duckIV.setLayoutY((NEW_HEIGHT/2) + 100);
		
	}
	
	public ImageView getHorse() {
		
		return horseIV;
	}
	
	public ImageView getDuck() {
		
		return duckIV;
	}
	
	public ImageView getGoat() {
		
		return goatIV;
	}
	
	public ImageView getFirstHorse() {
		
		return _horseIV;
	}
	
	public ImageView getFirstDuck() {
		
		return _duckIV;
	}
	
	public ImageView getFirstGoat() {
		
		return _goatIV;
	}
	
	public ImageView getSecondHorse() {
		
		return _horseIV2;
	}
	
	public ImageView getSecondDuck() {
		
		return _duckIV2;
	}

	public ImageView getSecondGoat() {
	
		return _goatIV2;
	}
	
	public ImageView getThirdHorse() {
		
		return _horseIV3;
	}
	
	public ImageView getThirdDuck() {
		
		return _duckIV3;
	}
	
	public ImageView getThirdGoat() {
		
		return _goatIV3;
	}
	
	public ImageView getFourthHorse() {
		
		return _horseIV4;
	}
	
	public ImageView getFourthDuck() {
		
		return _duckIV4;
	}
	
	public ImageView getFourthGoat() {
		
		return _goatIV4;
	}
	
	public ImageView getFirstDuckFourth() {
		
		return _duckIV12;
	}
	
	
}
