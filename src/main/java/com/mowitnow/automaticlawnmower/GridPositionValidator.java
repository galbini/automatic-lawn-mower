package com.mowitnow.automaticlawnmower;

import java.util.Set;
import java.util.TreeSet;

/**
 * GridPositionValidator is used to valid if one position is inside the grid and is not occupied by another lawn mower.
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
	public GridPositionValidator(Integer maxX, Integer maxY) {
		if( maxX == null ) throw new IllegalArgumentException("maxX cannot be null");
		if( maxY == null ) throw new IllegalArgumentException("y cannot be null");
		
		this.maxX = maxX;
		this.maxY = maxY;
		coordinates = new TreeSet<>();
	}
	/**
	 * Validate if the new grid position if not outside the grid and not used by another mower.
	 * Need to compare with the current position in case we change only the  orientation.
	 * 
	 * @param currentPosition the current position
	 * @param newPosition the position need check
	 * @return true if is a valide position otherwise false.
	 */
	public boolean validate(GridPosition currentPosition, GridPosition newPosition){
		if(currentPosition == null) throw new IllegalArgumentException("current position cannot be null");
		if(newPosition == null) throw new IllegalArgumentException("new position cannot be null");
		
		return (newPosition.getX() <= maxX && newPosition.getY() <= maxY 
				&& (getStringCoordinate(newPosition).equals(getStringCoordinate(currentPosition)) 
						|| (!getStringCoordinate(newPosition).equals(getStringCoordinate(currentPosition)) 
						&& !coordinates.contains(getStringCoordinate(newPosition)))));
	}
	
	/**
	 * Add to a set the last position of a mower
	 * @param position the last position of a mower
	 */
	public void addUsedCoordinate(GridPosition position){
		if(position == null) throw new IllegalArgumentException("position cannot be null");
		
		coordinates.add(getStringCoordinate(position));
	}
	
	private String getStringCoordinate(GridPosition position) {
		return position.getX()+"-"+position.getY();
	}
	/**
	 * Remove an unused position
	 * @param position the old position
	 */
	public void removeUnusedCoordinate(GridPosition position) {
		if(position == null) throw new IllegalArgumentException("position cannot be null");
		coordinates.remove(getStringCoordinate(position));
		
	}
}
