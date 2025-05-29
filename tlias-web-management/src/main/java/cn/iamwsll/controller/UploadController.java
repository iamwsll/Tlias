package cn.iamwsll.controller;

import cn.iamwsll.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String name,Integer age,MultipartFile file) throws IOException {
        log.info("接受的参数: name={}, age={}, file={}", name, age, file.getOriginalFilename());
        //获取原先的文件后缀
        String originalFilename = file.getOriginalFilename()
                .substring(file.getOriginalFilename().lastIndexOf("."));
        //新文件名
        String newFileName = UUID.randomUUID().toString()+
                originalFilename;
        //保存文件 transferTo的参数是一个File对象，表示文件保存的路径
        file.transferTo(new File("C:\\code\\JavaLearning\\JavaWeb\\item\\tlias\\tlias-web-management\\src\\main\\resources\\image\\" + newFileName));
        return Result.success();
    }
}
