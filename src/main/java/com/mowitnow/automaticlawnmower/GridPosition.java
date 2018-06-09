package com.mowitnow.automaticlawnmower;

/**
 * The position on the virtual grid on the lawn
 * <ul>
 * <li>x: the horizontal coordinate
 * <li>y: the vertical coordinate
 * <li>orientation: the orientation according to English cardinal notation (N,E,W,S)
 * </ul>
 * @author galbini
 *
 */
public class GridPosition {
	
	private final Integer x;
	private final Integer y;
	private final Orientation orientation;
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
