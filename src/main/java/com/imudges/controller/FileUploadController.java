package com.imudges.controller;

/**
 * Created by Administrator on 2016/11/14.
 */


import com.imudges.utils.Upload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import static com.imudges.utils.FileUpload.uploadFile;

@Controller
public class FileUploadController {

    //Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping("test")
    public String test(){
        return "test";
    }
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public String addIndent(MultipartFile imagethree,HttpServletRequest request) throws IOException {
        //CommodityEntity commodityEntity = new CommodityEntity();
        String filePath3 = uploadFile(imagethree, request);
        System.out.println(filePath3);
        Upload upload  = new Upload();
        File file= new File(filePath3);
        String url = upload.upload(file);
        System.out.println(url);
        return "index";
    }

}