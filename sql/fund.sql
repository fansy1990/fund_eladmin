drop table fund_details;

CREATE TABLE fund_details
(
    fund_code VARCHAR(10) NOT NULL  ,
    fund_name VARCHAR(200),
    fund_name_key VARCHAR(50),
    count_date VARCHAR(10),
    nav DOUBLE,
    ljjz DOUBLE,
    grow_rate DOUBLE,
    recent_one_week DOUBLE,
    recent_one_month DOUBLE,
    recent_three_month DOUBLE,
    recent_six_month DOUBLE,
    recent_one_year DOUBLE,
    recent_two_year DOUBLE,
    recent_three_year DOUBLE DEFAULT '0',
    recent_this_year DOUBLE,
    from_creation DOUBLE(10,4),
    creation_date VARCHAR(20),
    a1 INT(11),
    custom DOUBLE,
    a2 VARCHAR(10),
    fee VARCHAR(10),
    a3 DOUBLE,
    a4 VARCHAR(10),
    a5 DOUBLE,
    a6 DOUBLE DEFAULT '0'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


# CREATE TABLE eladmin.fund_details
# (
#     id INT NOT NULL,
#     fund_code VARCHAR(100) PRIMARY KEY,
#     fund_name VARCHAR(200),
#     fund_name_key VARCHAR(50),
#     count_date VARCHAR(10),
#     nav DOUBLE,
#     ljjz DOUBLE,
#     grow_rate DOUBLE,
#     recent_one_week DOUBLE,
#     recent_one_month DOUBLE,
#     recent_three_month DOUBLE,
#     recent_six_month DOUBLE,
#     recent_one_year DOUBLE,
#     recent_two_year DOUBLE,
#     recent_three_year DOUBLE,
#     recent_this_year DOUBLE,
#     from_creation DOUBLE,
#     creation_date VARCHAR(10),
#     a1 INT,
#     custom DOUBLE,
#     a2 DOUBLE,
#     fee DOUBLE,
#     a3 DOUBLE,
#     a4 DOUBLE,
#     a5 DOUBLE,
#     a6 DOUBLE
# )ENGINE=InnoDB DEFAULT CHARSET=utf8;
# CREATE UNIQUE INDEX fund_details_fund_code_uindex ON eladmin.fund_details (fund_code);

TRUNCATE TABLE fund_details;
-- insert data
LOAD DATA INFILE '/Users/fanzhe/projects/fansy_githubs/eladmin/data/fund_data.txt'
INTO TABLE eladmin.fund_details character set utf8
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
(@col1,@col2,@col3,@col4,@col5,@col6,@col7,@col8,@col9,@col10,@col11,@col12,@col13,@col14,@col15,@col16,@col17,@col18,@col19,@col20,@col21,@col22,@col23,@col24,@col25)
set fund_code = @col1,
    fund_name = @col2,
    fund_name_key = @col3,
    count_date = @col4,
    nav = nullif(@col5,''),
    ljjz = nullif(@col6,''),
    grow_rate = nullif(@col7,''),
    recent_one_week = nullif(@col8,''),
    recent_one_month = nullif(@col9,''),
    recent_three_month = nullif(@col10,''),
    recent_six_month = nullif(@col11,''),
    recent_one_year = nullif(@col12,''),
    recent_two_year = nullif(@col13,''),
    recent_three_year = nullif(@col14,''),
    recent_this_year = nullif(@col15,''),
    from_creation = @col16,
    creation_date = @col17,
    a1 = @col18,
    custom = nullif(@col19,''),
    a2 = @col20,
    fee = @col21,
    a3 = nullif(@col22,''),
    a4 = @col23,
    a5 = nullif(@col24,''),
    a6 = nullif(@col25,'')
;


