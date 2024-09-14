create table adjust_room
(
    id             int auto_increment
        primary key,
    username       varchar(255)                                     not null comment '账号',
    name           varchar(255)                                     not null comment '姓名',
    currentroom_id int                                              not null comment '当前房间',
    currentbed_id  int                                              not null comment '当前床位号',
    towardsroom_id int                                              not null comment '目标房间',
    towardsbed_id  int                                              not null comment '目标床位号',
    state          enum ('未处理', '通过', '驳回') default '未处理' not null comment '申请状态',
    apply_time     varchar(255)                                     not null comment '申请时间',
    finish_time    varchar(255)                                     null comment '处理时间'
)
    charset = utf8mb3
    row_format = DYNAMIC;

