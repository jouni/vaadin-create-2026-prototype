package com.example.base.ui;

import java.util.List;

import com.example.LucideIcon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.badge.Badge;
import com.vaadin.flow.component.badge.BadgeVariant;
import com.vaadin.flow.component.breadcrumbs.Breadcrumbs;
import com.vaadin.flow.component.breadcrumbs.BreadcrumbsItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.card.CardVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridMultiSelectionModel;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.masterdetaillayout.MasterDetailLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayoutVariant;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;

@Route("people/directory")
@ParentLayout(MainLayout.class)
@PageTitle("People directory")
@CssImport(value = "./grid.css", themeFor = "vaadin-grid")
public class PeopleDirectoryView extends MasterDetailLayout {

    static final List<Person> PEOPLE = List.of(
            new Person("Maya Chen", "MC", "maya.chen@northstar.io", "VP of Product", "Product",
                    "New York, US", "Full-time", "Active", "Mar 12, 2021", 1),
            new Person("Elias Novak", "EN", "elias.novak@northstar.io", "Staff Engineer", "Engineering",
                    "Helsinki, FI", "Full-time", "Active", "Aug 04, 2020", 2),
            new Person("Amara Okafor", "AO", "amara.okafor@northstar.io", "People Partner", "People",
                    "London, UK", "Full-time", "On leave", "Jan 17, 2022", 3),
            new Person("Jonas Berg", "JB", "jonas.berg@northstar.io", "Product Designer", "Design",
                    "Stockholm, SE", "Full-time", "Active", "Nov 28, 2022", 4),
            new Person("Sofia Martinez", "SM", "sofia.martinez@northstar.io", "Finance Manager", "Finance",
                    "Madrid, ES", "Full-time", "Active", "Jun 05, 2023", 5),
            new Person("Noah Williams", "NW", "noah.williams@northstar.io", "Account Executive", "Sales",
                    "Austin, US", "Full-time", "Active", "Feb 19, 2024", 6),
            new Person("Leila Haddad", "LH", "leila.haddad@northstar.io", "Content Strategist", "Marketing",
                    "Paris, FR", "Contractor", "Active", "Sep 09, 2024", 7),
            new Person("Riku Tanaka", "RT", "riku.tanaka@northstar.io", "Data Analyst", "Operations",
                    "Tokyo, JP", "Full-time", "On leave", "Apr 21, 2025", 8),
            new Person("Priya Shah", "PS", "priya.shah@northstar.io", "Engineering Manager", "Engineering",
                    "Bengaluru, IN", "Full-time", "Active", "Jul 15, 2019", 9),
            new Person("Liam O'Connor", "LO", "liam.oconnor@northstar.io", "Senior Recruiter", "People",
                    "Dublin, IE", "Full-time", "Active", "Oct 07, 2020", 10),
            new Person("Camila Rocha", "CR", "camila.rocha@northstar.io", "UX Researcher", "Design",
                    "Sao Paulo, BR", "Full-time", "Active", "May 24, 2021", 11),
            new Person("Mateo Silva", "MS", "mateo.silva@northstar.io", "Product Manager", "Product",
                    "Lisbon, PT", "Full-time", "On leave", "Feb 14, 2022", 12),
            new Person("Nadia Petrova", "NP", "nadia.petrova@northstar.io", "Financial Analyst", "Finance",
                    "Sofia, BG", "Full-time", "Active", "Sep 01, 2022", 13),
            new Person("Owen Murphy", "OM", "owen.murphy@northstar.io", "Sales Development Rep", "Sales",
                    "Boston, US", "Full-time", "Active", "Dec 12, 2022", 14),
            new Person("Aisha Rahman", "AR", "aisha.rahman@northstar.io", "Lifecycle Marketer", "Marketing",
                    "Toronto, CA", "Full-time", "Active", "Mar 06, 2023", 15),
            new Person("Lucas Meyer", "LM", "lucas.meyer@northstar.io", "Platform Engineer", "Engineering",
                    "Berlin, DE", "Full-time", "Active", "Apr 18, 2023", 16),
            new Person("Chloe Dubois", "CD", "chloe.dubois@northstar.io", "Visual Designer", "Design",
                    "Lyon, FR", "Contractor", "Active", "Jul 10, 2023", 17),
            new Person("Samuel Kim", "SK", "samuel.kim@northstar.io", "Business Operations Lead", "Operations",
                    "Seoul, KR", "Full-time", "Active", "Aug 28, 2023", 18),
            new Person("Fatima Zahra", "FZ", "fatima.zahra@northstar.io", "Compensation Analyst", "People",
                    "Casablanca, MA", "Full-time", "Active", "Oct 16, 2023", 19),
            new Person("Diego Alvarez", "DA", "diego.alvarez@northstar.io", "Solutions Consultant", "Sales",
                    "Mexico City, MX", "Full-time", "On leave", "Jan 08, 2024", 20),
            new Person("Ingrid Larsen", "IL", "ingrid.larsen@northstar.io", "Product Operations", "Product",
                    "Oslo, NO", "Full-time", "Active", "Mar 25, 2024", 21),
            new Person("Ben Carter", "BC", "ben.carter@northstar.io", "Controller", "Finance",
                    "Chicago, US", "Full-time", "Active", "May 13, 2024", 22),
            new Person("Yuna Park", "YP", "yuna.park@northstar.io", "Frontend Engineer", "Engineering",
                    "Busan, KR", "Full-time", "Active", "Jul 22, 2024", 23),
            new Person("Kwame Mensah", "KM", "kwame.mensah@northstar.io", "Community Manager", "Marketing",
                    "Accra, GH", "Contractor", "Active", "Oct 01, 2024", 24),
            new Person("Elena Rossi", "ER", "elena.rossi@northstar.io", "Talent Development Lead", "People",
                    "Milan, IT", "Full-time", "Active", "Dec 02, 2024", 25),
            new Person("Tomasz Kowalski", "TK", "tomasz.kowalski@northstar.io", "Security Engineer", "Engineering",
                    "Warsaw, PL", "Full-time", "Active", "Feb 10, 2025", 26),
            new Person("Zara Ali", "ZA", "zara.ali@northstar.io", "Product Marketing Manager", "Marketing",
                    "Dubai, AE", "Full-time", "On leave", "Jun 16, 2025", 27),
            new Person("Gabriel Costa", "GC", "gabriel.costa@northstar.io", "Revenue Operations Analyst", "Operations",
                    "Porto, PT", "Full-time", "Active", "Sep 08, 2025", 28));

