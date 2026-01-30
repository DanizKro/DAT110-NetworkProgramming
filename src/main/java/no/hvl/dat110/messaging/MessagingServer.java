package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingServer {

	// server-side socket for accepting incoming TCP connections
	private ServerSocket welcomeSocket;

	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// accept an incoming connection from a client
	public MessageConnection accept() {

		MessageConnection connection = null;

		// TODO - START
		// accept TCP connection on welcome socket and create messaging connection to be returned

			//Skrevet selv start!!!
		
		
		try {
			Socket clientSocket = welcomeSocket.accept(); /* venter på at en klient skal koble seg til. 
															Når dette skjer opprettes det en TCP forbindelse
														  */
			connection = new MessageConnection(clientSocket); //Gjør forbindelsen mulig å bruke. 
		} catch (IOException e) {
			System.out.println("Accept: " + e.getMessage());
			e.printStackTrace();
		}
			
			//Skrevet selv slutt!!!
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
		return connection;

	}

	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
