package com.wangmiao.demo.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DateTime 2018-03-29 11:47
 *
 * @author db
 **/
@Entity
@Table(name = "t_pile",schema = "charging_pile")
public class Pile {
    private long id;
    private Long electricQuantity;
    private Date startTime;
    private Date endTime;
    private BigDecimal cost;
    private BigDecimal salesAmount;
    private BigDecimal profit;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "electric_quantity")
    public Long getElectricQuantity() {
        return electricQuantity;
    }

    public void setElectricQuantity(Long electricQuantity) {
        this.electricQuantity = electricQuantity;
    }

    @Basic
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "cost")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "sales_amount")
    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    @Basic
    @Column(name = "profit")
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
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", cost=" + cost +
                ", salesAmount=" + salesAmount +
                ", profit=" + profit +
                '}';
    }
}
