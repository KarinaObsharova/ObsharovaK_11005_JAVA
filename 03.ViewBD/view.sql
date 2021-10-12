/*студенты которые посещают курс JavaLab*/
CREATE VIEW ViewStudents
AS SELECT * FROM person p join group_student_relation gsr
                               ON gsr.student_id = p.id;

/*студенты которые находятся в первой группе LOCAL CHECK OPTION */
CREATE VIEW ViewStudentsLocal
AS SELECT * FROM group_student_relation gsr
   where gsr.group_id = 1
        WITH LOCAL CHECK OPTION;

insert into ViewStudentsLocal(group_id, student_id) values (2,5); /*нет*/
insert into ViewStudentsLocal(group_id, student_id) VALUES (1,5); /*да*/

/*студентов в первой группе не должно быть больше 20 человек*/
CREATE VIEW student_first_group
AS SELECT * FROM ViewStudentsLocal s
   where s.student_id < 20
        WITH CASCADED CHECK OPTION;

insert into student_first_group(group_id, student_id) values (1, 5);