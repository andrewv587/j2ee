package www.hwh.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	public static void main(String[] args) throws Exception{
		DatagramSocket server = new DatagramSocket(8888);
		byte[] data=new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		server.receive(packet);
		byte[] getDate=packet.getData();
		int length=packet.getLength();
		System.out.println(new String(getDate,0,length));
		server.close();
	}
}
