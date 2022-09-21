import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Scraper {

	public static void main(String[] args) {
		
		
		
		final String url = "https://www.rotoballer.com/nfl-game-center-live-scores-fantasy-football-scoreboard?src=rtr";
		
		try {
			final Document doc = Jsoup.connect(url).get();
			
			
			
			for(Element row: doc.select("table.marianExclude.sortable tr")) {
				 String player = row.select("td:nth-child(1)").text();
				// String position = row.select("td:nth-child(1)").text();
				 
				 if(row.select("td:nth-child(1)").text().equals("")) {
					 continue;
				 }
				
				 else {
					 
					String halfPpr = row.select("td:nth-of-type(6)").text();	
				 	
					if(!halfPpr.equals("0")) {
				 	System.out.println(player + " "+ halfPpr);
					}
				 }
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
