

/*drop table if exists user_role;
drop table if exists user;
drop table if exists role;

-- Create table
create table role
(
    id   BIGINT      not null auto_increment,
    name VARCHAR(30) not null
);

--
alter table role
    add constraint APP_ROLE_PK primary key (id);

alter table role
    add constraint APP_ROLE_UK unique (name);

-- Create table
create table user
(
    id       BIGINT       not null auto_increment,
    email VARCHAR(36)  not null,
    login VARCHAR(36)  not null,
    password VARCHAR(128) not null,
    enabled  BIT          not null
);
--
alter table user
    add constraint APP_USER_PK primary key (id);

alter table user
    add constraint APP_USER_UK unique (login);

-- Create table
create table user_role
(
    user_id BIGINT not null,
    role_id BIGINT not null
);
--
alter table USER_ROLE
    add constraint USER_ROLE_UK unique (user_id, role_id);

alter table USER_ROLE
    add constraint USER_ROLE_FK1 foreign key (user_id)
        references user (id);

alter table USER_ROLE
    add constraint USER_ROLE_FK2 foreign key (role_id)
        references role (id);

-- Used by Spring Remember Me API.
CREATE TABLE Persistent_Logins
(

    username  varchar(64) not null,
    series    varchar(64) not null,
    token     varchar(64) not null,
    last_used timestamp   not null,
    PRIMARY KEY (series)

);
*/


insert into label values (null, "Poland", "Prosto");
insert into label values (null, "Poland", "SBM Label");

insert into artist values (null, "1977-03-11", "Wojciech", "Poland", "Sokół", "M", "Sosnowski");
insert into artist values (null, "1987-12-11", "Mateusz", "Poland", "Białas", "M", "Karaś");
insert into artist values (null, "1991-07-07", "Kuba", "Poland", "Quebonafide", "M", "Grabowski");
insert into artist values (null, "1998-04-21", "Borys", "Poland", "Bedoes", "M", "Przybylski");
insert into artist values (null, "1992-07-16", "Mateusz", "Poland", "Guzior", "M", "Bluza");
insert into artist values (null, "1982-05-21", "Adam", "Poland", "Łona", "M", "Zieliński");
insert into artist values (null, "1990-03-29", "Damian", "Poland", "Bonson", "M", "Kowalski");
insert into artist values (null, "1984-01-25", "Tomasz", "Poland", "VNM", "M", "Lewandowski");
insert into artist values (null, "1982-12-24", "Piotr", "Poland", "Ten Typ Mes", "M", "Szmidt");
insert into artist values (null, "1995-08-15", "Keith", "United States", "Chief Keef", "M", "Cozart");
insert into artist values (null, "1989-05-24", "Gerald", "United States", "G-Eazy", "M", "Gillum");
insert into artist values (null, "1986-10-24", "Aubrey", "Canada", "Drake", "M", "Graham");

insert into album values (null, 0, "Rap", "2012-02-20", "Etenszyn: Drimz Kamyn Tru", 1);

insert into album values (null, 0, "Rap", "2019-02-15", "Wojtek Sokół", 1);

insert into album_artist values (1, 8);
insert into album_artist values (2, 1);

insert into user values (null, "patryk.leczycki1@gmail.com", 1, "$2a$10$5zl.4gm/CdR0l3v4Qv6Er.lk01q.1DXGXzLdAsDb6h3Dv8xF.uQRG", "Pinky");
insert into user values (null, "email@email.com", 1, "$2a$10$ZfOnsqjlibAnZ1d3BP26V.qR.m.P/zADl54bbF5IO1F9bhyeidnqK", "user1");
insert into user values (null, "matrix9596@gmail.com", 1, "$2a$10$sgJIPaeihpn2oyPEpPQcvO8Fn3A2xcI5hZrviLLQPs9Co.EIP7G2O", "YourFatherDrunk");



/*insert into user (username, password, enabled)
values ('dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into user (username, password, enabled)
values ('dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);*/


insert into role (name)
values ('ROLE_ADMIN');

insert into role (name)
values ('ROLE_USER');


insert into user_role (user_id, role_id)
values (1, 1);

insert into user_role (USER_ID, ROLE_ID)
values (1, 2);

insert into user_role (USER_ID, ROLE_ID)
values (2, 2);

insert into user_role (USER_ID, ROLE_ID)
values (3, 2);
