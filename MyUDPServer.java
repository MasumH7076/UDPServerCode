
//Demonstrate datagrams server program
import java.net.*;

class MyUDPServer {
    public static int ServerPort = 998;
    public static int ClientPort = 999;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte buffer[] = new byte[buffer_size];

    public static void TheServer() throws Exception {
        int pos = 0;
        System.out.println("\n Enter text(-1 to exit)...\n");
        while (true) {
            int c = System.in.read();
            switch (c) {
                case '1':
                    System.out.println("server quits.");
                    return;
                case '\r':
                    break;
                case '\n':
                    // For localhost target........
                    ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), ClientPort));

                    ds.send(new DatagramPacket(buffer, pos, InetAddress.getByName("172.168.1.22"), ClientPort));

                    ds.send(new DatagramPacket(buffer, pos, InetAddress.getByName("172.168.1.23"), ClientPort));

                    ds.send(new DatagramPacket(buffer, pos, InetAddress.getByName("255.255.255.255"), ClientPort));

                    pos = 0;
                    break;
                default:
                    buffer[pos++] = (byte) c;

            }
        }
    }

    public static void main(String args[]) throws Exception {
        ds = new DatagramSocket(ServerPort);
        TheServer();
        ds.close();
    }
}// end the class
