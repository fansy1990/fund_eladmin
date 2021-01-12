DROP TABLE fund_stock;
CREATE TABLE fund_stock
(
    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fund_code VARCHAR(255),
    jing_zhi_percent VARCHAR(255),
    quater INT(11),
    stock_code VARCHAR(255),
    stock_name VARCHAR(255),
    stock_size DOUBLE,
    stock_value DOUBLE,
    year INT(11)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;