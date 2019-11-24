package com.linkpets.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.util.StreamUtils;

public class FileUtil {

	/***
	 * 计算文件的Content-MD5
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getContentMD5(String filePath) {
		// 获取文件MD5的二进制数组（128位）
		byte[] bytes = getFileMD5Bytes128(filePath);
		// 对文件MD5的二进制数组进行base64编码（而不是对32位的16进制字符串进行编码）
		return new String(Base64.encodeBase64(bytes));
	}

	/***
	 * 计算文件的大小
	 * 
	 * @param filePath
	 * @return
	 */
	public static long getFileSize(String filePath) {
		File file = new File(filePath);
		return file.length();
	}

	/***
	 * 获取文件名
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFileName(String filePath) {
		File file = new File(filePath);
		return file.getName();
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 */
	public static void delFile(String filePath) {
		File file = new File(filePath);
		if (file.exists() && file.isFile()) {
			file.delete();
		}
	}

	/***
	 * 获取文件MD5-二进制数组（128位）
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static byte[] getFileMD5Bytes128(String filePath) {
		FileInputStream fis = null;
		byte[] md5Bytes = null;
		try {
			File file = new File(filePath);
			fis = new FileInputStream(file);
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = fis.read(buffer, 0, 1024)) != -1) {
				md5.update(buffer, 0, length);
			}
			md5Bytes = md5.digest();

			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return md5Bytes;
	}

	public static String downloadFile(String url, String dest, String fileName, String fileSuffix) throws Throwable {
		String fullName = dest + File.separator + fileName + '.' + fileSuffix;
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpGet httpget = new HttpGet(url);
			httpget.setConfig(RequestConfig.custom() //
					.setConnectionRequestTimeout(5000) //
					.setConnectTimeout(5000) //
					.setSocketTimeout(5000) //
					.build());
			try (CloseableHttpResponse response = httpclient.execute(httpget)) {
				org.apache.http.HttpEntity entity = response.getEntity();
				File desc = new File(fullName);
				File folder = desc.getParentFile();
				folder.mkdirs();
				try (InputStream is = entity.getContent(); //
						OutputStream os = new FileOutputStream(desc)) {
					StreamUtils.copy(is, os);
				}
			} catch (Throwable e) {
				throw new Throwable("文件下载失败......", e);
			}
		}
		return fullName;
	}

	/**
	 * 转化inputStream 为byte[]
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static byte[] is2ByeteArray(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = is.read(buff, 0, 100)) > 0) {
			baos.write(buff, 0, rc);
		}

		return baos.toByteArray();
	}

}
