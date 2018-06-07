package com.mowitnow.automaticlawnmower.instruction;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mowitnow.automaticlawnmower.GridPosition;
import com.mowitnow.automaticlawnmower.Instruction;
import com.mowitnow.automaticlawnmower.Orientation;
import com.mowitnow.automaticlawnmower.instruction.D;
import com.mowitnow.automaticlawnmower.instruction.G;

public class InstructionGTest {

	@Test
	public void testNToW() {
		GridPosition position = new GridPosition(0, 0, Orientation.N);
		Instruction g = new G();
		position = g.nextPosition(position);
		assertEquals(Orientation.W, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());
		
	}
	
	@Test
	public void testWToS() {
		GridPosition position = new GridPosition(0, 0, Orientation.W);
		Instruction g = new G();
		position = g.nextPosition(position);
		assertEquals(Orientation.S, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());
		
	}
	
	@Test
	public void testSToE() {
		GridPosition position = new GridPosition(0, 0, Orientation.S);
		Instruction g = new G();
		position = g.nextPosition(position);
		assertEquals(Orientation.E, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());
		
	}
	
	@Test
	public void testEToN() {
		GridPosition position = new GridPosition(0, 0, Orientation.E);
		Instruction g = new G();
		position = g.nextPosition(position);
		assertEquals(Orientation.N, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());		
	}
	
	@Test
	public void testNull(){
		boolean exception = false;
		try{
			Instruction g = new G();
			g.nextPosition(null);
		}catch(IllegalArgumentException e){
			exception = true;
			assertEquals("position cannot be null", e.getMessage());
		}
		if(!exception)fail("not throw IllegalArgumentException");
	}
}