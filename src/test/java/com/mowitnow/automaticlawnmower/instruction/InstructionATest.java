package com.mowitnow.automaticlawnmower.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.mowitnow.automaticlawnmower.GridPosition;
import com.mowitnow.automaticlawnmower.Instruction;
import com.mowitnow.automaticlawnmower.Instruction.InstructionType;
import com.mowitnow.automaticlawnmower.Orientation;

public class InstructionATest {

	@Test
	public void testAToN() {
		GridPosition position = new GridPosition(3, 3, Orientation.N);
		Instruction a = InstructionFactory.getInstruction(InstructionType.A);
		position = a.nextPosition(position);
		assertEquals(Integer.valueOf(3), position.getX());
		assertEquals(Integer.valueOf(4), position.getY());
		assertEquals(Orientation.N, position.getOrientation());
		
	}
	
	@Test
	public void testAToW() {
		GridPosition position = new GridPosition(3, 3, Orientation.W);
		Instruction a = InstructionFactory.getInstruction(InstructionType.A);
		position = a.nextPosition(position);
		assertEquals(Integer.valueOf(2), position.getX());
		assertEquals(Integer.valueOf(3), position.getY());
		assertEquals(Orientation.W, position.getOrientation());
	}
	
	@Test
	public void testAToS() {
		GridPosition position = new GridPosition(3, 3, Orientation.S);
		Instruction a = InstructionFactory.getInstruction(InstructionType.A);
		position = a.nextPosition(position);
		assertEquals(Integer.valueOf(3), position.getX());
		assertEquals(Integer.valueOf(2), position.getY());
		assertEquals(Orientation.S, position.getOrientation());
	}
	
	@Test
	public void testAToE() {
		GridPosition position = new GridPosition(3, 3, Orientation.E);
		Instruction a = InstructionFactory.getInstruction(InstructionType.A);
		position = a.nextPosition(position);
		assertEquals(Integer.valueOf(4), position.getX());
		assertEquals(Integer.valueOf(3), position.getY());
		assertEquals(Orientation.E, position.getOrientation());
	}

	@Test
	public void testNull(){
		boolean exception = false;
		try{
			Instruction a = InstructionFactory.getInstruction(InstructionType.A);
			a.nextPosition(null);
		}catch(IllegalArgumentException e){
			exception = true;
			assertEquals("position cannot be null", e.getMessage());
		}
		if(!exception)fail("not throw IllegalArgumentException");
	}
}
