package theSmallApp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 7777;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, PORT);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader userText = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            Thread messageThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = userText.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            messageThread.start();

            String userInput;

            while (true) {
                userInput = reader.readLine();
                if (ClientHandler.EXIT_MESSAGE.equals(userInput)) {
                    System.out.println("채팅이 종료되었습니다.");
                    break;
                } else {
                    outToServer.println(userInput);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
