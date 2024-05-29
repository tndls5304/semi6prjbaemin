package com.kh.baemin.util.file;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.Part;

import com.kh.baemin.store.vo.StoreInforVo;

public class FileUpload {
	
	public static StoreInforVo saveFile(Part f) throws Exception {
		
		InputStream is = f.getInputStream();
		String path = "D:\\dev\\group6bmWorkspace\\group6bmprj\\src\\main\\webapp\\resources\\upload\\";
		int random = (int)(Math.random() * 90000) + 10000;
		String businessRegistrationCertificateImg = f.getSubmittedFileName();
		FileOutputStream fos = new FileOutputStream(path + businessRegistrationCertificateImg);
		
		byte[] buf = new byte[1024];
		int size = 0;
		while( (size=is.read(buf)) != -1 ) {
			fos.write(buf , 0, size);
		}
		
		is.close();
		fos.close();
		
		StoreInforVo siVo = new StoreInforVo();
		siVo.setBusinessRegistrationCertificateImg(businessRegistrationCertificateImg);
		
		return siVo;
	}//method

}
