
CREATE TABLE IF NOT EXISTS car
(
     id SERIAL PRIMARY KEY,
     body_id int references body(id),
     engine_id int references engine(id),
     mark_id int references mark(id),
     user_id int references users(id),
     price int
);

drop TABLE car;
drop TABLE body;
drop TABLE engine;
drop TABLE mark;
drop TABLE item;

CREATE TABLE IF NOT EXISTS body
(
    id SERIAL PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE IF NOT EXISTS engine
(
    id SERIAL PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE IF NOT EXISTS mark
(
    id SERIAL PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE IF NOT EXISTS item
(
    id SERIAL PRIMARY KEY,
    description varchar(255),
    car_id int references car(id)
);

CREATE TABLE IF NOT EXISTS users
(
   id SERIAL PRIMARY KEY,
   name varchar(255),
   email varchar(255),
   password varchar(255)
);

insert into mark(name) values ('Toyota');
insert into mark(name) values ('Lada');

insert into engine(name) values ('V8');
insert into engine(name) values ('V6');

insert into body(name) values ('Седан');
insert into body(name) values ('Универсал');

insert into item(description, car_id) values ('Универсал', 1);

DELETE FROM body;
