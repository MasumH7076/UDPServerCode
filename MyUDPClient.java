import java.net.*;
public class MyUDPClient {
    public static int ServerPort = 998;
    public static int ClientPort = 999;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte buffer[] = new byte[buffer_size];

    public static void TheClient() throws Exception{
        while(true){
            DatagramPacket p= new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println( new String(p.getData(),0,p.getLength()));
        }
    }
    public static void main(String args[]) throws Exception{
        ds=new DatagramSocket(ClientPort);
        TheClient();
    }
}
