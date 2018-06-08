package com.mowitnow.automaticlawnmower;

import com.mowitnow.automaticlawnmower.instruction.A;
import com.mowitnow.automaticlawnmower.instruction.D;
import com.mowitnow.automaticlawnmower.instruction.G;

/**
 * An instruction is an order to the lawn mower.
 * There are 3 type of instructions
 * 	D : turns mower to the right with a 90°
 *  G : turns mower to the left with a 90°
 *  A : moves mower of one box in the direction it faces
 *  @see A
 *  @see D
 *  @see G
 * @author galbini
 *
 */
public interface Instruction {
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

