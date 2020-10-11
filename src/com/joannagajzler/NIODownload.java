package com.joannagajzler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class NIODownload {

    private final static String absolutePath = System.getProperty("user.dir") + "\\nbpXML.xml";

    public static void downloadXML() throws IOException {
        final String urlString = "https://www.nbp.pl/kursy/xml/lasta.xml";
        URL url = new URL(urlString);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

        fileOutputStream.close();
        readableByteChannel.close();
    }

    public static String getAbsolutePath() {
        return absolutePath;
    }
}
