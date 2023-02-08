package com.example.awss3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private final AwsS3Service s3Upload;

    @PostMapping("/upload")
    public UploadResponse uploadFile(@RequestParam("images") MultipartFile multipartFile) throws IOException {
        String upload = s3Upload.upload(multipartFile);
        return new UploadResponse(upload);
    }
}
