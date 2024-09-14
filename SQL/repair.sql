create table repair
(
    id               int auto_increment comment '订单编号'
        primary key,
    repairer         varchar(255)                                      not null comment '报修人',
    dormbuild_id     int                                               not null comment '报修宿舍楼',
    dormroom_id      int                                               not null comment '报修宿舍房间号',
    title            varchar(255)                                      not null comment '表单标题',
    content          longtext                                          not null comment '表单内容',
    state            enum ('完成', '未完成') default '未完成'          not null comment '订单状态（是否维修完成）',
    order_buildtime  datetime                default CURRENT_TIMESTAMP not null comment '订单创建时间',
    order_finishtime datetime                                          null comment '订单完成时间'
)
    charset = utf8mb3
    row_format = DYNAMIC;

INSERT INTO dormitory.repair (id, repairer, dormbuild_id, dormroom_id, title, content, state, order_buildtime, order_finishtime) VALUES (1491161089, '张三', 1, 1201, '灯光损坏', '里面的那个灯坏了', '完成', '2024-06-24 14:50:07', '2024-06-24 14:51:13');
