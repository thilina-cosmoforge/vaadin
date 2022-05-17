package com.example.application.views.forms;

import com.example.application.views.components.ProfileImage;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.ZoneId;

@PageTitle("New Student")
@Route(value = "newStudent")
public class StudentForm extends VerticalLayout {

    DatePicker.DatePickerI18n singleFormatI18n = new DatePicker.DatePickerI18n();
    //https://dcstatic.com/images/brandcrowd/logos/brandcrowd-logo-5d59400c52.svg
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
    ComboBox<String> formerSchool = new ComboBox<>("House");
    NumberField distance = new NumberField("Distance");
    ComboBox<String> transport = new ComboBox<>("Mode of Transmission");
    IntegerField BirthCertNo = new IntegerField("Birth Certificate No.");

    private final Button create_btn;
    private final NativeButton cancel_btn;

    //https://dcstatic.com/images/brandcrowd/logos/brandcrowd-logo-5d59400c52.svg
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
//        formLayoutStudent.getStyle().set("background-color", "hsla(219, 25%, 20%, 5%");
        H1 h1 = new H1("Register Student");
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

        this.getClassNames().add("v-form");
        setMargin(true);
        this.setAlignItems(Alignment.CENTER);
        add(
                logo,
                h1,
                formLayoutStudent,
                bottomButtons
        );
    }
}
