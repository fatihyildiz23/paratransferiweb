Feature: Login Functionality


  Background: Background

    * user is on login page
    * "loginPage.usernameInput" alanina "fatih.yildiz@testinium.com" yazilir
    * "loginPage.passwordInput" alanina "Fatih1453+" yazilir
    * "loginPage.loginButton" elementine tiklanir
    * "loginPage.openmoneytransfer" elementine tiklanir

  @smoke @regression
  Scenario: Send Money

    * "loginPage.transfermoney" elementine tiklanir
    * sistem "1" saniye bekler
    * "loginPage.amount" alanina "1" yazilir
    * sistem "1" saniye bekler
    * "loginPage.sendmoney" elementine tiklanir
    * "loginPage.transactions" listesindeki son işlemin tutarı "1.00" olmalıdır
    * sistem "1" saniye bekler



  Scenario: Add Money

    * "addMoneyPage.addmoney" elementine tiklanir
    * "addMoneyPage.cardnumber" alanina "1234123412341234" yazilir
    * "addMoneyPage.cardholder" alanina "Fatih" yazilir
    * "addMoneyPage.expirydate" alanina "1026" yazilir
    * "addMoneyPage.cvv" alanina "110" yazilir
    * "addMoneyPage.amount" alanina "110" yazilir
    * "addMoneyPage.addamount" elementine tiklanir


    Scenario: Edit Account

      * "editaccount.editaccount" elementine tiklanir
      * "editaccount.accountname" alanina "Fatih" yazilir
      * "editaccount.update" elementine tiklanir
      * "myaccount.accountname" elementinin değeri "Fatih22" olmalıdır








