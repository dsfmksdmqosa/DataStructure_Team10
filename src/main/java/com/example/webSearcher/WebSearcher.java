package com.example.webSearcher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebSearcher {
	public String urlStr;
    private String content;

    public WebSearcher(String urlStr) {
        this.urlStr = urlStr;
    }

    private String fetchContent() throws IOException{
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	
		String retVal = "";
	
		String line = null;
		
		while ((line = br.readLine()) != null){
		    retVal = retVal + line + "\n";
		}
	
		return retVal;
    }
    
    public int BoyerMoore(String T, String P){
        int i = P.length() -1;
        int j = P.length() -1;
        char [] Tarray = new char[T.length()];
        char [] Parray = new char[P.length()];
    	while(i <= T.length()-1) {
    		if(Tarray[i] == Parray[j]) {
    			if(j == 0) return i;
    			i--; 
    			j--;
    		}else {
    			int l = last(Parray[j],P);
    			i = i + P.length() - Math.min(j, l + 1);
    			j = P.length() - 1;
    			
    		}
    	}
        // Bonus: Implement Boyer-Moore Algorithm     
        return -1;
    }

    public int last(char c, String P){
    	// Bonus: Implement last occurence function
    	/*
    	char[] Carray = P.toCharArray(); 
    	int cout = -1;
    	for(int i = 0; i < Carray.length; i++){    	
    		if(Carray[i] == c) cout++;
    	}
    	if(cout != -1) {
    		return cout;
    	}
    	*/
        return -1;
    }

    public int min(int a, int b){
        if (a < b)
            return a;
        else if (b < a)
            return b;
        else 
            return a;
    }
    
    public int countKeyword(String keyword) throws IOException{
		if (content == null){
		    content = fetchContent();
		}
		
		//To do a case-insensitive search, we turn the whole content and keyword into upper-case:
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
	
		int retVal = 0; 

		// 1. calculates appearances of keyword (Bonus: Implement Boyer-Moore Algorithm)
		// 用indexof的版本
		
		while(content.indexOf(keyword) != -1) {
			content = content.substring(content.indexOf(keyword) + keyword.length() -1);
			retVal++;
		}
		
		return retVal;
    }
}