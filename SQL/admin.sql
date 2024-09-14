create table admin
(
    username  varchar(255)                   not null comment '用户名'
        primary key,
    password  varchar(32)                    not null comment '密码',
    name      varchar(255)                   not null comment '姓名',
    gender    enum ('男', '女') default '男' not null comment '性别',
    age       int                            not null comment '年龄',
    phone_num varchar(11)                    null comment '手机号',
    email     varchar(255)                   null comment '邮箱',
    avatar    varchar(255)                   null comment '头像'
)
    charset = utf8mb3
    row_format = DYNAMIC;

INSERT INTO dormitory.admin (username, password, name, gender, age, phone_num, email, avatar) VALUES ('admin', '123456', '小赵', '男', 20, '17320036428', '1613594786@qq.com', 'cd9cc9dfb060463b9c97e890cdcce692.jpg');
INSERT INTO dormitory.admin (username, password, name, gender, age, phone_num, email, avatar) VALUES ('Atest', '123456', '测试管理员', '男', 22, '14785412478', null, null);
