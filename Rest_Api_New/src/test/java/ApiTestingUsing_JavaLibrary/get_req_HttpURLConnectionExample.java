package ApiTestingUsing_JavaLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class get_req_HttpURLConnectionExample {
	
	public void getMethodExample() throws IOException {
		
		URL url = new URL("https://dummy.restapiexample.com/api/v1/employee/1");
		HttpURLConnection connection =  (HttpURLConnection)url.openConnection();
		
		connection.setRequestMethod("GET");
		connection.connect();
		
		int responseCode = connection.getResponseCode();
		System.out.println("Status Code : "+responseCode);
		
		String responseMessage = connection.getResponseMessage();
		System.out.println("Response Message : "+responseMessage);
		
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String line;
		StringBuffer buffer = new StringBuffer();
		while((line = bufferedReader.readLine())!=null) {
			buffer = buffer.append(line);
		}
		
		System.out.println(buffer);
		
	}
	
	public static void main(String[] args) throws IOException {
		get_req_HttpURLConnectionExample connectionExample = new get_req_HttpURLConnectionExample();
		connectionExample.getMethodExample();
	}

}
