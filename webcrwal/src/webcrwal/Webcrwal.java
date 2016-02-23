/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrwal;
import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;



/**
 *
 * @author mamun
 */
public class Webcrwal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        File input = new File("C:\\Users\\mamun\\Desktop\\New folder (2)\\web.html");
	Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
	//Document doc = Jsoup.parse(input);
	try {
		FileWriter writer = new FileWriter("C:\\Users\\mamun\\Desktop\\New folder (2)\\dataout.csv");
	
		for (Element table : doc.select("table.yfi_portfolios_multiquote")) {
			for (Element row : table.select("tr")) {
				Elements ths = row.select("th");
				Elements tds = row.select("td");
				if(ths.size()>0){
					for ( Element cellh : ths){
						writer.write(cellh.text().replace(",","").concat(","));
					}
				}
                                int col=0;
				for ( Element cell : tds){
                                        col++;
					writer.write(cell.text().replace(",","").concat(","));
                                        
                                        System.out.println(col);
                                        
                                       /* //FileWriter writer2= new FileWriter("C:\\Users\\mamun\\Desktop\\New folder (2)\\"+cell.text());
                                        if(col == 1)
                                        {
                                             File writer1 = new File("C:\\Users\\mamun\\Desktop\\New folder (2)\\"+cell.text()+".csv");                                      
                                           if(!writer1.exists()) {
                                               System.out.println("if");
                                            writer1.createNewFile();
                                            }                                                                                      
                                            else
                                            {
                                             System.out.println("else");
                                            //writer2.write(cell.text().replace(",","").concat(","));
                                            }
                                        }*/
                                     if(col==1)
                                     {
                                         System.out.println("hi"+cell.text());
                                         File file = new File("C:\\Users\\mamun\\Desktop\\New folder (2)\\"+cell.text()+".csv");
                                         boolean b = false; 
                                            if (!file.exists()) {
                                                 b = file.createNewFile();
                                            }
                                             if (b)
                                        System.out.println("Empty File successfully created");
                                        else
                                        System.out.println("Failed to create File");
                                        /*   
 
                                            


 
                                       */
                                        
                                        }

                                       
                                       
                                       
                                       
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


