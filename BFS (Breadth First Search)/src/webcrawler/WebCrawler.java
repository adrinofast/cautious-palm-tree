package webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	private Queue<String> queue ;
	private List<String> discoveredWebsites;
	
	public WebCrawler()
	{
		this.queue = new LinkedList<>();
		this.discoveredWebsites = new ArrayList<>();
		
		
	}
	
	public void discoveredWeb(String root)
	{
		
		queue.add(root);
		this.discoveredWebsites.add(root);
		
		
		while(!queue.isEmpty())
		{
			String v = queue.remove();
			String rowHtml =  readURL(v);
			
			String regExp = "https://(\\w+\\.)*(\\w+)"; 
			
			Pattern pattern = Pattern.compile(regExp); 
			Matcher matcher = pattern.matcher(rowHtml);
			
			//System.out.println(matcher.toString());
			while(matcher.find())
			{
				String actualURL = matcher.group();
				//System.out.println("aeusfgun");
				if(!discoveredWebsites.contains(actualURL))
				{
					discoveredWebsites.add(actualURL);
					System.out.println("Website ahs been found wth URL" + "" + actualURL);
					queue.add(actualURL);
				} 
			}
			
		}
		
	}

	private String readURL(String v) {
		
		String rowHtml= "";
		
		try {
			
			URL url = new URL(v);
			BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String inputLine ="";
			
			while((inputLine = input.readLine()) != null)
			{
				rowHtml += inputLine;
				
			}
			 
			input.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//System.out.println(rowHtml);
		return rowHtml;
	}
	
	
	
}
