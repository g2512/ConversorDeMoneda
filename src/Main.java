import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura=new Scanner(System.in);
        System.out.println("Escriba el nombre de una moneda: ");
        String busqueda= lectura.nextLine();
        {
            String direccion ="https://v6.exchangerate-api.com/v6/1f76ea4b8742f68115acb789/latest/"+busqueda;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json=response.body();
            System.out.println(json);
        }
        System.out.println("Fin");
    }
}