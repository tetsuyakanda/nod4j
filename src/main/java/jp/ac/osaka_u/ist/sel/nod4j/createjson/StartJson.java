package jp.ac.osaka_u.ist.sel.nod4j.createjson;

import java.io.IOException;

import jp.ac.osaka_u.ist.sel.nod4j.data.SeloggerFiles;

/**
 * This class calls the module which creates varInfo.json and fileInfo.json, and print them.
 * @author k-simari
 */
public class StartJson {
	private SeloggerFiles selFiles;
	private String projectDir;
	private String traceDir;
	private String outputDir;
	private static final String VARINFO_FILENAME = "varinfo.json";
	private static final String FILEINFO_FILENAME = "fileinfo.json";

	public StartJson(SeloggerFiles selFiles, String projectDir, String outputDir) {
		this.selFiles = selFiles;
		this.projectDir = projectDir;
		this.outputDir = outputDir;
	}

	public void start() {
		System.out.println("Create json ...");
		startJson(new CreateStructure(projectDir), FILEINFO_FILENAME);
		startJson(new CreateVarInfo(selFiles), VARINFO_FILENAME);
	}

	private void startJson(ICreateJson cj, String filename) {
		Object json = cj.create();
		print(json, filename);
	}

	private void print(Object json, String filename) {
		try {
			PrintJson pj = new PrintJson(outputDir, filename);
			pj.printJson(json);
			//pj.printJsonForDebug(jsonList);
			System.out.println("Create json SUCCESS at " + outputDir);
		} catch (IOException e) {
			System.err.println("Create json FAILED");
			e.printStackTrace();
		}
	}

}