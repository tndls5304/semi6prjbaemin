package com.kh.baemin.util.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletContext;
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


	public static String save(Part f, ServletContext context) {

		try {
			// 파일이 업로드된 경우
			if (f.getSize() > 0) {
				// 파일을 서버에 저장하기
				String originFileName = f.getSubmittedFileName(); // 원본 파일 이름을 가져옴
				InputStream is = f.getInputStream(); // 파일의 입력 스트림을 가져옴

				String path = context.getRealPath("/resources/upload/");

				java.io.File dir = new java.io.File(path); // 파일 저장 경로의 디렉토리 객체 생성
				if (!dir.exists()) {
					dir.mkdirs(); // 디렉토리가 존재하지 않으면 생성
				}

				String random = UUID.randomUUID().toString(); // 고유한 파일 이름 생성을 위한 랜덤 문자열 생성
				String ext = originFileName.substring(originFileName.lastIndexOf(".")); // 파일 확장자를 가져옴
				String changeName = System.currentTimeMillis() + "_" + random + ext; // 현재 시간과 랜덤 문자열을 조합하여 고유한 파일 이름 생성
				FileOutputStream fos = new FileOutputStream(path + changeName); // 파일 저장을 위한 출력 스트림 생성

				byte[] buf = new byte[1024]; // 파일을 읽고 쓰기 위한 버퍼 생성
				int size = 0;
				while ((size = is.read(buf)) != -1) { // 입력 스트림에서 데이터를 읽어 버퍼에 저장
					fos.write(buf, 0, size); // 버퍼에 있는 데이터를 출력 스트림에 씀
				}

				is.close(); // 입력 스트림 닫기
				fos.close(); // 출력 스트림 닫기
			}
			return null;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}


}
