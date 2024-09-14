create table student
(
    username  varchar(255)                       not null comment '学号'
        primary key,
    password  varchar(32)       default '123456' not null comment '密码',
    age       int unsigned                       not null comment '年龄',
    name      varchar(255)                       not null comment '姓名',
    gender    enum ('男', '女') default '男'     not null comment '性别',
    phone_num varchar(11)                        null comment '手机号',
    email     varchar(255)                       null comment '邮箱',
    avatar    varchar(255)                       null comment '头像',
    constraint stu_num
        unique (username)
)
    charset = utf8mb3
    row_format = DYNAMIC;

INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('Stest', '123456', 20, '学生测试', '男', '13233332222', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu1', '123456', 18, '张三', '男', '15833332222', '123@qq.com', '497c847e088b47048bbb3eb40c325428.jpg');
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu10', '123456', 19, '马克', '女', '15833333333', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu11', '123456', 16, '巧巧', '女', '18922223333', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu12', '123456', 17, '丽丽', '女', '17922222222', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu13', '123456', 18, '美美', '女', '15822222222', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu14', '123456', 20, '拉拉', '女', '13355556666', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu15', '123456', 18, '贝贝', '男', '15899999999', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu16', '123456', 18, '力力', '男', '14596475257', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu17', '123456', 18, '阿成', '男', '15896542147', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu18', '123456', 19, '阿达', '女', '14785635874', 'akk@qq.com', null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu19', '123456', 19, '帕森斯', '男', '15889658475', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu2', '123456', 18, '田田', '男', '15875359641', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu20', '123456', 21, '柠檬', '男', '15874563558', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu21', '123456', 21, '面对', '男', '15889635874', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu22', '123456', 25, '等等', '男', '13412341234', 'akkk@kkk.com', null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu3', '123456', 18, '吉安', '男', '15798657350', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu4', '123456', 22, '力力', '男', '15878965874', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu5', '123456', 19, '哦哦', '男', '15897535478', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu6', '123456', 18, '泡泡', '男', '18987554765', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu7', '123456', 15, '刚刚', '男', '15897543854', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu8', '123456', 18, '七七', '男', '12332143215', null, null);
INSERT INTO dormitory.student (username, password, age, name, gender, phone_num, email, avatar) VALUES ('stu9', '123456', 20, '德萨', '男', '15889658741', null, null);
