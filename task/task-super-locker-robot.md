## 存包(Deposit Bag)
- Given lockers with different ratio of available spaces, When deposit the bag, Then deposit succeed and obtained a ticket.

1. Given super locker robot 2 lockers, locker No.1 with 20 total spaces and 18 available spaces, 
locker No.2 with 10 total spaces and 8 available spaces, When super locker robot deposit the bag, 
Then obtained 1 ticket and the bag deposited to locker No.1.

2. Given super locker robot 2 lockers, locker No.1 with 20 total spaces and 14 available spaces, 
locker No.2 with 10 total spaces and 8 available spaces, When super locker robot deposit the bag, 
Then obtained 1 ticket and the bag deposited to locker No.2.

3. Given super locker robot 2 lockers, locker No.1 with 20 total spaces and 18 available spaces,
locker No.2 with 10 total spaces and 9 available spaces, When super locker robot deposit the bag, 
Then obtained 1 ticket and the bag deposited to locker No.1.

- Given lockers both without available spaces, When deposit the bag, Then deposit failed and obtained a hint of "柜子已满".

1. Given super locker robot 2 lockers, locker No.1 with 20 total spaces and 0 available spaces,
locker No.2 with 10 total spaces and 0 available spaces, When super locker robot deposit the bag,
Then deposit failed and obtained "柜子已满".

## 取包(Claim Bag)
- Given a ticket is valid, When claim the bag, Then obtained the bag succeed.

1. Given super locker robot 2 lockers both with available space, 
  1 valid ticket link to a bag deposited, When super locker robot claim the bag, 
  Then the deposited bag can be obtained.

- Given a ticket is invalid, When claim the bag, Then obtained the bag failed and obtained a hint of "票无效".

1. Given super locker robot 2 lockers both with available spaces, 
  1 used ticket, When super locker robot claim the bag, 
  Then obtained the bag failed and "票无效".
2. Given super locker robot 2 lockers both with available spaces, 
  1 ticket not created in our system, When super locker robot claim the bag, 
  Then obtained the bag failed and "票无效".
