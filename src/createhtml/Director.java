package createhtml;

import builder.Builder;
import logvis.SrcFiles.SrcFile;

public class Director {

	private Builder builder;

	// 実際はBuilderのサブクラスを引数に取る
	public Director(Builder builder) {
		this.builder = builder;
	}

	// 文章の中身を作る
	public void construct(String dir,SrcFile file) {
		builder.makeTitle(file.getFilename()+".java");
		builder.makeHeading("今日の目標");
		for(String line: file.getLines()) {
			builder.makeContents(line);
		}
		builder.makeHeading("使うもの");
		builder.makeContents("Java言語で学ぶデザインパターン入門");
		builder.close(dir);
	}
}