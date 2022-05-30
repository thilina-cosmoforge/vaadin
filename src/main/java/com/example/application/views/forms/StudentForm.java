package com.example.application.views.forms;

import com.example.application.domain.Parent;
import com.example.application.domain.Student;
import com.example.application.domain.weak.FullName;
import com.example.application.services.IParentService;
import com.example.application.services.IStudentService;
import com.example.application.services.ParentService;
import com.example.application.services.StudentService;
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
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToFloatConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;

@PageTitle("New Student")
@Route(value = "newStudent")
@SpringComponent
@UIScope
public class StudentForm extends VerticalLayout {

    DatePicker.DatePickerI18n singleFormatI18n = new DatePicker.DatePickerI18n();
    Image logo = new Image(
            "https://dcstatic.com/images/brandcrowd/logos/brandcrowd-logo-5d59400c52.svg",
            "logo");

    @Autowired
    private IParentService parentService;
    @Autowired
    private IStudentService studentService;

    Binder<Student> studentBinder = new Binder<>(Student.class);
    Binder<Parent> nameBinder = new Binder<>(Parent.class);
    FullName fullName = new FullName();
    Student student = new Student();

//  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public StudentForm() {
        logo.setMaxHeight(100, Unit.PIXELS);
        H1 h1 = new H1("Register Student");
        this.getClassNames().add("v-form");
        setMargin(true);
        singleFormatI18n.setDateFormat("yyyy-MM-dd");

        studentBinder.setBean(student);


        ProfileImage userImage = new ProfileImage();
        userImage.getStyle().set("margin-left", "20%");

        TextField firstName_S = new TextField("First name");
        firstName_S.setPrefixComponent(VaadinIcon.USER.create());
        studentBinder.forField(firstName_S)
                .asRequired()
                .withValidator(
                        name -> name.length() >= 3,
                        "Name must contain at least three characters")
                .bind(Student::getFirstName, Student::setFirstName);

        TextField middleName_S = new TextField("Middle Name");
        studentBinder.forField(middleName_S)
                .bind(Student::getMiddleName, Student::setMiddleName);

        TextField surName_S = new TextField("Last Name");
        studentBinder.forField(surName_S)
                .asRequired()
                .withValidator(
                        name -> name.length() >= 3,
                        "Name must contain at least three characters")
                .bind(Student::getSurName, Student::setSurName);

        TextField nameInitials = new TextField("Name With Initials");
        studentBinder.forField(nameInitials)
                .asRequired()
                .bind(Student::getNameInitials, Student::setNameInitials);

        TextField admissionNo = new TextField();
        admissionNo.setLabel("Admission No");
        admissionNo.setHelperText("school index no");
        studentBinder.forField(admissionNo)
                .asRequired()
                .bind(Student::getAdmissionNumber, Student::setAdmissionNumber);

        DatePicker dob = new DatePicker("Date of Birth");
        studentBinder.forField(dob)
                .asRequired()
                .bind(Student::getDateOfBirth, Student::setDateOfBirth);

        ComboBox<String> religion = new ComboBox<>("Religion");
        religion.setItems("Buddhist", "Christian", "Catholic", "Islam");
        studentBinder.forField(religion)
                .asRequired()
                .bind(Student::getReligion, Student::setReligion);

        ComboBox<String> nationality = new ComboBox<>("Nationality");
        nationality.setItems("Sri Lankan");
        studentBinder.forField(nationality)
                .asRequired()
                .bind(Student::getNationality, Student::setNationality);

        ComboBox<String> house = new ComboBox<>("House");
        house.setItems("house1","house2","house3","house4");
        studentBinder.forField(house)
                .asRequired()
                .bind(Student::getHouse, Student::setHouse);

        TextField insuranceNo = new TextField("Insurance No.");
        insuranceNo.setHelperText("digits");
        studentBinder.forField(insuranceNo)
                .asRequired("*")
                .withNullRepresentation("")
                .withConverter(new StringToLongConverter("Invalid Type"))
                .bind(Student::getInsuranceNumber, Student::setInsuranceNumber);

        ComboBox<String> formerSchool = new ComboBox<>("Previous School");
        formerSchool.setItems("List of popular schools");
        studentBinder.forField(formerSchool)
                .asRequired()
                .bind(Student::getFormerSchool , Student::setFormerSchool);

        ComboBox<String> clasCategory = new ComboBox<>("Class Category");
        clasCategory.setItems("A", "B");
        studentBinder.forField(clasCategory)
                .bind(Student::getGradeCategory , Student::setGradeCategory);

        TextField distance = new TextField("Distance");
        distance.setHelperText("distance from residence (Km)");
        studentBinder.forField(distance)
                .asRequired()
                .withNullRepresentation("")
                .withConverter(new StringToFloatConverter("Invalid Type"))
                .bind(Student::getDistance, Student::setDistance);

