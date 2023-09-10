CREATE database eazybank;

use eazybank;


CREATE TABLE authorities (
                             id INT NOT NULL AUTO_INCREMENT,
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             PRIMARY KEY (id)
);

CREATE TABLE `users` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `username` VARCHAR(45) NOT NULL,
                         `password` VARCHAR(45) NOT NULL,
                         `enabled` TINYINT NOT NULL,
                         PRIMARY KEY (`id`)
);

CREATE TABLE `users` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `gmail` VARCHAR(45) NOT NULL,
                         `password` VARCHAR(45) NOT NULL,
                         `role` TINYINT NOT NULL,
                         PRIMARY KEY (`id`)
);

INSERT INTO users (username, password, enabled) VALUES ('happy', '12345',  1);
INSERT INTO authorities (username, authority) VALUES ('happy', 'write');
INSERT INTO users (gmail, password,role) VALUES ('sasvaratharasa540@gmail.com', 'sasi24',  'admin');



CREATE TABLE `customer` (
                            `customer_id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(45) NOT NULL,
                            `email` VARCHAR(45) NOT NULL,
                            `mobile_number` VARCHAR(45) NOT NULL,
                            `role` VARCHAR(45) NOT NULL,
                            `password` VARCHAR(45) NOT NULL,
                            `create_date` DATE DEFAULT NULL,
                            PRIMARY KEY (`customer_id`)
);

INSERT INTO `customer` (`name`, `email`, `mobile_number`, `role`, `create_date`)
VALUES ('Happy', 'happy@example.com', '555-123-4567', 'Customer', '2023-09-06');




CREATE TABLE `accounts` (
                            `customer_id` INT NOT NULL AUTO_INCREMENT,
                            `account_number` VARCHAR(45) NOT NULL,
                            `account_type` VARCHAR(45) NOT NULL,
                            `branch_address` VARCHAR(45) NOT NULL,
                            `create_date` DATE DEFAULT NULL,
                            PRIMARY KEY (`account_number`),
                            KEY `customer_id` (`customer_id`),
                            CONSTRAINT `customer_idfk1` FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`) ON DELETE CASCADE
);

-- Inserting values into the accounts table
INSERT INTO `accounts` (`customer_id`, `account_number`, `account_type`, `branch_address`, `create_date`)
VALUES (1, 'ACC123456', 'Savings', '123 Main Street', '2023-09-06');



CREATE TABLE `account_transactions` (
                                        `transaction_id` INT NOT NULL AUTO_INCREMENT,
                                        `customer_id` INT NOT NULL
                                         `account_number` VARCHAR(45) NOT NULL,
                                        `transaction_type` VARCHAR(45) NOT NULL,
                                        `branch_address` VARCHAR(45) NOT NULL,
                                        `transaction_amount` INT NOT NULL,
                                        `closing_amount` INT NOT NULL,

                                        `create_date` DATE DEFAULT NULL,
                                        `transaction_date` DATE DEFAULT NULL,
                                        PRIMARY KEY (`transaction_id`),
                                        KEY `customer_id` (`customer_id`),
                                        KEY `account_number` (`account_number`),

                                        CONSTRAINT `account_idfk1` FOREIGN KEY (`account_number`) REFERENCES `accounts`(`account_number`) ON DELETE CASCADE
                                            CONSTRAINT `account_user_idfk2` FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`) ON DELETE CASCADE

);

