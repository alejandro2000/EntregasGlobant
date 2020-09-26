# Author : Alejandro Taborda Cadavid
# Date : 25th of september - 2020
# Company : Globant

Feature: logout the website
  As a user of the espn platform
  I want to logout the platform
  So that i would be able to navigate in the website as a no logged user

  @id=00008
  Scenario Outline: succesful user logout
    Given logged user is in the landing page site
      | userName   | password   |
      | <userName> | <password> |
    When user logs out of the current session
    Then user should see a 'Welcome!' message in the user modal

    Examples:
      | userName                   | password         |
      | cody.obrien@example.com    | secretpassword12 |
      | bobbie.butler@example.com  | sbbie.butte      |
      | serenity.garza@example.com | robinson         |
