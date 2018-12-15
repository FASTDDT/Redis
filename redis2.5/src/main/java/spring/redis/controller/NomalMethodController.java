package spring.redis.controller;

import help.Enum.CodeEnum;
import help.common.Result;
import help.util.FileLoad;
import help.util.Internet;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * <p>
 * 参考：https://blog.csdn.net/qq_33439525/article/details/78166301
 * 与业务逻辑无关的路由
 * </p>
 *
 * @author father
 * @ClassName NomalMethodController
 * @since 2018/12/5 21:20
 */
@Controller
@RequestMapping("/Nomal")
public class NomalMethodController {
    /**
     * swagger-ui.html
     * /druid/login.html
     */
    //文件上传与下载
    @RequestMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        FileLoad.upLoadFile(file);
        return "index";
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
                e.printStackTrace();
            }
            System.out.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @ResponseBody
    @RequestMapping(value = "/getIp")
    @ApiOperation(value = "ip",httpMethod = "POST")
    public Result<String> getIp() {
        String ip= null;
        try {
            ip = Internet.getLocalHostLANAddress().getHostAddress();
            System.out.println(ip);
            return Result.getSuccessResult(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.getFailResult(CodeEnum.FAILURE);
    }

}