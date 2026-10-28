# Vaadin Layout and Styling Prototypes (2026)

A collection of small layout and styling prototypes I researched before my session at the Vaadin Create 2026 conference. You can  find the project that I worked on during my "office hours" session at the conference at https://github.com/jouni/vaadin-create-2026-office-hours

[![Watch the preview](https://github.com/jouni/vaadin-create-2026-prototype/raw/refs/heads/main/preview.png)](https://github.com/jouni/vaadin-create-2026-prototype/raw/refs/heads/main/preview.mov)

## Featured Prototypes

### 1. Rail Navigation with AppLayout

A customized `AppLayout` navbar serves as a navigation rail, with sub-navigation items in the `AppLayout` drawer. Hover interactions make the sub-navigation accessible even when the drawer is collapsed.

### 2. Continuous Scrolling with a Lazy-Loaded Grid

A typical data listing view places a summary area above a data table. The prototype makes the grid appear infinitely long while preserving lazy loading: scrolling initially moves the view, then seamlessly switches to the grid's own scrolling region when the end of the view is reached.

This is a workaround for a `vaadin-grid` limitation: it cannot virtualize its rows based on an external scrolling region.

### 3. iOS-Style MasterDetailLayout Transition

A customized `MasterDetailLayout` transition for viewports below 500px wide. Opening the detail makes it occupy the full width while the master area slides and fades out, mimicking the iOS view navigation transition.

### 4. Custom User Menu

A user menu built with a regular `Button` and `ContextMenu` instead of a single-item `MenuBar`, making the trigger button easier to style. The context-menu overlay also has customized opening and closing animations, scaling up from the trigger button when opened and back down when closed.

### 5. First-Visit Staggered Entry Animation

On the first visit to the demo view, its elements animate into place in a staggered sequence. The entry animation does not replay on subsequent visits.

## Run the Demo

Import the project into your IDE and run the `Application` class, or start it from the command line:

```bash
./mvnw
```

Open [localhost:8080](http://localhost:8080) in your browser.
