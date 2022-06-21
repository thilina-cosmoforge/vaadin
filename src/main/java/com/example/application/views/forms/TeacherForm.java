package com.example.application.views.forms;


import com.example.application.domain.Teacher;
import com.example.application.domain.TeacherContact;
import com.example.application.enums.ContactDetail;
import com.example.application.services.ITeacherContactService;
import com.example.application.services.ITeacherService;
import com.example.application.views.components.ContactField;
import com.example.application.views.components.ProfileImage;
import com.example.application.views.core.ChangeHandler;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
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
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private ITeacherContactService teacherContactService;

    Binder<Teacher> teacherBinder = new Binder<>(Teacher.class);
    Grid<Teacher> grid = new Grid<>(Teacher.class);
    Editor<Teacher> editor = grid.getEditor();
    Teacher teacher = new Teacher();
    private ChangeHandler changeHandler;

    Button cancel_btn = new Button("Cancel");

    Button plusButton = new Button(new Icon(VaadinIcon.PLUS));
    Button plusButton2 = new Button(new Icon(VaadinIcon.PLUS));
    Button plusButton3 = new Button(new Icon(VaadinIcon.PLUS));

    Map<Integer, ComboBox<String>> conTypeMap = new HashMap<>();
    Map<Integer, TextField> conValueMap = new HashMap<>();

    Map<Integer, Binder<TeacherContact>> teacherContactBinder_HashMap = new HashMap<>();
    Map<Integer, TeacherContact> teacherContact_HashMap = new HashMap<>();
    Map<Integer, HorizontalLayout> horizontalLayoutHashMap = new HashMap<>();
    Map<Integer, ContactField> ContactField_Map = new HashMap<>();
    Map<Integer, Button> rem = new HashMap<>();



    public TeacherForm() {
        plusButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        plusButton.getElement().setAttribute("aria-label", "Add Contact");
        logo.setMaxHeight(100, Unit.PIXELS);
        H1 h1 = new H1("Register Teacher");
        this.getClassNames().add("v-form");
        setMargin(true);
        singleFormatI18n.setDateFormat("yyyy-MM-dd");

        teacherBinder.setBean(new Teacher());

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


        Button create_btn = new Button("Save");
        create_btn.addClickListener(e -> save());

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
                appointedSubject,
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
        formLayoutContact.add(

        );
//        ArrayList<ContactField> inputs = new ArrayList<>();
//
//        Div in = new Div();
//        formLayoutContact.add(
//                addText,
//                plusButton,
//                in
//        );
//
//        ContactField in1 = new ContactField();
//        ContactField in2 = new ContactField();
//        ContactField in3 = new ContactField();
//        ContactField in4 = new ContactField();
//        inputs.add(in1);
//        inputs.add(in2);
//        inputs.add(in3);
//        inputs.add(in4);
//
//        final int[] a = {-1};
//        plusButton.addClickListener(e -> {
//            a[0]++;
//            if(a[0] < 5){
//                addText.setText(Arrays.toString(a));
//                in.add(inputs.get(a[0]));
//                inputs.get(a[0]).getElement().setAttribute("aria-label", Arrays.toString(a));
//            }
//        });
//
//        in1.remBTN.addClickListener(e -> {
//            in1.removeAll();
//            notify("removed 1");
//            a[0]--;
//        });
//        in2.remBTN.addClickListener(e -> {
//            in2.removeAll();
//            notify("removed 2");
//            a[0]--;
//        });
//        in3.remBTN.addClickListener(e -> {
//            in3.removeAll();
//            notify("removed 3");
//            a[0]--;
//        });
//        in4.remBTN.addClickListener(e -> {
//            in4.removeAll();
//            notify("removed 4");
//            a[0]--;
//        });

        HorizontalLayout bottomButtons = new HorizontalLayout();
        cancel_btn.addClickListener(e -> {clearForm();closePage();});
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
            teacherService.save(teacherBinder.getBean());
            setVisible(true);
            System.out.println("Data Entered");
            notify("Teacher Saved");
            clearForm();
            closePage();
        }

        teacherContactBinder_HashMap.forEach((key, binder) -> {
            if (binder.validate().isOk()){
                teacherContact_HashMap.forEach((index, contact) -> {
                    teacherContactService.save(contact);
                });
                notify("Contacts Added");
            }
        });
    }
    private void update() {
        if (teacherBinder.validate().isOk()) {
            teacherService.update(teacherBinder.getBean());
            setVisible(true);
            System.out.println("Data Updated");
            notify("Teacher Data Updated");

        }
    }

    void clearForm(){
        teacherBinder.getFields().forEach(f -> f.clear());
    }

    void closePage(){
        cancel_btn.getUI().ifPresent(ui ->ui.navigate("teacher"));
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
    private void NewContactField(VerticalLayout layout, int i){
        horizontalLayoutHashMap.put(i,new HorizontalLayout());
        conTypeMap.put(i,new ComboBox<>("Type"));
        conTypeMap.get(i).setItems(
                String.valueOf(ContactDetail.EMAIL.getValue()),
                String.valueOf(ContactDetail.MOBILE.getValue()),
                String.valueOf(ContactDetail.FIXED.getValue())
        );
        conValueMap.put(i,new TextField("Value"));
        rem.put(i, new Button(new Icon(VaadinIcon.MINUS)));

//        fatherContactBinder.forField(conTypeMap.get(i))
//                .asRequired()
//                .bind(ParentContact::getType, ParentContact::setType);
//        fatherContactBinder.forField(conValueMap.get(i))
//                .asRequired()
//                .bind(ParentContact::getValue, ParentContact::setValue);

        horizontalLayoutHashMap.get(i).add(
                conTypeMap.get(i),
                conValueMap.get(i),
                rem.get(i)
        );
        rem.get(i).addClickListener(e -> {
            layout.remove(horizontalLayoutHashMap.get(i));
            notify("removed");
        });
        if(horizontalLayoutHashMap.get(i)!=null){
            layout.add(horizontalLayoutHashMap.get(i));
        }
    }

    private void AddContactField(VerticalLayout layout, int i){
        teacherContactBinder_HashMap.put(i, new Binder<>());
        teacherContactBinder_HashMap.get(i).setBean(teacherContact_HashMap.put(i, new TeacherContact()));
        horizontalLayoutHashMap.put(i,new HorizontalLayout());
        layout.add(new Text("Add New Contact"));
        ContactField_Map.put(i, new ContactField());

        teacherContactBinder_HashMap.get(i).forField(ContactField_Map.get(i).name)
                .asRequired("*")
                .bind(TeacherContact::getValue, TeacherContact::setValue);

        horizontalLayoutHashMap.get(i).add(
                ContactField_Map.get(i).type,
                ContactField_Map.get(i).name,
                ContactField_Map.get(i).remBTN
        );
        ContactField_Map.get(i).remBTN.addClickListener(e -> {
            layout.remove(horizontalLayoutHashMap.get(i));
            notify("removed");
        });
        if(horizontalLayoutHashMap.get(i)!=null){
            layout.add(horizontalLayoutHashMap.get(i));
        }
    }

    private Component findComponentWithId(HasComponents root, String id) {
        for(Component child : root) {
            if(id.equals(child.getId())) {
                // found it!
                return child;
            } else if(child instanceof HasComponents) {
                // recursively go through all children that themselves have children
                return findComponentWithId((HasComponents) child, id);
            }
        }
        // none was found
        return null;
    }
    private void newRow(){

    }

}

