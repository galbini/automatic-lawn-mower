package com.mowitnow.automaticlawnmower.instruction;

import java.util.HashMap;
import java.util.Map;

import com.mowitnow.automaticlawnmower.Orientation;
/**
 * Contain the orientation movement for d (right turn) and g (left turn)
 * @author galbini
 *
 */
public class InstructionHelpers {
	
	private static Map<Orientation, Orientation> dMovements;
	private static Map<Orientation, Orientation> gMovements;
	
	protected static Map<Orientation, Orientation> getDMovements(){
		if(dMovements == null){
			dMovements = new HashMap<>(4);
			dMovements.put(Orientation.N, Orientation.E);
			dMovements.put(Orientation.E, Orientation.S);
			dMovements.put(Orientation.S, Orientation.W);
			dMovements.put(Orientation.W, Orientation.N);
		}
		return dMovements;
	}

	protected static Map<Orientation, Orientation> getGMovements() {
		if(gMovements == null){
			gMovements = new HashMap<>(4);
			gMovements.put(Orientation.N, Orientation.W);
			gMovements.put(Orientation.W, Orientation.S);
			gMovements.put(Orientation.S, Orientation.E);
			gMovements.put(Orientation.E, Orientation.N);
		}
		return gMovements;
	}
}
