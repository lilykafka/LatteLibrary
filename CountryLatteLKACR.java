

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Random;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class CountryLatteLKACR {
	public static void main(String[] args) throws IOException, UnirestException {



	}

	public static CountryLatteLKACR fetch() throws IOException, UnirestException
	{
		
		while(true)
		{
			//build a country latte
			CountryLatteLKACR country = new CountryLatteLKACR();

			//build random IP
			Random r = new Random();
			String randomIP = r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
			country.setIP(randomIP);
			//System.out.println(IpConverter.longToIp(r.nextLong()));


			System.out.println(country.getIP());
			//Build URL using random IP
			String url = "http://www.hajanaone.com/api/ip2country.php?ip="+ country.getIP();
			System.out.println(url);

			StringBuilder result = new StringBuilder();
			URL urlu = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) urlu.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
			System.out.println(result.toString());
			country.setCountry(result.toString());

			if(country.getCountry() != null)
			{
				
				return country;
	
			}
		}


	}
	public static CountryLatteLKACR fetch(String ipIn) throws IOException, UnirestException
	{
		CountryLatteLKACR country = new CountryLatteLKACR();

		//String urlchange = "https://hajana1-ip-to-country-name-v1.p.mashape.com/free-ip-country-api.php?ip=";
		country.setIP(ipIn);
		String url = "http://www.hajanaone.com/api/ip2country.php?ip="+ country.getIP();
		System.out.println(url);

		StringBuilder result = new StringBuilder();
		URL urlu = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) urlu.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		System.out.println(result.toString());
		country.setCountry(result.toString());

		//		System.out.println(response.getBody());


		return country;

	}
	String country;
	String IP;
	public void setIP(String input)
	{
		IP = input;
	}
	public String getIP ()
	{
		return IP;
	}
	public void setCountry(String countryIn)
	{
		country = countryIn;
	}
	public String getCountry()
	{
		return country;
	}






}