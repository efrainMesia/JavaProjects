# JavaProjects

I learnt Java in Open University of Israel. The following projects below displays my assignments during this course.


1. Conway's lifecycle - 
   I applied Conway's research of organisms lifecycle for my first assignment. This helped further my understanding of Graphic User Interface (GUI).
In the beginning of the program you will see an empty matrix. However, each cells will eventually represent an organism. Once the next generation button is pressed the program will then set a random matrix containing organisms. https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
   
   There are three ways that an organism is developed:
   
        Creation - On each empty cell there is exactly 3 filled cells, so in the next generation will create a new organism (filled cell)
        Death - Each filled cell which has 0 or 1 filled neighbor, will convert to empty. also each filled cell that has more than 4 filled cell will convert to empty.
        Existency - Each filled cell that has 2 or 3 filled neighbors will continue be filled.
       
   ![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/64331443/155858485-91623303-f81b-417e-b04b-8821f564108f.gif)


2. PhoneBook:
   PhoneBook: The next assignment introduced me to the application of Serialize, by using the example of phonebooks. We all have access to phonebooks on our smart gadgets. Which enables us to view, add and remove our phone contacts. Furthermore, it is possible to update contact information. I gained further knowledge from this assignment as I understood the importance of implementing Interfaces and also how to use Generics Classes.

   ![Hnet com-image (1)](https://user-images.githubusercontent.com/64331443/155857668-97631242-a099-44e6-8125-c24aa664cad0.jpg)

3. Server and Client:

   Server - creates a socket on port 8888, and also runs GUI which contains canvas and a button which clear the canvas. The main Thread of the Server runs another Thread which is responsible to get the data from Clients and draw it on server's canvas
   
   Clients - on every 2 clicks it draws an rectangle. Once a rectangle is drawed, the main Thread of the Clients run a thread which connect to the Server and send the coordinates of the rectangle. The GUI of the client has also a canvas and a button which clear the canvas.
   
   On this assigment, I used all what I learnt during the course (GUI,Threads,Networks,Catch exceptions).
   ![Hnet com-image (2)](https://user-images.githubusercontent.com/64331443/155857821-dba30b8f-7918-4a07-a164-9c87024eaca3.jpg)

   
