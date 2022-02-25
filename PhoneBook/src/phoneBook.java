import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class phoneBook extends Application{ 
	
	public void start(Stage stage) throws Exception{ 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("phoneBook.fxml"));
		Parent root = loader.load();
		phoneBookController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage1 = new Stage();
		stage1.setTitle("phoneBook"); 
		stage1.setScene(scene); 
		//save the status once "X" for exit is pressed
		stage1.setOnHidden(e -> {
			controller.saveToFile();	
		    Platform.exit();
		});
		stage1.show(); 
	} 
	
	public static void main(String[] args) { 
		launch(args); 
		System.out.println();
	} 
}