create database saludos;
use saludos;
create user 'brand'@'localhost' identified by '123456789';
create user 'brand'@'127.0.0.1' identified by '123456789';
grant all privileges on saludos.* to 'brand'@'localhost';
grant all privileges on saludos.* to 'brand'@'127.0.0.1';
flush privileges;