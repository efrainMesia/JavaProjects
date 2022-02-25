package A2021_m78_question2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;


public class ClientController {

    @FXML
    private Canvas canv;

    private GraphicsContext gc;
    private Point2D savedClicked;
    @FXML
    public void initialize() {
    	gc = canv.getGraphicsContext2D();
    	this.savedClicked = null;
    }

    
    @FXML
    void clear(ActionEvent event) {
    	gc.clearRect(0, 0, this.canv.getWidth(), this.canv.getHeight());

    }
    
    @FXML
    void click(MouseEvent event) {
    	Point2D clickPoint = new Point2D(event.getX(),event.getY());
	    if(savedClicked == null) {
	    	this.savedClicked = clickPoint;
	    }
    	else {
    		Rect r = new Rect(
    					Math.min(savedClicked.getX(), clickPoint.getX()),
    					Math.min(savedClicked.getY(), clickPoint.getY()),
    					Math.abs(savedClicked.getX() - clickPoint.getX()),
    					Math.abs(savedClicked.getY() - clickPoint.getY()));
    		gc.strokeRect(r.getX(),r.getY(),r.getWidth(),r.getHeight());
    		new ClientThread("127.0.0.1", r).start();
    		savedClicked = null;
    	}
    }

}
