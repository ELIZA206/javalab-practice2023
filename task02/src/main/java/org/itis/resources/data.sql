insert into products(name_product, price, currency)
values ('Молоко',50,'руб'),
       ('Хлеб',20,'руб'),
       ('Мясо',500,'руб'),
       ('Рыба',750,'руб'),
       ('Макароны',300,'руб'),
       ('Масло',200,'руб'),
       ('Мука',150,'руб'),
       ('Крупа',100,'руб');

insert into clients (first_name, last_name, company)
values ('Андрей','Сергеев','RTI'),
       ('Ника','Костина','Tokenshop'),
       ('Артём','Матвеев','Itembox'),
       ('Илья','Прохоров','Conshop'),
       ('Лев','Соловьев','Shopcube'),
       ('Егор','Селиванов','Magnit');

insert into shops (title, address)
values ('Магнит','просп. Мира, 45'),
       ('Пятерочка','Мартеновская, 2'),
       ('Fixprice','Заводская, 3'),
       ('Магнит','ул. Сталеваров, 14'),
       ('Метро','Пушкинская, 8');

insert into products_in_shops(shop_id, product_id, sum)
values (1,2,100),
       (2,3,746),
       (3,6,289),
       (1,4,600),
       (4,3,469),
       (5,8,261),
       (1,5,467);

insert into orders (shop_id, clients_id)
values (1,4),
       (1,1),
       (2,4),
       (2,1),
       (3,5),
       (4,4),
       (2,3),
       (5,2),
       (4,3),
       (5,2);