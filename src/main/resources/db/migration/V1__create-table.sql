create table users
(
    id identity primary key,
    name varchar(255) default '' not null
);

insert into users (name)
values ('Dima');