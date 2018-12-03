package help.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
@Component
@Slf4j
public class FileLoad {
    private static String upPath;

    private static String downPath;

    @Value("${upload.path}")
    public void setUpPath(String path){
        FileLoad.upPath=path;
    }
    @Value("${download.path}")
    public void setDownPath(String path){
        FileLoad.downPath=path;
    }
    public static void upLoadFile(MultipartFile mfile) throws IOException {
        String originalFilename=mfile.getOriginalFilename();
        String uuid= UUID.randomUUID().toString();
        int index=originalFilename.lastIndexOf(".");
        String suffix=originalFilename.substring(index);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy\\MM\\dd\\HH\\mm\\ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String time = dateTime.format(formatter); // "1986-04-08 12:30"
        String path=upPath+time;

        File file=new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        path+="\\"+uuid+suffix;
        System.out.println("path:"+path);
        mfile.transferTo(new File(path));
    }


}
