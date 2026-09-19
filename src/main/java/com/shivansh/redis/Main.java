package com.shivansh.redis;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        int port = 6379;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Redis server listening on port " + port);

            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected!");

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}


