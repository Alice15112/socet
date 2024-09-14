import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer {
    public static void main(String[] args) {
        int portNumber = 8080;

        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Сервер ожидает подключений...");

            while (true) {

                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключение установлено: " + clientSocket);

                OutputStream out = clientSocket.getOutputStream();

                out.write("OK\n".getBytes("UTF-8"));

                clientSocket.close();
                System.out.println("Соединение закрыто");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
