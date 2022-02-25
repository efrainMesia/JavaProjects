import java.io.*;
import javax.swing.JOptionPane;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;


public class phoneBookController {

	private final int FIRST_ASCII_NUMBER_VAL = 48; // 1 in ascii is 48
	private final int LAST_ASCII_NUMBER_VAL = 57; // 9 in ascii is 57
	private final String[] CHOICE_SEARCH = {"Name","Phone"};
    @FXML
    private TableView<Contact> table;
  
    @FXML
    private TableColumn<Contact, String> nameCol;

    @FXML
    private TableColumn<Contact, String> phoneCol;

    private Contacts contacts;
    private Contact contact;
    private ObservableList<Contact> observableList;
    private File phoneBookFile;
    
    @FXML
    private TextField addName;

    @FXML
    private TextField addPhone;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField oldPhone;
    @FXML
    private TextField searchBar;
    @FXML
    private Pane search;
    
    /* Controller will set GUI functionality.
     * Search bar is implemented, by using Observable list and also Filtered list.
     * Listener was set on Search bar.
     * On every start of the program, the file "phonebook.txt" is searched and loaded. if its not founded it creates a new file 
     * and starts the working on the new file.
     * If loadfile button is pressed, after selecting a file we set the attrib "phoneBookFile", this attrib. will be our current workingFile
     * no pop ups will be prompt on save File 
     * 
     * */
    @FXML
	public void initialize() {
    	this.contacts = new Contacts();
    	nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    	phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
    	this.observableList = FXCollections.observableArrayList();				// this list is used for tableView.
    	FilteredList<Contact> filteredData = new FilteredList<>(this.observableList, b-> true);		// This list is to filter the List from table view
    	table.setEditable(true);
    	this.createPhoneBookFile();		//create a phonebook file incase the file doesnt exist
    	this.loadFile(true);			//load from phonebook file
    	
    	for (int i = 0; i < CHOICE_SEARCH.length; i++) 	//adding Choices names to ChoiceBOX for searchBar
    	{
			this.choiceBox.getItems().add(CHOICE_SEARCH[i]);
		}
    	
    	this.choiceBox.getSelectionModel().selectFirst();	//selects the first in ChoiceBox.
    	
    	//adding a listener to searchbar.
    	this.searchBar.textProperty().addListener((observable,oldValue,newValue) ->
    	{
    		switch (choiceBox.getValue()) //gets the filter name from Choicebox
    		{
    			case "Name":
    				//filter table by first name
    				filteredData.setPredicate(contact -> contact.getName().toLowerCase().contains(newValue.toLowerCase().trim()));
    				break;
    			case "Phone":
    				//filter table by phone
    				filteredData.setPredicate(contact -> contact.getPhone().toLowerCase().contains(newValue.toLowerCase().trim()));
    				break;
    		}
    	});
    	
    	//set the table
    	this.table.setItems(filteredData);
    }
    

    @FXML
    void addContact(ActionEvent event) {
    	if(this.checkPhoneInput(this.addPhone.getText()))	//checking if phone text is just numbers
    	{
    		this.contact = new Contact(this.addName.getText(), this.addPhone.getText());	//creates new Contact
        	this.contacts.addContact(this.addName.getText(), this.addPhone.getText());		//add the contact
        	this.clearTextFields();
        	this.sortRefreshTable();	//sorting the table and refreshing it
    	}

    }
    
    // Check inputs of the textfield.
    private boolean checkPhoneInput(String phoneNumber)
    {
    	if(phoneNumber.isEmpty())		//text field is empty
    	{
    		JOptionPane.showMessageDialog(null,"phone number field is empty");
    		return false;
    	}
    	else
    	{
	    	for (int i = 0; i < phoneNumber.length(); i++) 
	    	{
	    		if(phoneNumber.charAt(i)< FIRST_ASCII_NUMBER_VAL || 
	    				phoneNumber.charAt(i)>LAST_ASCII_NUMBER_VAL) 	//check if text field only has numbers
	    		{
	    			JOptionPane.showMessageDialog(null,"Phone number must contains only numbers");
	    			return false;
	    		}
			}
    	}
    	
    	return true;
    }
    
    @FXML
    void saveFile(ActionEvent event) {
    	this.saveToFile();
    }   
    
    /* Use Serialize to save the current status of the Contacts arrayList*/
    public void saveToFile()
    {
    	try {
    		FileOutputStream fout = new FileOutputStream(this.phoneBookFile);
        	ObjectOutputStream oos = new ObjectOutputStream(fout);
        	oos.writeObject(this.contacts);
        	fout.close();
        	oos.close();
    	}
    	catch (Exception ex){
    		 ex.printStackTrace();
    	}
    	
    }
    
    @FXML
    void loadFile(ActionEvent event) {
		this.loadFile(false);
    }
    
    
    /* Load file, if we just opened the program will load the existed phoneBook file.
     * if we want to load another file, firstLoad flag will be false, and option to select file will be raised
     */
    private void loadFile(boolean firstLoad)
    {
    	try {
			if(!firstLoad)
				this.phoneBookFile= getFile();
			FileInputStream fi = new FileInputStream(this.phoneBookFile);
			ObjectInputStream ois = new ObjectInputStream(fi);
			this.contacts = (Contacts) ois.readObject();
			this.sortRefreshTable();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			if(!firstLoad)		
				JOptionPane.showMessageDialog(null,"Phonebook file is might be empty or damaged");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong");
		}
    }

    //Creates a new file, and saves it as a attribute.
    private void createPhoneBookFile()
    {
    	try {
    		this.phoneBookFile = new File("phoneBook.txt");
    		this.phoneBookFile.createNewFile();		// if file already exists will do nothing 
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    
    //gets a file from user. its used by "loadFile" function.
    private File getFile() {
		JOptionPane.showMessageDialog(null, "Enter your phonebook file");
		FileChooser fileChooser = new FileChooser(); 
		fileChooser.setTitle("select a file"); 
		fileChooser.setInitialDirectory(new File(".")); 
		return fileChooser.showOpenDialog(null);

	}
    
    @FXML
    void removeContact(ActionEvent event) {
    	this.contact = table.getSelectionModel().getSelectedItem();
    	this.contacts.removeContact(this.contact);
    	this.sortRefreshTable();

    }

    
    private void clearTextFields()
    {
    	this.addName.clear();
    	this.addPhone.clear();
    	this.oldPhone.clear();
    }
    
    

    @FXML
    void updateContact(ActionEvent event) {
    	if(checkPhoneInput(this.addPhone.getText()) && checkPhoneInput(this.oldPhone.getText()))
    	{
    		this.contacts.updateContactPhone(this.addName.getText(), this.addPhone.getText(), this.oldPhone.getText());
    		this.sortRefreshTable();
    		this.clearTextFields();
    	}
    }
    
    //refresh the contacts table
    private void sortRefreshTable()
    {
    	this.contacts.sortContacts();
    	this.observableList.clear();
    	for(int i =0 ; i< this.contacts.getContacts().size();i++)
    	{
    		this.observableList.add(this.contacts.getContacts().get(i));
    	}
    }

}
