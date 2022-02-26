# JavaProjects

I learnt Java in Open University of Israel. Those projects that you can see here, were a part of my assignments in the course.


1. Conway's lifecycle:
   I did a simulation of Conway's research of organisms lifecicle.
   As the program starts we have an empty matrix which each cell its an organism. when we start pressing next generation, the program will set randomly the matrix with organisms. if the cell is filled then there is an organism else there isnt an organism. https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
   
   There is three ways that an organism develops:
   
        Creation - On each empty cell there is exactly 3 filled cells, so in the next generation will create a new organism (filled cell)
        Death - Each filled cell which has 0 or 1 filled neighbor, will convert to empty. also each filled cell that has more than 4 filled cell will convert to empty.
        Existency - Each filled cell that has 2 or 3 filled neighbors will continue be filled.
        
   ![Hnet com-image](https://user-images.githubusercontent.com/64331443/155857071-da777b2e-1437-4fcf-bfe3-67954041e144.jpg)

2. PhoneBook:
   As normal phonebook application, we are able to save phonebook, remove contacts, load phonebook.
   Load and save phonebook was done using Serialize. we can search phones by names or phones.
   Its possible to update contacts and also add contacts.
   
   ![Hnet com-image (1)](https://user-images.githubusercontent.com/64331443/155857668-97631242-a099-44e6-8125-c24aa664cad0.jpg)

