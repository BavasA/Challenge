Feature: Smoke feature

Scenario Outline: validate pet post service
Given user adds pet "<petName>" with "<id>" using post service
Then validate "<petName>" in response
Examples:
|petName|id|
|catiee|100001|


Scenario Outline: Update petname
Given user edits pet "<petName>" with "<id>" using post service
Then validate "<petName>" in response
Examples:
|petName|id|
|Parrooooot|100001|



Scenario Outline: getPetByIdAndValidateName
Given user gets pet by "<id>"
Then Validate status code "200" in response
Then validate "<petName>" in response
Examples:
|petName|id|
#|Parrooooot|100001|
