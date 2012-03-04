/* The CellGrid is a class that holds all the information regarding each cell location on the grid.
 * It knows the neighbours of a cell and can return a list of alive neightbours.
 * 
 * */

package conway.game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class CellGrid {

	
	private  int row,col;
	private List<String> neighbours;
	
	public CellGrid(int row, int col)
	{
		this.row = row;
		this.col =  col;
		this.neighbours = new ArrayList();
	}
	
	public int getRow()
	{
		return this.row;
	}
	public int getCol()
	{
		return this.col;
	}
	
	
	public void addNeighbour(int x, int  y) throws InvalidStateException
	{
		
		CellMachine cmKey = getKeyByValue(new CellGrid(x,y));
		
		if(cmKey != null)
		{
			if(cmKey.getState() == null)
			{
				cmKey.setState(cmKey.getDeadState());
				neighbours.add("-");
			}
			else
			{
				if(cmKey.getState().equals(cmKey.getAliveState()))
				{
					neighbours.add("X");
				}
				if(cmKey.getState().equals(cmKey.getDeadState()))
				{
					neighbours.add("-");
				}
			}
		}
		else
		{
			cmKey = new CellMachine(x, y, '-');
			neighbours.add("-");
		}
		
	}
	
	public List getNeighbours()
	{	
		int x = this.row;
		int y = this.col;
		
		try {
			
			this.addNeighbour(x-1,y);
			this.addNeighbour(x+1,y-1);
			this.addNeighbour(x+1,y);
			this.addNeighbour(x+1,y+1);
			this.addNeighbour(x,y+1);
			this.addNeighbour(x-1,y+1);
			this.addNeighbour(x,y-1);
			this.addNeighbour(x-1,y-1);
			
		} catch (InvalidStateException e) {

			e.printStackTrace();
		}
		
	
		
		
		return this.neighbours;
	}
	
	public static <CellMachine, CellGrid> CellMachine getKeyByValue(CellGrid value) {
        
		Comparator<CellGrid> cellCom = new CellComparator();
		
		for (Entry entry : NewWorld.world.entrySet()) {
	        if (cellCom.compare(value,(CellGrid)entry.getValue()) == 1) {
	            return (CellMachine)entry.getKey();
	        }
	    }
	    return null;
	}


	
	
	
}
