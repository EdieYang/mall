package com.linkpets.controller;

import com.alibaba.fastjson.JSONObject;
import com.linkpets.utils.OssUtil;
import com.linkpets.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/oss")
public class OssResourceController {


    @Autowired
    OssUtil ossUtil;

    /**
     * @param @param  path
     * @param @param  fileName
     * @param @param  file
     * @param @return
     * @param @throws IOException
     * @return JSONObject
     * @throws
     * @Title: uploadFileToOss 
     * @Description: 将文件上传至oss，并返回文件信息
     * @author wando 
     * @date 2019年9月24日 下午4:33:13 
     * @version V1.0   
     */
    @PostMapping(value = "upload")
    public JSONObject uploadFileToOss(@RequestParam("path") String path,
                                      @RequestParam(value = "fileName", required = false) String fileName,
                                      @RequestParam("file") MultipartFile file) throws IOException {
        if (StringUtils.isEmpty(fileName)) {
            String origFileName=file.getOriginalFilename();
            String fileType=origFileName.substring(origFileName.lastIndexOf("."));
            fileName = UUIDUtils.getId()+fileType;
        }
        JSONObject res = ossUtil.uploadFile(path, fileName, file.getInputStream());
        res.put("fileName", fileName);
        res.put("fileSize", file.getSize());
        res.put("fileType", file.getContentType());
        return res;
    }

}
