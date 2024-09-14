package com.example.springboot.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zzp
 * @create 2024/9/10-20:07
 */
@Component
public class ScheduledTask {

    //每晚9点定时提醒未晚点名宿舍进行晚点名
    @Scheduled(cron = "0 25 20 * * ?")
    public void notification(){
        System.out.println("正在推送中。。。");
    }

    //Todo 每天凌晨三点更新学生在宿状态为0（不在宿）
    @Scheduled(cron = "0 0 3 * * ?")
    public void resetInDormStatus(){

    }

}
