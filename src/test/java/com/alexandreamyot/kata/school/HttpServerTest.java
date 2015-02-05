package com.alexandreamyot.kata.school;

import com.sun.net.httpserver.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class HttpServerTest {

    private HttpServer serverThatAlwaysAnswers200;

    @Before
    public void startServers() throws Exception {

        serverThatAlwaysAnswers200 = HttpServer.create(new InetSocketAddress(7002), 0);
        serverThatAlwaysAnswers200.createContext("/", exchange -> {
            exchange.sendResponseHeaders(200, 0);
            exchange.close();
        });
        serverThatAlwaysAnswers200.start();
    }

    @After
    public void stopServers() throws Exception {
        serverThatAlwaysAnswers200.stop(1);
    }

    @Test
    public void canConnect() throws IOException {
        URL url = new URL("http://localhost:7002");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        assertThat(connection.getResponseCode(), equalTo(200));
    }
}
