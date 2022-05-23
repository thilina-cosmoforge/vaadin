package com.example.application.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;

public class ContactField extends FormLayout {
    NumberField mobile = new NumberField("Mobile");
    NumberField fixed = new NumberField("Fixed");
    EmailField email = new EmailField("Email");
    public Button remBTN = new Button(new Icon(VaadinIcon.MINUS));

    public void removeButton(){
        remove(
                fixed,
                mobile,
                email
        );
    }

    public ContactField(){
        remBTN.addThemeVariants(ButtonVariant.LUMO_ICON);
        remBTN.getElement().setAttribute("aria-label", "Remove Contact");
        remBTN.setWidth("50%");
        this.setResponsiveSteps(
                // Use one column by default
                new FormLayout.ResponsiveStep("0", 1),
                // Use two columns, if the layout's width exceeds 320px
                new FormLayout.ResponsiveStep("320px", 4),
                // Use three columns, if the layout's width exceeds 500px
                new FormLayout.ResponsiveStep("500px", 4)
        );
        this.setColspan(email,2);
        HorizontalLayout end = new HorizontalLayout();
        end.add(
                email,remBTN
        );
        add(
                fixed,
                mobile,
                end
        );
    }
}
