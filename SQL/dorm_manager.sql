create table dorm_manager
(
    username     varchar(255)                       not null comment '用户名'
        primary key,
    password     varchar(32)       default '123456' not null comment '密码',
    dormbuild_id int                                not null comment '所管理的宿舍楼栋号',
    name         varchar(255)                       not null comment '名字',
    gender       enum ('男', '女') default '男'     not null comment '性别',
    age          int                                not null comment '年龄',
    phone_num    varchar(11)                        null comment '手机号',
    email        varchar(255)                       null comment '邮箱',
    avatar       varchar(255)                       null comment '头像'
)
    charset = utf8mb3
    row_format = DYNAMIC;

INSERT INTO dormitory.dorm_manager (username, password, dormbuild_id, name, gender, age, phone_num, email, avatar) VALUES ('dorm1', '123456', 1, '张三', '男', 35, '15222223333', '12@email.com', null);
INSERT INTO dormitory.dorm_manager (username, password, dormbuild_id, name, gender, age, phone_num, email, avatar) VALUES ('dorm2', '123456', 2, '李四', '女', 55, '15333332222', null, null);
INSERT INTO dormitory.dorm_manager (username, password, dormbuild_id, name, gender, age, phone_num, email, avatar) VALUES ('dorm3', '123456', 3, '王五', '男', 38, '15855552222', null, null);
INSERT INTO dormitory.dorm_manager (username, password, dormbuild_id, name, gender, age, phone_num, email, avatar) VALUES ('dorm4', '123456', 4, '赵花', '女', 40, '15877776666', null, null);
INSERT INTO dormitory.dorm_manager (username, password, dormbuild_id, name, gender, age, phone_num, email, avatar) VALUES ('Mtest', '123456', 2, '宿管测试', '男', 22, '15899999999', null, null);
