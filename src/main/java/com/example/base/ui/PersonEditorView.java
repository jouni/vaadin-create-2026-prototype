package com.example.base.ui;

import java.util.Optional;

import com.example.LucideIcon;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "people/directory/:personIndex", layout = PeopleDirectoryView.class)
@PageTitle("Edit person")
public class PersonEditorView extends Scroller implements BeforeEnterObserver {

    private final Avatar avatar = new Avatar();
    private final H2 title = new H2();
    private final Div emailSummary = new Div();
    private final TextField name = new TextField("Name");
    private final EmailField email = new EmailField("Email");
    private final TextField role = new TextField("Role");
    private final TextField department = new TextField("Department");
    private final TextField location = new TextField("Location");
    private final TextField employment = new TextField("Employment");
    private final TextField status = new TextField("Status");
    private final TextField startDate = new TextField("Start date");

    public PersonEditorView() {
        addClassName("person-editor-view");
        setSizeFull();

        var layout = new VerticalLayout();
        layout.setPadding(true);
        layout.setSpacing(true);

        avatar.addThemeVariants(AvatarVariant.XLARGE, AvatarVariant.AURA_FILLED);
        emailSummary.addClassName("secondary-text");

        var identity = new Div(title, emailSummary);
        identity.addClassName("person-editor-identity");

        var close = new Button();
        close.setAriaLabel("Close");
        close.setIcon(LucideIcon.X.create());
        close.addClickListener(event -> getUI()
                .ifPresent(ui -> ui.navigate(PeopleDirectoryView.class)));

        var header = new HorizontalLayout(avatar);
        header.addAndExpand(identity);
        header.addToEnd(close);
        header.setAlignSelf(Alignment.CENTER, avatar);
        header.setWidthFull();
        header.addClassNames("person-editor-header");

        var form = new FormLayout();
        form.addClassName("person-editor-form");
        form.setAutoResponsive(true);
        form.setExpandColumns(true);
        form.setExpandFields(true);
        form.addFormRow(name, email);
        form.addFormRow(role, department);
        form.addFormRow(location, employment);
        form.addFormRow(status, startDate);

        layout.add(header, form);
        setContent(layout);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        var index = event.getRouteParameters().get("personIndex")
                .flatMap(PersonEditorView::parseIndex)
                .orElse(-1);

        if (index < 0 || index >= PeopleDirectoryView.PEOPLE.size()) {
            event.rerouteTo(PeopleDirectoryView.class);
            return;
        }

        showPerson(PeopleDirectoryView.PEOPLE.get(index));
    }

    private void showPerson(PeopleDirectoryView.Person person) {
        avatar.setName(person.name());
        avatar.setAbbreviation(person.initials());
        title.setText(person.name());
        emailSummary.setText(person.email());

        name.setValue(person.name());
        email.setValue(person.email());
        role.setValue(person.role());
        department.setValue(person.department());
        location.setValue(person.location());
        employment.setValue(person.employment());
        status.setValue(person.status());
        startDate.setValue(person.startDate());
    }

    private static Optional<Integer> parseIndex(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

}
