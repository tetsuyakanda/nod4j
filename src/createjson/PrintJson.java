package createjson;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.Json;

public class PrintJson {
	private String targetDir;
	private String filename;

	public PrintJson(String dir, String filename) {
		this.targetDir = dir;
		this.filename = filename;
	}

	void printJson(List<Json> jsonList) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		MyFormater jf = new MyFormater(jsonList);
		ArrayList<String> lines = new ArrayList<String>();
		lines.add(mapper.writeValueAsString(jf));

		if (Files.exists(Paths.get(targetDir, filename))) {
			Files.delete(Paths.get(targetDir, filename));
		}
		Files.createFile(Paths.get(targetDir, filename));
		Files.write(Paths.get(targetDir, filename), lines, Charset.forName("UTF-8"), StandardOpenOption.WRITE);
	}

	/*For Debug*/
	void printJsonForDebug(List<Json> jsonList) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<String> lines = jsonList.stream()
				.map(s -> {
					try {
						return mapper.writeValueAsString(s);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
						return "";
					}
				})
				.collect(Collectors.toList());
		if (Files.exists(Paths.get(targetDir, filename))) {
			Files.delete(Paths.get(targetDir, filename));
		}
		Files.createFile(Paths.get(targetDir, filename));
		Files.write(Paths.get(targetDir, filename), lines, Charset.forName("UTF-8"), StandardOpenOption.WRITE);
	}

	class MyFormater {
		List<Json> recentdata;

		public MyFormater(List<Json> recentdata) {
			this.recentdata = recentdata;
		}

		public List<Json> getRecentdata() {
			return recentdata;
		}
	}
}
