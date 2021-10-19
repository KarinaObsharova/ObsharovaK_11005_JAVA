/*студентов в первой группе не должно быть больше 20 человек*/
CREATE VIEW student_first_group
AS SELECT * FROM ViewStudentsLocal s
   where s.student_id < 20
        WITH CASCADED CHECK OPTION;

insert into student_first_group(group_id, student_id) values (1, 5);

/*все студенты из списка person*/
SELECT first_name, last_name FROM person INNER JOIN student s on person.id = s.person_id;


/*все студенты с проектами и без*/
SELECT  first_name, last_name, spr.person_id, project_id, name FROM student s
                                                                        LEFT JOIN person p on p.id = s.person_id
                                                                        LEFT JOIN student_project_relation spr on s.person_id = spr.person_id
                                                                        LEFT JOIN project pj on spr.project_id = pj.id;


/*все проекты и студенты, которые их взяли*/
SELECT  first_name, last_name, spr.person_id, project_id, name FROM student s
                                                                        LEFT JOIN person p on p.id = s.person_id
                                                                        LEFT JOIN student_project_relation spr on s.person_id = spr.person_id
                                                                        RIGHT JOIN project pj on spr.project_id = pj.id;

/*FULL*/
/*Первый способ — объединение запросов LEFT и RIGHT*/
(SELECT  first_name, last_name, spr.person_id, project_id, name FROM student s
                                                                         LEFT JOIN person p on p.id = s.person_id
                                                                         LEFT JOIN student_project_relation spr on s.person_id = spr.person_id
                                                                         LEFT JOIN project pj on spr.project_id = pj.id)
UNION
(SELECT  first_name, last_name, spr.person_id, project_id, name FROM student s
                                                                         LEFT JOIN person p on p.id = s.person_id
                                                                         LEFT JOIN student_project_relation spr on s.person_id = spr.person_id
                                                                         RIGHT JOIN project pj on spr.project_id = pj.id);

/*Второй способ — объединение LEFT и RIGHT, но в одном из запросов мы исключаем часть, соответствующую INNER. А объединение задаём как UNION ALL.*/
(SELECT  first_name, last_name, spr.person_id, project_id, name FROM student s
                                                                         LEFT JOIN person p on p.id = s.person_id
                                                                         LEFT JOIN student_project_relation spr on s.person_id = spr.person_id
                                                                         LEFT JOIN project pj on spr.project_id = pj.id)
UNION ALL
(SELECT  first_name, last_name, spr.person_id, project_id, name FROM student s
                                                                         LEFT JOIN person p on p.id = s.person_id
                                                                         LEFT JOIN student_project_relation spr on s.person_id = spr.person_id
                                                                         RIGHT JOIN project pj on spr.project_id = pj.id
 WHERE s.person_id is NULL);

/*каждый студент проверяет проект*/
SELECT person_id, name FROM student s CROSS JOIN project;

SELECT * FROM student s NATURAL JOIN student_project_relation;

Select *
FROM person p1, person p2
WHERE p1.id = p2.id;


/*люди без проекта*/
SELECT  first_name, last_name FROM student s
                                       LEFT JOIN person p on p.id = s.person_id
WHERE NOT EXISTS( Select * FROM
    student_project_relation spr where s.person_id = spr.person_id);

/*люди с проектом*/
SELECT  first_name, last_name FROM student s
                                       LEFT JOIN person p on p.id = s.person_id
WHERE EXISTS( SELECT * FROM
    student_project_relation spr where s.person_id = spr.person_id);
