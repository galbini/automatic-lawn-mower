package com.mowitnow.automaticlawnmower;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridPositionValidatorTest {

	@Test
	public void testInsideGrid() {
		GridPosition currentPosition = new GridPosition(1, 7, Orientation.N);
		GridPosition position = new GridPosition(2, 7, Orientation.N);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		
		assertTrue(validator.validate(currentPosition, position));
	}

	@Test
	public void testOutsideGrid() {
		GridPosition currentPosition = new GridPosition(10, 10, Orientation.N);
		GridPosition position = new GridPosition(11, 11, Orientation.N);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		
		assertFalse(validator.validate(currentPosition, position));
	}
	
	@Test
	public void testXOutsideGrid() {
		GridPosition currentPosition = new GridPosition(10, 8, Orientation.N);
		GridPosition position = new GridPosition(11, 8, Orientation.N);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		
		assertFalse(validator.validate(currentPosition, position));
	}
	
	@Test
	public void testYOutsideGrid() {
		GridPosition currentPosition = new GridPosition(8, 10, Orientation.N);
		GridPosition position = new GridPosition(8, 11, Orientation.N);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		
		assertFalse(validator.validate(currentPosition, position));
	}
	
	
	@Test
	public void testBusyPosition() {
		GridPosition currentPosition = new GridPosition(4, 8, Orientation.N);
		GridPosition position = new GridPosition(5, 8, Orientation.N);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		validator.addUsedCoordinate(position);
		assertFalse(validator.validate(currentPosition, position));
	}
	
	@Test
	public void testSamePositionOtherOrientation() {
		GridPosition currentPosition = new GridPosition(4, 8, Orientation.N);
		GridPosition position = new GridPosition(4, 8, Orientation.W);
		
		GridPositionValidator validator = new GridPositionValidator(10, 10);
		validator.addUsedCoordinate(currentPosition);
		assertTrue(validator.validate(currentPosition, position));
	}
	
}
