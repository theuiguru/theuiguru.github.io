-- phpMyAdmin SQL Dump
-- version 2.11.2.1
-- http://www.phpmyadmin.net
--
-- localhost
-- 2012/05/01 06:04
-- server edition: 5.0.45
-- PHP edition: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- database schema: `acors`
--

-- --------------------------------------------------------

--
-- table structure `billingaddress`
--

CREATE TABLE `billingaddress` (
  `ID` int(11) NOT NULL auto_increment,
  `CardId` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `Street` varchar(100) character set utf8 collate utf8_unicode_ci NOT NULL,
  `City` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `State` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `ZIP` varchar(15) character set utf8 collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`ID`),
  KEY `CardId` (`CardId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- export the data `billingaddress`
--


-- --------------------------------------------------------

--
-- table structure `creditcard`
--

CREATE TABLE `creditcard` (
  `ID` int(11) NOT NULL auto_increment,
  `CardID` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `FName` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `LName` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `CardType` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `SecurityNum` varchar(10) character set utf8 collate utf8_unicode_ci NOT NULL,
  `ExpiryDate` date NOT NULL,
  `CID` int(11) NOT NULL,
  PRIMARY KEY  (`CardID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `CID` (`CID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- export the data `creditcard`
--

INSERT INTO `creditcard` (`ID`, `CardID`, `FName`, `LName`, `CardType`, `SecurityNum`, `ExpiryDate`, `CID`) VALUES
(2, '111222333444555666', 'posa', 'wu', 'posa', '23423', '2012-04-02', 8),
(1, '123456789012345678', 'posa', 'wu', 'das', 'da', '2012-04-02', 8),
(23, '132312332132132132', 'sa', 'daf', 'fda', '43', '2012-04-02', 8),
(3, '222333111456435678', 'posa', 'wu', 'afdas', '12312', '2012-04-02', 8),
(4, '231234234343432321', 'posa', 'wu', 'dsfa', '2342', '2012-04-02', 8),
(8, '231312321321433232', 'posa', 'wu', 'asfda', '234', '2012-04-03', 8),
(20, '233333333333222222', 'd', 'd', 'd', 'd', '2012-04-02', 8),
(9, '234324324324321124', 'das', 'dsfa', 'dfsa', 'dfsa', '2012-04-02', 8),
(12, '234324324324324323', 'sdf', 'd', 'd', 'd', '2012-04-02', 8),
(6, '234343433232323232', 'posa', 'wu', 'das', '432432', '2012-04-02', 8),
(16, '243242425353454344', 'd', 'd', 'd', 'd', '2012-04-02', 8),
(18, '252432443253262624', '4', '4', '4', '4', '2012-04-02', 8),
(19, '321222222222222221', 'd', 'd', 'd', 'd', '2012-04-02', 8),
(29, '324432432432434324', 'carlloveemily', 'carlloveemily', 'luce', '3242343', '2012-05-09', 7),
(15, '333333333333333333', 'd', 'd', 'd', 'd', '2012-04-02', 8),
(21, '333333333333344443', 'd', 'd', 'g', 'g', '2012-04-02', 8),
(17, '342343333333333334', 'd', 'd', 'd', 'd', '2012-04-03', 8),
(13, '342423432432432453', 'asfds', 'fdsa', 'fda', 'dfa', '2012-04-02', 8),
(27, '344113113131213131', 'DFAS', 'DAS', 'DSAF', '23', '2012-04-02', 8),
(10, '344323242342532552', 'fdas', 'd', 'd', 'd', '2012-04-02', 8),
(24, '364676365363553656', 'f', 'f', 'f', '52', '2012-04-02', 8),
(7, '377987982789834712', 'posa', 'wu', '234432', '34243', '2012-04-02', 8),
(28, '423534654476487875', 'fdsa', 'fdas', 'dasf', '23442', '2012-04-03', 8),
(11, '432432432325422123', 'sda', 'dsa', 'ds', 'f', '2012-04-02', 8),
(14, '432432432432432432', 'd', 'd', 'd', 'd', '2012-04-02', 8),
(25, '433333333333444343', 'dfda', 'f', 'fdsa', '432', '2012-04-02', 8),
(22, '442222222322345232', 'fa', 'fds', 'fd', '2342', '2012-04-02', 8),
(5, '455565656565656565', 'posa', 'wu', 'das', '34234', '2012-04-02', 8),
(26, '879234672367233243', 'fsa', 'fda', 'a', '234', '2012-04-02', 8);

-- --------------------------------------------------------

--
-- table structure `customer_information`
--

CREATE TABLE `customer_information` (
  `CID` int(11) NOT NULL,
  `DT` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `FName` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `LName` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `Gender` varchar(10) character set utf8 collate utf8_unicode_ci NOT NULL,
  `Tel` varchar(20) character set utf8 collate utf8_unicode_ci default NULL,
  `Email` varchar(20) default NULL,
  `Birthday` date NOT NULL,
  KEY `CID` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- export the data `customer_information`
--

INSERT INTO `customer_information` (`CID`, `DT`, `FName`, `LName`, `Gender`, `Tel`, `Email`, `Birthday`) VALUES
(6, '2012-03-11 19:41:39', 'dffdafda@', 'dffdafda@', 'female', 'dffdafda@', 'dffdafda@', '2012-03-07'),
(7, '2012-03-13 15:43:54', 'kun', 'Tang', 'female', '1231423114313', 'ddsa@sina.com', '2012-12-30'),
(8, '2012-04-30 11:15:50', 'posa88', 'wu', 'male', '13431312312', 'fdas@sina.com', '2012-04-04');

-- --------------------------------------------------------

--
-- table structure `customer_registeration`
--

CREATE TABLE `customer_registeration` (
  `CID` int(11) NOT NULL auto_increment,
  `CLoginID` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `CPassword` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`CID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- export the data `customer_registeration`
--

INSERT INTO `customer_registeration` (`CID`, `CLoginID`, `CPassword`) VALUES
(6, 'dffdafda@', 'dffdafda@'),
(7, 'carlloveemily', 'carlloveemily'),
(8, 'posa88', 'posa88');

-- --------------------------------------------------------

--
-- table structure `order`
--

CREATE TABLE `order` (
  `OID` int(11) NOT NULL auto_increment,
  `CID` int(11) NOT NULL,
  `Cost` float unsigned NOT NULL,
  `CardID` varchar(50) NOT NULL,
  PRIMARY KEY  (`OID`),
  UNIQUE KEY `OID` (`OID`),
  KEY `CID` (`CID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- export the data `order`
--

INSERT INTO `order` (`OID`, `CID`, `Cost`, `CardID`) VALUES
(4, 8, 156, '111222333444555666'),
(5, 8, 339, '111222333444555666'),
(6, 8, 152, '111222333444555666'),
(9, 7, 152, '324432432432434324'),
(10, 8, 5412, '111222333444555666');

-- --------------------------------------------------------

--
-- database structure `orderitems`
--

CREATE TABLE `orderitems` (
  `Quantity` int(11) NOT NULL default '0',
  `Price` float NOT NULL,
  `OID` int(11) NOT NULL,
  `PID` int(11) NOT NULL,
  KEY `OID` (`OID`),
  KEY `orderImtes_ibfk_2` (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- export the data `orderitems`
--

INSERT INTO `orderitems` (`Quantity`, `Price`, `OID`, `PID`) VALUES
(1, 156, 4, 2),
(1, 35, 5, 1),
(2, 304, 5, 3),
(1, 152, 6, 3),
(1, 152, 9, 3),
(1, 5412, 10, 6);

-- --------------------------------------------------------

--
-- database structure `product`
--

CREATE TABLE `product` (
  `PID` int(11) NOT NULL auto_increment,
  `ProductName` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `Brand` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `Size` varchar(10) character set utf8 collate utf8_unicode_ci NOT NULL,
  `Category` varchar(50) character set utf8 collate utf8_unicode_ci default 'default_category',
  `Price` float NOT NULL,
  `Gender` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `Remainder` int(11) NOT NULL,
  `PicURL` varchar(50) default NULL COMMENT 'picture URl',
  PRIMARY KEY  (`PID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- export the data `product`
--

INSERT INTO `product` (`PID`, `ProductName`, `Brand`, `Size`, `Category`, `Price`, `Gender`, `Remainder`, `PicURL`) VALUES
(1, 'startT3', 'ohmyT', 'large', 'default_category', 35, 'female', 45, 'img/tshirt.jpg'),
(2, 'New start', 'New Sweater', 'small', 'sweater', 156, 'male', 10, 'img/sweater1.jpg'),
(3, 'cool jeans', 'JJ', 'large', 'jeans', 152, 'female', 10, 'img/jeans1.jpg'),
(4, 'pretty girl', 'Luice', 'small', 'skirt', 253, 'male', 20, 'img/skirt1.jpg'),
(5, 'pant is better', 'good boy', 'large', 'pant', 521, 'male', 10, 'img/pant1.jpg'),
(6, 'Iamhere', 'good father', 'large', 'suit', 5412, 'male', 10, 'img/suit1.jpg');

-- --------------------------------------------------------

--
-- database structure `shippingaddress`
--

CREATE TABLE `shippingaddress` (
  `OID` int(11) NOT NULL,
  `CID` int(11) NOT NULL,
  `Street` varchar(100) character set utf8 collate utf8_unicode_ci NOT NULL,
  `City` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `State` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `ZIP` varchar(15) character set utf8 collate utf8_unicode_ci NOT NULL,
  UNIQUE KEY `OID` (`OID`),
  KEY `CID` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- export the data `shippingaddress`
--


-- --------------------------------------------------------

--
-- database structure `staff_login`
--

CREATE TABLE `staff_login` (
  `DT` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `SLoginID` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  `SPassword` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`SLoginID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- export the data `staff_login`
--

INSERT INTO `staff_login` (`DT`, `SLoginID`, `SPassword`) VALUES
('2012-05-01 13:33:52', 'admin', 'admin');

--
-- limited export table
--

--
-- limited table `billingaddress`
--
ALTER TABLE `billingaddress`
  ADD CONSTRAINT `billingaddress_ibfk_1` FOREIGN KEY (`CardId`) REFERENCES `creditcard` (`CardID`);

--
-- limited table `creditcard`
--
ALTER TABLE `creditcard`
  ADD CONSTRAINT `creditcard_ibfk_1` FOREIGN KEY (`CID`) REFERENCES `customer_information` (`CID`);

--
-- limited table `customer_information`
--
ALTER TABLE `customer_information`
  ADD CONSTRAINT `customer_information_ibfk_1` FOREIGN KEY (`CID`) REFERENCES `customer_registeration` (`CID`);

--
-- limited table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`CID`) REFERENCES `customer_information` (`CID`);

--
-- limited table `orderitems`
--
ALTER TABLE `orderitems`
  ADD CONSTRAINT `orderImtes_ibfk_2` FOREIGN KEY (`PID`) REFERENCES `product` (`PID`),
  ADD CONSTRAINT `orderItems_ibfk_1` FOREIGN KEY (`OID`) REFERENCES `order` (`OID`);

--
-- limited table `shippingaddress`
--
ALTER TABLE `shippingaddress`
  ADD CONSTRAINT `shippingaddress_ibfk_1` FOREIGN KEY (`OID`) REFERENCES `order` (`OID`),
  ADD CONSTRAINT `shippingaddress_ibfk_2` FOREIGN KEY (`CID`) REFERENCES `customer_information` (`CID`);
