import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
class WebCrawler {

public static void main( String[] args ) throws IOException{  
	
	File input = new File("web.html");
	Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
	//Document doc = Jsoup.parse(input);
	try {
		FileWriter writer = new FileWriter("dataout.csv");
	
		for (Element table : doc.select("table.yfi_portfolios_multiquote")) {
			for (Element row : table.select("tr")) {
				Elements ths = row.select("th");
				Elements tds = row.select("td");
				if(ths.size()>0){
					for ( Element cellh : ths){
						writer.write(cellh.text().replace(",","").concat(","));
					}
				}
				for ( Element cell : tds){
					writer.write(cell.text().replace(",","").concat(","));
				}
				writer.write("\n");
			}
			writer.close();
		}
	} catch (IOException e) {
		e.getStackTrace();
	}
        //    String title = doc.title();  
        //    System.out.println("title is: " + title);  
}  
}

