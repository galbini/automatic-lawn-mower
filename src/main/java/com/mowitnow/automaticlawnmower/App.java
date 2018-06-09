package com.mowitnow.automaticlawnmower;

import java.nio.file.Paths;
import java.util.logging.Logger;

import com.mowitnow.automaticlawnmower.file.FileParser;

/**
 * App is the application launched when used command line
 * @author galbini
 *
 */
public class App {
	
	public static Logger logger = Logger.getLogger(App.class.getName());
	
    
	public static void main(String[] args) {
    	int status = 0;
    	try{
    		if(args == null || args.length == 0)throw new IllegalArgumentException("missing file, please set a file");
    		
    		
    		App app = new App();
    		status = app.run(args[0]);
    		if(status == 0){
    			logger.info(app.getFinalMessage());
    		}else{
    			logger.severe(app.getFinalMessage());
    		}
    		
    	}catch (Exception e) {
			logger.severe("Problem during execution "+e.getMessage());
			status = -1;
		}
    	System.exit(status);
    }
    
    private String finalMessage;
    
    
    

    
    /**
     * Load the file, create mowers and run instructions for each mower.
     * @param filePath the path to file with mower instructions
     * @return 0 if all is good otherwise -1
     */
    public int run(String filePath){
    	try{
    		FileParser parser = new FileParser(Paths.get(filePath));
    		parser.getLawnMowers().forEach(m -> {
    			System.out.println(m.run().toString());    			
    		});
        	return 0;
    	}catch(Exception e){
    		finalMessage = "Problem during execution : "+e.getMessage();
    		return 1;
    	}    		    	
    }
    
	public String getFinalMessage() {
		return finalMessage;
	}

	
}
