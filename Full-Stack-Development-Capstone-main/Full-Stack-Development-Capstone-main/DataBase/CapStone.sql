DROP DATABASE IF EXISTS CarDealership;
CREATE DATABASE CarDealership;

USE CarDealership;

DROP TABLE IF EXISTS Admin;


DROP TABLE IF EXISTS Vehicle;
CREATE TABLE Vehicle(
    vehicle_id INT PRIMARY KEY AUTO_INCREMENT,
    vehicle_model_name VARCHAR(255) NOT NULL,
    'year' DATE NOT NULL,
    make  VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    'types' VARCHAR(255) NOT NULL,
	body_style  VARCHAR(255) NOT NULL,
	trans ENUM('Automatic','Manual')NOT NULL,
	color VARCHAR(255) NOT NULL,
    interior_color VARCHAR(255) NOT NULL
    mileage VARCHAR(255) NOT NULL,
    vin  VARCHAR(255) NOT NULL,
    sale_price decimal(8,2) default 0,
	msrp decimal(8,2) default 0,
    'description' VARCHAR(255)
);

DROP TABLE IF EXISTS UserAccount;
CREATE TABLE UserAccount(
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	emali VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
	account_type ENUM('Disabled','Sales','Admin') NOT NULL
);


DROP TABLE IF EXISTS ContactUS;
CREATE TABLE ContactUS(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    emali VARCHAR(255),
    phone VARCHAR(255),
    message VARCHAR(255)
);

DROP TABLE IF EXISTS Purchase;
CREATE TABLE Purchase(
    purchase_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    emali VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    street1 VARCHAR(255) NOT NULL,
    street2 VARCHAR(255) NOT NULL,
	city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
	zip_code INT (255) NOT NULL,
	purchase_price decimal(8,2) default 0,
    purchase_type VARCHAR(255) NOT NULL,
    vehicle_id INT NOT NULL,
	user_id INT NOT NULL,
	FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id),
    FOREIGN KEY (UserAccount) REFERENCES UserAccount(UserAccount)
);