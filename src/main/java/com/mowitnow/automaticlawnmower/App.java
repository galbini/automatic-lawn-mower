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
    			System.out.println(app.getFinalMessage());
    		}else{
    			System.err.println(app.getFinalMessage());
    		}
    		
    	}catch (Exception e) {
    		System.err.println("Problem during execution:\n"+e.getMessage());
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
    		StringBuffer sb = new StringBuffer();
    		sb.append("Final lawn mower position(s):\n");
    		FileParser parser = new FileParser(Paths.get(filePath));
    		parser.getLawnMowers().forEach(m -> {
    			sb.append(m.run().toString()).append("\n");    			
    		});
    		finalMessage = sb.toString();
        	return 0;
    	}catch(Exception e){
    		finalMessage = "Problem during execution:\n"+e.getMessage();
    		return 1;
    	}    		    	
    }
    
	public String getFinalMessage() {
		return finalMessage;
	}

	
}
