use `db_relationship_jpa_mysql`;

SELECT *
FROM book b
LEFT JOIN author a ON b.author_id = a.id
WHERE a.name = "messi";
