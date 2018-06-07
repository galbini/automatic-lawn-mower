package com.mowitnow.automaticlawnmower;

import java.util.Set;
import java.util.TreeSet;

/**
 * Use to valid if one position is inside the grid and  is not occupied by another lawn mower.
 * @author galbini
 *
 */
public class GridPositionValidator {
	private final Integer maxX;
	private final Integer maxY;
	
	private Set<String> coordinates; // busy coordinate
	/**
	 * 
	 * @param maxX : the x coordinate of the top right corner of the grid.
	 * @param maxY : the y coordinate of the top right corner of the grid.
	 */
	GridPositionValidator(Integer maxX, Integer maxY) {
		super();
		this.maxX = maxX;
		this.maxY = maxY;
		coordinates = new TreeSet<>();
	}
	/**
	 * Validate if the new grip position if not outside the grid and not used by another mower.
	 * @param newGridPosition the position need check
	 * @return true if is a valide position otherwise false.
	 */
	public boolean validate(GridPosition newPosition){
		if(newPosition == null){
			throw new IllegalArgumentException("new position cannot be null");
		}
		
		return (newPosition.getX() <= maxX && newPosition.getY() <= maxY 
				&& !coordinates.contains(getStringCoordinate(newPosition)));
	}
	
	/**
	 * Add to a set the last position of a mower
	 * @param position the last position of a mower
	 */
	public void addUsedCoordinate(GridPosition position){
		if(position == null){
			throw new IllegalArgumentException("position cannot be null");
		}
		coordinates.add(getStringCoordinate(position));
	}
	
	private String getStringCoordinate(GridPosition position) {
		return position.getX()+"-"+position.getY();
	}
}
