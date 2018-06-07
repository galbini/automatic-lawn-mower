package com.mowitnow.automaticlawnmower;

import java.util.Queue;

/**
 * Lawn mower used to mow a rectangular surface divided in a grid.
 * Lawn mower has a position in the grid and a list of instructions
 * @see Instruction
 * @see GridPosition
 * @author galbini
 *
 */
public class LawnMower {
	private GridPosition position;
	private final Queue<Instruction> instructions;
	/**
	 * The lawn mower is initialized with its initial position and all instructions.
	 * @param initialPosition the initial position on the grid.
	 * @param instructions the list of all instructions.
	 */
	public LawnMower(GridPosition initialPosition, Queue<Instruction> instructions) {
		super();
		this.position = initialPosition;
		this.instructions = instructions;
	}
	
	/**
	 * Execute all the instructions and return the last position on the grid
	 * @return
	 */
	public GridPosition run(){
		
		instructions.forEach(i -> position = i.nextPosition(position));
		
		return position;
	}
}