    public PeopleDirectoryView() {
        addClassName("people-directory-view");
        setExpandMaster(true);
        setMaster(createDirectory());

        addBackdropClickListener(event -> closeEditor());
        addDetailEscapePressListener(event -> closeEditor());
    }

    private Component createDirectory() {
        var directory = new VerticalLayout(createHeader(), createMetrics(), createDirectorySection(), createFilters(),
                        createGrid());
        directory.setPadding(false);
        directory.setAlignItems(Alignment.STRETCH);
        directory.setSizeFull();

        var scroller = new Scroller(directory);
        scroller.setSizeFull();
        scroller.addClassName("people-directory-content");
        return scroller;
    }

    private void closeEditor() {
        getUI().ifPresent(ui -> ui.navigate(PeopleDirectoryView.class));
    }

    private Component createHeader() {
        var breadcrumbs = new Breadcrumbs(Breadcrumbs.Mode.MANUAL);
        breadcrumbs.add(new BreadcrumbsItem("People", "people/directory"));
        var title = new BreadcrumbsItem("Directory");
        title.getElement().setAttribute("role", "heading");
        title.getElement().setAttribute("aria-level", "1");
        breadcrumbs.add(title);
        var subtitle = new Div("Find teammates, understand the shape of your organization, and stay connected.");
        subtitle.addClassNames("secondary-text");
        var titleGroup = new Div(breadcrumbs, subtitle);
        titleGroup.getElement().getStyle().set("flex", "1");

        var invite = new Button("Add Person", LucideIcon.USER_PLUS.create());
        invite.addThemeVariants(ButtonVariant.PRIMARY);

        var header = new HorizontalLayout(titleGroup);
        header.addToEnd(invite);
        header.setAlignItems(Alignment.CENTER);
        header.addThemeVariants(HorizontalLayoutVariant.WRAP);
        return header;
    }

