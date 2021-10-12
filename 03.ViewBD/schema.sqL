insert into person(first_name, last_name) VALUES ('Карина', 'Обшарова');
insert into person(first_name, last_name) values ('Минникаев','Мансур');
insert into person(first_name, last_name) VALUES ('Миргалиев','Тимур');
insert into person(first_name, last_name) VALUES ('Марсель', 'Сидиков');

insert into teacher(person_id) values (6);

insert into student(person_id) values (1);
insert into student(person_id) values (3);
insert into student(person_id) values (4);
insert into student(person_id) values (5);

insert into course(name_course, teacher_id) VALUES ('JavaLab', 6);

insert into class(name, course_id) VALUES ('1 group', 1);
insert into class(name, course_id) VALUES ('2 group', 1);

insert into group_student_relation(group_id, student_id) VALUES (1, 1);
insert into group_student_relation(group_id, student_id) VALUES (1, 3);
insert into group_student_relation(group_id, student_id) VALUES (1, 4);
