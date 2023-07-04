package com.example.demojparelationship.service.ManyToMany;


import com.example.demojparelationship.entity.ManyToMany.Article;
import com.example.demojparelationship.entity.ManyToMany.Tag;
import com.example.demojparelationship.repository.ManyToMany.ArticleRepo;
import com.example.demojparelationship.repository.ManyToMany.TagRepo;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagService {

    @Autowired
    private TagRepo tagRepo;
    @Autowired
    private ArticleRepo articleRepo;


    @Transactional
    public void generateArticleTag() {
        Tag sport = new Tag("Sport");
        Tag fashion = new Tag("Fashion");
        Tag technology = new Tag("Technology");

        Article at1 = new Article("Ronaldo sang Việt nam thi đấu");
        Article at2 = new Article("Luis Vuiton sẽ sản xuất ở Việt nam");
        Article at3 = new Article("HTML6 chuẩn bị ra mắt");
        Article at4 = new Article("Pep Guardiola học lập trình Java");
        Article at5 = new Article("Zlatan Ibrahimovic quảng cáo cho Bitis Hunter");

        at1.addTag(sport);
        at2.addTag(fashion);
        at3.addTag(technology);
        at4.addTag(sport);
        at4.addTag(technology);
        at5.addTag(sport);
        at5.addTag(fashion);

        tagRepo.save(sport);
        tagRepo.save(fashion);
        tagRepo.save(technology);

        articleRepo.save(at1); articleRepo.save(at2); articleRepo.save(at3);
        articleRepo.save(at4); articleRepo.save(at5);
    }

    public List<Article> getAllArticles() {
        return articleRepo.findAll();
    }
    public List<Tag> getAllTags(){return  tagRepo.findAll();}
}
