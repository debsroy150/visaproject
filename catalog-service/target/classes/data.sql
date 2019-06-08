create table visaproduct (
    id integer not null,
    name varchar(200) not null,
    desc varchar(1000),
    amount double,
    quantity integer,
    primary key(id)
);


insert into visaproduct (id, name, desc, amount, quantity) values (1001, 'Product 1', 'Product 1 Description', 50.00, 100);
insert into visaproduct (id, name, desc, amount, quantity) values (1002, 'Product 2', 'Product 2 Description', 150.00, 200);
insert into visaproduct (id, name, desc, amount, quantity) values (1003, 'Product 3', 'Product 3 Description', 250.00, 0);
