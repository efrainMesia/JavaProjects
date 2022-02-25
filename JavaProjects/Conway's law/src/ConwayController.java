import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class ConwayController {
	
	private LifeMatrix lifeMatrix;
	private final int lifeMatrixX = 10;
	private final int lifeMatrixY = 10;
	private int counterClicks;
	private double widthCell;
	private double heightCell;
	
	
	
    @FXML
    private Button btn;

    @FXML
    private Canvas canv;

    private GraphicsContext gc;
    
    
    //Divide the Canvas to get a full usage of the canvas
    public void initialize() {
    	gc = canv.getGraphicsContext2D();
    	this.lifeMatrix = new LifeMatrix(lifeMatrixX,lifeMatrixY);
    	this.widthCell = canv.getWidth() / lifeMatrixX; 	// Divide by Matrix width
    	this.heightCell = canv.getHeight() / lifeMatrixY; // Divide by Matrix Height 
    	this.counterClicks = 0;
    }
    
    
    public void drawRect(double x, double y,Color Color)
    {
    	gc.setFill(Color);
    	gc.fillRect(x, y, this.widthCell, this.heightCell);
    }
    
    
    //It draws the Matrix. if the cell is True then we paint the cell as black. else we paint it to white
    public void drawMatrix()
    {
    	double startOfCanvasX = 0;
    	double startOfCanvasY = 0;
    	for (int x = 0; x < lifeMatrixX; x++) 
    	{
			for (int y = 0; y < lifeMatrixY; y++) 
			{
				if(this.lifeMatrix.getValueInCell(x,y))
				{
					this.drawRect(startOfCanvasX, startOfCanvasY, Color.BLACK);
				}
				else
				{
					
					this.drawRect(startOfCanvasX, startOfCanvasY, Color.WHITE);
				}
				startOfCanvasX +=  this.widthCell;
				
			}
			startOfCanvasY +=  this.heightCell;
			startOfCanvasX = 0;
		}
    }
    
    @FXML
    void btnNexGen(ActionEvent event)
    {
    	if(counterClicks == 1)
    	{
    		this.lifeMatrix.randomInitialize();
    	}
    	else 
    	{
    		this.lifeMatrix.nextGen();
    	}
    	this.drawMatrix();
    	counterClicks++;
    }

}
