package exam01;

import java.time.LocalDate;

/**
 *
 */
public class Debt {

    private String name;
    private LocalDate issueDate;
    private long issueAmount;
    private LocalDate maturityDate;
    private String couponRate;
    private long outstandingAmount;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public LocalDate getIssueDate() {

        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {

        this.issueDate = issueDate;
    }

    public long getIssueAmount() {

        return issueAmount;
    }

    public void setIssueAmount(long issueAmount) {

        this.issueAmount = issueAmount;
    }

    public LocalDate getMaturityDate() {

        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {

        this.maturityDate = maturityDate;
    }

    public String getCouponRate() {

        return couponRate;
    }

    public void setCouponRate(String couponRate) {

        this.couponRate = couponRate;
    }

    public long getOutstandingAmount() {

        return outstandingAmount;
    }

    public void setOutstandingAmount(long outstandingAmount) {

        this.outstandingAmount = outstandingAmount;
    }
}
