//package com.example.demomysql.controller;
//
//import com.example.demomysql.service.ImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("api/v1/image")
//public class ImageController {
//    @Autowired
//    private ImageService service;
//
//    @PostMapping("/upload")
//    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
//        String uploadImage = service.uploadImage(file);
//        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
//    }
//
//    @GetMapping("/{fileName}")
//    public ResponseEntity<?> downloadImage(@PathVariable("fileName") String fileName){
//        byte[] imageData = service.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/jpeg"))
//                .body(imageData);
//    }
//}
