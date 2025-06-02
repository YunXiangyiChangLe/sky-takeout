package com.sky.service;

import com.sky.vo.TurnoverReportVO;

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
}
