package testpathfunction;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;

public class test{
			static File jarFile;
	public static String getJarContainingFolder(Class aclass,File jarFile) throws Exception {
		  CodeSource codeSource = aclass.getProtectionDomain().getCodeSource();

	
		  if (codeSource.getLocation() != null) {
		    jarFile = new File(codeSource.getLocation().toURI());
		  }
		  else {
		    String path = aclass.getResource(aclass.getSimpleName() + ".class").getPath();
		    String jarFilePath = path.substring(path.indexOf(":") + 1, path.indexOf("!"));
		    jarFilePath = URLDecoder.decode(jarFilePath, "UTF-8");
		    jarFile = new File(jarFilePath);
		  }
		  return jarFile.getParentFile().getAbsolutePath();
		}
	 public static void main(String[] args) throws URISyntaxException {
	
		String a = null;
		try {
			a = getJarContainingFolder(test.class,jarFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(a);
		 
		 System.out.println(test.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
		 
		 
		 
	 }
}
