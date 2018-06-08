package com.mowitnow.automaticlawnmower.file;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.mowitnow.automaticlawnmower.LawnMower;

public class FileParserTest {
	@Test
	public void testLoadNotExistFileApp() {
		try{
			FileParser parser = new FileParser(Paths.get("src/data-test.txt") );
			
		}catch(Exception e){
			assertTrue(e.getMessage().startsWith("java.nio.file.NoSuchFileException"));
		}		
	}

	

	@Test
	public void testLoadEmptyFileApp() {
		
		try{
			FileParser parser = new FileParser(Paths.get("src/test/data-test-empty.txt"));
		}catch(Exception e){
			assertTrue(e.getMessage().startsWith("file content is empty"));
		}		
	}

	@Test
	public void testLoadFileApp() {
		
		try{
			FileParser parser = new FileParser(Paths.get("src/test/data-test.txt"));
		}catch(Exception e){
			assertTrue(e.getMessage().startsWith("file content is empty"));
		}	
		
		
	}
	
	
	@Test
	public void testBadFirstLine() {
		FileParser parser = new FileParser("F R\n");
		try{
			parser.getLawnMowers();
		}catch(FileException e){
			assertTrue(e.getMessage().startsWith("First line does not have the good format "));
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
		}catch(FileException e){
			assertTrue(e.getMessage().matches("Instructions at \\d does not have the good format GGGGF"));
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
