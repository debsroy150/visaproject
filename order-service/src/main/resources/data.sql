create table visaorder (
    orderId integer not null auto_increment,
    orderTotal double,
    status char,
    emailId varchar(100),
    primary key(orderId),
    unique (status, emailId)
);

create table visaorderitem (
    orderId integer not null,
    productId integer,
    quantity integer,
    amount double
);