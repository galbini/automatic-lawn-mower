package com.mowitnow.automaticlawnmower;

/**
 * The position on the grid
 * x: the horizontal coordinate
 * y: the vertical coordinate
 * orientation: the orientation according to English cardinal notation (N,E,W,S)
 * @author galbini
 *
 */
public class GridPosition {
	
	private Integer x;
	private Integer y;
	private Orientation orientation;
	/**
	 * 
	 * @param x the horizontal coordinate
	 * @param y the vertical coordinate
	 * @param orientation the orientation according to English cardinal notation
	 */
	public GridPosition(Integer x, Integer y, Orientation orientation) {
		
		if( x == null ) throw new IllegalArgumentException("x cannot be null");
		if( y == null ) throw new IllegalArgumentException("y cannot be null");
		if( orientation == null ) throw new IllegalArgumentException("orientation cannot be null");
		
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	public Orientation getOrientation() {
		return orientation;
	}

	@Override
	public String toString() {
		return x + " " + y + " " + orientation;
	}
	
	
}
