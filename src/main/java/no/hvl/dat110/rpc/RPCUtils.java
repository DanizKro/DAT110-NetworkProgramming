package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// TODO - START
		
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		
				//Skrevet selv start!! 
		rpcmsg = new byte[1 + payload.length]; 						// definerer "rpcmsg" som en ny byte-array med lengde lik headeren(1) + payload. 
		rpcmsg[0] = rpcid; 											//setter rpcid (RPC Id) lik "headeren / metoden som skal kalles". 
		System.arraycopy(payload, 0, rpcmsg, 1, payload.length);    //kopierer payload'en, fra indeks 0, over i "rpcmsg"(RPC Message) fra indeks 1, 
																    // med lengde "payload". 
		
		  /* if (true)
			throw new UnsupportedOperationException(TODO.method());
			*/
		
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
				
			encoded = new byte[0];			/* Etter et void-kall mottar clienten en tom byte-array i retur, 
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
		
		byte[] encoded = new byte[1]; 		//denne metoen får inn en ...
				
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
		
		return (data[0] > 0);			//Får inn en byte-array (data), returner "True" hvis den IKKE er tom ?
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		
		//Skrevet selv start
		encoded = ByteBuffer.allocate(4).putInt(x).array(); //
		
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
		
		//Skrevet selv slutt

		
		/*
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return decoded;
		
	}
}
