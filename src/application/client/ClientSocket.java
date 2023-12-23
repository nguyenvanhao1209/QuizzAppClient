package application.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import application.model.User;

public class ClientSocket extends Thread {
	private static ClientSocket instance;
	private Socket socket = null;
	private String IPAddress;
	private int port;
	public User user;
	
	public String getIPAddress() {
		return IPAddress;
	}

	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ClientSocket(String IPAddress, int port) {
		this.IPAddress = IPAddress;
		this.port = port;
		try {
			socket = new Socket(IPAddress, port);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ClientSocket getInstance() {
		if(instance == null) {
			instance = new ClientSocket("127.0.0.1", 8080);
		}
		return instance;
	}
	
	public void sendMessage(String message) {
		try {
			 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			 out.println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readMessage() {
    	try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = input.readLine();
            return message;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
}
