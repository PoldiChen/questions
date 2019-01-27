package question012;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class PermGenOutOfMemory {
	
	public static void main(String[] args) {
		URL url = null;
		List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
		try {
			url = new File("/tmp").toURI().toURL();
			URL[] urls = {url};
			while (true) {
				ClassLoader classLoader = new URLClassLoader(urls);
				classLoaders.add(classLoader);
				classLoader.loadClass("question162.PermGenOutOfMemory");
			}
		} catch (Exception e) { // java.lang.OutOfMemoryError: Java heap space
			e.printStackTrace();
		}
	}

}
