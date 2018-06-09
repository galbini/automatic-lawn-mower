package com.mowitnow.automaticlawnmower;

import com.mowitnow.automaticlawnmower.instruction.A;
import com.mowitnow.automaticlawnmower.instruction.D;
import com.mowitnow.automaticlawnmower.instruction.G;

/**
 * An instruction is an order to the lawn mower.<br>
 * There are 3 type of instructions
 * <ul>
 *  <li>A : moves mower of one box in the direction it faces
 * 	<li>D : turns mower to the right with a 90°
 *  <li>G : turns mower to the left with a 90°
 *  </ul>
 *  @see A
 *  @see D
 *  @see G
 * @author galbini
 *
 */
public interface Instruction {
	/**
	 * The instruction type : A, D and G
	 * @author Guillaume
	 *
	 */
	public enum InstructionType {
		A,
		D,
		G
	}
	
	/**
	 * Compute the next position
	 * @param position the current position
	 * @return the new position
	 */
	public GridPosition nextPosition(GridPosition position);

	
}

