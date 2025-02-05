Feature: Login Functionality

  @smoke @regression
  Scenario: Successful login with valid credentials
    * user is on login page
    * "loginPage.usernameInput" alanina "test@test.com" yazilir
    * "loginPage.passwordInput" alanina "Test123!" yazilir
    * sistem "1" saniye bekler
    * "loginPage.loginButton" elementine tiklanir
    * sistem "1" saniye bekler
    * "loginPage.loginButton" elementine tiklanir
    * sistem "1" saniye bekler
    * user should be logged in successfully