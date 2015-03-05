package com.alexandreamyot.school;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class InputStreamTest {

    @Test
    public void convertsIntoByteArray() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 0, 1, 2 });
        byte[] targetArray = new byte[inputStream.available()];
        inputStream.read(targetArray);

        assertThat(targetArray, equalTo(new byte[] { 0, 1, 2 }));
    }

    @Test
    public void convertsIntoString() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("All work and no play makes Jack a dull boy.".getBytes());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        String out = bufferedReader.readLine();

        assertThat(out, equalTo("All work and no play makes Jack a dull boy."));
    }

}
