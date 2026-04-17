CREATE TABLE Client(
    customerid INT,
    name VARCHAR(50),
    city VARCHAR(50)
);

CREATE TABLE Productlist (
    productid INT,
    name VARCHAR(50),
    category VARCHAR(50),
    price INT
);

CREATE TABLE Orderlist (
    orderid INT,
    customerid INT,
    date DATE
);

CREATE TABLE OrderItems (
    orderid INT,
    productid INT,
    quantity INT
);

INSERT INTO Client VALUES
(1, 'Vijay', 'Hyderabad'),
(2, 'Ramu', 'Mumbai'),
(3, 'Anji', 'Delhi');

INSERT INTO Productlist VALUES
(101, 'Shoes', 'Fashion', 1000),
(102, 'Mobile', 'Electronics', 15000),
(103, 'Bag', 'Fashion', 800);

INSERT INTO Orderlist VALUES
(201, 1, '2026-04-10'),
(202, 2, '2026-04-11'),
(203, 1, '2026-04-12');

INSERT INTO OrderItems VALUES
(201, 101, 2),
(202, 102, 1),
(203, 103, 3);

SELECT p.name, SUM(oi.quantity) AS totalsold
FROM Productlist p
JOIN OrderItems oi ON p.productid = oi.productid
GROUP BY p.name
ORDER BY totalsold DESC;

SELECT SUM(p.price * oi.quantity) AS totalrevenue
FROM Productlist p
JOIN OrderItems oi ON p.productid = oi.productid;

SELECT p.category, SUM(p.price * oi.quantity) AS categorysales
FROM Productlist p
JOIN OrderItems oi ON p.productid = oi.productid
GROUP BY p.category;

SELECT c.name, SUM(p.price * oi.quantity) AS totalspent
FROM Client c
JOIN Orderlist o ON c.customerid = o.customerid
JOIN OrderItems oi ON o.orderid = oi.orderid
JOIN Productlist p ON oi.productid = p.productid
GROUP BY c.name
ORDER BY totalspent DESC;

SELECT MONTH(date) AS month,
SUM(p.price * oi.quantity) AS revenue
FROM Orderlist o
JOIN OrderItems oi ON o.orderid = oi.orderid
JOIN Productlist p ON oi.productid = p.productid
GROUP BY month;
