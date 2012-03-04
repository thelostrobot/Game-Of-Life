/* This class implements the State Interface. It decides the state transition for a
 * dead cell to dead or alive based on Conway's Rule*/

package conway.game;

public class Dead implements State{
	
	CellMachine cell;
	
	public Dead(CellMachine cell)
	{
		this.cell = cell;
	}
		
	public void neighboursOutOfBound()
	{
		//System.out.println("No change");
	}
	
	public void neighbourTrilogy()
	{
		cell.setState(cell.getAliveState());
	}
	
}
