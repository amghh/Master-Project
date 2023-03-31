@pdfFunction
Feature: PDF Functionality

  Scenario: Check the PDF functionality


    Given The user has made past purchases on the website and has an account with the website.
    When  The user logs into their account "https://demowebshop.tricentis.com/"
    And   navigates to orders
    When  The user click on the Details so that he comes to the overview
    And   when the PDF Invoice Button is available
    And   the user click und the Button
    Then  The PDF file should download successfully and display correctly on the user's device.
