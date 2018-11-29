package spring.redis.controller;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import spring.redis.manager.RedisManager;
import spring.redis.model.User;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Controller
@RequestMapping("/file")
public class PalaceController {
    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws FileNotFoundException {
        File file =new File("C:\\Users\\ASUS\\Desktop\\spring-boot-reference.pdf");
        FileInputStream fileInputStream=new FileInputStream(file);
        // 设置被下载而不是被打开
        response.setContentType("application/gorce-download");
        // 设置被第三方工具打开,设置下载的文件名
        response.addHeader("Content-disposition","attachment;fileName=spring-boot-reference.pdf");
        try {
            OutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



