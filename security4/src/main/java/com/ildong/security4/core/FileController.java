package com.ildong.security4.core;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {

    @Value("${temp.path}") private String tempPath;

    @PostMapping("/api/files")
    @ResponseBody
    public String upload(@RequestParam String msg, @RequestParam MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
            File tmp = new File(tempPath + UUID.randomUUID().toString());
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), tmp);
            } catch (IOException e) {
                throw e;
            }
        }
        return "success";
    }
}
