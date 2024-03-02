create table if not exists purchase(
id int not null AUTO_INCREMENT, 
product varchar(50) not null, 
price double not null, 
primary key(id));