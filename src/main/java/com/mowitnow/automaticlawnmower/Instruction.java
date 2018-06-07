package com.mowitnow.automaticlawnmower;

/**
 * An instruction is an order to the lawn mower
 * There are 3 type of instructions
 * 	D : turns mower to the right with a 90°
 *  G : turns mower to the left with a 90°
 *  A : moves mower of one box in the direction it faces
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

