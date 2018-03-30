package com.wangmiao.demo.pojo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateTime 2018-03-29 11:38
 *
 * @author db
 **/
public class Pile {
    private Long id;
    private Long electricQuantity;//电量
    private String startTime;//开始时间
    private String endTime;//结束时间
    private BigDecimal cost;//成本
    private BigDecimal salesAmount;//销售金额
    private BigDecimal profit;//纯利润
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public Pile(){

    }

    public Pile(Long id, Long electric_quantity, Date start_time, Date end_time, BigDecimal cost, BigDecimal sales_amount, BigDecimal profit) {
        this.id = id;
        this.electricQuantity = electric_quantity;
        this.startTime = format.format(start_time);
        this.endTime = format.format(end_time);
        this.cost = cost;
        this.salesAmount = sales_amount;
        this.profit = profit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getElectricQuantity() {
        return electricQuantity;
    }

    public void setElectricQuantity(Long electricQuantity) {
        this.electricQuantity = electricQuantity;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = format.format(startTime);
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = format.format(endTime);
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {



        return "Pile{" +
                "id=" + id +
                ", electricQuantity=" + electricQuantity +
                ", startTime=" +  startTime +
                ", endTime=" +  endTime +
                ", cost=" + cost +
                ", salesAmount=" + salesAmount +
                ", profit=" + profit +
                '}';
    }
}
