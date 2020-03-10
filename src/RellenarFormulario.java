import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RellenarFormulario {

    public static void main(String[] args) throws IOException {
        String nombre = "David";
        String bool = "Si";
        URL direccion = new URL("https://docs.google.com/forms/u/0/d/e/1FAIpQLScE6sxLFb3BmCmT2TKHQH5ormS0qvjHwO-uTAR8MXaagBvSSQ/formResponse");
        HttpURLConnection connection = (HttpURLConnection) direccion.openConnection();
        //ACTIVAR ESCRITURA
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");

        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("entry.835030737="+nombre+"&entry.1616686619="+bool);
        dataOutputStream.close();
        dataOutputStream.flush();

        BufferedReader in= new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        while((line=in.readLine())!=null) {
            System.out.println(line);
        }
        in.close();
    }
}
