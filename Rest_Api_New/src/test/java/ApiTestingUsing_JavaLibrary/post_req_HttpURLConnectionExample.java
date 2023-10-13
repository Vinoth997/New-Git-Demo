package ApiTestingUsing_JavaLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class post_req_HttpURLConnectionExample {

	public void postMethodExample() throws IOException {

		URL url = new URL("https://reqres.in/api/users");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "appliation/json");
		connection.setDoOutput(true);

		String jsonBody = "{\r\n"
				+ "    \"name\": \"Morbius\",\r\n"
				+ "    \"job\": \"President\"\r\n"
				+ "}";
		byte[] inputJson = jsonBody.getBytes();
		
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(inputJson);
		
		System.out.println("Status Code : "+connection.getResponseCode());
		System.out.println("Response Message : "+connection.getResponseMessage());
		
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);
		
		String line;
		StringBuffer buffer = new StringBuffer();
		while((line = bufferReader.readLine())!=null) {
			buffer = buffer.append(line);
		}
		
		System.out.println(buffer);
	}
	
	public static void main(String[] args) throws IOException {
		post_req_HttpURLConnectionExample postRequestExample = new post_req_HttpURLConnectionExample();
		postRequestExample.postMethodExample();
	}

}
