package com.example.application.views.forms;


import com.example.application.domain.Student;
import com.example.application.domain.Teacher;
import com.example.application.services.ITeacherService;
import com.example.application.views.components.ContactField;
import com.example.application.views.components.ProfileImage;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;

@PageTitle("New Teacher")
@Route(value = "newTeacher")
@SpringComponent
@UIScope
public class TeacherForm extends VerticalLayout {
    DatePicker.DatePickerI18n singleFormatI18n = new DatePicker.DatePickerI18n();
    Image logo = new Image(
            "https://dcstatic.com/images/brandcrowd/logos/brandcrowd-logo-5d59400c52.svg",
            "logo");


    @Autowired
    private ITeacherService teacherService;
    Binder<Teacher> teacherBinder = new Binder<>(Teacher.class);
    Teacher teacher = new Teacher();

    public TeacherForm() {
        logo.setMaxHeight(100, Unit.PIXELS);
        H1 h1 = new H1("Register Teacher");
        this.getClassNames().add("v-form");
        setMargin(true);
        singleFormatI18n.setDateFormat("yyyy-MM-dd");

        teacherBinder.setBean(teacher);

        ProfileImage userImage = new ProfileImage();
        userImage.getStyle().set("margin-left", "20%");

        TextField firstName = new TextField("First name");
        firstName.setPrefixComponent(VaadinIcon.USER.create());
        teacherBinder.forField(firstName)
                .asRequired()
                .withValidator(
                        name -> name.length() >= 3,
                        "Name must contain at least three characters")
                .bind(Teacher::getFirstName, Teacher::setFirstName);

        TextField middleName = new TextField("Middle Name");
        middleName.setPrefixComponent(VaadinIcon.USER.create());
        teacherBinder.forField(middleName)
                .bind(Teacher::getMiddleName, Teacher::setMiddleName);

        TextField surName = new TextField("Last Name");
        surName.setPrefixComponent(VaadinIcon.USER.create());
        teacherBinder.forField(surName)
                .asRequired()
                .withValidator(
                        name -> name.length() >= 3,
                        "Name must contain at least three characters")
                .bind(Teacher::getSurName, Teacher::setSurName);

        TextField nameInitials = new TextField("Name With Initials");
        teacherBinder.forField(nameInitials)
                .asRequired()
                .bind(Teacher::getNameWithInitials, Teacher::setNameWithInitials);

        TextField teacherId = new TextField();
        teacherId.setLabel("Teacher ID");
        teacherBinder.forField(teacherId)
                .asRequired()
                .bind(Teacher::getTeacherId, Teacher::setTeacherId);


        TextField nicNumber = new TextField();
        nicNumber.setLabel("Teacher NIC No");
        teacherBinder.forField(nicNumber)
                .asRequired()
                .bind(Teacher::getNicNumber, Teacher::setNicNumber);

        TextField teacherGrade = new TextField("Teacher Grade");
        teacherBinder.forField(teacherGrade)
                .bind(Teacher::getTeacherGrade, Teacher::setTeacherGrade);


        TextField appointedSubject = new TextField("Appointed Subject");
        teacherBinder.forField(appointedSubject)
                .bind(Teacher::getAppointedSubject, Teacher::setAppointedSubject);


        TextField street1 = new TextField("Street1");
        teacherBinder.forField(street1)
                .asRequired()
                .bind(Teacher::getAddressStreet1, Teacher::setAddressStreet1);


        TextField street2 = new TextField("Street2");
        teacherBinder.forField(street2)
                .asRequired()
                .bind(Teacher::getAddressStreet2, Teacher::setAddressStreet2);


        TextField district = new TextField("District");
        teacherBinder.forField(district)
                .asRequired()
                .bind(Teacher::getAddressDistrict, Teacher::setAddressDistrict);


        Button create_btn = new Button("Create");
        create_btn.addClickListener(e -> save());
        Button cancel_btn = new Button("Cancel");
//  -------------------------------------------------------------------------------------------------------------------------------
        FormLayout names = new FormLayout();
        names.add(
                firstName,
                middleName,
                surName
        );
        FormLayout address = new FormLayout();
        Text addAddressText = new Text("Address");
        address.add(
                addAddressText,
                street1,
                street2,
                district
        );

        FormLayout formLayoutTeacher = new FormLayout();
        formLayoutTeacher.add(
                userImage,
                names,
                nameInitials,
                teacherId,
                nicNumber,
                teacherGrade,
                address
        );

        formLayoutTeacher.setColspan(nameInitials, 2);
//        formLayoutStudent.set(na/meInitials, 2);
        formLayoutTeacher.setResponsiveSteps(
                // Use one column by default
                new FormLayout.ResponsiveStep("0", 1),
                // Use two columns, if layout's width exceeds 500px
                new FormLayout.ResponsiveStep("500px", 2)
        );


        Details teacherDetails = new Details("Teacher", formLayoutTeacher);
        //------------------------------------------------------------------------------------------------------------------------------
        DatePicker firstAppointDate = new DatePicker("Date Of First Appoint");
        firstAppointDate.setI18n(singleFormatI18n);
        firstAppointDate.setValue(LocalDate.now(ZoneId.systemDefault()));
        teacherBinder.forField(firstAppointDate)
                .asRequired()
                .bind(Teacher::getFirstAppointDate, Teacher::setFirstAppointDate);

        DatePicker dateAssumingSchool = new DatePicker("Date Of Assuming School");
        dateAssumingSchool.setI18n(singleFormatI18n);
        dateAssumingSchool.setValue(LocalDate.now(ZoneId.systemDefault()));
        teacherBinder.forField(dateAssumingSchool)
                .asRequired()
                .bind(Teacher::getDateAssumingSchool, Teacher::setDateAssumingSchool);

        DatePicker datePension = new DatePicker("Date Of Pension");
        datePension.setI18n(singleFormatI18n);
        datePension.setValue(LocalDate.now(ZoneId.systemDefault()));
        teacherBinder.forField(datePension)
                .asRequired()
                .bind(Teacher::getDateAssumingSchool, Teacher::setDateAssumingSchool);

        FormLayout formLayoutDates = new FormLayout();
        formLayoutDates.add(
              firstAppointDate,
              dateAssumingSchool,
              datePension
        );
        Details Dates = new Details("Important Dates", formLayoutDates);

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
                in
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
                teacherDetails,
                Dates,
                contacts,
                bottomButtons
        );
    }

    private void save() {
        if (teacherBinder.validate().isOk()) {
            teacherService.save(teacher);
            setVisible(true);
            System.out.println("Data Entered");
            notify("Teacher Added");
        }


    }
    void notify(String ms){
        Notification notification = Notification.show(ms);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }

    private Image convertToImage(byte[] imageData)
    {
        StreamResource streamResource = new StreamResource("isr", new InputStreamFactory() {
            @Override
            public InputStream createInputStream() {
                return new ByteArrayInputStream(imageData);
            }
        });
        return new Image(streamResource, "photo");
    }
}

