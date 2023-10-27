Feature: Login

  Scenario: Successfull Login With Valid Credentials
    Given User Will Launch Browser
    When User Will Open Url "https://admin-demo.nopcommerce.com/login"
    And User Will Enter Email as "admin@yourstore.com" and Password as "admin"
    And User Will Click on Login button
    Then HomePage Title Should be "Dashboard / nopCommerce administration"
    When User Will Click on Logout link
    Then LoginPage Title Should be "Your store. Login"
    And User Will Close the Browser
