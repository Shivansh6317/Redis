package com.shivansh.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int port = 6379;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true);
            System.out.println("Redis server listening on port " + port);
            try(Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected!");

                InputStream inputStream=clientSocket.getInputStream();
                Scanner sc=new Scanner(inputStream);
                System.out.println(sc.nextLine());

                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write("+PONG\r\n".getBytes(StandardCharsets.UTF_8));//PONG is RESP serialization protocol
                //UTF-8  convert text to bytes explicitly specifying avoids relying on machine's default encoding
                outputStream.flush();
            }

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}


