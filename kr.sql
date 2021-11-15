/*1) Построить физическую модель данных, которая максимально описывает начальные условия системы.*/

create table airport(
                        id serial primary key,
                        name varchar(20)
);

create table airplanes(
                          id serial primary key,
                          name varchar(20)
);

create table passengers(
                           id serial primary key,
                           first_name varchar(20),
                           last_name varchar(20),
                           flights_id int references flights(id)

);

create table flights(
                        id serial primary key,
                        date_flight date,
                        from_departure int references airport(id),
                        to_departure int references airport(id),
                        airplane int references airplanes(id),
                        flight_time int
);

create table pilots(
                       id serial primary key,
                       first_name varchar(20),
                       last_name varchar(20)
);
create table stewardesses(
                             id serial primary key,
                             first_name varchar(20),
                             last_name varchar(20)
);


create table crew(
                     pilot int references pilots(id),
                     stewardess int references stewardesses(id)
);


6) Для каждого пилота вывести цепочку городов, по которым он летал. Пример:
Иванов Иван Иванович | Казань - Москва - Париж - Чебоксары.*/

/*2) Заполнить получившиеся таблицы тестовыми данными (как минимум 3 аэропорта, 3 самолета и 10 рейсов).*/
insert into airport(name) values ('KZN');
insert into airport(name) values ('SVO');
insert into airport(name) values ('VOG');
insert into airport(name) values ('KRR');

insert into airplanes(name) values ('Airbus А320');
insert into airplanes(name) values ('Boeing 737');
insert into airplanes(name) values ('Boeing 800');
insert into airplanes(name) values ('SuperJet 100');

insert into flights(date_flight, from_departure, to_departure, airplane, flight_time) values ('10.11.2021', 1, 4, 1, 80);
insert into flights(date_flight, from_departure, to_departure, airplane, flight_time) values ('10.11.2021', 1, 3, 2, 120);
insert into flights(date_flight, from_departure, to_departure, airplane, flight_time) values ('10.11.2021', 2, 4, 3, 240);
insert into flights(date_flight, from_departure, to_departure, airplane, flight_time) values ('10.11.2021', 2, 4, 4, 60);
insert into flights(date_flight, from_departure, to_departure, airplane, flight_time) values ('11.11.2021', 1, 4, 1, 140);
insert into flights(date_flight, from_departure, to_departure, airplane, flight_time) values ('11.11.2021', 1, 2, 2, 60);
insert into flights(date_flight, from_departure, to_departure, airplane, flight_time) values ('11.11.2021', 2, 4, 3, 300);
insert into flights(date_flight, from_departure, to_departure, airplane, flight_time) values ('11.11.2021', 2, 3, 4, 90);
insert into flights(date_flight, from_departure, to_departure, airplane, flight_time) values ('12.11.2021', 3, 1, 4, 120);

insert into passengers(first_name, last_name, flights_id) VALUES ('Kaрина', 'Обшарова', 1);
insert into passengers(first_name, last_name, flights_id) VALUES ('Kaрина', 'Обшарова', 2);
insert into passengers(first_name, last_name, flights_id) VALUES ('Kaрина', 'Обшарова', 3);
insert into passengers(first_name, last_name, flights_id) VALUES ('Тимур', 'Миргалиев', 4);
insert into passengers(first_name, last_name, flights_id) VALUES ('Мансур', 'Минникаев', 3);


/*3) Вывести самый продолжительный по времени рейс.*/
SELECT max_time, date_flight, from_airport, to_airport, plane FROM flights
                                                                       INNER JOIN (SELECT MAX(flight_time) as max_time FROM flights) as newtable on flight_time = newtable.max_time
                                                                       LEFT JOIN airplanes as plane on plane.id = flights.airplane
                                                                       LEFT JOIN airport from_airport on flights.from_departure = from_airport.id
                                                                       LEFT JOIN airport to_airport on flights.to_departure = to_airport.id;

/*4) Вывести количество рейсов для каждого аэропорта за указанный день (одним запросом).*/
SELECT from_departure, count(from_departure) FROM  flights
where date_flight = to_date('12.11.2021', 'DD.MM.YYYY')
group by from_departure;

/*5) Вывести ФИО пассажира, который провел в полетах наибольшее количество часов и наименьшее. По возможности сделать это одним запросом.*/
SELECT first_name, last_name, f.flight_time FROM passengers INNER JOIN flights f on f.id = passengers.flights_id WHERE flight_time in (SELECT MAX(flight_time) FROM first_name, last_name;