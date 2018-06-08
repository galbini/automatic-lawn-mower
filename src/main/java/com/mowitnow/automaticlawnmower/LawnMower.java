package com.mowitnow.automaticlawnmower;

import java.util.Queue;
import java.util.logging.Logger;

/**
 * Lawn mower used to mow a rectangular surface divided in a grid.
 * Lawn mower has a position in the grid and a list of instructions
 * @see Instruction
 * @see GridPosition
 * @see GridPositionValidator
 * @author galbini
 *
 */
public class LawnMower {
	private Logger logger = Logger.getLogger(LawnMower.class.toString());
	private GridPosition position;
	private final GridPositionValidator validator;
	private final Queue<Instruction> instructions;
	/**
	 * The lawn mower is initialized with its initial position and all instructions.
	 * @param initialPosition the initial position on the grid.
	 * @param instructions the list of all instructions.
	 * @param validator the grid position validator
	 */
	public LawnMower(GridPosition initialPosition, Queue<Instruction> instructions, GridPositionValidator validator) {
		if( initialPosition == null ) throw new IllegalArgumentException("initialPosition cannot be null");
		if( instructions == null ) throw new IllegalArgumentException("instructions cannot be null");
		if( validator == null ) throw new IllegalArgumentException("validator cannot be null");
		
		this.position = initialPosition;
		this.instructions = instructions;
		this.validator = validator;
	}
	
	/**
	 * Execute all the instructions and return the last position on the grid
	 * At each instruction set the new position in GridPositionValidator and remove the previous
	 * @see GridPositionValidator
	 * @return the last grid position
	 */
	public GridPosition run(){
		
		instructions.forEach(i -> {
			GridPosition newPosition = i.nextPosition(position);
			logger.info("new position is "+newPosition.toString());
			if(validator.validate(position, newPosition)){
				validator.addUsedCoordinate(newPosition);
				GridPosition oldPosition = position;
				position = newPosition;
				validator.removeUnusedCoordinate(oldPosition);
				
			}else{
				logger.warning("Position is not valid "+newPosition.toString()+" keep on the current position");
				//if position is not valid, mower keep at the current position and execute next instruction
			}
		});
		
		return position;
	}
}
