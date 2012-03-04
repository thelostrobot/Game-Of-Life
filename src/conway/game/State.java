/*This is a standard interface that defines a State and its transition.
 * This design is based on a state machine which I derived from the rules. 
 * */
package conway.game;

public interface State {
	
	void neighboursOutOfBound();
	void neighbourTrilogy();
	
}
