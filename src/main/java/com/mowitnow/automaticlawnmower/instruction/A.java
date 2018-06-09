package com.mowitnow.automaticlawnmower.instruction;

import com.mowitnow.automaticlawnmower.GridPosition;
import com.mowitnow.automaticlawnmower.Instruction;
import com.mowitnow.automaticlawnmower.Orientation;
/**
 * These instruction moves lawn mower of one case in the direction it faces.<br>
 * <ul>
 * <li>if orientation is N so lawn mower move to y + 1.
 * <li>if orientation is S so lawn mower move to y - 1.
 * <li>if orientation is E so lawn mower move to x + 1.
 * <li>if orientation is W so lawn mower move to x - 1.
 * </ul>
 */
public class A implements Instruction {
	
	protected A() {
		
	}

	@Override
	public GridPosition nextPosition(GridPosition position) {
		
		if( position == null ) throw new IllegalArgumentException("position cannot be null");
		
		if(Orientation.N.equals(position.getOrientation())){
			return new GridPosition(position.getX(), position.getY()+1, position.getOrientation());
		}else if(Orientation.S.equals(position.getOrientation())){
			return new GridPosition(position.getX(), position.getY()-1, position.getOrientation());
		}else if(Orientation.E.equals(position.getOrientation())){
			return new GridPosition(position.getX()+1, position.getY(), position.getOrientation());
		}else if(Orientation.W.equals(position.getOrientation())){
			return new GridPosition(position.getX()-1, position.getY(), position.getOrientation());
		}else{
			throw new RuntimeException("Orientation not managed "+position.getOrientation());
		}
	}
}
