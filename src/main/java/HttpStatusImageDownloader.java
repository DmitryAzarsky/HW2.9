import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class HttpStatusImageDownloader {
    void downloadStatusImage(int code) throws RuntimeException{
        try {
            BufferedInputStream in = new BufferedInputStream(getHttpUrlConnection(code).getInputStream());
            FileOutputStream out = new FileOutputStream(new File("./cat" + code + "_image.jpg"));
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static HttpURLConnection getHttpUrlConnection(int code) throws IOException {
        URL url = new URL(new HttpStatusChecker().getStatusImage(code));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }
}
