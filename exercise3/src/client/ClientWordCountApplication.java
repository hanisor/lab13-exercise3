package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import server.WordGenerator;

/**
 * This method launch the frame and manage the connection to the server.
 * 
 * @author hanis sorhana
 *
 */

public class ClientWordCountApplication {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		WordGenerator wordGenerator = new WordGenerator();
		
		// Launch client-side frame
		ClientWordCountFrame clientFrame = new ClientWordCountFrame();
		clientFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the current word count
		int wordcount = wordGenerator.getWordCount();
		clientFrame.updateServerWordCount(wordcount);
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}
