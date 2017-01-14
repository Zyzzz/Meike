package com.imudges.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;


public class FileUpload {

    public static final String FILE_PATH = "/images/";

    //文件上传
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        String path=request.getSession().getServletContext().getRealPath("");
        File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return path +"\\"+ tempFile.getName();
    }

    public static File getFile(String fileName,HttpServletRequest request) {
        String path=request.getSession().getServletContext().getRealPath("images/");
        return new File(path, fileName);
    }
}