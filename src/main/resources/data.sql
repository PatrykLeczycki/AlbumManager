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
