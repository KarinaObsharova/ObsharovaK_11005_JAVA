create table person(
                       id integer,
                       first_name varchar(20),
                       last_name varchar(20),
                       PRIMARY KEY (id)
);

create table teacher (
                         person_id serial primary key,
                         foreign key (person_id) references person(id)
);

create table course(
                       id integer,
                       name_course varchar(20),
                       teacher_id integer CONSTRAINT teacher_not_null CHECK (teacher_id > 0) ,
                       foreign key (teacher_id) references teacher(person_id),
                       PRIMARY KEY (id)
);

create table class(
                      id serial primary key,
                      name varchar(20),
                      course_id integer,
                      foreign key (course_id) references course(id)
);

create table student(
                        person_id  integer UNIQUE NOT NULL ,
                        foreign key (person_id) references person(id)
);

create table group_student_relation(
                                       group_id integer,
                                       foreign key (group_id) references class(id),
                                       student_id integer,
                                       foreign key (student_id) references student(person_id)

);

create table project(
                        name varchar(20)
);

create  table student_project_relation(
                                          student_id integer not null check ( student_id > 10),
                                          foreign key (student_id) references student(person_id),
                                          project_id integer,
                                          foreign key (project_id) references project(id),
                                          UNIQUE (student_id, project_id)
);

ALTER TABLE class
    ADD CHECK ( id < 10 );

ALTER TABLE project
    ADD PRIMARY KEY (Id);