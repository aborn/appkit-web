package org.popkit.appkit.demo.controller;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.popkit.appkit.common.controller.BaseController;
import org.popkit.appkit.common.entity.ResponseJSON;
import org.popkit.appkit.common.utils.AppKitUtils;
import org.popkit.appkit.common.utils.FileUtils;
import org.popkit.appkit.common.utils.ResponseUtils;
import org.popkit.appkit.demo.entity.FileInfo;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author Aborn Jiang
 * @email aborn.jiang AT foxmail.com
 * @date 07-13-2015
 * @time 10:12 PM
 */
@Controller
@RequestMapping(value = "/demo/multifile")
public class MultiFileController extends BaseController {
    private static final String IMAGE_FILE_DIR = "/data/appdatas/skin/";

    LinkedList<FileInfo> files = new LinkedList<FileInfo>();
    FileInfo FileInfo = null;

    @RequestMapping(value = "multiFilesExample.html")
    public String multiFilesExample(HttpServletRequest request) {
        Map<String, String> searchMapVo = new HashMap<String, String>();
        searchMapVo.put("info", "");
        request.setAttribute("searchMapVo", searchMapVo);
        return "demo/multifiles-upload";
    }

    @RequestMapping(value="ajaxFilesUpload.html", method = RequestMethod.POST)
    public void upload(MultipartHttpServletRequest request, HttpServletResponse response) {
        String imageFileDir = IMAGE_FILE_DIR + getUserInfo().getName() + "/";

        // 本次上传的图片
        LinkedList<FileInfo> currentFiles = new LinkedList<FileInfo>();
        //1. build an iterator
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;

        //2. get each file
        while(itr.hasNext()){

            //2.1 get next MultipartFile
            mpf = request.getFile(itr.next());

            //2.2 if files > 10 remove the first from the list
            if(files.size() >= 10)
                files.pop();

            //2.3 create new FileInfo
            FileInfo = new FileInfo();
            FileInfo.setName(mpf.getOriginalFilename());
            FileInfo.setSize(FileUtils.humanReadableByteCount(mpf.getSize(), true));
            //FileInfo.setSize(mpf.getSize()+"");
            FileInfo.setType(mpf.getContentType());

            try {
                FileInfo.setBytes(mpf.getBytes());

                // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
                if (FileUtils.createDirectory(imageFileDir)) {
                    FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(imageFileDir + mpf.getOriginalFilename()));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            //2.4 add to files
            files.add(FileInfo);
            if (FileInfo.getName().endsWith(".txt")) {
                FileInfo.setError("格式不符合要求");
            }
            currentFiles.add(FileInfo);
        }


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("files", currentFiles);
        } catch (Exception e){
            //
        }

        ResponseUtils.renderJson(response, jsonObject.toString());
    }

    // 列出该用户已经上传的文件
    @RequestMapping(value = "/getUploadImageList.json")
    public void getUploadImageList(HttpServletResponse response) {
        File file = new File(IMAGE_FILE_DIR + getUserInfo().getName() + "/");
        List<String> imageFiles = new ArrayList<String>();
        if (file.isDirectory()) {
            imageFiles = Arrays.asList(file.list());
        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("files", imageFiles);
        } catch (Exception e) {
            //
        }
        ResponseUtils.renderJson(response, jsonObject.toString());
    }

    // 支持文件名扩展
    @RequestMapping(value = "/get/{value:.+}", method = RequestMethod.GET)
    public void getImage(@PathVariable String value,
                         HttpServletRequest request,
                         HttpServletResponse response){
        String rootPath = "/data/appdatas/";
        String fileName = value;
        String filePathName = rootPath + fileName;
        if (!new File(filePathName).exists()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("info", "文件不存在");
            ResponseUtils.renderJson(response, jsonObject.toJSONString());
        } else {
            try {
                MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
                String contentType = AppKitUtils.getContentType(fileName);
                if (StringUtils.isNotBlank(contentType)) {
                    // 页面展示
                    response.setContentType(contentType);
                } else {
                    // 变成下载模式
                    response.setContentType(mimetypesFileTypeMap.getContentType(filePathName));
                }
                com.google.common.io.Files.copy(new File(filePathName), response.getOutputStream());
                // 下面这句只能在 java 1.7 环境下用 java.nio.file
                // response.getOutputStream().write(Files.readAllBytes(Paths.get(filePathName)));
            } catch (IOException e) {
                ResponseUtils.renderJson(response, ResponseJSON.getFailedResponse("异常").toJSONString());
            } finally {
                // do nothing
            }
        }
    }

    // 删除文件 
    @RequestMapping(value = "/delete/{value:.+}", method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable String value,
                            HttpServletRequest request,
                            HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        if (!new File(value).exists()) {
            jsonObject.put("info", "文件不存在,不能删除!");
            ResponseUtils.renderJson(response, jsonObject.toJSONString());
        } else {
            File f = new File(value);
            boolean status = f.delete();
            if (status) {
                jsonObject.put("info", "删除文件:" + value + "成功!");
            } else {
                jsonObject.put("info", "删除文件:" + value + "失败!");
            }
            ResponseUtils.renderJson(response, jsonObject.toJSONString());
        }
    }
}
