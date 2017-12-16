# final-project-upegu100
final-project-upegu100 created by GitHub Classroom
My project, called "Spending Friend" (I know, suuuuper cheesy), is an app to help you keep track of your transactions and create a monthly budget.

Some things my app does:

AccountsListActivity
~Shows a recycler view of all accounts, with their name and current balance
~Cash will always be an account for a user
~You can add an account by clicking the + button in the top right corner
~Clicking on an account will start an AccountActivity

AccountActivity
~Displays the information of the account, including name, number, starting balance, current balance, and what type it is
~There is a trash menu item in the top right to delete the account. If the account has a transaction associated to it, an error will be thrown.
~The only thing that is editable for the Cash account is the starting balance. It cannot be deleted.
~Errors will be thrown for invalid account names and non-unique account names

TransactionListActivity
~Shows a recycler view of all transactions, with their name and amount colored for whether it is a withdrawal or deposit
~Transactions can be swiped away to be deleted
~Clicking on a Transaction will start a TransactionActivity
~Clicking the + button will add a new Transaction

TransactionActivity
~Displays the information of the Transaction, including name, amount, whether it is a withdrawal or deposit, date it occurred, and account it came from
~Errors will be thrown for invalid transaction names, invalid account names, and dates that are not in 2017, and dates that are later than today's date

BudgetListActivity
~Shows a list of each account with it's name
~Clicking on a cell will open a BudgetActivity

BudgetActivity
~Shows budget for account, which includes, monthly spending cap, monthly income goal, and overall savings goal


SummaryActivity
~Shows a recycler view of all the accounts and how they compare with the budget that was set
~Clicking a month button displays the summary for that month of each account and then the total (the default month to show is January)


Things I would change if I were actually going to make this a real app:
~Allow for persisted data (obviously)
~Rather than let people type account names, I would just have a dropdown for them.
~Throw more interactive dialogs to make sure the users want to make changes on certain things (i.e. starting balance, negative account values, etc.)
~Allow users to put it dates from more than just 2017.
...and many more things lol. 

Anyway, thanks for a great semester!

