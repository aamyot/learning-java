package com.alexandreamyot.school;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FileTest {

    @Test
    public void readsTheContentOfAFile() throws IOException {
        Path path = Paths.get("src/test/resources/file-test.txt");
        String content = new String(Files.readAllBytes(path));

        assertThat(content, equalTo("Everybody's got something to hide"));
    }

    @Test
    public void readsTheContentOfAResource() throws IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("file-test.txt").toURI());
        String content = new String(Files.readAllBytes(path));

        assertThat(content, equalTo("Everybody's got something to hide"));
    }

}
