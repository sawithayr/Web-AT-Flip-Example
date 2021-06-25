#Buatlah suatu function (automation code) test, untuk mendeteksi semua hal jika terjadi ketidak
#sesuaian data di atas!

Feature: Verify data list is not null (nb : this feature just example - do not run)

  Scenario: Verify data list on table data and data list on UI
#    Given user goes to "flipid"
#    When user logs in as admin with username "usernameTest" and password "passwordTest"
#    And user navigates to page user data
    Then user verify data table and data list user
      | ID  | User name | Source bank | Destination bank | Amount       |
      | 011 | Smith     | BCA         | BRI              | Rp 1,000,000 |
      | 100 | John      | BRI         | BCA              | Rp 1,000,000 |
      | 101 | Fulan     | Mandiri     | BCA              | Rp 4,333,011 |
      | 110 | Sri       | BNI         | BSI              | Rp 3,000,000 |
      | 111 | Bambang   | BCA         | BSI              | Rp 1,500,000 |