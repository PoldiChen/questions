package question011;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * url±àÂëºÍ½âÂë
 * @author Administrator
 *
 */
public class UrlEncode {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String url = "www.chenxihong.com/ test";
		String urlEncoded = URLEncoder.encode(url);
		System.out.println(urlEncoded);
		String urlDecoded = URLDecoder.decode(urlEncoded);
		System.out.println(urlDecoded);
	}

}
