package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	private static final byte write_RPCID = 2;

	public DisplayStub(RPCClient rpcclient) {

		super(rpcclient);
	}
	
	public void write (String message) {
		
		//denne konverterer stringen til bytes
		byte[] param = RPCUtils.marshallString(message);
		rpcclient.call(write_RPCID, param);
		
		// implement marshalling, call and unmarshalling for write RPC method

		
	}
}
