create table user (
user_id int auto_increment,
nick_name varchar(20) not null,
account varchar(20)  not null,
password varchar(30) not null,
constellation varchar(15),
email varchar(30),
primary key (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table picture(
picture_id int auto_increment,
type varchar(20) ,
mood varchar(20),
path varchar(50),
catalogue varchar(20),
primary key(picture_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table user_weather(
uw_id int auto_increment,
user_id int not null,
city varchar(50) ,
primary key (uw_id)
foreign key(uw_id) references to user(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;