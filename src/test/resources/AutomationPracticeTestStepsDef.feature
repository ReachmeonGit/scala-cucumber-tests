
Feature: Test


        Scenario: 1. Create a new account

            Given a new user to website
             When user click on Signin
             Then they see option to create a new account
              And  enters the details to register
             Then user is registered


        Scenario: 2. Login

            Given a new user to website
             When user click on Signin
             Then they see option to Login
              And  enters the details to Login
             Then user is logged in

        
        Scenario: 3. Find the most expensive dress and add it to the cart

            Given a new user to website
             When user click on Signin
             Then they see option to Login
              And  enters the details to Login
             Then user is logged in
             Then the user click on dress tab
              And the user select the expensive dress
             Then the user should see the product added to cart basket successfully
              And User should see correct product details in the shopping cart summary page
             Then user is logged out

        @report

        Scenario: 4. Retain Cart

            Given a new user to website
             When user click on Signin
             Then they see option to Login
              And  enters the details to Login
             Then user is logged in
             Then the user click on dress tab
              And the user select the expensive dress
             Then the user should see the product added to cart basket successfully
             Then The customer log out and back in again
              And User should see correct product details in the shopping cart summary page
             Then user is logged out