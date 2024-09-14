create table visitor
(
    id          int auto_increment
        primary key,
    name        varchar(255)                                not null comment '姓名',
    gender      enum ('男', '女') default '男'              not null comment '性别',
    phone_num   varchar(255)                                not null comment '电话',
    origin_city varchar(255)                                not null comment '来源城市',
    visit_time  datetime          default CURRENT_TIMESTAMP not null comment '来访时间',
    content     varchar(255)                                not null comment '事情'
)
    charset = utf8mb3
    row_format = DYNAMIC;

INSERT INTO dormitory.visitor (id, name, gender, phone_num, origin_city, visit_time, content) VALUES (1, '张三', '男', '13433333333', '武汉', '2024-06-25 15:04:53', '探访孩子');
INSERT INTO dormitory.visitor (id, name, gender, phone_num, origin_city, visit_time, content) VALUES (2, '李四', '女', '15722222222', '江苏', '2024-06-25 15:04:58', '运送快递');
INSERT INTO dormitory.visitor (id, name, gender, phone_num, origin_city, visit_time, content) VALUES (3, '啊啊', '女', '13255555555', '天津', '2024-12-25 15:41:21', '运送食品');
