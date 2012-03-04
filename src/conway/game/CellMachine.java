/*CellMachine is the controller of the cell objects. It is responsible for creating cells 
 * and assigning state as alive or dead. It also has the ability to change the state of a cell.
 * */

package conway.game;

import java.util.List;

public class CellMachine {
	
	private State alive;
	private State dead;
	private State state;
	
	
	
	private CellGrid cellGrid;
	
	public CellMachine(int x, int y) 
	{
		alive = new Alive(this);
		dead = new Dead(this);
		cellGrid = new CellGrid(x,y);
		
	}
	
	public CellMachine(int x, int y, char state) throws InvalidStateException
	{
		alive = new Alive(this);
		dead = new Dead(this);
		cellGrid = new CellGrid(x,y);

		
		if(state == 'X')
		{
			this.setState(alive);
		}
		else if(state == '-')
		{
			this.setState(dead);
		}	
		else
		{
			throw new InvalidStateException("InvalidStateException: Unknown state encountered.");
		}
	}
	
	void setState(State state)
	{
		this.state = state;
	}
	
	State getState()
	{
		return this.state;
	}
	
	CellGrid getGridPosition()
	{
		return this.cellGrid;
	}
	
	State getAliveState()
	{
		return this.alive;
	}
	
	State getDeadState()
	{
		return this.dead;
	}
	
	public void neighboursOutOfBound()
	{
		if(state != null)
		{
			state.neighboursOutOfBound();	
		}
	}
	
	public void neighbourTrilogy()
	{
		if(state == null)
		{
			this.setState(dead);
		}
		state.neighbourTrilogy();
	}
	
}
