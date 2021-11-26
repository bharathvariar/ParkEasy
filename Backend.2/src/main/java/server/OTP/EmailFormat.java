package server.OTP;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class EmailFormat {
	private String format;
	private Map replacementParams;
	public EmailFormat(String custom) {
		try {
			this.format = loadFormat(custom);
		} catch(Exception e) {
			this.format = "Empty";
		}
	}
	private String loadFormat(String custom) throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(custom).getFile());
		String content = "Empty";
		try {
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			throw new Exception("Could not read template  = " + custom);
		}
		return content;
	}
	public String getFormat(Map<String,String> replacement) {
		
		String cFormat = this.format; 
		for (Map.Entry entry : replacement.entrySet()) {
			cFormat = cFormat.replace("{{" + entry.getKey() + "}}", (CharSequence) entry.getValue());
		}
		return cFormat;
    }

}
