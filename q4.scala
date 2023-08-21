class Account(id: String, initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double): Unit = { balance += amount }
  def withdraw(amount: Double): Unit = { balance -= amount }
  def transfer(that: Account, amount: Double): Unit = {
    this.withdraw(amount)
    that.deposit(amount)
  }
  
  def getBalance: Double = balance
  override def toString: String = s"[$id] $balance"
}

class Bank {
  private var accounts: List[Account] = Nil
  def addAccount(account: Account): Unit = { accounts ::= account }
  def accountsWithNegativeBalances: List[Account] =
    accounts.filter(_.getBalance < 0)
  def getAccounts: List[Account] = accounts
  def sumOfAllBalances: Double = accounts.map(_.getBalance).sum
  def applyInterest(): Unit =
    for (account <- accounts) {
      if (account.getBalance > 0) account.deposit(account.getBalance * 0.05)
      else account.withdraw(account.getBalance.abs * 0.1)
    }

}

@main def init() ={
  val bank = new Bank()
  bank.addAccount(new Account("1", -100))
  bank.addAccount(new Account("2", -200))
  bank.addAccount(new Account("3", 900))
  bank.addAccount(new Account("4", -400))
  bank.addAccount(new Account("5", 1500))
  bank.addAccount(new Account("6", -600))
  bank.addAccount(new Account("7", -500))
  bank.addAccount(new Account("8", 1800))
  bank.addAccount(new Account("9", -900))
  bank.addAccount(new Account("10", 1000))

  val negativeAccounts = bank.accountsWithNegativeBalances
  println("Accounts with negative balances:")
  negativeAccounts.foreach(println)

  val sumOfBalances = bank.sumOfAllBalances
  println("\nSum of all balances: " + sumOfBalances)

  bank.applyInterest()
  println("\nAfter applying interest:")
  bank.getAccounts.foreach(println)

}