//DB Schema & SQL created by Chris Thomas on Wednesday, February 6, 2013
CREATE TABLE cuzinz (
     id int auto_increment primary key, 
     name varchar(30), 
     email varchar(30),
     location varchar(30)
    );

INSERT INTO cuzinz (name, email, location)
VALUES
('Santosh', 'josephg2005@gmail.com', 'Bangalore'),
('Sunu', 'annjoseph2000@gmail.com', 'Bangalore'),
('Allan', 'allanjoseph98@gmail.com', 'Bangalore'),
('Robin', 'robsen25@yahoo.co.in', 'Kuwait'),
('Shiji', 'N/A', 'Kuwait'),
('Rojan', 'rojanphilips@gmail.com', 'Kerala'),
('Priya', 'N/A', 'Kerala'),
('Rekha', 'lrdservant@yahoo.com', 'Golden, Colorado'),
('Sunil', 'sjdaniel@yahoo.com', 'Golden, Colorado'),
('Ranjan', 'tossthedice511@hotmail.com', 'Syosset, NY'),
('Roshan', 'roshan.abraham@gmail.com', 'Syosset, NY'),
('Ranjit', 'j.mathew.1@alumni.nyu.edu', 'New York, NY'),
('Erica', 'eaovero@yahoo.com', 'New York, NY'),
('Bavan', 'philippmathew@gmail.com', 'Queens, NY'),
('Anita', 'anita.geevarughese@gmail.com', 'Queens, NY'),
('Swithin', 'swithbeatz@gmail.com', 'Queens Village, NY'),
('Rena', 'rena.john@yahoo.com', 'Queens Village, NY'),
('John (Sona)', 'N/A', 'Dubai'),
('Sherry', 'sherry.geo@gmail.com', 'Queens Village, NY'),
('Shanu', 'kuttichaathan@gmail.com', 'Baltimore, MD'),
('Justin', 'justm1@msn.com', 'Stony Brook, NY'),
('Alex', 'almathwiz517@yahoo.com', 'Bellerose, NY'),
('Chris', 'webmaster102@gmail.com', 'Levittown, NY'),
('Dinah', 'dinaht9492@gmail.com', 'Binghamton, NY');

SELECT * FROM cuzinz