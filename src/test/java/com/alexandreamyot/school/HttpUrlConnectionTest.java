package com.alexandreamyot.school;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.charset.Charset;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HttpUrlConnectionTest {

    private HttpServer server;
    private boolean ping;

    @Before
    public void startServers() throws Exception {

        server = HttpServer.create(new InetSocketAddress(7002), 0);
        server.createContext("/", exchange -> {
            ping = true;
            String response = readBody(exchange);
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
            exchange.close();
        });
        server.start();
    }

    private String readBody(HttpExchange exchange) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody(), Charset.forName("UTF-8")));
        return reader.lines().collect(joining());
    }

    @After
    public void stopServers() throws Exception {
        server.stop(1);
    }

    @Test
    public void readsTheResponseFromTheServer() throws IOException {
        URL url = new URL("http://localhost:7002/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        writeBody(connection, "my tailor is rich");

        assertThat(readResponse(connection), equalTo("my tailor is rich"));
    }

    @Test
    public void readsTheResponseFireTheRequest() throws IOException {
        URL url = new URL("http://localhost:7002/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        assertFalse(ping);

        connection.getResponseCode();

        assertTrue(ping);
    }

    private void writeBody(HttpURLConnection connection, String content) throws IOException {
        connection.getOutputStream().write(content.getBytes());
    }

    private String readResponse(HttpURLConnection connection) throws IOException {
        InputStream is = connection.getInputStream();
        byte[] content = new byte[is.available()];
        is.read(content);
        return new String(content);
    }

}
