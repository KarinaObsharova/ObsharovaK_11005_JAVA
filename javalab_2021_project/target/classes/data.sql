insert into course(name, date_start, data_end)
values ('JavaLab', '07.07.2021', '7.08.2021');
insert into course(name, date_start, data_end)
values ('iOS development', '28.06.2021', '16.07.2021');
insert into course(name, date_start, data_end)
values ('Android development', '01.06.2021', '01.07.2021');
insert into course(name, date_start, data_end)
values ('Smart Education', '02.07.2021', '30.07.2021');


insert into lesson(name, day_week, time, id_course)
values ('SQL', 'Monday', '14:00', 1);
insert into lesson(name, day_week, time, id_course)
values ('JDBC', 'Friday', '14:30', 1);
insert into lesson(name, day_week, time, id_course)
values ('Swift', 'Tuesday', '12:00', 2);
insert into lesson(name, day_week, time, id_course)
values ('ViewController', 'Saturday', '10:00', 2);
insert into lesson(name, day_week, time, id_course)
values ('Kotlin', 'Monday', '11:00', 3);
insert into lesson(name, day_week, time, id_course)
values ('Application Kotlin', 'Monday', '11:00', 3);
insert into lesson(name, day_week, time, id_course)
values ('Phyton', 'Thursday', '14:00', 4);
insert into lesson(name, day_week, time, id_course)
values ('Project', 'Saturday', '15:00', 4);

insert into teacher(first_name, last_name, experience)
values ('Марсель', 'Сидиков', '10');
insert into teacher(first_name, last_name, experience)
values ('Ирина', 'Шахова', '5');
insert into teacher(first_name, last_name, experience)
values ('Ирина', 'Шахова', '5');
insert into teacher(first_name, last_name, experience)
values ('Михаил', 'Абрамский', '12');

insert into student(first_name, last_name, number_group)
values ('Александр', 'Кузнецов', '11-005');
insert into student(first_name, last_name, number_group)
values ('Карина', 'Обшарова', '11-005');
insert into student(first_name, last_name, number_group)
values ('Александра', 'Сафина', '11-002');
insert into student(first_name, last_name, number_group)
values ('Анастасия', 'Войтенко', '11-004');
insert into student(first_name, last_name, number_group)
values ('Иванов', 'Кирилл', '11-005');
insert into student(first_name, last_name, number_group)
values ('Виктория', 'Латыпова', '11-010');
insert into student(first_name, last_name, number_group)
values ('Миргалиев', 'Тимур', '11-005');
insert into student(first_name, last_name, number_group)
values ('Байгулова', 'Эльмира', '11-004');
insert into student(first_name, last_name, number_group)
values ('Герасимов', 'Данил', '11-004');
insert into student(first_name, last_name, number_group)
values ('Денис', 'Алферов', '11-007');
insert into student(first_name, last_name, number_group)
values ('Сивачев', 'Никита', '11-006');
insert into student(first_name, last_name, number_group)
values ('Калугин', 'Артем', '11-004');

insert into teacher_courses_relation(teacher_id, course_id)
values (1, 1);
insert into teacher_courses_relation(teacher_id, course_id)
values (2, 2);
insert into teacher_courses_relation(teacher_id, course_id)
values (2, 3);
insert into teacher_courses_relation(teacher_id, course_id)
values (3, 4);

insert into students_courses_relation(stud_id, course_id)
values (1, 1);
insert into students_courses_relation(stud_id, course_id)
values (1, 2);
insert into students_courses_relation(stud_id, course_id)
values (2, 1);
insert into students_courses_relation(stud_id, course_id)
values (2, 2);
insert into students_courses_relation(stud_id, course_id)
values (3, 1);
insert into students_courses_relation(stud_id, course_id)
values (4, 1);
insert into students_courses_relation(stud_id, course_id)
values (5, 3);
insert into students_courses_relation(stud_id, course_id)
values (6, 3);
insert into students_courses_relation(stud_id, course_id)
values (7, 2);
insert into students_courses_relation(stud_id, course_id)
values (8, 2);
insert into students_courses_relation(stud_id, course_id)
values (9, 2);
insert into students_courses_relation(stud_id, course_id)
values (10, 4);
insert into students_courses_relation(stud_id, course_id)
values (11, 4);
insert into students_courses_relation(stud_id, course_id)
values (12, 4);
