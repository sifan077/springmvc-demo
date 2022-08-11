/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/4/26
 * Time: 21:42
 * Describe:
 */

package com.shentu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping(value = "/file")
public class FileController {

    @RequestMapping("getUpload")
    public String getUpload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws Exception {
        //获取文件名 : file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();
        System.out.println("上传文件名 : " + uploadFileName);

        //上传路径保存设置
        String path = "D:/upload";
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址：" + realPath);
        //就问香不香，就和你写读流一样
        file.transferTo(new File(path + "/" + uploadFileName));
        return "success";
    }

    @GetMapping("/download")
    @ResponseBody
    public String download1(HttpServletResponse response) {
        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        try {
            // 这个文件名是前端传给你的要下载的图片的id
            // 然后根据id去数据库查询出对应的文件的相关信息，包括url，文件名等
            String fileName = "1.png";

            //1、设置response 响应头，处理中文名字乱码问题
            response.reset(); //设置页面不缓存,清空buffer
            response.setCharacterEncoding("UTF-8"); //字符编码
            response.setContentType("multipart/form-data"); //二进制传输数据
            //设置响应头，就是当用户想把请求所得的内容存为一个文件的时候提供一个默认的文件名。
            //Content-Disposition属性有两种类型：inline 和 attachment
            //inline ：将文件内容直接显示在页面
            //attachment：弹出对话框让用户下载具体例子：
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

            // 通过url获取文件
            File file = new File("D:/upload/" + fileName);
            fileInputStream = new FileInputStream(file);
            outputStream = response.getOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }

            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
