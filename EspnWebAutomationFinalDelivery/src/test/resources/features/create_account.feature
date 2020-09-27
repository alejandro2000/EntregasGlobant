# Author : Alejandro Taborda Cadavid
# Date : 25th of september - 2020
# Company : Globant

Feature: Create an account
  As a future user of the espn platform
  i want to create an account
  so that i can see premium content and receive newsletter information

  Background: User gets into the website
    Given user is in the landing page site


  @id=00001
  Scenario Outline: Sucesful user creation
    When user create the account with the parameters
      | firstName   | lastName   | emailAddress   | Password   | showPasswordCheck   | newsletterCheck   |
      | <firstName> | <lastName> | <emailAddress> | <Password> | <showPasswordCheck> | <newsletterCheck> |
    Then user should see a 'Welcome <firstName>!' message

    Examples:
      | firstName | lastName | emailAddress               | Password         | showPasswordCheck | newsletterCheck |
      | Cody      | Obrien   | cody.obrien@example.com    | secretpassword12 | true             | true            |
      | Bobbie    | Butler   | bobbie.butler@example.com  | bbie.butte       | true             | false           |
      | Serenity  | Garza    | serenity.garza@example.com | robinson         | false            | true            |


  @id=00002
  Scenario Outline: failed user creation
    When user create the account with the parameters
      | firstName   | lastName   | emailAddress   | Password   | showPasswordCheck   | newsletterCheck   |
      | <firstName> | <lastName> | <emailAddress> | <Password> | <showPasswordCheck> | <newsletterCheck> |
    Then user should see a 'Please enter your' message

    Examples:
      | firstName | lastName | emailAddress | Password | showPasswordCheck | newsletterCheck |
      |           |          |              |          |                   |                 |


  @id=00003
  Scenario Outline: failed user creation with an already taken email address
    When user create the account with the parameters
      | firstName   | lastName   | emailAddress   | Password   | showPasswordCheck   | newsletterCheck   |
      | <firstName> | <lastName> | <emailAddress> | <Password> | <showPasswordCheck> | <newsletterCheck> |
    Then user should see an already taken mail adress message

    Examples:
      | firstName | lastName | emailAddress    | Password | showPasswordCheck | newsletterCheck |
      | Angel     | Murray   | hello@gmail.com | wrestler | false             | false           |

