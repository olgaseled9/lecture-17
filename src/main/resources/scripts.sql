create
    database store;

CREATE SEQUENCE People_id_seq START 1;
CREATE SEQUENCE Passport_passport_id_seq START 1;

create table People
(
    id          bigint      not null primary key,
    first_name  varchar(25) not null,
    last_name   varchar(30) not null,
    patronymic  varchar(30) not null
);
ALTER SEQUENCE People_id_seq OWNED BY People.id;

create table Passports
(
    passport_id bigint      not null primary key,
    number      varchar(25) not null,
    id          bigint      not null,
    foreign key (id) references People (id) on update cascade on delete cascade
);
ALTER SEQUENCE Passport_passport_id_seq OWNED BY Passports.passport_id;


insert into People (id, first_name, last_name, patronymic)
values (nextval('people_id_seq'), 'Ivan', 'Ivanov', 'Ivanovich'),
       (nextval('people_id_seq'), 'Petr', 'Petrov', 'Petrovich'),
       (nextval('people_id_seq'), 'Andrei', 'Fedorov', 'Fedorovich'),
       (nextval('people_id_seq'), 'Andrei', 'Andreev', 'Andreevich'),
       (nextval('people_id_seq'), 'Julia', 'Petrova', 'Petrovna');

insert into Passports (passport_id, number, id)
values (nextval('passport_passport_id_seq'), 123123, 1),
       (nextval('passport_passport_id_seq'), 141214, 2 ),
       (nextval('passport_passport_id_seq'), 124141,3 ),
       (nextval('passport_passport_id_seq'), 123454, 4),
       (nextval('passport_passport_id_seq'), 112346,5 );

drop DATABASE store;
drop table People;
drop table Passports;

