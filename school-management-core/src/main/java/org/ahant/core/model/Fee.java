package org.ahant.core.model;

import java.util.Date;

/**
 * Created by ahant on 7/16/2016.
 */
public class Fee {
    private double amount;
    private Date paymentDate;
    private String feeDetail;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(final Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getFeeDetail() {
        return feeDetail;
    }

    public void setFeeDetail(String feeDetail) {
        this.feeDetail = feeDetail;
    }
}
