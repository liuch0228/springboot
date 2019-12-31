package com.example.lchtest.springbootdemo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Controller
public class UploadController {
    /**
     * 可以上传的文件类型
     */
    private static final List<String> UPLOAD_SUFFIX_ALLOWED = Arrays.asList(".jpg", ".png", ".jpeg", ".apk", ".zip");

    /**
     * 获取文件上传路径
     */
    @Value("${file.upload.path}")
    private String uploadPath;

    /**
     * http://localhost:8080/upload.html (访问 static/upload.html)
     * @param file    上传的文件
     * @param request http请求，获取其他表单字段
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request)  {
        String name = request.getParameter("name");
        System.out.println("name=" + name);

        Map<String, Object> result = new HashMap<>();
        String originalFilename = file.getOriginalFilename();

        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        // 文件校验：后缀名，文件头，文件路径，如果是zip文件，要校验文件个数，个数，边解压边校验单个文件大小以及解压后的文件总大小
        if (!UPLOAD_SUFFIX_ALLOWED.contains(suffix)) {
            result.put("retCode", 500);
            result.put("Msg", "File not allow upload");
            return result;
        }

        // 文件重命名
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
        File dest = new File(uploadPath  +  fileName);

        try{
            // 文件路径归一化校验
            if(!dest.getAbsolutePath().equals(dest.getCanonicalPath())){
                // 文件保存路径异常
            }
            file.transferTo(dest);
            result.put("retCode", 200);
            result.put("fileName", fileName);
        } catch (Exception e){
            e.printStackTrace();
            result.put("retCode", 500);
            result.put("Msg", "upload inner error");
        }

        return result;
    }
}
