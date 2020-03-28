## 存包(Deposit Bag)
- Given a locker with available space, When deposit the bag, Then deposit succeed and obtained a ticket.

>
1. Given 2 available spaces, When deposit the bag, Then deposit succeed and obtained 1 ticket.

- Given a locker without available space, When deposit the bag, Then deposit failed and obtained a hint of "柜子已满".

>
1. Given 0 available spaces, When deposit the bag, Then deposit failed and obtained "柜子已满".

## 取包(Claim Bag)
- Given a ticket is valid, When claim the bag, Then obtained the bag succeed.

>
1. Given 2 available space, 1 valid ticket link to a bag depositted, When claim the bag, Then the depositted bag can be obtained.

- Given a ticket is invalid, When claim the bag, Then obtained the bag failed.

>
1. Given 17 available spaces, 1 invalid tickets, When claim the bag, Then obtained the bag failed and "票无效".
