import java.util.Scanner;

public class HttpImageStatusCli {
    public static void main(String[] args) {
        askStatus();
    }
    public static void askStatus() {
        int code = readHttpCodeFromConsole();
        try {
            new HttpStatusImageDownloader().downloadStatusImage(code);
        } catch (RuntimeException e) {
            System.out.println("There is not image for HTTP status "+code);
        }
    }
    private static int readHttpCodeFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        return Integer.parseInt(scanner.nextLine());
    }
}
