create table branch(
                       id serial primary key,
                       city int references city(id)
);

create table city(
                     id serial primary key,
                     name_city varchar(20)
);

create table client(
                       id serial primary key,
                       first_name varchar(20),
                       document varchar(20)

);


create table loan(
                     id serial primary key,
                     id_branch int references branch(id),
                     id_client int references client(id),
                     cost_of_loan int check (cost_of_loan > 0 and cost_of_loan <= 150000 ),
                     date_of_taken date,
                     fake_return_date date check ( fake_return_date - loan.date_of_taken <= 61 ),
                     return_date  date
);

insert into city(name_city) values ('Kazan');
insert into city(name_city) values ('Moscow');

insert into branch(city) VALUES ( 1);
insert into branch(city) VALUES ( 2);

insert into client(first_name, document) VALUES ('Карина', '9216102567');
insert into client(first_name, document) VALUES ('Тимур', '9216102395');
insert into client(first_name, document) VALUES ('Вадим', '9210678495');
insert into client(first_name, document) VALUES ('Маша', '9214840238');

insert into loan(id_branch, id_client, cost_of_loan, date_of_taken, fake_return_date, return_date) VALUES (1, 1, 50000, '01.11.2021', '10.11.2021', null);
insert into loan(id_branch, id_client, cost_of_loan, date_of_taken, fake_return_date, return_date) values (2, 2, 50000, '01.11.2021', '30.11.2021', '30.11.2021');
insert into loan(id_branch, id_client, cost_of_loan, date_of_taken, fake_return_date, return_date) values (2, 2, 20000, '10.11.2021', '30.11.2021', null);
insert into loan(id_branch, id_client, cost_of_loan, date_of_taken, fake_return_date, return_date) values (2, 2, 80000, '28.11.2021', '01.12.2021', null);
insert into loan(id_branch, id_client, cost_of_loan, date_of_taken, fake_return_date, return_date) values (2, 2, 10000, '28.11.2021', '01.12.2021', null);
insert into loan(id_branch, id_client, cost_of_loan, date_of_taken,fake_return_date, return_date) values (1, 3, 100000, '30.11.2021', '31.12.2021', null);
insert into loan(id_branch, id_client, cost_of_loan, date_of_taken,fake_return_date, return_date) values (1, 4, 30000, '11.11.2021', '31.12.2021', '20.11.2021');

/*(3) Вывести список людей с открытыми займами на сегодняшний день.*/
SELECT c FROM loan left join client c on c.id = loan.id_client where return_date IS NULL;

/*3) Вывести город с наибольшей суммой всех займов и эту сумму.*/
SELECT c.name_city, SUM(cost_of_loan)FROM loan left join branch b on b.id = loan.id_branch left join city c on b.city = c.id
group by c.name_city;

/*Коллекторам понадобился список людей, не погасивших задолженность в срок. Вывести их ФИО, адреса проживания/регистрации и сумму долгов. Отсортировать в порядке убывания суммы долга.*/
ALTER TABLE client ADD COLUMN address VARCHAR (20);
ALTER TABLE client ADD COLUMN last_name VARCHAR (20);
UPDATE client SET address = 'пушкина 32', last_name = 'Обшарова'
WHERE first_name = 'Карина';


UPDATE client SET address = 'пушкина 32а', last_name = 'Миргалиев'
WHERE first_name = 'Тимур';
UPDATE client SET address = 'университетская 2', last_name = 'Поляков'
WHERE first_name = 'Вадим';
UPDATE client SET address = 'пушкина 5', last_name = 'Димухаметова'
WHERE first_name = 'Маша';

SELECT c.first_name, c.last_name, c.address, SUM(loan.cost_of_loan) as sum
FROM loan left join client c on c.id = loan.id_client
where return_date IS NULL
group by c.last_name, c.first_name, c.address
order by sum desc ;