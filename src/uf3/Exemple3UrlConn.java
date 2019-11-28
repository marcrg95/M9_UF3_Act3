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
			System.out.println("ADREÇA, DARA I CONTINGUT");
			System.out.println("Adreça [getURL]: " + connexio.getURL());

			Date data = new Date(connexio.getLastModified());
			System.out.println("Data última modificació [getLastModified()]: " + data);
			System.out.println("Tipus de Contingut [getContentType()]" + connexio.getContentType());

			System.out.println("===============================================================");
			System.out.println("TOTS ELS CAMPS DE CAPÇALERA AMB getHeaderFields(): ");

			//Fem servir una estructura Map per a recuperar capçaleres
			Map campsCapçalera = connexio.getHeaderFields();
			Iterator it = campsCapçalera.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry map = (Map.Entry) it.next();
				System.out.println(map.getKey() + ":" + map.getValue());
			}

			System.out.println("===============================================================");
			System.out.println("Camps 1, 2, 3, 4 i 5 de Capçalera");
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