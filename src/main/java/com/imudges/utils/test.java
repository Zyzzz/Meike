package com.imudges.utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/18.
 */
public class test {

    public static void main(String[] arge) throws IOException {
        Upload upload  = new Upload();
        File file= new File("g:\\1.jpg");
        String url = upload.upload(file);
        System.out.println(url);
    }
}
