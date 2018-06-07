package com.mowitnow.automaticlawnmower.instruction;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mowitnow.automaticlawnmower.GridPosition;
import com.mowitnow.automaticlawnmower.Instruction;
import com.mowitnow.automaticlawnmower.Orientation;
import com.mowitnow.automaticlawnmower.instruction.D;
import com.mowitnow.automaticlawnmower.instruction.G;

public class InstructionDTest {

	@Test
	public void testNToE() {
		GridPosition position = new GridPosition(0, 0, Orientation.N);
		Instruction d = new D();
		position = d.nextPosition(position);
		assertEquals(Orientation.E, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());		
	}
	
	@Test
	public void testEToS() {
		GridPosition position = new GridPosition(0, 0, Orientation.E);
		Instruction d = new D();
		position = d.nextPosition(position);
		assertEquals(Orientation.S, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());
		
	}
	
	@Test
	public void testSToW() {
		GridPosition position = new GridPosition(0, 0, Orientation.S);
		Instruction d = new D();
		position = d.nextPosition(position);
		assertEquals(Orientation.W, position.getOrientation());
		assertEquals(Integer.valueOf(0), position.getX());
		assertEquals(Integer.valueOf(0), position.getY());
		
	}
	
	@Test
	public void testWToN() {
		GridPosition position = new GridPosition(0, 0, Orientation.W);
		Instruction d = new D();
		position = d.nextPosition(position);
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
