package question005;

public class Test {
	
	public static void main(String[] args) {
        for(int j=1;j<10;j++) {
            UrlShortener urlShortener = new UrlShortenerMemory(j);
            for (int i = 0; i < 5; i++) {
                System.out.println(urlShortener.get("http://www.tinygroup.org"));
            }
            System.out.println();
        }
    }

}
