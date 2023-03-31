@exerciseForm

Feature: Exercise Form

  Scenario: Fill every option on the exercise form

Given  user is on the website demoqa
When   user fills the form
And    clicks on submit
Then   user gets a list of his submitted data