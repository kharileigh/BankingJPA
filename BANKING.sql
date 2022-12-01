use wileyDI001;

CREATE TABLE Customer (
	ACCOUNT_ID int AUTO_INCREMENT PRIMARY KEY,
    NAME varchar(30) NOT NULL,
	PASSWORD varchar(30) NOT NULL,
    ADDRESS varchar(30) NOT NULL,
    PHONE_NUMBER varchar(15) NOT NULL,
    BALANCE double NOT NULL
);

INSERT INTO Customer 
VALUES (1122, "Penelope", "loop", "12 Cambridge Road, Hastings, TN34 3TY", "+441112223456", 45024.55),
(1123, "Penelope", "loop", "12 Cambridge Road, Hastings, TN34 3TY", "+441113338790", 108024.90),
(1124, "Wilde", "wile", "3 Harrison Road, Kensington, WD22 2PL", "+441114443588", 5689.23),
(1125, "Mona", "moon", "101 Dalmatian Ave, Southend-On-Sea, SE21 5HN", "+441115552578", 112657.11),
(1126, "Nuu", "uuna", "55 Victoria Palace, West Olympia, WH45 6UY", "+441116661212", 12567.05),
(1127, "Leigh", "lee", "1 Strawberry Hill, West Brompton, WE90 2FF", "+441117770909", 40400.56),
(1128, "Lorraine", "rainey", "14 Ply Hill, Birmingham, BI34 3LK", "+441118885678", 678900.23),
(1129, "Vincent", "mill", "10 Coolier Rise, London, CTY 4FV", "+441119992837", 555678.44);

ALTER TABLE Customer
	MODIFY ADDRESS varchar(50) NOT NULL;
    
SELECT ACCOUNT_ID AS ID, NAME AS Name, PASSWORD AS Password, ADDRESS AS Address, PHONE_NUMBER "Phone Number", BALANCE "Current Balance"
FROM Customer;