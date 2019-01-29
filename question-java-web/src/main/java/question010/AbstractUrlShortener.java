package question010;

import java.util.Random;

public abstract class AbstractUrlShortener implements UrlShortener {
	
    public static char[] VALID_CHARS = 
    		"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
    private static Random random = new Random(System.currentTimeMillis());
    protected int length = 4;
 
    public AbstractUrlShortener() {
 
    }
 
    public AbstractUrlShortener(int length) {
        this.length = length;
    }
 
    public void setLength(int length) {
        this.length = length;
    }
 
    public int getLength() {
        return length;
    }
 
    public String get(String url) {
        String sortUrl = seek(url);
        if (sortUrl == null) {
            sortUrl = generate(url);
            put(url, sortUrl);
        }
        return sortUrl;
    }
 
    public String generate(String url, int seed) {
        char[] sortUrl = new char[length];
        for (int i = 0; i < length; i++) {
            sortUrl[i] = VALID_CHARS[seed % VALID_CHARS.length];
            seed = random.nextInt(Integer.MAX_VALUE) % VALID_CHARS.length;
        }
        return new String(sortUrl);
    }
 
    public String generate(String url) {
        String shortUrl;
        shortUrl = generate(url, random.nextInt(Integer.MAX_VALUE));
        while (seek(shortUrl) != null) {
            shortUrl = generate(url, random.nextInt(Integer.MAX_VALUE));
        }
        put(url, shortUrl);
        return shortUrl;
    }
 
}
