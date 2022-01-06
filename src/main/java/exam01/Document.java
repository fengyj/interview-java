package exam01;

import java.time.LocalDate;
import java.util.List;

/**
 * The data of Financial Report or Statement
 */
public class Document {

    private LocalDate reportedDate;
    private DocumentType documentType;
    private List<Debt> debts;

    public LocalDate getReportedDate() {

        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {

        this.reportedDate = reportedDate;
    }

    public DocumentType getDocumentType() {

        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {

        this.documentType = documentType;
    }

    public List<Debt> getDebts() {

        return debts;
    }

    public void setDebts(List<Debt> debts) {

        this.debts = debts;
    }

}
