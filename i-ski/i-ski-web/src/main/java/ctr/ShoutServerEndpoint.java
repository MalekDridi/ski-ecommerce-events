package ctr;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author <a href="http://jmesnil.net/">Jeff Mesnil</a> (c) 2014 Red Hat inc.
 */

@ServerEndpoint("/shout")
public class ShoutServerEndpoint {

	@OnMessage
	public void shout(String text, Session client) {
		client.getAsyncRemote().sendText(text.toUpperCase());
	}
}