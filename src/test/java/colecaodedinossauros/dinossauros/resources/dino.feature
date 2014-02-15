Feature: Dinosaurs app access
In order to identify dinosaurs
As a bones keeper
I want to access information about dinosaurs

Scenario: List dinos names - example 1
  Given There are dinosaurs in my repository
  When I list dinosaurs
  Then I see list of Dinosaurs
  
 Scenario: List dinos names - example 2
  Given There are "Tiranossauro-rex,Abelisaurus,Hadrossauro" dinosaurs in my repository
  When I list dinosaurs
  Then I see list "Tiranossauro-rex,Abelisaurus,Hadrossauro" of Dinosaurs

 Scenario: List dinos names - example 3
  Given The following dinosaurs exist in my repository:
    |name            |
    |Tiranossauro-rex|
    |Abelisaurus     |
    |Hadrossauro     |
  When I list dinosaurs
  Then I see the following list of Dinosaurs
    |name            |
    |Tiranossauro-rex|
    |Abelisaurus     |
    |Hadrossauro     |
 