package com.sky.service;

import com.sky.entity.User;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ReportService {
    /**
     * 统计指定时间内营业额
     * @param begin
     * @param end
     * @return
     */
    TurnoverReportVO getTurnOverReport(LocalDate begin, LocalDate end);

    /**
     * 用户数据统计
     * @param begin
     * @param end
     * @return
     */
    UserReportVO getUserReport(LocalDate begin, LocalDate end);
}
