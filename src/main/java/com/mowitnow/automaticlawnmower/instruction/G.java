package com.mowitnow.automaticlawnmower.instruction;

import com.mowitnow.automaticlawnmower.GridPosition;
import com.mowitnow.automaticlawnmower.Instruction;
/**
 * This instruction turns mower to the left with a 90°.<br>
 * <ul>
 * <li>N to W
 * <li>W to S
 * <li>S to E
 * <li>E to N
 * </ul>
 * @author galbini
 *
 */
public class G implements Instruction {
	
	protected G() {
		
	}
	
	@Override
	public GridPosition nextPosition(GridPosition position) {
		if( position == null ) throw new IllegalArgumentException("position cannot be null");
		return new GridPosition(position.getX(), position.getY(), InstructionHelper.getGMovements().get(position.getOrientation()));
	}
}
