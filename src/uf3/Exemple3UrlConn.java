package uf3;

import java.net.*;
import java.io.*;
import java.util.*;

public class Exemple3UrlConn {

	@SuppressWarnings("rawtypes")
	public static void main (String[] args) {

		try {
			String cadena;
			URL url = new URL(args[0]);
			URLConnection connexio = url.openConnection();

			System.out.println("===============================================================");
			System.out.println("ADRE�A, DARA I CONTINGUT");
			System.out.println("Adre�a [getURL]: " + connexio.getURL());

			Date data = new Date(connexio.getLastModified());
			System.out.println("Data �ltima modificaci� [getLastModified()]: " + data);
			System.out.println("Tipus de Contingut [getContentType()]" + connexio.getContentType());

			System.out.println("===============================================================");
			System.out.println("TOTS ELS CAMPS DE CAP�ALERA AMB getHeaderFields(): ");

			//Fem servir una estructura Map per a recuperar cap�aleres
			Map campsCap�alera = connexio.getHeaderFields();
			Iterator it = campsCap�alera.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry map = (Map.Entry) it.next();
				System.out.println(map.getKey() + ":" + map.getValue());
			}

			System.out.println("===============================================================");
			System.out.println("Camps 1, 2, 3, 4 i 5 de Cap�alera");
			for (int i = 0; i < Integer.parseInt(args[1]); i++) {
				System.out.println("getHeaderField(" + i + ")=> " + connexio.getHeaderField(i));
			}

			System.out.println("===============================================================");

			System.out.println("Contingut de [url.getFile()]: " + url.getFile());
			BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));

			while ((cadena = pagina.readLine()) != null) {

				if (cadena.indexOf(args[2]) != -1) {
					System.out.println(cadena);
				}
			}

		}
		catch (MalformedURLException e) { e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}

}