DROP TABLE IF EXISTS sales;

DROP TABLE IF EXISTS customers;

CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255));

CREATE TABLE sales(id SERIAL, amount NUMBER, currency VARCHAR(3), save_date DATE, customer_id INT, FOREIGN KEY(customer_id) REFERENCES customers(id));
