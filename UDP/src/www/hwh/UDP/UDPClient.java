package www.hwh.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception{
		DatagramSocket client = new DatagramSocket(8888);
		String abc="hwhkll;sakdfuopwer";
		byte[] data=abc.getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost",8888));
		client.send(packet);
		client.close();
	}

}
