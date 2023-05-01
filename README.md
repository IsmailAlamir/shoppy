## Database setup :
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