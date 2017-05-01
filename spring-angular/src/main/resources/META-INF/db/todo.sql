create table tb_todo (
	id integer identity primary key,
	title varchar(100) not null,
	description varchar(500) not null,
	event_date date,
	completed boolean
);


insert into tb_todo (id, title, description, event_date, completed) values(1, 'todo1', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(2, 'todo2', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(3, 'todo3', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(4, 'todo4', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(5, 'todo5', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(6, 'todo6', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(7, 'todo7', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(8, 'todo8', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(9, 'todo9', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(10, 'todo10', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(11, 'todo11', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(12, 'todo12', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(13, 'todo13', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(14, 'todo14', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(15, 'todo15', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(16, 'todo16', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(17, 'todo17', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(18, 'todo18', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(19, 'todo19', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(20, 'todo20', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(21, 'todo21', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(22, 'todo22', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(23, 'todo23', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(24, 'todo24', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(25, 'todo25', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(26, 'todo26', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(27, 'todo27', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(28, 'todo28', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(29, 'todo29', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(30, 'todo30', 'todo1', now(), false);
insert into tb_todo (id, title, description, event_date, completed) values(31, 'todo31', 'todo1', now(), false);

commit;
