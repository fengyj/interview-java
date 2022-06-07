# Requirement of Exam-01

## Background

Companies will publish their operation situation in financial report periodically. For example, the frequency could be quarterly.
In the report, it contains all debts' information of the company, include name (assume it's unique), issue date, issue amount,
maturity date, coupon rate, and outstanding amount.

For example:

Reported on 2020-12-31 of company XYZ (2020-12-31 is the Reported Date of this document)

| Name        | Issue Date | Issue Amount | Maturity Date | Coupon Rate | Outstanding Amount |
|-------------|------------|--------------|---------------|-------------|--------------------|
| 200803-3%   | 2008-03-14 | 3,000,000    | 2028-03-13    | 3%          | 2,000,000          |
| 201006-2.7% | 2010-06-10 | 5,000,000    | 2025-06-09    | 2.7%        | 5,000,000          |
| 201512-1.5% | 2025-12-01 | 4,000,000    | 2025-11-30    | 1.5%        | 3,000,000          |

(Name is unique, the other columns are meaningless in this exam)

Companies also could publish a statement when a new debt is issued or the coupon rate is changed occasionally.
*That means there could be 0 to many statements between two financial reports.*
*Only the new debt(s) or changed debt(s) will be listed in the statement.*

For example:

Reported on 2021-06-14 of company XYZ (2021-06-14 is the Reported Date of this document)

| Name        | Issue Date | Issue Amount | Maturity Date | Coupon Rate | Outstanding Amount |
|-------------|------------|--------------|---------------|-------------|--------------------|
| 200803-3%   | 2008-03-14 | 3,000,000    | 2028-03-13    | 2%          | 1,000,000          |
| 202106-2.5% | 2021-06-10 | 1,000,000    | 2024-06-09    | 2.5%        | 1,000,000          |

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
