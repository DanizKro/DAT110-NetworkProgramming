package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[SEGMENTSIZE]; //pakken som skal sendes
		byte[] data = message.getData(); //inneholde i pakken
		
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer
		
		segment[0] = (byte) data.length; //vi setter på en header
		System.arraycopy(data, 0, segment, 1, data.length); //definerer pakken på 128 bytes
		
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		
		int length = segment[0]; //henter headeren og lagrer den som "length" 
		
		// decapsulate segment and put received payload data into a message
		
		
		byte[] data = Arrays.copyOfRange(segment, 1, 1 + length); //definerer inneholdet i pakken, lengden på relevant data (alt utenom padding)
		Message message = new Message(data); //setter inneholdet i pakken inn i et Message-objekt
		
		return message;
		
	}
	
}
