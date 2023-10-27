Feature: Customers

  Scenario: Add New Customer
    Given User Will Launch Browser
    When User Will Open Url "https://admin-demo.nopcommerce.com/login"
    And User Will Enter Email as "admin@yourstore.com" and Password as "admin"
    And User Will Click on Login button
    Then HomePage Title Should be "Dashboard / nopCommerce administration"
    When User expands the Customers menu tab and click on Customers from submenus
    Then User lands on Customers Page "Customers / nopCommerce administration"
    When User clicks on the Add New button
    Then User lands on the Create Customer Page "Add a new customer / nopCommerce administration"
    When User enters the customers info in the form
    And user Clicks on Save button
    Then User can view the Confirmation Message "The new customer has been added successfully."
    When User Will Click on Logout link
    Then LoginPage Title Should be "Your store. Login"
    And user closes the browser
