CREATE SEQUENCE People_id_seq START 1;

create table People
(
    id          bigint      not null primary key,
    first_name  varchar(25) not null,
    last_name   varchar(30) not null,
    patronymic  varchar(30) not null
);
ALTER SEQUENCE People_id_seq OWNED BY People.id;

insert into People (id, first_name, last_name, patronymic)
values (nextval('people_id_seq'), 'Ivan', 'Ivanov', 'Ivanovich'),
       (nextval('people_id_seq'), 'Petr', 'Petrov', 'Petrovich'),
       (nextval('people_id_seq'), 'Andrei', 'Fedorov', 'Fedorovich'),
       (nextval('people_id_seq'), 'Andrei', 'Andreev', 'Andreevich'),
       (nextval('people_id_seq'), 'Julia', 'Petrova', 'Petrovna');
