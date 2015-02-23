package com.alexandreamyot.school;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class InputStreamTest {

    @Test
    public void canConvertInputStreamIntoByteArray() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 0, 1, 2 });

        byte[] targetArray = new byte[inputStream.available()];
        inputStream.read(targetArray);

        assertThat(targetArray, equalTo(new byte[] { 0, 1, 2 }));
    }

}
