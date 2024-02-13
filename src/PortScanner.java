import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// Purpose: A simple port scanner. The user enters an IP address, and the program scans all 65536 ports on that IP address.
public class PortScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the IP address to scan: ");
        String ip = input.nextLine();
        for (int port = 0; port <= 65535; port++) { //
            try {
                Socket socket = new Socket(ip, port);
                System.out.println("Port " + port + " is open");
                socket.close();
            } catch (IOException e) {
                // Port is closed
            }
        }
    }
}
