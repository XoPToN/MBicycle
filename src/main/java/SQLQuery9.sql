/* 
1. Создаем базу данных 
*/

CREATE DATABASE Savchenko_BookAndAuthors
COLLATE SQL_Latin1_General_CP1251_CI_AS
go
USE Savchenko_BookAndAuthors
Go
/*
2.	Создаем таблицы в базе данных
*/
USE Savchenko_BookAndAuthors
go
CREATE TABLE authors(
	[idA] [int] NOT NULL,
	[nameA] [nchar](20) NULL
) ON [PRIMARY]
GO
CREATE TABLE books(
	[idB] [int] NOT NULL,
	[nameB] [nchar](20)  NULL
) ON [PRIMARY]
GO
CREATE TABLE storage(
	[id_authors] [int] NOT NULL,
	[id_book] [int] NOT NULL
) ON [PRIMARY]
GO
/*
4.	Заполняю таблицы
*/
insert into books values(1,'Book_1')
insert into books values(2,'Book_2')
insert into books values(3,'Book_3')
insert into books values(4,'Book_4')
insert into books values(5,'Book_5')

insert into authors values(1,'Author_1')
insert into authors values(2,'Author_2')
insert into authors values(3,'Author_3')
insert into authors values(4,'Author_4')

insert into storage values(1,3)
insert into storage values(2,3)
insert into storage values(3,3)
insert into storage values(5,3)

insert into storage values(2,2)
insert into storage values(4,4)
insert into storage values(1,1)
insert into storage values(5,1)
/*
5.	Проверка результат заполнения таблиц
*/
select * from authors
select * from books
select * from storage

select * from books where idB 
in(select id_book from storage where id_authors
in(select idA from authors where nameA='Author_2'))
