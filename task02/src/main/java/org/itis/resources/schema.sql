create table products(
                         id serial primary key,
                         name_product varchar(30),
                         price integer,
                         currency varchar(10)
);

create table clients (
                         id serial primary key,
                         first_name varchar(20),
                         last_name varchar(20),
                         company varchar(30)
);

create table shops (
                       id serial primary key,
                       title varchar(20),
                       address varchar(30)
);

create table products_in_shops (
                                   id serial primary key,
                                   shop_id integer,
                                   product_id integer,
                                   sum integer,
                                   foreign key (shop_id) references shops(id),
                                   foreign key (product_id) references  products(id)
);

create table orders (
                        id serial primary key,
                        shop_id integer,
                        clients_id integer,
                        foreign key (shop_id) references shops(id),
                        foreign key (clients_id) references clients(id)
);
