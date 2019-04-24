insert into label values (null, "Poland", "Prosto");
insert into label values (null, "Poland", "SBM Label");
insert into label values (null, "Poland", "QueQuality");

insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null, "Wojciech", "Sosnowski", "Sokół", "Poland", "1977-03-11", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null, "Mateusz", "Karaś", "Białas", "Poland", "1987-12-11", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null, "Kuba", "Grabowski", "Quebonafide", "Poland", "1991-07-07", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null,  "Borys", "Przybylski", "Bedoes", "Poland", "1998-04-21", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null,  "Mateusz", "Bluza", "Guzior", "Poland", "1992-07-16", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null, "Adam", "Zieliński", "Łona", "Poland", "1982-05-21", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null,  "Damian", "Kowalski", "Bonson", "Poland", "1990-03-29", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null, "Tomasz", "Lewandowski", "VNM", "Poland", "1984-01-25", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null, "Piotr", "Szmidt", "Ten Typ Mes","Poland", "1982-12-24", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null, "Keith", "Cozart", "Chief Keef", "United States", "1995-08-15", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null,  "Gerald", "Gillum", "G-Eazy", "United States", "1989-05-24", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null, "Aubrey", "Graham", "Drake", "Canada", "1986-10-24", "M");
insert into artist(id, name, surname, pseudonym, nationality, birth_date, sex) values (null, "Piotr", "Gędek", "Soulpete", "Poland", null, "M");

insert into band values(null, "BonSoul");

insert into album values (null, 0, "Rap", "2012-02-20", "Etenszyn: Drimz Kamyn Tru", null, 1);
insert into album values (null, 0, "Rap", "2019-02-15", "Wojtek Sokół", null, 1);
insert into album values (null, 0, "Rap", "2015-12-04", "Demówka EP", null, 3);

insert into album_artist values (1, 8);
insert into album_artist values (2, 1);
insert into album_artist values (3, 2), (3,3);

insert into band_artist(band_id, artist_id) values(1, 7), (1, 13);

insert into user(id, email, username, password, enabled, registration_token, pass_recovery_token) values (null, "patryk.leczycki1@gmail.com", "Pinky","$2a$10$5zl.4gm/CdR0l3v4Qv6Er.lk01q.1DXGXzLdAsDb6h3Dv8xF.uQRG", 1, null, null);
insert into user(id, email, username, password, enabled, registration_token, pass_recovery_token) values (null, "email@email.com", "user1", "$2a$10$ZfOnsqjlibAnZ1d3BP26V.qR.m.P/zADl54bbF5IO1F9bhyeidnqK", 1, null, null);
insert into user(id, email, username, password, enabled, registration_token, pass_recovery_token) values (null, "matrix9596@gmail.com", "YourFatherDrunk", "$2a$10$sgJIPaeihpn2oyPEpPQcvO8Fn3A2xcI5hZrviLLQPs9Co.EIP7G2O", 1, null, null);


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
