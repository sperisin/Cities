insert into county (name) values
('Osječko - baranjska'),
('Grad Zagreb'),
('Splitsko - dalmatinska'),
('Brodsko - posavska'),
('Virovitičko - podravska');

insert into major (name, surname) values
('Ivan', 'Radić'),
('Tomislav', 'Tomašević'),
('Ivica', 'Puljak'),
('Tomislav', 'Rob'),
('Mirko', 'Duspara'),
('Ivica', 'Kirin');

insert into city (name, post_code, major_id, no_of_citizens, county_id) values
('Osijek', 31000, 1, 100000, 1),
('Zagreb', 10000, 2, 1000000, 2),
('Split', 21000, 3, 350000, 3),
('Beli Manastir', 31300, 4, 10000, 1),
('Slavonski Brod', 35000, 5, 65000, 4);
('Virovitica', 33000, 6, 21000, 5)



