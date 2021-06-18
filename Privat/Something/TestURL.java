
public class TestURL {
	
	static char[] urlChar = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','-','_'};
	
	public static void main(String[] args) {
		//if(isURL("https://www.youtube.com/watch?v=-FBwZtuJtMw/mqdefault.jpg")) {
		
//		if(isURL("https://i.ytimg.com/vi/vKA4w2O61Xo/maxresdefault.jpg")) {
//			System.out.println("test");
//		}
		//ca 16 milli
		
		generateAllURL(0, "");
		
		System.out.println("done");
	}
	
	public static void generateAllURL(int depth, String URL) {
		
		if(depth == 10) {
			System.out.println(URL + "A");
		}
		
		if(depth >= 11) {
			//URL = "iQW3qXUaeFY";
				
			String trueURL = "https://www.youtube.com/oembed?url=http%3A//www.youtube.com/watch%3Fv%3D" + URL;
			//String trueURL = "https://i.ytimg.com/vi/" + URL + "/maxresdefault.jpg";
			
			if(isURL(trueURL)) {
				System.out.println(URL);
			}
			
			//System.out.println(URL);
		}
		else {
			for (int i = 0; i < urlChar.length; i++) {
				generateAllURL(depth + 1, URL + String.valueOf(urlChar[i]));
			}
		}
	}
	
	public static boolean isURL(String url) {
		try {
			(new java.net.URL(url)).openStream().close();
			return true;
		} catch (Exception ex) { }
		return false;
	}
}
