package com.atguigu.task.service;

import org.springframework.stereotype.Service;

/**
 * @author wangsen
 * @createtime 2018-11-08 15:44
 */
@Service
public class ScheduledService {
    /**
     * 定时执行任务
     *      cron： minute, hour, day of month, month , day of week.
     *              * * * * * *
     *      【0 0/5 14 18 * * ?】 每天 14 点整，和 18 点整，每隔 5 分钟执行一次
     *      【0 15 10 ? * 1-6】 每个月的周一到周六 10:15 分执行一次
     *      【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次
     *      【0 0 2 LW * ?】每个月的最后一个工作日凌晨2点执行一次
     *      【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次
     * 特殊字符：
     *  【',' -> 枚举】 【'-' -> 区间】 【'*' -> 任意】 【'/' -> 步长】 【'?' -> 日/星期冲突匹配】 【'L' -> 最后】
     *  【W -> 工作日】【'C' -> 和 Calendar 联系后计算过的值】 【'#' -> 星期 4#2 第二个星期四】
     *
     */
//    @Scheduled(cron="0 * * * * MON-SAT") // 周一 - 周五 每0秒时刻执行
//    @Scheduled(cron = "1,2,3,4 * * * * MON-SAT") // 周一 - 周五 每 1,2,3,4 秒执行
//    @Scheduled(cron = "0-4 * * * * MON-SAT")// 周一 - 周五 每 0-4 秒执行
//    @Scheduled(cron = "0/4 * * * * MON-SAT") // 周一 - 周五 每隔4 秒执行
    public void scheduledPrint() {
        System.out.println("hello...");
    }

}
