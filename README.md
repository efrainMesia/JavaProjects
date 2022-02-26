# JavaProjects

I learnt Java in Open University of Israel. The following projects below were my assignments in this course.


1. Conway's lifecycle:
   I applied Conway's research of organisms lifecycle.
   As the program starts we have an empty matrix which each cell represent an organism. when next generation is press the program will set a random matrix containing organisms. https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
   
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

3. Server and Client:
   Clients has canvas to draw rectangles on. The clients connect to the server and send the rectangle that has been drawed, and the server draw the rectangle on it's own canvas.
   If the clients clear the canvas, it doesnt send that to the server. Only the server can clear its own canvas.
   
   ![Hnet com-image (2)](https://user-images.githubusercontent.com/64331443/155857821-dba30b8f-7918-4a07-a164-9c87024eaca3.jpg)

   
