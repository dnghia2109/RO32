package com.example.demouploadfilethymeleaf.service;

import com.example.demouploadfilethymeleaf.model.Product;
import com.example.demouploadfilethymeleaf.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    @Autowired
    private ProductRepository productRepository;

    @Value("${upload.path}")
    private String PATH;

    public void uploadFile(MultipartFile file, int id) throws IOException {
        String fileName = file.getOriginalFilename();
        try {
            var is = file.getInputStream();
            var address = PATH + "pic" + id + ".jpg";
            Files.copy(is, Paths.get(address), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException ex){
            var msg = String.format("Failed to store file: %s ",fileName);
        }
    }

    public void deleteFile(int id){
        Optional<Product> productOp = productRepository.getProductById(id);
        if(productOp.isPresent()){
            Product product = productOp.get();
            String fileName = product.getPhoto().getOriginalFilename();
            try{
                var address = PATH + "pic"+id+".jpg";
                Files.deleteIfExists(Paths.get(address));
            }catch(Exception e){
                var msg = String.format("Failed to delete file %s",fileName);

            }
        }
    }
}
