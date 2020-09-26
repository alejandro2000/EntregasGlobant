# Author : Alejandro Taborda Cadavid
# Date : 25th of september - 2020
# Company : Globant

Feature: delete an user account
  As a user of the espn platform
  I want to delete my active account
  So that i can't continue receiving emails

  @id=00004
  Scenario Outline: succesful account elimination
    Given user is logged in the landing page site
      | userName   | password   |
      | <userName> | <password> |
    When user try to delete his account on the personal information section
    Then user should see a 'Welcome!' message in the user modal

    Examples:
      | userName                   | password         |
      | cody.obrien@example.com    | secretpassword12 |
      | bobbie.butler@example.com  | sbbie.butte      |
      | serenity.garza@example.com | robinson         |


  @id=00005
  Scenario Outline: failed account elimination
    Given user is logged in the landing page site
      | userName   | password   |
      | <userName> | <password> |
    When user try to delete his account on the personal information section
    Then user should see a 'Welcome <firstName>!' message in the user modal

    Examples:
      | userName                   | password         |
      | cody.obrien@example.com    | secretpassword12 |
      | bobbie.butler@example.com  | sbbie.butte      |
      | serenity.garza@example.com | robinson         |