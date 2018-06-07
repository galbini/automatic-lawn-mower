package com.mowitnow.automaticlawnmower.instruction;

import com.mowitnow.automaticlawnmower.GridPosition;
import com.mowitnow.automaticlawnmower.Instruction;
/**
 * turns mower to the left with a 90°
 * @author galbini
 *
 */
public class G implements Instruction {
	@Override
	public GridPosition nextPosition(GridPosition position) {
		if( position == null ) throw new IllegalArgumentException("position cannot be null");
		return new GridPosition(position.getX(), position.getY(), InstructionHelpers.getGMovements().get(position.getOrientation()));
	}
}
