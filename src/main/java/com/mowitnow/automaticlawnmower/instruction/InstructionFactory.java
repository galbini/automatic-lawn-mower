package com.mowitnow.automaticlawnmower.instruction;

import com.mowitnow.automaticlawnmower.Instruction;
import com.mowitnow.automaticlawnmower.Instruction.InstructionType;
/**
 * Instruction factory based on enum InstructionType
 * 
 * @author galbini
 *
 */
public class InstructionFactory {
	
	public static Instruction getInstruction(InstructionType instructionType){
		
		switch (instructionType) {
		case A:
			return new A();			
		case G:
			return new G();			
		case D:
			return new D();			
		default:
			throw new IllegalArgumentException("instructionType not managed "+instructionType);			
		}
		
	}
	
}

