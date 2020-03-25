## 存包
- Given there has still an available locker, When pressing the 'open' button, Then a ticket can be returned.

>
1. Given 17 available lockers, 2 tickets, When pressing the 'open' button, Then 16 available lockers, 3 tickets.

- Given there has not an available locker, When pressing the 'open' button, Then a ticket cannot be returned.

>
1. Given 0 available lockers, 19 tickets, When pressing the 'open' button, Then 0 available lockers, 19 tickets.

## 取包
- Given a ticket has not been used, When scanning the ticket, Then the locker can be released.

>
1. Given 17 available lockers, 2 tickets, When scanning the ticket, Then 18 available lockers, 1 tickets.

- Given a ticket has been used already, When scanning the ticket, Then the locker cannot be released.

>
1. Given 17 available lockers, 2 tickets, When scanning the ticket,, Then 17 available lockers, 2 tickets.
