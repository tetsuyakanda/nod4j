package data;

public class DataIdVar {
//	private String filename;
//	private Integer linenum;

	private String var;
	private Integer count;
/*
	public DataIdVar(String filename, Integer linenum, String var, Integer count) {
		this.filename = filename;
		this.linenum = linenum;
		this.var = var;
		this.count = count;
	}
*/
	public DataIdVar(String var, Integer count) {
		this.var = var;
		this.count = count;
	}

/*
	public String getFilename() {
		return filename;
	}

	public Integer getLinenum() {
		return linenum;
	}
*/

	public String getVar() {
        return var;
    }

    public Integer getCount() {
        return count;
    }
}