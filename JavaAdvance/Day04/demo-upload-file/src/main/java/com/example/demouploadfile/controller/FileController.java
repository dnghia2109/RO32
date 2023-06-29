package com.example.demouploadfile.controller;

import com.example.demouploadfile.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController()
@RequestMapping("/image")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image") MultipartFile image) throws Exception {
        String uploadImage = fileService.uploadToFile(image);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable("fileName")String name) throws Exception {
        byte[] imageData = fileService.downloadFile(name);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpeg"))
                .body(imageData);
    }

    @GetMapping("/fileSystem/search/{id}")
    public ResponseEntity<?> renderImageFromFileSystem(@PathVariable("id")String id) throws Exception {
        byte[] imageData = fileService.renderFile(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpeg"))
                .body(imageData);
    }
}
