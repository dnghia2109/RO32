package com.example.demojparelationship.entity.OneToOne;

import com.example.demojparelationship.entity.OneToOne.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetail {
    @Id
    private Long id;
    private String job;
    private String address;

    public UserDetail(String job, String address) {
        this.job = job;
        this.address = address;
    }

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
