package org.academiadecodigo.webserver;

public class ResponseHeaders {

    public static String typeText(long fileByteSize) {
        return "HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: text/html; charset=UTF-8\r\n" +
                "Content-Length: " + fileByteSize + "\r\n" +
                "\r\n";
    }

    public static String typeImage(long fileByteSize, String imageFileExtension) {
        return "HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: image/" + imageFileExtension + "\r\n" +
                "Content-Length: " + fileByteSize + "\r\n" +
                "\r\n";
    }

    public static String typeNotFound(long fileByteSize) {
        return "HTTP/1.0 404 Not Found\r\n" +
                "Content-Type: text/html; charset=UTF-8\r\n" +
                "Content-Length: " + fileByteSize + "\r\n" +
                "\r\n";
    }

}
