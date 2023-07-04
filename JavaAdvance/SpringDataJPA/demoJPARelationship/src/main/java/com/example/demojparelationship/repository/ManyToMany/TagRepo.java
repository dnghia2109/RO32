package com.example.demojparelationship.repository.ManyToMany;

import com.example.demojparelationship.entity.ManyToMany.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends JpaRepository<Tag, Long> {
}
