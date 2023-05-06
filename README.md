# Shoppy App

### Routes:
* Post/ create new cart : http://localhost:8080/carts
* Get/ get all carts : http://localhost:8080/carts
* Get/ find all items of cart : http://localhost:8080/carts/{id}/items
* Post/ create new shopper : http://localhost:8080/shoppers
* Post/ create new item : http://localhost:8080/carts/{id}
* Put/ shopper like an item : http://localhost:8080//shoppers/{shopperId}/items/{itemId}
* Get/ find all items above cost : http://localhost:8080/carts/{id}items/cost/{cost}

## The application.properties File
```
spring.datasource.url=jdbc:postgresql://localhost:5432/shoppydb
spring.datasource.username=ismail
spring.datasource.password=123456

# JPA
spring.jpa.database=POSTGRESQL
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.type=trace

```

## Database setup :
* start the sql server
* type **psql**

```

CREATE TABLE item (
item_id serial PRIMARY KEY,
name VARCHAR(50) NOT NULL,
cost FLOAT NOT NULL,
cart_id INTEGER
);

CREATE TABLE cart (
cart_id serial PRIMARY KEY,
name VARCHAR(50) NOT NULL,
description VARCHAR(255) NOT NULL
);

CREATE TABLE shopper (
shopper_id serial PRIMARY KEY,
name VARCHAR ( 50 ) NOT NULL
);

ALTER TABLE item
ADD CONSTRAINT fk_cart_id FOREIGN KEY (cart_id) REFERENCES cart (cart_id); 
```