/* A custom Exception Handling class. It ensures no invalid inputs are accepted as States for a cell.
 * */

package conway.game;

public class InvalidStateException extends Exception{

	String errorMessage;
	
	
	public InvalidStateException(String msg)
	{
		super(msg);
		errorMessage = msg;
	}
	public String getErrorMessage()
	{
		return errorMessage;
	}
	
}
