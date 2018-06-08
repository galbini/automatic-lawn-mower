package com.mowitnow.automaticlawnmower.instruction;

import com.mowitnow.automaticlawnmower.GridPosition;
import com.mowitnow.automaticlawnmower.Instruction;

/**
 * Turns mower to the right with a 90°
 * <ul>
 * <li>N to E
 * <li>E to S
 * <li>S to W
 * <li>W to N
 * </ul>
 * @author galbini
 *
 */
public class D implements Instruction {
	
	protected D() {
		
	}
	
	@Override
	public GridPosition nextPosition(GridPosition position) {
		if( position == null ) throw new IllegalArgumentException("position cannot be null");
		return new GridPosition(position.getX(), position.getY(), InstructionHelpers.getDMovements().get(position.getOrientation()));
	}
}
