package StringPack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;


public class Regex {
	
		public void useRegex() throws IOException, NullPointerException  {
			
			String target = "<p>hi</p> "
					+ "<a href='index.html'>hello</a>"
					+ "<a href=\"http://google.com\">" + 
					"      <A target=\"mainframe\" href=’data321.html’>" + 
					"      <a id=’link23’ HREF = \"file23.html\" target=\"_TOP\">" + 
					"      <a href=\"images/myhouse.png\">"; 
			
			Scanner in = new Scanner(target);
			in.useDelimiter("\n");
			
			while (in.hasNext()) {
				target = in.next();
				if (target != null) {
				
				
					target.toLowerCase();
					Pattern p = Pattern.compile("<A\\b[^>]*(HREF\\s*=\\s*[\\\"'’])(.*?)[\\\"'’]>", Pattern.CASE_INSENSITIVE);
					
					Matcher m = p.matcher(target);
					
					Scanner scan = null;
					String url = null;
					
					while (m.find()) {
					    url = m.group();
						System.out.println(url);
						
					    scan = new Scanner(url);
						scan.useDelimiter("[\"\'’]");
						while (scan.hasNext()) {
							String nextScan = scan.next();
							if (nextScan.matches(".*HREF\\s*=\\s*")|nextScan.matches(".*href\\s*=\\s*")) {
									System.out.println(scan.next());
								}
						}
						System.out.println();
					}
					
				}
			}
			
			in.close();
		}
	}

