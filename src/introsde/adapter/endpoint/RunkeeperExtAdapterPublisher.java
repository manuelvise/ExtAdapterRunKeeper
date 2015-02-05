package introsde.adapter.endpoint;
import java.net.InetAddress;
import java.net.UnknownHostException;

import introsde.adapter.ws.AdapterRunkeeperImpl;

import javax.xml.ws.Endpoint;

public class RunkeeperExtAdapterPublisher {
	public static String SERVER_URL = "http://localhost";
	public static String PORT = "6905";
	public static String BASE_URL = "/ws/lifecoach/adapterextrunkeeper";
	
	public static String getEndpointURL() throws UnknownHostException {
		
//		String protocol = "http://";
//		String port = ":443/";
//		String hostname = InetAddress.getLocalHost().getHostAddress();
//		if (hostname.equals("127.0.0.1")) {
//			hostname = "localhost";
//		}
//		
//		return protocol+hostname+":"+PORT+BASE_URL;
		
		return SERVER_URL+":"+PORT+BASE_URL;
	}
 
	public static void main(String[] args) throws UnknownHostException {
		String endpointUrl = getEndpointURL();
		System.out.println("Starting Runkeeper external adapter Service...");
		System.out.println("--> Published at = "+endpointUrl);
		Endpoint.publish(endpointUrl, new AdapterRunkeeperImpl());
    }
}

