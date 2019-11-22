package com.mvn.test.vo;

import org.apache.commons.fileupload.FileItem;

import lombok.Data;

@Data
public class PhotoBoardVO {
	private Integer pbNum;
	private String pbContent;
	private String pbImg1Name;
	private String pbImg2Name;
	private FileItem pbImg1;
	private FileItem pbImg2;
	private String pbTitle;
	private String credat;
	private String cretim;
	private Integer creusr;
	private String moddat;
	private String modtim;
	private Integer modusr;
	private Integer pbCnt;
}
