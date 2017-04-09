package com.imudges.controller;

/**
 * Created by Administrator on 2016/11/14.
 */


import com.imudges.model.LessonsEntity;
import com.imudges.model.VideoEntity;
import com.imudges.repository.LessonsRepository;
import com.imudges.repository.VideoRepository;
import com.imudges.utils.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import static com.imudges.utils.FileUpload.uploadFile;

@Controller
public class FileUploadController {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private LessonsRepository lessonsRepository;
    //Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping("test")
    public String test(){
        return "test";
    }
    @ResponseBody
    @RequestMapping(value = "addLessons")
    public String addIndent(int courseId,String name,int teacherId,MultipartFile vidoe,HttpServletRequest request) throws IOException {
        //CommodityEntity commodityEntity = new CommodityEntity();
        String filePath3 = uploadFile(vidoe, request);
        System.out.println(filePath3);
        Upload upload  = new Upload();
        File file= new File(filePath3);
        String url = upload.upload(file);
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setUrl(url);
        videoRepository.saveAndFlush(videoEntity);
        videoEntity = videoRepository.findByUrl(url);
        LessonsEntity lessonsEntity = new LessonsEntity();
        lessonsEntity.setCourseId(courseId);
        lessonsEntity.setName(name);
        lessonsEntity.setTeacherid(teacherId);
        lessonsEntity.setVideoId(videoEntity.getId());
        lessonsRepository.saveAndFlush(lessonsEntity);
        System.out.println(url);
        return "index";
    }
    @ResponseBody
    @RequestMapping(value = "upload")
    public String upload(MultipartFile vidoe,HttpServletRequest request) throws IOException {
        //CommodityEntity commodityEntity = new CommodityEntity();
        String filePath3 = uploadFile(vidoe, request);
        System.out.println(filePath3);
        Upload upload  = new Upload();
        File file= new File(filePath3);
        String url = upload.upload(file);
        return "index";
    }
}