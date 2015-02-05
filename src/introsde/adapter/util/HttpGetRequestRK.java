package introsde.adapter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import sun.net.www.http.HttpClient;

public class HttpGetRequestRK {

	private String host;
	private String query;
	private String token;
	private String accept;

	public HttpGetRequestRK(String host, String query, String token, String accept) {
		this.host = host;
		this.query = query;
		this.token = token;
		this.accept = accept;
	}

	public String getResponse() {

		String output = null;
		String strResponse = null;

		try {
			String url = host + "/" + query;
			 
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
			// optional default is GET
			con.setRequestMethod("GET");
			
			con.addRequestProperty("Authorization", "Bearer "+token);
			con.addRequestProperty("Accept", accept);
			
			
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());
			strResponse = response.toString();
			

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return strResponse;

	}

}
