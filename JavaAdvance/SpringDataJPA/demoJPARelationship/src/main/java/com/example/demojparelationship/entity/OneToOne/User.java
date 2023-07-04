package com.example.demojparelationship.entity.OneToOne;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String email;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn

    private UserDetail userDetail;

    public User(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
        userDetail.setUser(this);
    }
}
