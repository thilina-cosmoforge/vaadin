package com.example.application.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class ContactField extends FormLayout {
    public ComboBox<String> type = new ComboBox<>();
    public TextField name = new TextField();
    public Button remBTN = new Button(new Icon(VaadinIcon.MINUS));

    public void removeButton(){
        remove();
    }

    public ContactField(){
        remBTN.addThemeVariants(ButtonVariant.LUMO_ICON);
        remBTN.getElement().setAttribute("aria-label", "Remove Contact");
        remBTN.setWidth("50%");
        this.setResponsiveSteps(
                // Use one column by default
                new ResponsiveStep("0", 1),
                // Use two columns, if the layout's width exceeds 320px
                new ResponsiveStep("320px", 4),
                // Use three columns, if the layout's width exceeds 500px
                new ResponsiveStep("500px", 4)
        );
//        this.setColspan(email,2);
        HorizontalLayout end = new HorizontalLayout();
        end.add(remBTN);
        add(type,name);
    }
}
