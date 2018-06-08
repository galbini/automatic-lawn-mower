package com.mowitnow.automaticlawnmower;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.mowitnow.automaticlawnmower.Instruction.InstructionType;
import com.mowitnow.automaticlawnmower.file.FileParser;
import com.mowitnow.automaticlawnmower.instruction.InstructionFactory;

public class LawnMowerTest {

	/**
	 * 5 5 
	 * 1 2 N 
	 * GAGAGAGAA
	 * 1 3 N
	 */
	@Test
	public void testFirstMower() {
		
		GridPosition initialPosition = new GridPosition(1, 2, Orientation.N);
		GridPositionValidator validator = new GridPositionValidator(5, 5);
		
		List<Instruction> instructions = new LinkedList<>();
		instructions.add(InstructionFactory.getInstruction(InstructionType.G));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.G));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.G));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.G));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		
		LawnMower mower = new LawnMower(initialPosition, instructions, validator);
		
		GridPosition lastPosition = mower.run();
		
		assertEquals(Integer.valueOf(1), lastPosition.getX());
		assertEquals(Integer.valueOf(3), lastPosition.getY());
		assertEquals(Orientation.N, lastPosition.getOrientation());		
	}
	
	/**
	 * 5 5
	 * 3 3 E 
	 * AADAADADDA
	 * 5 1 E
	 */
	@Test
	public void testSecondMower() {
		
		GridPosition initialPosition = new GridPosition(3, 3, Orientation.E);
		GridPositionValidator validator = new GridPositionValidator(5, 5);
		
		
		List<Instruction> instructions = new LinkedList<>();
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.D));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.D));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.D));
		instructions.add(InstructionFactory.getInstruction(InstructionType.D));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		
		LawnMower mower = new LawnMower(initialPosition, instructions, validator);
		
		GridPosition lastPosition = mower.run();
		
		assertEquals(Integer.valueOf(5), lastPosition.getX());
		assertEquals(Integer.valueOf(1), lastPosition.getY());
		assertEquals(Orientation.E, lastPosition.getOrientation());		
	}
	
	/**
	 * 5 5
	 * 3 3 E 
	 * AADAADADDA
	 * 4 1 E because 5 3 E is already busy
	 */
	@Test
	public void testSecondMowerButOnePositionIsAlreadyOccupied() {
		
		GridPosition initialPosition = new GridPosition(3, 3, Orientation.E);
		
		GridPosition occupiedPosition = new GridPosition(5, 3, Orientation.E);
		
		GridPositionValidator validator = new GridPositionValidator(5, 5);
		validator.addUsedCoordinate(occupiedPosition);
		
		List<Instruction> instructions = new LinkedList<>();
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.D));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.D));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		instructions.add(InstructionFactory.getInstruction(InstructionType.D));
		instructions.add(InstructionFactory.getInstruction(InstructionType.D));
		instructions.add(InstructionFactory.getInstruction(InstructionType.A));
		
		LawnMower mower = new LawnMower(initialPosition, instructions, validator);
		
		GridPosition lastPosition = mower.run();
		
		assertEquals(Integer.valueOf(4), lastPosition.getX());
		assertEquals(Integer.valueOf(1), lastPosition.getY());
		assertEquals(Orientation.E, lastPosition.getOrientation());		
	}
	
	@Test
	public void testTwoMowerButTheSecondOccupeTheLastPositionOfTheFirst() {
		
		try{
    		FileParser parser = new FileParser(Paths.get("src/test/data-test-2.txt"));
    		List<LawnMower> l = parser.getLawnMowers();
    		
    		assertEquals("1 2 N",l.get(0).run().toString());
    		assertEquals("3 5 N",l.get(1).run().toString());
    		
    	}catch(Exception e){
    		fail(e.getMessage());
    	}    
	}

}
