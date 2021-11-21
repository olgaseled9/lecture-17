CREATE SEQUENCE Passport_passport_id_seq START 1;

create table Passports
(
    passport_id bigint      not null primary key,
    number      varchar(25) not null,
    id          bigint      not null,
    foreign key (id) references People (id) on update cascade on delete cascade
);
ALTER SEQUENCE Passport_passport_id_seq OWNED BY Passports.passport_id;

insert into Passports (passport_id, number, id)
values (nextval('passport_passport_id_seq'), 123123, 1),
       (nextval('passport_passport_id_seq'), 141214, 2 ),
       (nextval('passport_passport_id_seq'), 124141,3 ),
       (nextval('passport_passport_id_seq'), 123454, 4),
       (nextval('passport_passport_id_seq'), 112346,5 );