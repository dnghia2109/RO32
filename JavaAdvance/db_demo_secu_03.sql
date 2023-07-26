USE db_demo_secu_03;
DROP DATABASE IF EXISTS db_demo_secu_03;
SELECT * FROM blog b
LEFT JOIN blog_categories bc ON b.id = bc.blog_id
LEFT JOIN category c ON bc.category_id = c.id
WHERE c.name = 'Backend';


select * from blog b where b.user_id = 1 order by b.created_at DESC
