# Author : Alejandro Taborda Cadavid
# Date : 25th of september - 2020
# Company : Globant

Feature: login into the website
  As a user of the espn platform
  I want to login into the platform
  So that i would be able to navigate and consume the services

  @id=00006
  Scenario Outline: succesful user login
    Given user is in the landing page site
    When user authenticates in the platform
      | userName   | password   |
      | <userName> | <password> |
    Then user should see a 'Welcome <userName>!' message in the user modal

    Examples:
      | userName                   | password         |
      | cody.obrien@example.com    | secretpassword12 |
      | bobbie.butler@example.com  | sbbie.butte      |
      | serenity.garza@example.com | robinson         |

  @id=00007
  Scenario Outline: failed user login
    Given user is in the landing page site
    When user authenticates in the platform
      | userName   | password   |
      | <userName> | <password> |
    Then user should see a 'The credentials you entered are incorrect. Reminder: Passwords are case sensitive.'
      message in the user modal

    Examples:
      | userName                   | password         |
      | cody.obrien@example.com    | secretpassword11 |
      | bobbie.butler@example.com  | sbbie.butte1     |
      | serenity.garza@example.com | robinson300      |