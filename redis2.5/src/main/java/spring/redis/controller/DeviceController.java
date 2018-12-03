package spring.redis.controller;


import help.util.FileLoad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Slf4j
@Controller
public class DeviceController {

    @RequestMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        FileLoad.upLoadFile(file);
        return "index";
    }
    //@GetMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "dalaoyang.jpeg";// 文件名
        if (fileName != null) {
            //设置文件路径
            File file = new File("/Users/dalaoyang/Documents/dalaoyang.jpeg");
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }
    @RequestMapping(value = "/batch")
    public void moreFileUp(MultipartRequest mr){
        Map<String,MultipartFile> map=mr.getFileMap();
        map.forEach((key,value)-> {
            System.out.println("file="+value.getOriginalFilename());
            try {
                FileLoad.upLoadFile(value);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    @RequestMapping("/download")
    public String downLoad(HttpServletResponse response){
        String filename="ExecVBRFixer.exe";
        String filePath = "D:/Program Files (x86)/Tencent/QQPCMgr/12.9.19152.219/170829VBR/" ;
        filePath+=filename;
        File file = new File(filePath);
        int index=filePath.lastIndexOf("/");
        String myPath=filePath.substring(index+1);
        System.out.println("myPath:"+myPath);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}

