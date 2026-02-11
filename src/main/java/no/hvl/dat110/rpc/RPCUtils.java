package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {

	//payload er data
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// TODO - START
		
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		
				//Skrevet selv start!! 
		rpcmsg = new byte[1 + payload.length]; 						// definerer "rpcmsg" som en ny byte-array med lengde lik headeren(1) + payload. 
		rpcmsg[0] = rpcid; 											//setter rpcid (RPC Id) lik "headeren / metoden som skal kalles". 
		System.arraycopy(payload, 0, rpcmsg, 1, payload.length);    //kopierer payload'en, fra indeks 0, over i "rpcmsg"(RPC Message) fra indeks 1, 
																    // med lengde "payload".
			// Skrevet selv slutt
		// TODO - END
		
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		// TODO - START
		
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
				//Skrevet selv start
		
			payload = new byte[rpcmsg.length - 1];						// gir byte-arrayen "payload" lengden av rpcmsg minus headeren. (som er payload). 
			System.arraycopy(rpcmsg, 1, payload, 0, payload.length);	// kopierer det fra indeks: 1 i "rpcmsg" inn i "payload" fra indeks: 0). 
			//Skrevet selv slutt
		/*
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		// TODO - START 
			//Skrevet selv start
		
		encoded = str.getBytes(StandardCharsets.UTF_8); 		//string-parameteren som kommer inn gjøres om til en byte-array. 
		
		//Skrevet selv slutt
		/*
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		
		// TODO - START 
		
		//Skrevet selv start
		
			decoded = new String(data, StandardCharsets.UTF_8); //byte-dataen som kommer inn (som parameter) gjøres om til en String. 
				
				//Skrevet selv slutt
		
		/*
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		// TODO - START 
		
			//Skrevet selv start
				
			encoded = new byte[0];			/* Etter et void-kall mottar klienten en tom byte-array i retur, 
												i RPC må det alltid sendes noe i retur */
						
					//Skrevet selv slutt
				
			/*
			if (true)
				throw new UnsupportedOperationException(TODO.method());
			 */
			// TODO - END
		
		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		return;
		/*
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1]; 		//denne metoen får inn en boolean (true/false). 
											// boolean skal sendes som en byte, så vi konverterer boolean
											// -verdien til 1(true) eller 0(false). 
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);			/* Får inn en byte-array (data) med verdien 0 eller 1, 
										 konverteres til true hvis verdien er 1 og false om verdien er 0. */
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		
		//Skrevet selv start
		encoded = ByteBuffer.allocate(4).putInt(x).array(); 
		// resulterer i en "encoded" byte-array på 4 bytes som inneholder tallet vårt (som kom inn som parameter). 
		
		//Skrevet selv slutt
		/*
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		// TODO - START 
		//Skrevet selv start
		
		decoded = ByteBuffer.wrap(data).getInt();
		//leser byte-arrayen og integer/tallet den inneholder. 
		
		//Skrevet selv slutt
		// TODO - END
		
		return decoded;
		
	}
}
