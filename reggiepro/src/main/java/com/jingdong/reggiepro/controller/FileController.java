package com.jingdong.reggiepro.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jingdong.reggiepro.common.R;
import com.jingdong.reggiepro.entity.Employee;
import com.jingdong.reggiepro.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;


@Slf4j
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*") //解决跨域
public class FileController {
    @Value("${reggie.path}")
    private String fileFile;

    @PostMapping("/upload")
    @CrossOrigin
    public R<String> upload(MultipartFile file){
        //形参名file必须跟前端上送的 <input name="file"> 保持一致
        //接收到的file是一个临时文件,已tmp格式暂存到C盘,执行完就会自动销毁,需要转存到指定目录下
        try {
            System.out.println(file.getOriginalFilename());
            String fileName = file.getOriginalFilename();
            file.transferTo(new File(fileFile + "study\\javeTemp\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  R.success("上传成功");
    }

    @GetMapping("/download")
    @CrossOrigin
    public void download(HttpServletRequest request, HttpServletResponse response){

        try {
            FileInputStream fileInputStream = new FileInputStream("F:\\study\\javeTemp\\112233.docx");
            response.setContentType("application/pdf");
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            String fileName = "1122.pdf";
            response.setHeader("Content-Disposition","attachment;filename=\"" + fileName +"\"");
            ServletOutputStream outputStream = response.getOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
