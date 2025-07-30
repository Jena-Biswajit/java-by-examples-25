package com.example.receiver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class ReceiverJVM {

    private static final int PORT = 5050;
    private static final String OUTPUT_FILE = "received_output.txt";

    public static void main(String[] args) throws IOException {
        System.out.println("Receiver JVM started. Listening on port " + PORT + "...");

        // This will store chunks with their order (TreeMap to auto-sort)
        Map<Integer, byte[]> chunkMap = new TreeMap<>();

        // Optional: keep track of total chunks (could be set by sender)
        int expectedChunks = -1;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Connected to sender: " + socket.getInetAddress());

                    DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

                    while (true) {
                        int chunkNumber;
                        try {
                            chunkNumber = dis.readInt();  // read chunk number
                        } catch (EOFException e) {
                            break; // done with this socket
                        }

                        if (chunkNumber == -1) {
                            expectedChunks = dis.readInt();
                            System.out.println("Expected total chunks: " + expectedChunks);
                            continue;
                        }

                        int chunkSize = dis.readInt();   // read chunk size
                        byte[] buffer = new byte[chunkSize];
                        dis.readFully(buffer);           // read chunk data

                        chunkMap.put(chunkNumber, buffer);
                        System.out.println("Received chunk " + chunkNumber + " of size " + chunkSize);
                    }

                    dis.close();

                    // Check if all expected chunks are received (optional)
                    if (expectedChunks > 0 && chunkMap.size() == expectedChunks) {
                        System.out.println("All chunks received. Merging into final file...");
                        writeToFile(chunkMap, OUTPUT_FILE);
                        System.out.println("File written to: " + OUTPUT_FILE);
                        break; // done!
                    }
                }
            }
        }
    }

    private static void writeToFile(Map<Integer, byte[]> chunkMap, String outputFile) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            for (Map.Entry<Integer, byte[]> entry : chunkMap.entrySet()) {
                fos.write(entry.getValue());
            }
        }
    }
}
