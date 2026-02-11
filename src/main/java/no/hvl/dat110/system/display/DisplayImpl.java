package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCRemoteImpl;
import no.hvl.dat110.rpc.RPCUtils;
import no.hvl.dat110.rpc.RPCServer;

public class DisplayImpl extends RPCRemoteImpl {

	private static final byte write_RPCID = 2;
	public DisplayImpl( RPCServer rpcserver) {
		super(write_RPCID,rpcserver);
	}

	public void write(String message)
	{
		System.out.println("DISPLAY:" + message);
	}

	public byte[] invoke(byte[] data) {

		byte[] returnval = null;

		// TODO - START: 
		// implement unmarshalling, call, and marshall for write RPC method
		// look at how this is done in the SensorImpl class for the read method
		String message = RPCUtils.unmarshallString(data);

		write(message);

		returnval = new byte[0];
		// TODO - END
		
		return returnval;
	}
}
