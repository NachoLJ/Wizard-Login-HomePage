package application;




import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controlador3 {

	@FXML
	private AnchorPane wizard1;

	@FXML
	private AnchorPane wizard2;

	@FXML
	private AnchorPane wizard3;

	@FXML
	private Label countLabel;
	


	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	public void initialize() {
		translateAnimation(0.5, wizard2, 600);
		translateAnimation(0.5, wizard3, 600);
	}

	int showSlide = 0;

	@FXML
	void nextAction() {

		if (showSlide == 0) {
			translateAnimation(0.5, wizard2, -600);
			showSlide++; // showSlide=1
			countLabel.setText("2/3");
		} else if (showSlide == 1) {

			translateAnimation(0.5, wizard3, -600);
			showSlide++; // showSlide=2
			countLabel.setText("3/3");

		} else {
			showHome();
		}

	}

	private void showHome() {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
            AnchorPane root1 = fxmlLoader.load();
            Stage stage = new Stage();
            //stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1));  
            stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
			
	}

	@FXML
	void backAction() {

		if (showSlide == 0) {
			System.out.println("No more slides");
		} else if (showSlide == 1) {
			translateAnimation(0.5, wizard2, 600);
			showSlide--; // showSlide=0
			countLabel.setText("1/3");
		} else if (showSlide == 2) {
			translateAnimation(0.5, wizard3, 600);
			showSlide--; // showSlide=1
			countLabel.setText("2/3");
		}

	}
}
