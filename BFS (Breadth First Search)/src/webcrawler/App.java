package webcrawler;

public class App {
	
	public static void main(String[] args)
	{
		//System.out.println("asd hasd");
		WebCrawler webCrawler= new WebCrawler();
		
		String rootUr = "http://www.bbc.com";
		
			webCrawler.discoveredWeb(rootUr);
			
	}

}
