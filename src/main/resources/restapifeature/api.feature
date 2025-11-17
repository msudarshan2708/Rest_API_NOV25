Feature: Update User API with Authorization
  As an API client
  I want to get an OAuth token
  So that I can update user details using authorized requests
@smoke
  Scenario: Get OAuth token and update user details
    Given I have valid credentials
    When I request an access token
    Then I should receive a valid access token
    When I update user "123" with new details using the token
    Then the response status code should be 200
    And the response should contain the updated user information
@SIT
  Scenario: Post Request validation 
  When  I give valid URI 
  Then  I add correct end point
  Then  I add correct PathParameter
  Then  I add the correct body in request
  Then I extract the Response 
  Then  I validate the Response code
  And Response code should be correct 