package help.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class FileLoad {
    public static void upLoadFile(MultipartFile mfile) throws IOException {
        String originalFilename=mfile.getOriginalFilename();
        String uuid= UUID.randomUUID().toString();
        int index=originalFilename.lastIndexOf(".");
        String suffix=originalFilename.substring(index);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy\\MM\\dd\\HH\\mm\\ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String time = dateTime.format(formatter); // "1986-04-08 12:30"
        String path="D:\\upload\\"+time;
        System.out.println("path:"+path);
        File file=new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        path+="\\"+uuid+suffix;
        mfile.transferTo(new File(path));
    }
}