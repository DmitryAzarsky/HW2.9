import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.security.InvalidParameterException;

public class HttpStatusChecker {
    public static void main(String[] args) {
        System.out.println(new HttpStatusChecker().getStatusImage(4040));
    }
    public static final String CATS_URL = "https://http.cat/";
    String getStatusImage(int code) throws RuntimeException {
        int responseCode = 0;
        try {
            URL url = new URL(CATS_URL + code);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (responseCode == 404) {
            throw new RuntimeException("Wrong response code entered");
        } else {
            return CATS_URL + code;
        }
    }
}
