Feature: DNS UI testing feature

  Scenario Outline: Positive find phone by specified parameters
    Given I open DNS website
    When I choose mobil phone category
    And I filter catalog for '<Brand>' and '<memory type>' of '<capacity>' memory
    And I sort result of my choose to expensive first
    And I click to first card in phone's list
    Then in characteristics in phone card I see what model Of phone is '<Brand>' and '<memory type>' is '<capacity>'




    Examples:
      | Brand   | memory type              | capacity |
      | Samsung | Объем встроенной памяти  | 256 ГБ   |
      | Apple   | Объем оперативной памяти | 4 Гб     |

