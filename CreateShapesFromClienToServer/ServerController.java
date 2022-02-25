package A2021_m78_question2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.*;



public class ServerController {

    @FXML
    private Canvas canv;

    private GraphicsContext gc;
    private Server srv;
    @FXML
    public void initialize() {
    	gc = canv.getGraphicsContext2D();
    	srv = new Server(this);
    	srv.start();
    }
    @FXML
    void clear(ActionEvent event) {
    	gc.clearRect(0, 0, this.canv.getWidth(), this.canv.getHeight());
    }
	public void drawRect(Rect r) {
		gc.strokeRect(r.getX(),r.getY(),r.getWidth(),r.getHeight());
	}

}
