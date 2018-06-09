package com.mowitnow.automaticlawnmower.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.StringUtils;

import com.mowitnow.automaticlawnmower.GridPosition;
import com.mowitnow.automaticlawnmower.GridPositionValidator;
import com.mowitnow.automaticlawnmower.Instruction;
import com.mowitnow.automaticlawnmower.Instruction.InstructionType;
import com.mowitnow.automaticlawnmower.LawnMower;
import com.mowitnow.automaticlawnmower.Orientation;
import com.mowitnow.automaticlawnmower.instruction.InstructionFactory;

/**
 * Parse the file content and create lawn mowers.<br><br>
 * 
 * The first line of the file is the top right corner of the virtual grid<br>
 * The next two lines are for define one lawn mower.<br>
 * The first line is the start position and the second line contains all instructions need to be execute.<br>
 * Example : <br>
 * 5 5 <br>
 * 1 2 N <br>
 * GAGAGAGAA <br>
 * 3 3 E <br>
 * AADAADADDA<br>
 * 
 * @author galbini
 *
 */
public class FileParser {
	private final String fileContent;
	private List<LawnMower> lawnMowers;
	
	/**
	 * Load the content of the file
	 * @param filePath the path of the file
	 */
	public FileParser(Path filePath) {
		if(filePath == null)throw new IllegalArgumentException("file path cannot be null");
		String fileContent = loadFile(filePath);
    	if(fileContent == null || StringUtils.isBlank(fileContent))throw new IllegalArgumentException("file content is empty");
    	this.fileContent = fileContent;
	}
	
	/**
	 * Load the content of the file
	 * @param fileContent the content of a file
	 */
	public FileParser(String fileContent) {
		if(fileContent == null || StringUtils.isBlank(fileContent))throw new IllegalArgumentException("file content is empty");
    	this.fileContent = fileContent;
	}
	
	
	public List<LawnMower> getLawnMowers() throws FileException {
		if(lawnMowers == null){
			lawnMowers = new ArrayList<>();
			validateContentFileAndComputeMowers();			
		}
		
		return lawnMowers;
	}

	private String loadFile(Path filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( filePath, StandardCharsets.UTF_8)) {
            stream.filter(s -> StringUtils.isNotBlank(s)) //remove blank line
            	  .forEach(s -> contentBuilder.append(s.trim()).append("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
 
        return contentBuilder.toString();
    }

	private void validateContentFileAndComputeMowers() throws FileException {
		String[] lines = fileContent.split("\n");
		
		if(!lines[0].matches("\\d \\d"))throw new FileException("First line does not have the good format "+lines[0]);
		String[] topRightCoordinates = lines[0].split("\\s",2);
		GridPositionValidator validator = new GridPositionValidator(Integer.valueOf(topRightCoordinates[0]), Integer.valueOf(topRightCoordinates[1]));
		
		for(int i = 1; i < lines.length; i = i+2){
			String mowerFirstPosition = lines[i];
			String mowerInstructions = lines[i+1];
			
			if(!mowerFirstPosition.matches("\\d \\d [NESW]"))throw new FileException("First grid position at "+(i+1)+ " does not have the good format "+lines[i]);
			if(!mowerInstructions.matches("[ADG]*"))throw new FileException("Instructions at "+(i+2)+ " does not have the good format "+lines[i+1]);
			String[] tmp1 = mowerFirstPosition.split("\\s",3);
			GridPosition initialPosition = new GridPosition(Integer.valueOf(tmp1[0]), Integer.valueOf(tmp1[1]), Orientation.valueOf(tmp1[2]));
			
			List<Instruction> instructions = Arrays.stream(mowerInstructions.split(""))
			        	.map(c -> InstructionFactory.getInstruction(InstructionType.valueOf(c)))
			        	.collect(Collectors.toList());
			
			lawnMowers.add(new LawnMower(initialPosition, instructions, validator));
		}
		
	}


	private void computeLawnMowers() {
		// TODO Auto-generated method stub
		
	}

	
}
