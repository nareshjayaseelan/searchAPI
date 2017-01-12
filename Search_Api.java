package REST.REST_Automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadJsonObject{
			
		@Test(dataProvider="TD_Search",dataProviderClass=DataProviderSource.class)
		public void aptTesting(String SearchKePair,String Expected_value) throws Exception {
		try {
		
				URL url = new URL("https://itunes.apple.com/search?"+SearchKePair);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				/*conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");*/
				
				if (conn.getResponseCode() != 200) {
				throw new RuntimeException(" HTTP error code : "
				+ conn.getResponseCode());
				}
				
				Scanner scan = new Scanner(url.openStream());
				String entireResponse = new String();
				while (scan.hasNext())
				entireResponse += scan.nextLine();
				
				System.out.println("Response : "+entireResponse);
				
				scan.close();
				
				JSONObject obj = new JSONObject(entireResponse );
				/*String responseCode = obj.getString("status");
				System.out.println("status : " + responseCode);*/
				
				JSONArray arr = obj.getJSONArray("results");
				for (int i = 0; i < arr.length(); i++) {
				String trackName = arr.getJSONObject(i).getString("trackName");
				
				//validating Address as per the requirement
				Assert.assertEquals(trackName, Expected_value);
				break;
				}
				
				conn.disconnect();
		} catch (MalformedURLException e) {
				e.printStackTrace();
		
		} catch (IOException e) {
		
		e.printStackTrace();
		
		}
		
		}
		
		@Test(dataProvider="TD_Search1",dataProviderClass=DataProviderSource.class)
		public void aptTestinNegative(String SearchKePair,String Expected_value) throws Exception {
		try {
		
				URL url = new URL("https://itunes.apple.com/search?"+SearchKePair);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				/*conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");*/
				
				
				Assert.assertEquals(conn.getResponseCode(), Expected_value);
				
				
				conn.disconnect();
		} catch (MalformedURLException e) {
				e.printStackTrace();
		
		} catch (IOException e) {
		
		e.printStackTrace();
		
		}
		
		}
}