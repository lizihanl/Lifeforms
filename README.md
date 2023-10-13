# Lifeforms
All Lifeforms can mate, and of course eat.

Additional Lifeforms: Carnivore, Omnivore.

Plants:		colour GREEN
		eat nothing
		can give birth if there are at least 2 plant neighbors, and at least 3 free neighboring cells, and 0 amount of food in neighboring cells
		
Herbivores: 	colour YELLOW
		eat only plants
		can give birth if there are at least 1 other Herbivore neighbors, at least two free neighboring cells, and at least 2 neighboring cells with food (plants)
		must eat within 5 moves

Carnivore is represented with the colour RED
		eat Herbivores and Omnivores
		can give birth if there are at least 1 other Carnivore neighbors, at least 3 free neighboring cells, and 2 neighboring cells with food (Herbivores or Omnivores)
		must eat within 5 moves

Omnivore is represented with the colour BLUE
		eat Herbivores, Carnivores, Plants
		can give birth if there are at least 1 other Omnivore neighbors, at least 3 free neighboring cells, and 1 neighboring cells with food
		must eat within 5 moves

