create table course(
                       id serial primary key,
                       name varchar not null,
                       date_start varchar not null,
                       data_end varchar not null,
                       teacher_id integer
);

create table lesson(
                       name varchar not null,
                       day_week varchar not null,
                       time varchar not null,
                       id_course integer,
                       foreign key (id_course) references course(id)
);

create table teacher(
                        id serial primary key,
                        first_name varchar,
                        last_name varchar,
                        experience varchar
);
create table student(
                        id serial primary key,
                        first_name varchar,
                        last_name varchar,
                        number_group varchar
);

create table teacher_courses_relation(
                                         teacher_id integer,
                                         foreign key (teacher_id) references teacher(id),
                                         course_id integer,

                                         foreign key (course_id) references course(id)

);

create table students_courses_relation(
                                          stud_id integer,
                                          foreign key (stud_id) references student(id),
                                          course_id integer,
                                          foreign key (course_id) references course(id)
);