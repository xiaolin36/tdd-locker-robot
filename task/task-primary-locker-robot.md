## 存包(Deposit Bag)
- Given lockers with available spaces, When deposit the bag, Then deposit succeed and obtained a ticket.

>
1. Given locker robot 2 lockers both with available spaces, When deposit the bag, Then deposit succeed and obtained 1 ticket belongs to locker No.1.
2. Given locker robot 2 lockers with available spaces only in locker No.1, When deposit the bag, Then deposit succeed and obtained 1 ticket belongs to locker No.1
3. Given locker robot 2 lockers with available spaces only in locker No.2, When deposit the bag, Then deposit succeed and obtained 1 ticket belongs to locker No.2.

- Given lockers without available spaces, When deposit the bag, Then deposit failed and obtained a hint of "柜子已满".

>
1. Given 2 lockers with 0 available spaces, When deposit the bag, Then deposit failed and obtained "柜子已满".

## 取包(Claim Bag)
- Given a ticket is valid, When claim the bag, Then obtained the bag succeed.

>
1. Given 2 lockers both with available space, 1 valid ticket link to a bag deposited, When claim the bag, Then the deposited bag can be obtained.

- Given a ticket is invalid, When claim the bag, Then obtained the bag failed.

>
1. Given 2 lockers both with available spaces, 1 invalid tickets, When claim the bag, Then obtained the bag failed and "票无效".