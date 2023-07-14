package org.academiadecodigo.webserver;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8081);
        Socket clientSocket;

        while  ((clientSocket = serverSocket.accept()) != null) {

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out =  new PrintWriter(clientSocket.getOutputStream(), true);
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

                String line = in.readLine();
                System.out.println(line);

                String[] receivedMessage = line.split(" ");
                System.out.println(receivedMessage[1]);

                if (receivedMessage[0].equals("GET")){

                    File file = new File( "www"+ receivedMessage[1]);

                    if(!file.exists()) {
                        File notFoundFile =  new File("www/404.html");
                        out.println(ResponseHeaders.typeNotFound(notFoundFile.length() + 1));
                        BufferedReader notFound = new BufferedReader(new FileReader(notFoundFile));
                        while (notFound.ready()){
                            out.println(notFound.readLine());
                        }
                        clientSocket.close();
                        continue;
                    }
                    

                    BufferedReader ibr = new BufferedReader(new FileReader(file));

                    out.println(ResponseHeaders.typeText(file.length() + 1));
                    while (ibr.ready()){
                        out.println(ibr.readLine());
                    }
        }
        clientSocket.close();
        }

}
}

