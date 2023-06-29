package com.example.demouploadfile.entity;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FileData {
    private String id;
    private String name;
    private String type;
    private String filePath;
}
