CREATE TABLE user (
  wxid VARCHAR(100)  NOT NULL ,
  name VARCHAR(50) NOT NULL DEFAULT '',
  account FLOAT NOT NULL DEFAULT 0.0,
  title VARCHAR(200) ,
  title_create_date DATE ,
  PRIMARY KEY (`wxid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tucao (
  id bigint(11)  NOT NULL AUTO_INCREMENT,
  from_wxid VARCHAR(100)  NOT NULL DEFAULT '',
  to_wxid VARCHAR(100)  NOT NULL DEFAULT '',
  content VARCHAR(1024) ,
  is_best bool ,
  create_at date,
  PRIMARY KEY (`id`),
  key `i_from_wxid` (`from_wxid`),
  key `i_to_wxid` (`to_wxid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;