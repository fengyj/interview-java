package exam01;

import java.time.LocalDate;
import java.util.List;

/**
 *
 */
public class DebtInfoHistory {

    private LocalDate reportedDate;
    private List<Debt> debts;

    public LocalDate getReportedDate() {

        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {

        this.reportedDate = reportedDate;
    }

    public List<Debt> getDebts() {

        return debts;
    }

    public void setDebts(List<Debt> debts) {

        this.debts = debts;
    }
}
