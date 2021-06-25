Feature: Flip Homepage

  #Assertion teks dan kemunculan dengan selector berbeda
  @tag1
  Scenario: Verify text navbar button at Flip Homepage
    Given user goes to "https://flip.id/landing"
    When user sees homepage banner
    Then user verifies the text1 buttons is "Produk"
    And user verifies the text2 buttons is "Karir"
    And user verifies the text3 buttons is "Masuk"

  #Click button masing-masing
  #Menggunakan scenario outline
  @tag2
  Scenario Outline: Verify navigation of <button> button at Flip Homepage
    Given user goes to "https://flip.id/landing"
    When user sees homepage banner
    And user clicks button "<button>"
    Then user verifies the navigation of button "<button>"

    Examples:
      | button |
      | Produk |
      | Karir  |
      | Masuk  |
