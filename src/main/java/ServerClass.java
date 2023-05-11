import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass {
    private static final int PORT = 8888;
    public static void main(String[] args) {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) { // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    out.println("Введите имя");
                    out.flush();


                    String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                    System.out.println("Соединение установлено");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
