create table person(
                       id serial primary key,
                       first_name varchar(20),
                       last_name varchar(20)
);

create table teacher (
                         person_id serial primary key,
                         foreign key (person_id) references person(id)
);

create table course(
                       id serial primary key,
                       name_course varchar(20),
                       teacher_id integer,
                       foreign key (teacher_id) references teacher(person_id)
);

create table class(
                      id serial primary key,
                      name varchar(20),
                      course_id integer,
                      foreign key (course_id) references course(id)
);

create table student(
                        person_id serial primary key ,
                        foreign key (person_id) references person(id)
);

create table group_student_relation(
                                       group_id integer,
                                       foreign key (group_id) references class(id),
                                       student_id integer,
                                       foreign key (student_id) references student(person_id)
);

create table project(
                        id serial primary key,
                        name varchar(20)
);

create  table student_project_relation(
                                          student_id integer,
                                          foreign key (student_id) references student(person_id),
                                          project_id integer,
                                          foreign key (project_id) references project(id)
);