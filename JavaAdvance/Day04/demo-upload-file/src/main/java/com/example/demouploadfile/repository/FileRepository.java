package com.example.demouploadfile.repository;

import com.example.demouploadfile.entity.FileData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FileRepository {
    private List<FileData> files = new ArrayList<>();

    public FileData saveFile(FileData data){
        files.add(data);
        return data;
    }

    public FileData findByName(String fileName){
        return files.stream().filter(file -> file.getName().equalsIgnoreCase(fileName)).findFirst().orElse(null);
    }

    public FileData findById(String id){
        return files.stream().filter(file->file.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}
