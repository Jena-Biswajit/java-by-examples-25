package com.example.sender;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SenderJVM {

    private static final String HOST = "localhost";
    private static final int PORT = 5050;
    private static final int CHUNK_SIZE = 1024;
    private static final int THREAD_COUNT = 4; // You can increase this

    public static void main(String[] args) throws Exception {
        String filePath = "input.txt"; // Make sure this file exists
        File file = new File(filePath);
        long fileSize = file.length();
        int totalChunks = (int) Math.ceil((double) fileSize / CHUNK_SIZE);

        System.out.println("Total Chunks to send: " + totalChunks);

        // Inform receiver about total chunks
        sendTotalChunkCount(totalChunks);

        // Create thread pool
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        // Submit each chunk task
        for (int i = 0; i < totalChunks; i++) {
            int chunkNumber = i;
            executor.submit(new ChunkSenderTask(filePath, chunkNumber));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }

        System.out.println("All chunks sent successfully.");
    }

    private static void sendTotalChunkCount(int totalChunks) throws IOException {
        try (Socket socket = new Socket(HOST, PORT);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            dos.writeInt(-1); // control signal
            dos.writeInt(totalChunks); // total number of chunks
            dos.flush();
        }
    }

    static class ChunkSenderTask implements Runnable {
        private final String filePath;
        private final int chunkNumber;

        public ChunkSenderTask(String filePath, int chunkNumber) {
            this.filePath = filePath;
            this.chunkNumber = chunkNumber;
        }

        @Override
        public void run() {
            try (FileInputStream fis = new FileInputStream(filePath);
                 BufferedInputStream bis = new BufferedInputStream(fis);
                 Socket socket = new Socket(HOST, PORT);
                 DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

                int start = chunkNumber * CHUNK_SIZE;
                byte[] buffer = new byte[CHUNK_SIZE];

                // Skip to this chunk's position
                bis.skip(start);

                int bytesRead = bis.read(buffer);
                if (bytesRead <= 0) {
                    return;
                }

                dos.writeInt(chunkNumber);     // chunk number
                dos.writeInt(bytesRead);       // actual length
                dos.write(buffer, 0, bytesRead); // actual data
                dos.flush();

                System.out.println("Sent chunk " + chunkNumber + " (" + bytesRead + " bytes)");

            } catch (IOException e) {
                System.err.println("Error sending chunk " + chunkNumber + ": " + e.getMessage());
            }
        }
    }
}
