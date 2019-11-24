package com.linkpets.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

@Component
public class OssUtil {

    private static final Logger log = LoggerFactory.getLogger(OssUtil.class);

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.endpoint-internal}")
    private String internalEndpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.roleArn}")
    private String roleArn;

    @Value("${aliyun.oss.hostAddress}")
    private String hostAddress;

    @Value("${aliyun.oss.hostAddress-internal}")
    private String hostInternalAddress;


    /**
     * @param @param  path 文件相对路径，例如'path/123'
     * @param @param  fileName 文件名，例如'aaa.xls'
     * @param @param  inputStream
     * @param @return
     * @return JSONObject
     * @throws
     * @Title: uploadFile 
     * @Description: 上传文件到阿里云oss
     * @author wando 
     * @date 2019年7月25日 上午10:35:57 
     * @version V1.0   
     */
    public JSONObject uploadFile(String path, String fileName, InputStream inputStream) {

        log.info("-------------uploadFile--------------");

        /*
         * //去除特殊字符 String regs="([^\\u4e00-\\u9fa5\\w\\(\\)（）])+?"; Pattern
         * pattern=Pattern.compile(regs);
         *
         * Matcher matcher=pattern.matcher(fileName);
         *
         * fileName = matcher.replaceAll("");
         */

        // 替换文件名中的+号、空格
        fileName = fileName.replace("+", "_");
        fileName = fileName.replace(" ", "_");

        // 限制文件名长度
//		if (fileName.length() > 100) {
//			fileName = fileName.substring(0, 100);
//		}

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        try {
            // 上传文件流。
            PutObjectResult re = ossClient.putObject(bucketName, path + "/" + fileName, inputStream);
            log.info(re.getETag());

        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        JSONObject result = new JSONObject();
        result.put("relativePath", path + "/" + fileName);
        result.put("absolutePath", hostAddress + "/" + path + "/" + fileName);
        return result;
    }


    public boolean downloadFileWithStsToken(String accessKeyId, String accessKeySecret, String securityToken) {

        log.info("----------downloadFileWithStsToken-----------");

        System.out.println("[endpoint]-->" + endpoint);
        System.out.println("[accessKeyId]-->" + accessKeyId);
        System.out.println("[accessKeySecret]-->" + accessKeySecret);
        System.out.println("[securityToken]-->" + securityToken);

        // 用户拿到STS临时凭证后，通过其中的安全令牌（SecurityToken）和临时访问密钥（AccessKeyId和AccessKeySecret）生成OSSClient。
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret, securityToken);

        // OSS操作。
        try {
            // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
            ossClient.getObject(new GetObjectRequest(bucketName, "banner.jpg"), new File("D:/banner2.jpg"));

        } catch (Exception e) {
            // TODO: handle exception
            throw e;

        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }

        return true;
    }

    public String getPreviewUrl(String objectKey) {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, objectKey);
        request.setProcess("imm/previewdoc");
        request.setExpiration(new Date(new Date().getTime() + 3600 * 1000));
        String previewUrl = ossClient.generatePresignedUrl(request).toString();
//		System.out.println(previewUrl);
        return previewUrl;
    }

}
