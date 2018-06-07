package com.mowitnow.automaticlawnmower;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridPosistionValidatorTest {

	@Test
	public void testInsideGrid() {
		GridPosition position = new GridPosition(2, 7, Orientation.N);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		
		assertTrue(validator.validate(position));
	}

	@Test
	public void testOutsideGrid() {
		GridPosition position = new GridPosition(11, 11, Orientation.N);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		
		assertFalse(validator.validate(position));
	}
	
	@Test
	public void testXOutsideGrid() {
		GridPosition position = new GridPosition(11, 8, Orientation.N);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		
		assertFalse(validator.validate(position));
	}
	
	@Test
	public void testYOutsideGrid() {
		GridPosition position = new GridPosition(8, 11, Orientation.N);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		
		assertFalse(validator.validate(position));
	}
	
	
	@Test
	public void testBusyPosition() {
		GridPosition position = new GridPosition(5, 8, Orientation.N);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		validator.addUsedCoordinate(position);
		assertFalse(validator.validate(position));
	}
	
}