    private Component createMetrics() {
        var metrics = new HorizontalLayout();
        metrics.addThemeVariants(HorizontalLayoutVariant.WRAP);
        metrics.addClassNames("directory-metrics");
        metrics.add(metricCard(LucideIcon.USERS, "Total People", "248", "+6 this month", "v-success"),
                metricCard(LucideIcon.PLANE, "Away Today", "12", "5 back this week", "neutral"),
                metricCard(LucideIcon.GLOBE_2, "Work Remotely", "68%", "Across 14 countries", "neutral"),
                metricCard(LucideIcon.BRIEFCASE_BUSINESS, "Open Roles", "9", "3 priority hires", "v-warning"));
        return metrics;
    }

    private Card metricCard(LucideIcon icon, String label, String value, String detail, String tone) {
        var iconBox = icon.create();
        iconBox.addClassNames("icon-box");

        var valueElement = new Div(value);
        valueElement.addClassName("metric-value");

        var card = new Card();
        card.setMedia(iconBox);
        card.setTitle(label);
        card.setSubtitle(detail);
        card.add(valueElement);
        card.addClassNames("directory-metric", tone);
        card.addThemeVariants(CardVariant.ELEVATED);
        return card;
    }

    private Component createDirectorySection() {
        var title = new H2("Team Members");
        var description = new Div("248 people across 8 departments");
        description.addClassNames("secondary-text");
        var heading = new Div(title, description);

        var export = new Button("Export", LucideIcon.DOWNLOAD.create());
        export.addThemeVariants(ButtonVariant.TERTIARY);

        var sectionHeader = new HorizontalLayout(heading);
        sectionHeader.addToEnd(export);
        sectionHeader.setWidthFull();
        sectionHeader.setAlignItems(Alignment.END);

        return sectionHeader;
    }

    private Component createFilters() {
        var search = new TextField("Search people");
        search.setPlaceholder("Name, role, or email");
        search.setPrefixComponent(LucideIcon.SEARCH.create());
        search.setClearButtonVisible(true);
        search.addClassName("directory-search");
        search.setMaxWidth("20em");
        search.setMinWidth("10em");

        var department = new Select<String>();
        department.setLabel("Department");
        department.setItems("All departments", "Design", "Engineering", "Finance", "Marketing", "People",
                "Product", "Sales");
        department.setValue("All departments");
        department.setMaxWidth("12em");

        var location = new Select<String>();
        location.setLabel("Location");
        location.setItems("All locations", "Americas", "Europe", "Asia Pacific");
        location.setValue("All locations");
        location.setMaxWidth("12em");

        var status = new Select<String>();
        status.setLabel("Status");
        status.setItems("All statuses", "Active", "On leave");
        status.setValue("All statuses");
        status.setMaxWidth("12em");

        var clear = new Button("Clear Filters");
        clear.addThemeVariants(ButtonVariant.TERTIARY);
        clear.addClassName("clear-filters");

        var filters = new HorizontalLayout();
        filters.addAndExpand(search, department, location, status);
        filters.addToEnd(clear);
        filters.addThemeVariants(HorizontalLayoutVariant.WRAP);
        filters.setAlignItems(Alignment.BASELINE);
        filters.addClassName("directory-filters");
        filters.setWidthFull();
        return filters;
    }

