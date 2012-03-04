/* A JUnit Test Case driver. It displays the output for the block, boat, blinker and toad patterns.
 * */

package conway.game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class StateMachineDriver extends TestCase {
	
	
	public StateMachineDriver(String name) 
	{
		super(name);
	}
	
	public void testBlock() 
	{
		
		NewWorld world = new NewWorld("block.txt");			
		
		System.out.println("\nInput:\n");
		world.showWorld();		
		
		world.regenerate();
		
		System.out.println("\nOutput:\n");
		world.showWorld();		
	}
	
	public void testBoat() 
	{
		
		NewWorld world = new NewWorld("boat.txt");			
		
		System.out.println("\nInput:\n");
		world.showWorld();		
		
		world.regenerate();
		
		System.out.println("\nOutput:\n");
		world.showWorld();		
	}
	
	public void testBlinker() 
	{
		
		NewWorld world = new NewWorld("blinker.txt");			
		
		System.out.println("\nInput:\n");
		world.showWorld();		
		
		world.regenerate();
		
		System.out.println("\nOutput:\n");
		world.showWorld();		
	}
	
	public void testToad() 
	{
		
		NewWorld world = new NewWorld("toad.txt");			
		
		System.out.println("\nInput:\n");
		world.showWorld();		
		
		world.regenerate();
		
		System.out.println("\nOutput:\n");
		world.showWorld();		
	}
	
	
	public static Test suite() 
	{
		TestSuite suite = new TestSuite();
		suite.addTest(new StateMachineDriver("testBlock"));
		suite.addTest(new StateMachineDriver("testBoat"));
		suite.addTest(new StateMachineDriver("testBlinker"));
		suite.addTest(new StateMachineDriver("testToad"));

		return suite;
	}
}
