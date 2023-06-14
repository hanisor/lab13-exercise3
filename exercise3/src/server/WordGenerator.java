package server;

/**
 * This class generates word count.
 * 
 * @author hanis sorhana
 *
 */
public class WordGenerator {

	
	/**
	 * This method generates word count.
	 * 
	 * @return word count
	 */
	public int getWordCount() {
		
		String text = "hello. this is dad subject";
	
		String[] words = text.trim().split("\\s+");
        return words.length;
        
		//String currentDate = new Date().toString();
		
		//return currentDate;
		
	}
	
}
