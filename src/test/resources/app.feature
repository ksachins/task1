#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: post data
 Scenario Outline: call post method
    Given I want to provide data with <id>,"<title>"
    When post method 
    Then validate "<msg>"

    Examples: 
    | id  | title | msg     |
    | 1   |  story| success |
     
     
#@tag
#Feature: Book

 # Scenario: Book List is Showing here    
 	#	Given I set Post data      
 	#	 When Send post http request
   #   Then I validate the outcomes

     