        ComboBox<String> transport = new ComboBox<>("Mode of Transmission");
        transport.setItems("Bus", "School Van", "MotorBike","Bicycle", "Car", "Three Wheeler");
        studentBinder.forField(transport)
                .asRequired()
                .bind(Student::getModeTransmission, Student::setModeTransmission);

        TextField BirthCertNo = new TextField("Birth Certificate No.");
        studentBinder.forField(BirthCertNo)
                .asRequired()
                .withNullRepresentation("")
                .withConverter(new StringToLongConverter("Invalid Type"))
                .bind(Student::getBirthCertificateNumber, Student::setBirthCertificateNumber);

        TextField S_street1 = new TextField("Street1");
        studentBinder.forField(S_street1)
                .asRequired()
                .bind(Student::getAddressStreet1, Student::setAddressStreet1);

        TextField S_street2 = new TextField("Street2");
        studentBinder.forField(S_street2)
                .asRequired()
                .bind(Student::getAddressStreet2, Student::setAddressStreet2);

        TextField S_district = new TextField("District");
        studentBinder.forField(S_district)
                .asRequired()
                .bind(Student::getAddressDistrict, Student::setAddressDistrict);
//        email.setSuffixComponent(new Div(new Text("@gmail.com")));


        DatePicker admissionDate = new DatePicker("Date of Admission");
        admissionDate.setI18n(singleFormatI18n);
        admissionDate.setValue(LocalDate.now(ZoneId.systemDefault()));
        studentBinder.forField(admissionDate)
                .asRequired()
                .bind(Student::getAdmissionDate, Student::setAdmissionDate);

        ComboBox<String> admissionGrade = new ComboBox<>("Class");
        admissionGrade.setItems("1","2","3");
        studentBinder.forField(admissionGrade)
                .asRequired()
                .bind(Student::getAdmissionGrade, Student::setAdmissionGrade);

        Button create_btn = new Button("Create");
        create_btn.addClickListener(e -> save());
        Button cancel_btn = new Button("Cancel");
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        FormLayout names = new FormLayout();
        names.add(
                firstName_S,
                middleName_S,
                surName_S
        );
        FormLayout address_S = new FormLayout();
        address_S.add(
                S_street1,
                S_street2,
                S_district
        );

        FormLayout formLayoutStudent = new FormLayout();
        formLayoutStudent.add(
                userImage,
                names,
                nameInitials,
                admissionNo,
                admissionDate,
                admissionGrade,
                dob,
                religion,
                nationality,
                house,
                insuranceNo,
                formerSchool,
                clasCategory,
                distance,
                transport,
                BirthCertNo,
                address_S
        );
        formLayoutStudent.setColspan(nameInitials, 2);
//        formLayoutStudent.set(na/meInitials, 2);
        formLayoutStudent.setResponsiveSteps(
                // Use one column by default
                new FormLayout.ResponsiveStep("0", 1),
                // Use two columns, if layout's width exceeds 500px
                new FormLayout.ResponsiveStep("500px", 2)
        );



//       ////////////////////////////////////////////////////////////////////////////
        ComboBox<String> guardianType = new ComboBox<>("Guardian");
        guardianType.setItems("Father","Mother","Guardian");
        TextField nic = new TextField("NIC");
        TextField nameWithIN_P = new TextField();
        TextField firstName_P = new TextField("First name");
        TextField middleName_P = new TextField("Middle Name");
        TextField surName_P = new TextField("Last Name");
        TextField P_street1 = new TextField("Street1");
        TextField P_street2 = new TextField("Street2");
        TextField P_district = new TextField("District");
        ComboBox<String> occupation = new ComboBox<>("Occupation");
//////////////////////////////////////////////////////////////////////////////////////////
        FormLayout address_P = new FormLayout();
        address_P.add(
                P_street1,
                P_street2,
                P_district
        );
        FormLayout formLayoutParent = new FormLayout();
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


        HorizontalLayout bottomButtons = new HorizontalLayout();
        cancel_btn.addClickListener(e ->
                cancel_btn.getUI().ifPresent(ui ->
                        ui.navigate(""))
        );
        bottomButtons.add(
                create_btn,
                cancel_btn
        );
        add(
                logo,
                h1,
                student,
                parent,
                contacts,
                bottomButtons
        );
    }

    private void save() {
        if (studentBinder.validate().isOk()) {
            studentService.save(student);
            setVisible(true);
            System.out.println("Data Entered");
            notify("Student Added");
        }
    }

    void notify(String ms){
        Notification notification = Notification.show(ms);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }
}
