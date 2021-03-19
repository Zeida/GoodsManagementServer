INSERT INTO user (userid, usercode, username, password, name, surname, email, address, phone) VALUES
    (2111321312, 'u01','zeida5','$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6','zeida','romen','zeidaromen@gmail.com','Moya','630222578'),
    (2111321313, 'u02','jennizqstn','$2y$12$hvxtrtv555EsrPd6rSHOl.UL6MKZCvWTSLJ6hosCoMt1OOe27jAzS ','jennifer','izquier','jennizqsant@gmail.com','Las Palmas','646582578'),
    (2111321314, 'u03','jonay','$2y$12$ahCtAX9EXhek2pBwKjL6aupey.S57foyXgpP8FTEbWhBRLWv17WAG','jonay','romen','jonayromen@gmail.com','Moya','645222588'),
    (2111321315, 'u04','fayna','$2y$12$8fh9M7OIPtt0VZnaGAvbd.VBkQ5xUNxr7xHVDwE0WAxskn3/aulAG ','fayna','romen','faynaromen@gmail.com','Arucas','645879588');

INSERT INTO supplier (suppliercode, name, country) VALUES
    ('S01', 'IKEA', 'Canary Islands'),
    ('S02', 'IKEAPR', 'Puerto Rico'),
    ('S03', 'IKEABALEARES', 'Baleares');

INSERT INTO pricereduction(pricereductioncode, reducedprice, startdate, enddate) VALUES
    ('PR01', '0.0', '2008-11-11', '2300-12-29'),
    ('PR02', '0.2', '2008-11-11', '2008-12-29'),
    ('PR03', '0.3', '2008-11-09', '2008-12-29'),
    ('PR04', '0.7', '2008-11-11', '2008-12-29');

INSERT INTO item(itemcode, description, price, state, creationdate, userid) VALUES
    ('I01', 'Hamaca verde de jardin', '58.90', 'ACTIVE', '2008-12-29',2111321312),
    ('I02', 'Mesa de plástico jardin', '45.90', 'ACTIVE', '2008-12-29',2111321312),
    ('I03', 'Barbacoa de mamposteria', '125.2', 'ACTIVE', '2008-12-29',2111321312);