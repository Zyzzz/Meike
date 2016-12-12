package com.imudges.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/12.
 */
public class Upload {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "Pk8KYcvRUg8gyw-Og5WDfQi_YnB-h5fy_pmc_2Ux";
    String SECRET_KEY = "Wz8QaAgsQY1Sn9tzXR53ZvW5-fNDySVkBXA-rdPd";
    //要上传的空间
    String bucketname = "meike";
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);

    public String getUpToken(){
        return auth.uploadToken(bucketname,null,3600,new StringMap()
                .put("callbackUrl","http://your.domain.com/callback")
                .put("callbackBody", "filename=$(fname)&filesize=$(fsize)"));
    }

    public void upload(File file) throws IOException{
        try {
            //调用put方法上传
            Response res = uploadManager.put(file, null, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

}

