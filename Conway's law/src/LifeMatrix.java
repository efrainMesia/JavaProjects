import java.util.Random;

public class LifeMatrix {
	
	private boolean lifeMat[][];
	private final int NEIGHBORS = 1;
	private final boolean DEAD = false;	//false means dead. True means alive
	private final boolean ALIVE = true;
	private final int GOALIVE = 3;
	private final int GODIE =1;
	private final int GODIE2 = 4;
	
		
	/* Life Matrix class represent the life of an organism, according to Conway theory.
	 * LifeMatrix has only one attribute which is a boolean Matrix.
	 * 1. It creates a boolean Matrix which first state is all cells are false.
	 * 2. Function randomInitialize - initialize the matrix to start checking Conway's theory
	 * 3. NextGen function - Checks all conway's condition. and creates a temp matrix and then main matrix will be equal to the temp Matrix.
	 */
	
	
	
	
	public LifeMatrix(int x , int y)
	{
		this.lifeMat = new boolean[x][y];
		for (int i = 0; i < lifeMat.length; i++) //initialize the Matrix to all false
		{
			for (int j = 0; j < lifeMat[i].length; j++) 
			{
				this.lifeMat[i][j]= false;
			}
		}
	}
	
	//Get status returns how many neighbors are in current state "life"
	//i.e getStatus("alive") -> returns 3
	public int getStatusNeighbors(boolean life, int x, int y)
	{
		int counter =0;
		int neighboursBehindX = getBorderX(x - NEIGHBORS);
		int neighboursInFrontX = getBorderX(x + NEIGHBORS);
		int neighboursBehindY = getBorderY(y - NEIGHBORS);
		int neighboursInFrontY = getBorderY(y + NEIGHBORS);
		
		for (int i = neighboursBehindX; i <= neighboursInFrontX; i++) 
		{
			for (int j = neighboursBehindY; j <= neighboursInFrontY; j++)
			{
				if(this.lifeMat[i][j] == life && !(i==x && j ==y)) // if neighbor match the current state & also avoid check of same input
				{
					counter++;
				}
			}
		}
		return counter;
	}
	
	
	public int getBorderX(int x)
	{
		if(x<0) // checking if out of borders X (0,y) of matrix
		{
			x = 0;
		}
		if(x >= this.lifeMat.length) // checking if out of borders X (X+1,y) of matrix
		{
			x = x-NEIGHBORS; // setting it as X so we wont go out of borders X of matrix
		}
		return x;	
	}
	
	public boolean getValueInCell(int x , int y)
	{
		return this.lifeMat[x][y];
	}
	
	public int getBorderY(int y)
	{
		if(y<0) // checking if out of borders Y (0,y) of matrix
		{
			y = 0;
		}
		if(y >= this.lifeMat[0].length) // checking if out of borders Y (x,y+1) of matrix
		{
			y = y - NEIGHBORS; // setting it as Y-1 so we wont go out of borders Y of matrix
		}
		return y;	
	}
	
	//Creates a temp matrix, and go through the lifeMat and calculates the next generation
	//the changes are made on temp matrix and then change to lifeMat
	public void nextGen()
	{
		int neighboursAlive =0;
		boolean[][] temp = new boolean[this.lifeMat.length][this.lifeMat[0].length];
		for (int i = 0; i < this.lifeMat.length; i++) 
		{
			for (int j = 0; j < this.lifeMat[i].length; j++) 
			{
				neighboursAlive = this.getStatusNeighbors(ALIVE, i, j);
				if((this.lifeMat[i][j] == DEAD && neighboursAlive == GOALIVE) || 								//if no life &  3 neighbors are alive then it goes alive
					this.lifeMat[i][j] == ALIVE && (neighboursAlive > GODIE && neighboursAlive < GODIE2))		//if alive & there is 2 or 3 neighbors alive then stays alive
				{
					temp[i][j] = ALIVE;
				}
				else
				{
					temp[i][j] = DEAD;
				}
			}
		}
		this.lifeMat = temp;
	}
	
	//Creates a random matrix, in matrix there is true or false
	public void randomInitialize()
	{
		Random r = new Random();

		for (int i = 0; i < lifeMat.length; i++) {
			for (int j = 0; j < lifeMat[i].length; j++) {
				lifeMat[i][j]= r.nextBoolean();
			}
		}
	}
	
	
	
}
