package com.sky.service;

import com.sky.entity.User;
import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import javax.servlet.http.HttpServletResponse;
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

    /**
     * 统计指定时间订单数据
     * @param begin
     * @param end
     * @return
     */
    OrderReportVO getOrderReport(LocalDate begin, LocalDate end);

    /**
     * 统计指定时间销量排名前10
     * @param begin
     * @param end
     * @return
     */
    SalesTop10ReportVO SalesTop10Report(LocalDate begin, LocalDate end);

    /**
     * 导出数据报表
     */
    void exportBussinessData(HttpServletResponse response);
}
