/*This class creates a newWorld from the given input. The world consists of cell objects and a grid object.
 * The world is responsible for creating itself , regenrating itself and displaying its objects as a graph 
 * of 'X' and '-'.
 * */

package conway.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NewWorld {
	
	
	public static Map<CellMachine,CellGrid> world;

	
	public NewWorld(String fileUrl)
	{
		world = Collections.synchronizedMap(new LinkedHashMap<CellMachine,CellGrid>());
		
		File file = new File(fileUrl);
		

		
		try {
			
			int rowCount = 0;
			int colCount = 0;
			
			Scanner scan = new Scanner(file);
			List lines = new ArrayList();
			
			lines.add("");
			while(scan.hasNextLine())
			{
				//char[] inputLine = scan.nextLine().toCharArray();
				String temp = scan.nextLine().toString();
				lines.add(temp);
				colCount = temp.length();
				rowCount++;
				
			}
			lines.add("");
			
			String line ="";
			for(int rowNo=0;rowNo<rowCount+2; rowNo++)
			{
				for(int colNo=0;colNo<colCount+2; colNo++)
				
			
					if (colNo>=1 && colNo <=colCount && rowNo>=1 && rowNo<=rowCount)
					{	
						
						line = lines.get(rowNo).toString();
						line = " "+line+" ";
						char[] data = line.toCharArray();
			
						world.put(new CellMachine(rowNo, colNo, data[colNo]), new CellGrid(rowNo,colNo));						
					}
					else
					{
						world.put(new CellMachine(rowNo, colNo), new CellGrid(rowNo,colNo));
					}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(InvalidStateException se)
		{
			System.out.println(se.errorMessage);
			System.exit(0);
		}
		
	}
	
	public void showWorld()
	{
		Iterator it = this.world.keySet().iterator();
		int tempRow =0;
		
		while(it.hasNext())
		{
			CellMachine cm = (CellMachine)it.next();
			
			if(cm.getGridPosition().getRow() != tempRow)
			{
				System.out.println();
			}
			
			if(cm.getState() != null)
			{
				if(cm.getState().equals(cm.getAliveState()))
				{
					System.out.print("X");
				}
				
				if(cm.getState().equals(cm.getDeadState()))
				{
					System.out.print("-");
				}
			}
			else
			{
				System.out.print(" ");
			}

			tempRow = cm.getGridPosition().getRow();
			
			
			//System.out.println(cm.getGridPosition().getRow()+" "+cm.getGridPosition().getCol());
		}		
	}
	
	
	public void regenerate()
	{
		Map tickMap = new LinkedHashMap();
		Iterator it = this.world.keySet().iterator();
		List neighbours = new ArrayList();
		while(it.hasNext())
		{
			CellMachine cm = (CellMachine)it.next();
			neighbours.clear();
			neighbours = cm.getGridPosition().getNeighbours();			
			
			int N = Collections.frequency(neighbours, "X");
			tickMap.put(cm, N);
		
		}
		

		
		this.Tick(tickMap);
		
	}
	
	
	public void Tick(Map tm){
				
		Iterator it_key = tm.keySet().iterator();
		
		while(it_key.hasNext())
		{
			Object it = it_key.next();
			CellMachine cm = (CellMachine)it;
			int N = (Integer)tm.get(it);
			
			if(N<2 || N>3)
			{
				cm.neighboursOutOfBound();
			}
			if(N ==3)
			{
				cm.neighbourTrilogy();
			}
			
		}
		
	}
}
