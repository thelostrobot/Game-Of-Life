/* This is a customised comparator that implements the Comparator interface.
 * It compares if two cells are having the same location in the cell grid.
 * */

package conway.game;

import java.util.Comparator;

public class CellComparator implements Comparator {
	
	public int compare(Object cellGrid1, Object cellGrid2){    
		
       
        int cellGrid1Row = ((CellGrid)cellGrid1).getRow();       
        int cellGrid2Row = ((CellGrid)cellGrid2).getRow();  
        
        int cellGrid1Col = ((CellGrid)cellGrid1).getCol();     
        int cellGrid2Col = ((CellGrid)cellGrid2).getCol();  
       
	       if( (cellGrid1Row==cellGrid2Row) && (cellGrid1Col == cellGrid2Col) )
	       {
	    	   return 1;
	       }
	       else
	       {
	    	   return 0;
	       }
   
    }

}
