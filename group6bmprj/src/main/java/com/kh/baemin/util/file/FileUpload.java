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


	public static String save(Part f, ServletContext context, String saveRootPath) {

		try {
			// ������ ���ε�� ���
			if (f.getSize() > 0) {
				// ������ ������ �����ϱ�
				String originFileName = f.getSubmittedFileName(); // ���� ���� �̸��� ������
				InputStream is = f.getInputStream(); // ������ �Է� ��Ʈ���� ������


				String resourceRoot = context.getRealPath("/resources");
				String filePath = resourceRoot + "/" + saveRootPath;

				java.io.File dir = new java.io.File(filePath); // ���� ���� ����� ���丮 ��ü ����
				if (!dir.exists()) {
					dir.mkdirs(); // ���丮�� �������� ������ ����
				}

				String random = UUID.randomUUID().toString(); // ������ ���� �̸� ������ ���� ���� ���ڿ� ����
				String ext = originFileName.substring(originFileName.lastIndexOf(".")); // ���� Ȯ���ڸ� ������
				String changeName = System.currentTimeMillis() + "_" + random + ext; // ���� �ð��� ���� ���ڿ��� �����Ͽ� ������ ���� �̸� ����
				FileOutputStream fos = new FileOutputStream( filePath + "/" + changeName); // ���� ������ ���� ��� ��Ʈ�� ����

				byte[] buf = new byte[1024]; // ������ �а� ���� ���� ���� ����
				int size = 0;
				while ((size = is.read(buf)) != -1) { // �Է� ��Ʈ������ �����͸� �о� ���ۿ� ����
					fos.write(buf, 0, size); // ���ۿ� �ִ� �����͸� ��� ��Ʈ���� ��
				}

				is.close(); // �Է� ��Ʈ�� �ݱ�
				fos.close(); // ��� ��Ʈ�� �ݱ�
				return "/" + saveRootPath + "/" + changeName;
			}
			return null;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}


}
