package com.njpi.xyh.takeout.controller;

import com.njpi.xyh.takeout.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件上穿
 *
 * @author: xyh
 * @create: 2022/7/5 8:37
 */
@Controller
@RequestMapping("common")
@ResponseBody
public class CommonController {

    @Value("${file.upload.path}")
    private String basePath;

    /**
     * 文件上传
     *
     * @param file 必须和前端上传上来的name="xxx" 一样
     * @return
     */
    @PostMapping("upload")
    public Result upload(MultipartFile file) throws IOException {
        // 1. 获取文件名称
        String originalFilename = file.getOriginalFilename();
        // 2.使用时间戳 创建新的文件名
        long fileNamePre = System.currentTimeMillis();
        // 3. 获取文件后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //4. 拼接 得到新的文件名
        String fileName = fileNamePre + substring;
        //5.判断basePath 是否存在
        File basePathFile = new File(basePath);
        if (!basePathFile.exists()) {
            basePathFile.mkdir();
        }
        //5. 保存到本地
        file.transferTo(new File(basePath + fileName));
        return Result.success(fileName);
    }


    /**
     * 文件下载
     *
     * @param name
     * @param response
     */
    @RequestMapping("download")
    public void download(String name, HttpServletResponse response) {
        ServletOutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        response.setContentType("image/jpeg");
        try {
            File file = new File(basePath + name);
            //1. 通过输入流读取本地的文件
            fileInputStream = new FileInputStream(file);
            // 2. 通过输出流将本地文件输出
            outputStream = response.getOutputStream();

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert outputStream != null;
                outputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
