
CREATE TABLE role(
	id bigint not null primary key auto_increment,
    name varchar(150) not null,
    code varchar(150) not null,
    createdDate TIMESTAMP null,
    modifiedDate TIMESTAMP null,
    createBy varchar(255) null,
    modifiedBy varchar(255) NULL
);

CREATE TABLE user(
	id bigint not null primary key auto_increment,
    username varchar(150) not null,
    password varchar(150) not null,
    fullname varchar(150) not null,
    status int NOT NULL,
    createdDate TIMESTAMP null,
    modifiedDate TIMESTAMP null,
    createBy varchar(255) null,
    modifiedBy varchar(255) NULL,
	roleid bigint not null,
    constraint fk_user_role FOREIGN KEY (roleid)
    REFERENCES role(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE news(
	id bigint not null primary key auto_increment,
	title varchar(255) null,
    thumbnail varchar(255)  null,
    shortdesscription text  null,
    content text null,
	categoryid bigint not null,
    createdDate TIMESTAMP null,
    modifiedDate TIMESTAMP null,
    createBy varchar(255) null,
    modifiedBy varchar(255) NULL,
    constraint fk_news_category foreign key(categoryid)
    references category(id)
);
create table comment(
	id bigint not null primary key auto_increment,
    content text not null,
    user_id bigint not null,
    new_id bigint not null,
    createBy varchar(255) null,
    modifiedBy varchar(255) NULL,
    constraint fk_comment_user foreign key(user_id)
    references user(id),
    constraint fk_comment_news foreign key(new_id)
    references news(id)
);
 

CREATE TABLE category(
	id bigint not null primary key auto_increment,
    name varchar(150) not null,
    code varchar(150) not null,
    createdDate TIMESTAMP null,
    modifiedDate TIMESTAMP null,
    createBy varchar(255) null,
    modifiedBy varchar(255) NULL
);