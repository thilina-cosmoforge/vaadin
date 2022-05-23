package com.example.application.views.forms;

import com.example.application.views.components.ContactField;
import com.example.application.views.components.ProfileImage;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;

@PageTitle("New Student")
@Route(value = "newStudent")
public class StudentForm extends VerticalLayout {

    DatePicker.DatePickerI18n singleFormatI18n = new DatePicker.DatePickerI18n();
    Image logo = new Image(
            "https://dcstatic.com/images/brandcrowd/logos/brandcrowd-logo-5d59400c52.svg",
            "logo");
    ProfileImage userImage = new ProfileImage();
    TextField admissionNo = new TextField();
    DatePicker admissionDate = new DatePicker("Date of Admission");
    TextField firstName = new TextField("First name");
    TextField middleName = new TextField("Middle Name");
    TextField surName = new TextField("Last Name");
    TextField nameInitials = new TextField("Name With Initials");
    DatePicker dob = new DatePicker("Date of Birth");
    ComboBox<String> religion = new ComboBox<>("Religion");
    ComboBox<String> nationality = new ComboBox<>("Nationality");
    ComboBox<String> house = new ComboBox<>("House");
    IntegerField insuranceNo = new IntegerField("Insurance No.");
    ComboBox<String> formerSchool = new ComboBox<>("Previous School");
    NumberField distance = new NumberField("Distance");
    ComboBox<String> transport = new ComboBox<>("Mode of Transmission");
    IntegerField BirthCertNo = new IntegerField("Birth Certificate No.");

    private final Button create_btn;
    private final NativeButton cancel_btn;






    public StudentForm() {

        logo.setMaxHeight(100, Unit.PIXELS);
        firstName.setPrefixComponent(VaadinIcon.USER.create());
        FormLayout names = new FormLayout();
        names.add(
                firstName,
                middleName,
                surName
        );
        singleFormatI18n.setDateFormat("yyyy-MM-dd");
        userImage.getStyle().set("margin-left", "20%");
        admissionNo.setLabel("Admission No");
        admissionNo.setHelperText("school index no");
        admissionDate.setI18n(singleFormatI18n);
        admissionDate.setValue(LocalDate.now(ZoneId.systemDefault()));
        religion.setItems("Buddhist", "Christian", "Catholic", "Islam");
        nationality.setItems("Sri Lankan");
        house.setItems("house1","house2","house3","house4");
        insuranceNo.setHelperText("digits");
        formerSchool.setItems("List of popular schools");
        distance.setHelperText("distance from residence (Km)");
        transport.setItems("Bus", "School Van", "MotorBike","Bicycle", "Car", "Three Wheeler");
        BirthCertNo.setMax(10);
//      email.setSuffixComponent(new Div(new Text("@gmail.com")));
        FormLayout formLayoutStudent = new FormLayout();
        formLayoutStudent.add(
                userImage,
                names,
                nameInitials,
                dob,
                religion,
                nationality,
                house,
                insuranceNo,
                formerSchool,
                distance,
                transport,
                BirthCertNo
        );
        formLayoutStudent.setColspan(nameInitials, 2);
//        formLayoutStudent.set(na/meInitials, 2);
        formLayoutStudent.setResponsiveSteps(
                // Use one column by default
                new FormLayout.ResponsiveStep("0", 1),
                // Use two columns, if layout's width exceeds 500px
                new FormLayout.ResponsiveStep("500px", 2)
        );


        HorizontalLayout bottomButtons = new HorizontalLayout();
        create_btn = new Button("Create");
        cancel_btn = new NativeButton("Cancel");
        cancel_btn.addClickListener(e ->
                cancel_btn.getUI().ifPresent(ui ->
                        ui.navigate(""))
        );
        bottomButtons.add(
                create_btn,
                cancel_btn
        );

        FormLayout formLayoutParent = new FormLayout();
        ComboBox<String> guardianType = new ComboBox<>("Guardian");
        guardianType.setItems("Father","Mother","Guardian");
        TextField nic = new TextField("NIC");
        TextField nameWithIN_P = new TextField();
        TextField firstName_P = new TextField("First name");
        TextField middleName_P = new TextField("Middle Name");
        TextField surName_P = new TextField("Last Name");

        FormLayout address_P = new FormLayout();
        TextField street1 = new TextField("Street1");
        TextField street2 = new TextField("Street2");
        TextField district = new TextField("District");
        address_P.add(
                street1,
                street2,
                district
        );
        ComboBox<String> occupation = new ComboBox<>("Occupation");
        formLayoutParent.add(
                guardianType,
                nic,
                firstName_P,
                middleName_P,
                surName_P,
                nameWithIN_P,
                occupation
        );


        Details student = new Details("Student", formLayoutStudent);
        Details parent = new Details("Parents", formLayoutParent);


        Text addText = new Text("Add New Contact");
        Button plusButton = new Button(new Icon(VaadinIcon.PLUS));
        Button remove = new Button(new Icon(VaadinIcon.MINUS));
        plusButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        plusButton.getElement().setAttribute("aria-label", "Add Contact");

        VerticalLayout formLayoutContact = new VerticalLayout();
        Details contacts = new Details("Contacts", formLayoutContact);

        ArrayList<ContactField> inputs = new ArrayList<>();

        Div in = new Div();

        formLayoutContact.add(
                addText,
                plusButton,
                in,
                address_P
        );

        ContactField in1 = new ContactField();
        ContactField in2 = new ContactField();
        ContactField in3 = new ContactField();
        ContactField in4 = new ContactField();
        inputs.add(in1);
        inputs.add(in2);
        inputs.add(in3);
        inputs.add(in4);

        final int[] a = {-1};
        plusButton.addClickListener(e -> {
            a[0]++;
            if(a[0] < 5){
                addText.setText(Arrays.toString(a));
                in.add(inputs.get(a[0]));
                inputs.get(a[0]).getElement().setAttribute("aria-label", Arrays.toString(a));
            }
        });


        in1.remBTN.addClickListener(e -> {
            in1.removeAll();
            notify("removed 1");
            a[0]--;
        });
        in2.remBTN.addClickListener(e -> {
            in2.removeAll();
            notify("removed 2");
            a[0]--;
        });
        in3.remBTN.addClickListener(e -> {
            in3.removeAll();
            notify("removed 3");
            a[0]--;
        });
        in4.remBTN.addClickListener(e -> {
            in4.removeAll();
            notify("removed 4");
            a[0]--;
        });

        Details addresses = new Details("Address", address_P);
        H1 h1 = new H1("Register Student");
        this.getClassNames().add("v-form");
        setMargin(true);
        add(
                logo,
                h1,
                student,
                parent,
                contacts,
                addresses,
                bottomButtons

        );

    }
    void notify(String ms){
        Notification notification = Notification.show(ms);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }
}
