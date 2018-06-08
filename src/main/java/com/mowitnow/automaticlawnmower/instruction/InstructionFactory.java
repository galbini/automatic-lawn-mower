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
	/**
	 * Get the instruction for a instructionType
	 * @param instructionType the type of the instruction (A, G or D)
	 * @return an instance of the instruction type.
	 */
	public static Instruction getInstruction(InstructionType instructionType){
		if(instructionType == null ) throw new IllegalArgumentException("instructionType cannot be null");
		
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

