package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws IOException {

        Connection conn = null;
        try {
            // Mengatur koneksi ke database SQLite
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\nanda\\Documents\\SQL Lite\\Database\\ecommerce.db");}
        catch (
                SQLException e) {
            e.printStackTrace();
        }

        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 5093), 0);
        httpServer.createContext("/ecommerce", new ecommerceHandler());
        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.start();
    }

    public static class ecommerceHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            if ("GET".equals(exchange.getRequestMethod())){

                OutputStream outputStream = exchange.getResponseBody();
                String responseToBeSentBack = DatabaseConnection.Connection();
                exchange.sendResponseHeaders(200, responseToBeSentBack.length());

                outputStream.write(responseToBeSentBack.getBytes());
                outputStream.flush();
                outputStream.close();

            }
        }
    }


}