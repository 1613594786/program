create table notice
(
    id           int auto_increment comment '主键'
        primary key,
    title        varchar(255) not null comment '主题',
    content      longtext     not null comment '内容',
    author       varchar(255) not null comment '作者',
    release_time datetime     not null comment '发布时间'
)
    charset = utf8mb3
    row_format = DYNAMIC;

INSERT INTO dormitory.notice (id, title, content, author, release_time) VALUES (1, '暑期放假提醒', '<p>近期即将放假，宿舍楼于7月10日关闭，请大家及时购票，避免意外情况</p>', '大强', '2024-06-25 14:59:59');
INSERT INTO dormitory.notice (id, title, content, author, release_time) VALUES (2, '关于宿舍卫生的新规定', '<p>学生公寓是学生们主要的生活区域，兼具休息、学习、交际等多种功能，是培养、提升学生全面素质不可或缺的重要阵地。为了培养学生良好的行为素养和生活习惯，我们实行宿舍长内务准军事化管理，切实把学生公寓建成学生自我教育，自我管理和自我服务的家园。</p>', '大强', '2024-06-25 15:00:04');
