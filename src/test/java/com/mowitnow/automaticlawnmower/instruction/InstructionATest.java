package com.mowitnow.automaticlawnmower.instruction;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mowitnow.automaticlawnmower.GridPosition;
import com.mowitnow.automaticlawnmower.Instruction;
import com.mowitnow.automaticlawnmower.Orientation;
import com.mowitnow.automaticlawnmower.instruction.A;
import com.mowitnow.automaticlawnmower.instruction.D;
import com.mowitnow.automaticlawnmower.instruction.G;

public class InstructionATest {

	@Test
	public void testAToN() {
		GridPosition position = new GridPosition(3, 3, Orientation.N);
		Instruction a = new A();
		position = a.nextPosition(position);
		assertEquals(Integer.valueOf(3), position.getX());
		assertEquals(Integer.valueOf(4), position.getY());
		assertEquals(Orientation.N, position.getOrientation());
		
	}
	
	@Test
	public void testAToW() {
		GridPosition position = new GridPosition(3, 3, Orientation.W);
		Instruction a = new A();
		position = a.nextPosition(position);
		assertEquals(Integer.valueOf(2), position.getX());
		assertEquals(Integer.valueOf(3), position.getY());
		assertEquals(Orientation.W, position.getOrientation());
	}
	
	@Test
	public void testAToS() {
		GridPosition position = new GridPosition(3, 3, Orientation.S);
		Instruction a = new A();
		position = a.nextPosition(position);
		assertEquals(Integer.valueOf(3), position.getX());
		assertEquals(Integer.valueOf(2), position.getY());
		assertEquals(Orientation.S, position.getOrientation());
	}
	
	@Test
	public void testAToE() {
		GridPosition position = new GridPosition(3, 3, Orientation.E);
		Instruction a = new A();
		position = a.nextPosition(position);
		assertEquals(Integer.valueOf(4), position.getX());
		assertEquals(Integer.valueOf(3), position.getY());
		assertEquals(Orientation.E, position.getOrientation());
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
