package com.example.blogging.blogging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        final int PORT = 8080;

        // 서버 소켓 생성
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                // 클라이언트 연결 대기
                Socket clientSocket = serverSocket.accept();
                // 클라이언트 요청을 처리하는 스레드 생성
                Thread clientHandler = new Thread(() -> {
                    try (BufferedReader reader =
                                 new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        
                        String inputLine;
                        StringBuilder requestData = new StringBuilder();
                        // 클라이언트로부터 데이터 읽기
                        while ((inputLine = reader.readLine()) != null) {
                            requestData.append(inputLine).append("\n");
                            // HTTP 요청의 경우 빈 줄이 나오면 헤더 끝
                            if (inputLine.isEmpty()) {
                                break;
                            }
                        }
                        
                        // 요청 데이터 콘솔에 출력
                        System.out.println("=== Request Data from " + clientSocket.getInetAddress() + " ===");
                        System.out.println(requestData);
                        System.out.println("=== End of Request ===\n");
                        
                    } catch (IOException e) {
                        System.err.println("Error handling client request: " + e.getMessage());
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            System.err.println("Error closing client socket: " + e.getMessage());
                        }
                    }
                });
                
                clientHandler.start();
            }
            
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
