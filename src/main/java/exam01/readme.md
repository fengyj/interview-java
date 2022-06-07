# Requirement of Exam-01

## Background

### Financial Report

Companies will publish their operation situation in financial report periodically. For example, the frequency could be quarterly.
In the report, it contains all debts' information of the company, include name (assume it's unique), issue date, issue amount,
maturity date, coupon rate, and outstanding amount.

*Company won't publish more than one financial report documents on the same date.*

For example:

Reported on 2020-12-31 of company XYZ (2020-12-31 is the Reported Date of this document)

| Name        | Issue Date | Issue Amount | Maturity Date | Coupon Rate | Outstanding Amount |
|-------------|------------|--------------|---------------|-------------|--------------------|
| 200803-3%   | 2008-03-14 | 3,000,000    | 2028-03-13    | 3%          | 2,000,000          |
| 201006-2.7% | 2010-06-10 | 5,000,000    | 2025-06-09    | 2.7%        | 5,000,000          |
| 201512-1.5% | 2025-12-01 | 4,000,000    | 2025-11-30    | 1.5%        | 3,000,000          |

(Name is unique, the other columns are meaningless in this exam)

We can define a ```Document``` object to represent this data.

```Java
public class Document {

    private LocalDate reportedDate; // using above sample data as example, the value will be 2020-12-31.
    private DocumentType documentType; // using above sample data as example, the value will be FinancialReport.
    private List<Debt> debts; // using above sample data as example, this list will contains 3 items.
}
```

> **Please note, in this kind of document (financial report), it includes all the debts of the company on that date.**
> For example, on 2020-12-31, there is a financial report document, it contains A, B, and C, 3 debts. It means the company only has that 3 debts from 2020-12-31.
> And then, on 2021-03-31, there is another financial report document, it contains A, C, D, and E debts. It means the company has 4 debts (B is removed, D and E are new added) from 2021-03-31.

### Statement

Companies also could publish a statement when a new debt is issued or the coupon rate is changed occasionally.
**That means there could be 0 to many statements between two financial reports.**
**Only the new debt(s) or changed debt(s) will be listed in the statement.**

*Company won't publish more than one statement documents on the same date.*

For example:

Reported on 2021-06-14 of company XYZ (2021-06-14 is the Reported Date of this document)

| Name        | Issue Date | Issue Amount | Maturity Date | Coupon Rate | Outstanding Amount |
|-------------|------------|--------------|---------------|-------------|--------------------|
| 200803-3%   | 2008-03-14 | 3,000,000    | 2028-03-13    | 2%          | 1,000,000          |
| 202106-2.5% | 2021-06-10 | 1,000,000    | 2024-06-09    | 2.5%        | 1,000,000          |

We also can use a ```Document``` object to represent this data.

```Java
public class Document {

    private LocalDate reportedDate; // using above sample data as example, the value will be 2021-06-14.
    private DocumentType documentType; // using above sample data as example, the value will be Statement.
    private List<Debt> debts; // using above sample data as example, this list will contains 2 items.
}
```

> **Please note, in this kind of document (statement), it only includes the debts of the company have been changed from the reported date.**
> Using above sample as example, the debt, 200803-3%, is changed with a new coupon rate (from 3% to 2%) from 2021-06-14. And a new debt, 202106-2.5%, is added.
> But on 2021-06-14, the company also have two other debts which are listed in the document published on 2020-12-31, 201006-2.7%, and 201512-1.5%.

## Requirement

User wants to see the full debt list on each reported date by given company. Here is the logic to populate the list:

1. On the reported date, if it's a financial report, all the debts come from it.
2. On the reported date, if it's a statement, list the debts from the statement and then pick the other debts from the list of previous reported date.
3. On the reported date, if both financial report and statement are available, ignore the data in the statement.

For example:

The list of company XYZ

| Reported Date | Name        | Issue Date | Issue Amount | Maturity Date | Coupon Rate | Outstanding Amount |
|---------------|-------------|------------|--------------|---------------|-------------|--------------------|
| 2020-12-31    | 200803-3%   | 2008-03-14 | 3,000,000    | 2028-03-13    | 3%          | 2,000,000          |
| 2020-12-31    | 201006-2.7% | 2010-06-10 | 5,000,000    | 2025-06-09    | 2.7%        | 5,000,000          |
| 2020-12-31    | 201512-1.5% | 2025-12-01 | 4,000,000    | 2025-11-30    | 1.5%        | 3,000,000          |
| 2021-06-14    | 200803-3%   | 2008-03-14 | 3,000,000    | 2028-03-13    | 2%          | 1,000,000          |
| 2021-06-14    | 202106-2.5% | 2021-06-10 | 1,000,000    | 2024-06-09    | 2.5%        | 1,000,000          |
| 2021-06-14    | 201006-2.7% | 2010-06-10 | 5,000,000    | 2025-06-09    | 2.7%        | 5,000,000          |
| 2021-06-14    | 201512-1.5% | 2025-12-01 | 4,000,000    | 2025-11-30    | 1.5%        | 3,000,000          |

> The first 3 records are from the financial report on 202-12-31, and the next two are from the statement on 2021-06-14,
> then the last 2 are copied from the list of report date on 2020-12-31.

Please finish the ```Converter``` class.

## Tips

The input could be a document list as below:

```Json
[
  {"reportedDate": "2020-12-31", "documentType": "FinancialReport", "debts": [...] },
  {"reportedDate": "2020-03-31", "documentType": "FinancialReport", "debts": [...] },
  {"reportedDate": "2020-04-16", "documentType": "Statement", "debts": [...] },
  {"reportedDate": "2020-05-12", "documentType": "Statement", "debts": [...] }
  {"reportedDate": "2020-06-30", "documentType": "FinancialReport", "debts": [...] },
]
```
