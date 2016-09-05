package org.ahant.core.model;

import com.github.ahant.validator.annotation.FieldInfo;

import java.util.Date;

/**
 * Created by ahant on 7/16/2016.
 */
public class Fee {
    @FieldInfo(optional = false)
    private Double amount;
    @FieldInfo(optional = false)
    private Date paymentDate;
    private String feeDetail;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return new Date(paymentDate.getTime());
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
