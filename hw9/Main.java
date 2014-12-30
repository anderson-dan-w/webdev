/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadedsocket;

import java.io.*;
import java.net.*;

/**
 *
 * @author dwanderson
 */
public class Main {
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(20005);
        } catch (IOException ioe) {
            System.err.println("Couldn't listen for dander73 on port 20005");
            System.exit(1);
        }
        
        Socket clientSocket = null;
        while (true) {
            clientSocket = serverSocket.accept();
            ThreadedSocket thread = new ThreadedSocket(clientSocket);
            thread.start();
        }
    }
}
