alter table users
    add column age int;

update users
set age = 15
where id = 3;