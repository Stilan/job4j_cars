
CREATE TABLE IF NOT EXISTS car
(
    id SERIAL PRIMARY KEY,
    name varchar(255),
    photo varchar(255),
    body_id int references body(id),
    engine_id int references engine(id),
    mark_id int references mark(id)
);

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

CREATE TABLE IF NOT EXISTS driver
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
    name varchar(255),
    car_id int references car(id)
);

CREATE TABLE IF NOT EXISTS history_owner
(
    id SERIAL PRIMARY KEY,
    driver_id int references driver(id),
    car_id int references car(id)
);