package com.mowitnow.automaticlawnmower.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.mowitnow.automaticlawnmower.LawnMower;

public class FileParserTest {
	@Test
	public void testLoadNotExistFileApp() {
		try{
			FileParser parser = new FileParser(Paths.get("src/data-test.txt") );
			fail("missing exception");
		}catch(Exception e){
			assertTrue(e.getMessage().startsWith("java.nio.file.NoSuchFileException"));
		}		
	}

	

	@Test
	public void testLoadEmptyFileApp() {
		
		try{
			FileParser parser = new FileParser(Paths.get("src/test/data-test-empty.txt"));
			fail("missing exception");
		}catch(Exception e){
			assertTrue(e.getMessage().startsWith("file content is empty"));
		}		
	}

	@Test
	public void testLoadFileApp() {
		
		try{
			FileParser parser = new FileParser(Paths.get("src/test/data-test.txt"));
		}catch(Exception e){
			fail(e.getMessage());
		}	
		
		
	}
	
	
	@Test
	public void testBadFirstLine() {
		FileParser parser = new FileParser("F R\n");
		try{
			parser.getLawnMowers();
			fail("missing exception");
		}catch(FileException e){
			assertTrue(e.getMessage().startsWith("First line does not have the good format: "));
		}
		
	}
	
	@Test
	public void testGoodFirstLine() {
		FileParser parser = new FileParser("5 5\n");
		try{
			parser.getLawnMowers();
		}catch(FileException e){
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testBadFirstGridPosition() {
		FileParser parser = new FileParser("5 5\n5 1 D\nAAAA");
		try{
			parser.getLawnMowers();
			fail("missing exception");
		}catch(FileException e){
			assertTrue(e.getMessage().startsWith("First grid position at "));
		}
		
	}
	
	@Test
	public void testGoodFirstGridPosition() {
		FileParser parser = new FileParser("5 5\n5 1 N\nAAAA");
		try{
			parser.getLawnMowers();
		}catch(FileException e){
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testBadSecondInstructionPosition() {
		FileParser parser = new FileParser("5 5\n5 1 N\nAAAA\n4 6 E\nGGGGF");
		try{
			parser.getLawnMowers();
			fail("missing exception");
		}catch(FileException e){
			assertTrue(e.getMessage().matches("Instructions at line \\d does not have the good format: GGGGF"));
		}
		
	}
	
	@Test
	public void testSeveralError() {
		FileParser parser = new FileParser("5 5\n5 1 Z\nAAAA\n4 6 E\nGGGGF");
		try{
			parser.getLawnMowers();
			fail("missing exception");
		}catch(FileException e){
			assertTrue(e.getMessage().matches("First grid position at line 2 does not have the good format: 5 1 Z\n"
					+ "Instructions at line 5 does not have the good format: GGGGF"));
		}
		
	}
	
	@Test
	public void testIncompleteFile() {
		FileParser parser = new FileParser("5 5\n5 1 N\nAAAA\n4 6 E\n\n");
		try{
			parser.getLawnMowers();
			fail("missing exception");
		}catch(FileException e){
			assertTrue(e.getMessage().matches("Incomplete file, see documentation, file format section"));
		}
		
	}
	
	@Test
	public void testGoodSecondInstructionPosition() {
		FileParser parser = new FileParser("5 5\n5 1 N\nAAAA\n4 6 E\nGGGGDDDAA");
		try{
			List<LawnMower> mowers = parser.getLawnMowers();
			assertEquals(mowers.size(), 2);
		}catch(FileException e){
			fail(e.getMessage());
		}
		
	}
	
	
}
