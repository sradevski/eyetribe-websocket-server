package stevche.radevski;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;


public class SocketServer extends WebSocketServer {

	public int numOfConnections = 0;
	public SocketServer(int port ) throws UnknownHostException {
		super( new InetSocketAddress( port ) );
		System.out.println( "SocketServer started on port: " + this.getPort() );
	}

	@Override
	public void onOpen( WebSocket conn, ClientHandshake handshake ) {
		numOfConnections += 1;
		System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " has connected!" );
	}

	@Override
	public void onClose( WebSocket conn, int code, String reason, boolean remote ) {
		numOfConnections -= 1;
		System.out.println(  conn.getRemoteSocketAddress().getAddress().getHostAddress() + " has disconnected! The reason is: " + reason );
	}

	@Override
	public void onMessage( WebSocket conn, String message ) {
		handleEyeNavMessage(conn, message);
		System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + "sent Message: " + message );
	}

	@Override
	public void onError( WebSocket conn, Exception ex ) {
		ex.printStackTrace();
		if( conn != null ) {
			// some errors like port binding failed may not be assignable to a specific websocket
		}
	}

	private void handleEyeNavMessage(WebSocket conn, String message){
		int status = Globs.NO_STATUS;

		switch(message){
			case "startTracker":
				status = ClientMessageHandler.startTracker();
				break;
			case "stopTracker":
				status = ClientMessageHandler.stopTracker();
				break;
		}

		//conn.send("{ command: '" + message + "', status: " + status + "}");
	}

	/**
	 * Sends <var>text</var> to all currently connected WebSocket clients.
	 * 
	 * @param text
	 *            The String to send across the network.
	 * @throws InterruptedException
	 *             When socket related I/O errors occur.
	 */
	public void sendToAll( String text ) {
		Collection<WebSocket> con = connections();
		synchronized ( con ) {
			for( WebSocket c : con ) {
				c.send( text );
			}
		}
	}
}
