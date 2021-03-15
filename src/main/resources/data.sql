INSERT INTO user (usercode, username, password, name, surname, email, address, phone) VALUES
    (1,'Zeida5','zeidapass','Zeida','Romen','Zeidaromen@gmail.com','Moya','630222578'),
    (2,'Jennizqstn','jennipass','Jennifer','Izquier','jennizqsant@gmail.com','Las Palmas','646582578'),
    (3,'Jonay','jonaypass','Jonay','Romen','jonayromen@gmail.com','Moya','645222588'),
    (4,'Fayna','faynapass','Fayna','Romen','faynaromen@gmail.com','Arucas','645879588');

INSERT INTO supplier (suppliercode, name, country) VALUES
    (1, 'IKEA', 'Canary Islands'),
    (2, 'IKEAPR', 'Puerto Rico'),
    (3, 'IKEABALEARES', 'Baleares');

INSERT INTO pricereduction(pricereductioncode, reducedprice, startdate, enddate) VALUES
    (0, '0.0', '2008-11-11', '2300-12-29'),
    (1, '0.2', '2008-11-11', '2008-12-29'),
    (2, '0.3', '2008-11-09', '2008-12-29'),
    (3, '0.7', '2008-11-11', '2008-12-29');

INSERT INTO item(itemcode, description, price, state, creationdate, usercode) VALUES
    (1, 'Hamaca verde de jardin', '58.90', 'ACTIVE', '2008-12-29','1'),
    (2, 'Mesa de plástico jardin', '45.90', 'ACTIVE', '2008-12-29','1'),
    (3, 'Barbacoa de mamposteria', '125.2', 'ACTIVE', '2008-12-29','1');