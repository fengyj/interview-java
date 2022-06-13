# Requirement of Exam-02

## Background

When calculates stock's return, needs to find the price on previous business day.
Most of the stock exchanges in the world are closed on the Saturday and Sunday, in another word, the business days are from Monday to Friday.
But there are a few of exchanges in different situations, like theirs weekend are Friday and Saturday or Thursday adn Friday.

Assuming we cover 200 exchanges, around 10 exchanges have different weekend.
And have 200,000 stocks. Each stock have around 20 years' historical price data in average.
We need to calculate daily return, monthly return for full history.

## Requirement

Please finish the ```BusinessDayUtil``` class so that we can use it in the return calculation.
Please notice, the weekend could be changed. For example, the exchange A, the weekend was Friday and Saturday,
and from 2021-01-01, the weekend was changed to Saturday and Sunday.
