package skreamizmLunarTan.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

public class Methods {
	
	public static void getPaint() {
        try {
            Variables.Banner = ImageIO.read(new URL("http://img15.imageshack.us/img15/1452/skreamizmtanner.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static int getPrice(int id) throws IOException { //Credits to Cakemix
		URL url = new URL("http://open.tip.it/json/ge_single_item?item=" + id);
        URLConnection con = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
        String line = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
                line += inputLine;
        }
        in.close();
        if (!line.contains("mark_price"))
                return -1;
        line = line.substring(line.indexOf("mark_price\":\"") + "mark_price\":\"".length());
        line = line.substring(0, line.indexOf("\""));
        line = line.replace(",", "");
        return Integer.parseInt(line);
	}	
}
