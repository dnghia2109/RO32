package com.example.demojparelationship.service;

import com.example.demojparelationship.entity.OneToOne.User;
import com.example.demojparelationship.entity.OneToOne.UserDetail;
import com.example.demojparelationship.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepo;

    @Transactional
    public void generateUsers() {
        User u1 = new User("John", "john@gmail.com");
        UserDetail ud1 = new UserDetail("Developer", "1 Ngô Quyền, Hà nội");
        u1.setUserDetail(ud1);

        User u2 = new User("Anna", "anna@gmail.com");
        UserDetail ud2 = new UserDetail("Tester", "12 Nguyễn Du, Hà nội");
        u2.setUserDetail(ud2);

        User u3 = new User("Nghia", "nghia@gmail.com");
        UserDetail ud3 = new UserDetail("Java Fresher", "100 Hoàng Quốc Việt, Hà Nội");
        u3.setUserDetail(ud3);

        em.persist(u1);
        em.persist(u2);
        em.persist(u3);
//        userRepo.save(u3);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

//    Sử dụng hibernate
//    public List<User> queryAll() {
//        TypedQuery<User> query = em.createQuery("SELECT u FROM user u", User.class);
//        return query.getResultList();
//    }

    public User findById(Long id){
        return userRepo.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Transactional
    public User updateUser(Long id,User user) {
        if (findById(id) != null) {
            User curUser = findById(id);
            curUser.setFullname(user.getFullname());
            curUser.setEmail(user.getEmail());
//            curUser.setUserDetail(user.getUserDetail());

            curUser.getUserDetail().setJob(user.getUserDetail().getJob());
            curUser.getUserDetail().setAddress(user.getUserDetail().getAddress());
            return userRepo.save(curUser);
        }
        return null;
    }

}