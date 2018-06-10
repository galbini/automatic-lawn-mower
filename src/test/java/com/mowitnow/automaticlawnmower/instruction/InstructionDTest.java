package com.mowitnow.automaticlawnmower.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.mowitnow.automaticlawnmower.GridPosition;
import com.mowitnow.automaticlawnmower.Instruction;
import com.mowitnow.automaticlawnmower.Instruction.InstructionType;
import com.mowitnow.automaticlawnmower.Orientation;

public class InstructionDTest {

	@Test
	public void testNToE() {
		GridPosition position = new GridPosition(0, 0, Orientation.N);
		Instruction d = InstructionFactory.getInstruction(InstructionType.D);
		position = d.nextPosition(position);
		assertEquals(Orientation.E, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());		
	}
	
	@Test
	public void testEToS() {
		GridPosition position = new GridPosition(0, 0, Orientation.E);
		Instruction d = InstructionFactory.getInstruction(InstructionType.D);
		position = d.nextPosition(position);
		assertEquals(Orientation.S, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());
		
	}
	
	@Test
	public void testSToW() {
		GridPosition position = new GridPosition(0, 0, Orientation.S);
		Instruction d = InstructionFactory.getInstruction(InstructionType.D);
		position = d.nextPosition(position);
		assertEquals(Orientation.W, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());
		
	}
	
	@Test
	public void testWToN() {
		GridPosition position = new GridPosition(0, 0, Orientation.W);
		Instruction d = InstructionFactory.getInstruction(InstructionType.D);
		position = d.nextPosition(position);
		assertEquals(Orientation.N, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());
		
	}

	@Test
	public void testNull(){
		try{
			Instruction d = InstructionFactory.getInstruction(InstructionType.D);
			d.nextPosition(null);
			fail("not throw IllegalArgumentException");
		}catch(IllegalArgumentException e){
			assertEquals("position cannot be null", e.getMessage());
		}
		
	}
}
