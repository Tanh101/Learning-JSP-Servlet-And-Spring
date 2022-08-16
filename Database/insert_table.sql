use demoservlet;
insert into role(code, name)
values ('ADMIN', 'Quản trị');
insert into role(code, name) values('USER', 'Người dùng');


insert into user(username, password, fullname, status)
values('admin', '123456', 'admin', 1, 1);

insert into user(username, password, fullname, status, roleid)
values('lyvantanh', '123456', 'Lý Văn Tánh', 1, 2);

insert into user(username, password, fullname, status)
values('nguyenvana', '123456', 'Nguyễn Văn A', 1, 2);