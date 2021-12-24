package ui;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import Exceptions.ChildNotFoundException;
import businessLogic.Address;
import businessLogic.Available_Slot;
import businessLogic.Book;
import businessLogic.ContactInfo;
import businessLogic.DonatedMoney;
import businessLogic.Donation;
import businessLogic.Item;
import businessLogic.Orphanage;
import businessLogic.Payment;
import businessLogic.Person;
import businessLogic.Title;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class OrphanageMainMenuController {

	Orphanage orphanage=new Orphanage();


	@FXML
	private TextField parentcnic;

	@FXML
	private TextField childcnic;



	@FXML
	private Label availableslots;

	@FXML
	private Label history=new Label();

	@FXML
	private TextField slotno;

	@FXML
	private TextField cnic=null;

	@FXML
	private TextField name=null;

	@FXML
	private TextField nationality;

	@FXML
	private TextField country;

	@FXML
	private TextField city;

	@FXML
	private TextField zipcode;

	@FXML
	private TextField postalcode;

	@FXML
	private RadioButton genderm;

	@FXML
	private RadioButton genderf;

	@FXML
	private DatePicker dateofbirth;

	@FXML
	private Label notvalidcnic;

	@FXML
	private Label empty;

	@FXML
	private Label invalidslotno;

	@FXML
	private Label reserved;

	@FXML
	private TextField phoneno;

	@FXML
	private TextField email;

	Person p;

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Label incorrect;

	@FXML
	private TextField donorcnic=new TextField();

	@FXML
	private Label donationsuccess=new Label();

	ArrayList<Item> items=new ArrayList<Item>();

	@FXML
	private TextField bookname;

	@FXML
	private TextField publisher;


	@FXML
	private TextField summary;

	@FXML
	private TextField author;

	@FXML
	private TextField amount;

	@FXML
	private Label parentview;

	@FXML
	private Label donorview;

	@FXML
	private Label childview;

	@FXML
	private ListView<Donation> donationlist;

	@FXML
	private TextField slottime;

	@FXML
	private Label slotsuccess;

	@FXML
	private DatePicker slotdate;

	@FXML
	private TextField background;

	@FXML
	private DatePicker dateofentry;


	@FXML
	void onclickconfirmslot(ActionEvent event) {

		if(slotdate.getAccessibleText().isEmpty()||slottime.getText().isEmpty())
			slotsuccess.setText("Fields cannot be empty");
		else {
			slotsuccess.setText("");
			Date date=java.sql.Date.valueOf(slotdate.getValue());
			orphanage.insertAvailableSlot((java.sql.Date) date, slottime.getText());
			slotsuccess.setText("Slots Inserted Successfuly");
		}

	}

	//for viewing parent info
	@FXML
	void onclickviewparent(ActionEvent event) {

		if(parentcnic.getText().isEmpty())
			empty.setText("Field cannot be empty");
		else
		{
			parentview.setText(orphanage.viewParent(donorcnic.getText()));
			parentcnic.setText("");
			empty.setText("");
		}

	}

	//for viewing child info
	@FXML
	void onclickviewchild(ActionEvent event) throws ChildNotFoundException {

		if(childcnic.getText().isEmpty())
			empty.setText("Field cannot be empty");
		else
		{
			childview.setText(orphanage.viewChildHandler(childcnic.getText()));
			childcnic.setText("");
			empty.setText("");
		}

	}



	//for viewing donor info
	@FXML
	void onclickviewdonor(ActionEvent event) {

		if(donorcnic.getText().isEmpty())
			empty.setText("Field cannot be empty");
		else
		{
			donorview.setText(orphanage.viewDonorHandler(donorcnic.getText()));
			donorcnic.setText("");
			empty.setText("");
		}

	}

	// for inserting money into item list
	@FXML
	void onclickadddonationmoney(ActionEvent event) {


		Payment payment=new Payment(Integer.valueOf(amount.getText()),"Cash");
		java.util.Date dNow = new java.util.Date();
		Date dateOfEntry = new Date(dNow.getTime());
		DonatedMoney dmoney=new DonatedMoney(dateOfEntry,Integer.valueOf(amount.getText()),payment);
		items.add(dmoney);
		orphanage.addDonation(items, donorcnic.getText());
		donationsuccess.setText("Donation Recorded Successfuly");
		donationsuccess.setText("Donated Money Added Successfuly");
		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("recorddonation.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	// for inserting book into item list
	@FXML
	void onclickadddonationbook(ActionEvent event) {

		Title t=new Title(bookname.getText(),summary.getText(),author.getText());
		java.util.Date utilDate = new java.util.Date();
		Date currentDate = new Date(utilDate.getTime());
		Book b=new Book (currentDate,t,publisher.getText());
		items.add(b);
		orphanage.addDonation(items, donorcnic.getText());
		donationsuccess.setText("Donation Recorded Successfuly");
		donationsuccess.setText("Book Added Successfuly");
		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("recorddonation.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	//record button on record donation page
	@FXML
	void OnpressDonationRecord(ActionEvent event) {

		if(items.isEmpty())
		{
			donationsuccess.setText("Choose Donation Item");
		}
		else
		{
			orphanage.addDonation(items, donorcnic.getText());
			donationsuccess.setText("Donation Recorded Successfuly");
			donorcnic.setText("");
		}


	}


	@FXML
	void onclickbook(ActionEvent event) {

		donationsuccess.setText("");
		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("donatebook.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void onclickmoney(ActionEvent event) {
		donationsuccess.setText("");
		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("donatemoney.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void OnpressLogin(ActionEvent event) {

		Boolean check=orphanage.Login(username.getText(),password.getText());
		if(check==true)
		{
			incorrect.setText(null);
			Stage primaryStage = new Stage();
			Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
			if (window instanceof Stage){
				((Stage) window).close();
			}
			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("OrphanageMainMenu.fxml"));
				Scene scene = new Scene(root,721,531);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Orphanage Management System");
				primaryStage.setResizable(false);
				primaryStage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			incorrect.setText("Incorrect Name or Password!");
		}

	}

	@FXML
	void OnPressRegister(ActionEvent event) {

		if(cnic.getText().isEmpty()||name.getText().isEmpty()||nationality.getText().isEmpty()||dateofbirth.toString().isEmpty()||country.getText().isEmpty()
				||postalcode.getText().isEmpty()||zipcode.getText().isEmpty()||city.getText().isEmpty())
		{
			empty.setText("Fill All Fields");
		}
		else if(genderm.getText().isEmpty()&&genderf.getText().isEmpty())
		{
			empty.setText("Fill All Fields");

		}
		else{

			Address address=new Address(country.getText(),city.getText(),Integer.valueOf(postalcode.getText()),
					Integer.valueOf(zipcode.getText()));
			String str;
			if(genderm==null)
				str=genderf.getText();
			else str=genderm.getText();
			Date date=java.sql.Date.valueOf(dateofbirth.getValue());
			p=new Person(cnic.getText(),name.getText(),date,str,nationality.getText(),address);
			ContactInfo c=new ContactInfo(phoneno.getText(),email.getText());
			orphanage.registerDonorHandler(cnic.getText(),name.getText(),(java.sql.Date) date,str,nationality.getText(),
					address,c);
			empty.setText("Donor Reserved Succesfuly");
			cnic=new TextField();
			name=new TextField();
			nationality=new TextField();
			country=new TextField();
			city=new TextField();
			postalcode=new TextField();
			zipcode=new TextField();
			genderm=new RadioButton();
			genderf=new RadioButton();

		}

	}


	//for getting persons info
	@FXML
	void OnPressContinue(ActionEvent event) {

		if(cnic.getText().isEmpty()||name.getText().isEmpty()||nationality.getText().isEmpty()||dateofbirth.toString().isEmpty()||country.getText().isEmpty()
				||postalcode.getText().isEmpty()||zipcode.getText().isEmpty()||city.getText().isEmpty())
		{
			empty.setText("Fill All Fields");
		}
		else if(genderm.getText().isEmpty()&&genderf.getText().isEmpty())
		{
			empty.setText("Fill All Fields");

		}
		else if(Orphanage.VerifyPerson(cnic.getText()))
		{
			Address address=new Address(country.getText(),city.getText(),Integer.valueOf(postalcode.getText()),
					Integer.valueOf(zipcode.getText()));
			String str;
			if(genderm==null)
				str=genderf.getText();
			else str=genderm.getText();
			Date date=java.sql.Date.valueOf(dateofbirth.getValue());
			p=new Person(cnic.getText(),name.getText(),date,str,nationality.getText(),address);
			Stage primaryStage = new Stage();
			Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
			if (window instanceof Stage){
				((Stage) window).close();
			}
			try {
				p.setCnic(cnic.getText());
				p.setDateOfBirth(date);
				p.setName(name.getText());
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ScheduleInterview.fxml"));
				Scene scene = new Scene(root,721,531);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Schedule Interview");
				primaryStage.setResizable(false);
				primaryStage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else
		{

			notvalidcnic.setText("Enter Valid cnic witout - ");
		}

	}

	@FXML
	void OnPressContinuechild(ActionEvent event) {

		if(cnic.getText().isEmpty()||name.getText().isEmpty()||nationality.getText().isEmpty()||dateofbirth.toString().isEmpty()||dateofentry.toString().isEmpty()
				||background.getText().isEmpty())
		{
			empty.setText("Fill All Fields");
		}
		else if(genderm.getText().isEmpty()&&genderf.getText().isEmpty())
		{
			empty.setText("Fill All Fields");

		}
		else
		{

			String str;
			if(genderm.getText().isEmpty())
				str=genderf.getText();
			else str=genderm.getText();
			Date date=java.sql.Date.valueOf(dateofbirth.getValue());
			Date date1=java.sql.Date.valueOf(dateofentry.getValue());
			orphanage.addChildHandler(cnic.getText(),name.getText(),date,str,nationality.getText(),date1,"Unadopted",background.getText());
			empty.setText("Insertion Successful");
		}


	}


	@FXML
	void  OnpressMainMenu(ActionEvent event) {

		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("OrphanageMainMenu.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	List<Available_Slot> slotslist;

	@FXML
	void onpressReserve(ActionEvent event) {

		Boolean check=false;
		int i=Integer.parseInt(slotno.getText());
		if(i>slotslist.size()||i<=0)
		{
			invalidslotno.setText("Invalid Slot Number");
		}
		else
		{
			check=orphanage.reserveSlot(p, slotslist.get(i).getAvailable_slot_date().toString(),slotslist.get(i).getAvailable_slot_time().toString());
		}
		if(check==true)
		{
			reserved.setText("Slot Reserved Succesfuly");
			cnic=new TextField();
			name=new TextField();
			nationality=new TextField();
			country=new TextField();
			city=new TextField();
			postalcode=new TextField();
			zipcode=new TextField();
			genderm=new RadioButton();
			genderf=new RadioButton();
		}

	}

	@FXML
	void onpressStart(ActionEvent event) {



		slotslist=orphanage.getAvailableSlots();
		String s="";
		for(int i=0;i<slotslist.size();i++)
		{
			s=s+slotslist.get(i).toString();
		}

		System.out.println(s);
		availableslots.setText(s);

	}





	@FXML
	void OnpressScheduleInterview(ActionEvent event) {

		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("verification.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Verification");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}


	}




	@FXML
	void onpressRegisterDonor(ActionEvent event) {

		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("RegisterDoner.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	@FXML
	void onpressRecordDonation(ActionEvent event) {

		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("recorddonation.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	@FXML
	void onpressviewdonors(ActionEvent event) {

		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("viewdonors.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	@FXML
	void onpressviewchild(ActionEvent event) {

		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("viewchild.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}


	}
	@FXML
	void onpressviewparent(ActionEvent event) {

		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("viewparent.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	List <Donation> l;
	@FXML
	void onpressdonationhistory(ActionEvent event) {

		l=orphanage.getDonationHistory();

		String s="";
		for(int i=0;i<l.size();i++)
		{
			s=s+l.get(i).toString();
		}
		System.out.println(s);
		availableslots.setText(s);

		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("donationhistory.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void onpressinsertslot(ActionEvent event) {

		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("insertslot.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	void onpressRegisterChild(ActionEvent event) {

		Stage primaryStage = new Stage();
		Window window =   ((javafx.scene.Node)(event.getSource())).getScene().getWindow();
		if (window instanceof Stage){
			((Stage) window).close();
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("registerchild.fxml"));
			Scene scene = new Scene(root,721,531);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Orphanage Management System");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}


}