    private Component createGrid() {
        var grid = new Grid<Person>();
        grid.addClassName("people-grid");
        grid.addThemeVariants(GridVariant.NO_BORDER);
        grid.setItems(PEOPLE);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        ((GridMultiSelectionModel<Person>) grid.getSelectionModel()).setSelectionColumnFrozen(true);
        grid.addItemClickListener(event -> getUI().ifPresent(ui -> ui.navigate(
                "people/directory/" + PEOPLE.indexOf(event.getItem()))));

        grid.addColumn(new ComponentRenderer<>(this::personCell))
                .setHeader("Person")
                .setKey("person")
                .setAutoWidth(true)
                .setFlexGrow(2)
                .setSortable(true)
                .setFrozen(true);
        grid.addColumn(Person::role)
                .setHeader("Role")
                .setAutoWidth(true)
                .setFlexGrow(1)
                .setSortable(true);
        grid.addColumn(new ComponentRenderer<>(person -> departmentCell(person.department())))
                .setHeader("Department")
                .setAutoWidth(true)
                .setSortable(true);
        grid.addColumn(new ComponentRenderer<>(person -> locationCell(person.location())))
                .setHeader("Location")
                .setAutoWidth(true)
                .setFlexGrow(1);
        grid.addColumn(new ComponentRenderer<>(person -> employmentCell(person.employment())))
                .setHeader("Employment")
                .setAutoWidth(true);
        grid.addColumn(new ComponentRenderer<>(person -> statusCell(person.status())))
                .setHeader("Status")
                .setAutoWidth(true);
        grid.addColumn(Person::startDate)
                .setHeader("Start date")
                .setAutoWidth(true)
                .setSortable(true);
        grid.addComponentColumn(person -> iconButton("More actions", LucideIcon.ELLIPSIS))
                .setAutoWidth(true)
                .setFlexGrow(0);
        return grid;
    }

    private Component personCell(Person person) {
        var avatar = new Avatar(person.name());
        avatar.setAbbreviation(person.initials());
        // avatar.setColorIndex(person.avatarColorIndex());
        avatar.setTooltipEnabled(true);
        avatar.addClassName("person-avatar");
        avatar.addThemeVariants(AvatarVariant.LARGE, AvatarVariant.AURA_FILLED);

        var name = new Div(person.name());
        name.addClassNames("person-name", "bold-text");
        var email = new Div(person.email());
        email.addClassNames("person-email", "secondary-text");
        var details = new Div(name, email);
        details.addClassName("person-details");

        var cell = new HorizontalLayout(avatar, details);
        cell.addClassName("person-cell");
        return cell;
    }

    private Component departmentCell(String department) {
        var badge = new Badge(department);
        badge.addThemeVariants(BadgeVariant.CONTRAST);
        if (department.equals("Product")) {
                badge.addClassName("aura-accent-blue");
        } else if (department.equals("Engineering")) {
                badge.addClassName("aura-accent-red");
        } else if (department.equals("People")) {
                badge.addClassName("aura-accent-orange");
        } else if (department.equals("Design")) {
                badge.addClassName("aura-accent-purple");
        } else if (department.equals("Finance")) {
                badge.addClassName("aura-accent-green");
        } else if (department.equals("Sales")) {
                badge.addClassName("aura-accent-yellow");
        } else if (department.equals("Marketing")) {
                badge.addClassName("aura-accent-purple");
        }
        return badge;
    }

    private Component locationCell(String location) {
        var icon = LucideIcon.MAP_PIN.create();
        var text = new Span(location);
        var cell = new HorizontalLayout(icon, text);
        return cell;
    }

    private Component employmentCell(String employment) {
        var text = new Span(employment);
        return text;
    }

    private Component statusCell(String status) {
        var badge = new Badge(status);
        badge.addThemeVariants(BadgeVariant.DOT,
                status.equals("Active") ? BadgeVariant.SUCCESS : BadgeVariant.WARNING);
        badge.addClassName("person-status");
        return badge;
    }

    private Button iconButton(String ariaLabel, LucideIcon icon) {
        var button = new Button(icon.create());
        button.setAriaLabel(ariaLabel);
        button.addThemeVariants(ButtonVariant.SMALL, ButtonVariant.TERTIARY);
        return button;
    }

    record Person(String name, String initials, String email, String role, String department,
            String location, String employment, String status, String startDate, int avatarColorIndex) {
    }
}
