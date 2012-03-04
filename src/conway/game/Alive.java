/* This class implements the State Interface. It decides the state transition for an 
 * alive cell to dead or alive based on Conway's Rule*/

package conway.game;


public class Alive implements State {

	CellMachine cell;
	
	public Alive(CellMachine cell)
	{
		this.cell = cell;
	}
	 
	public void neighboursOutOfBound()
	{
		cell.setState(cell.getDeadState());
	}
	
	public void neighbourTrilogy()
	{
		//System.out.println("No change");
	}
		
}
