package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;
import seedu.address.model.schedule.Schedule;

import java.util.logging.Logger;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class ListsPanel extends UiPart<Region> {

    private static final String FXML = "ListsPanel.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    // Independent Ui parts residing in this Ui container
    private PersonListPanel personListPanel;
    private ScheduleListPanel scheduleListPanel;

    @FXML
    private StackPane personListPanelPlaceholder;

    @FXML
    private StackPane scheduleListPanelPlaceholder;

    private ObservableList<Person> personList;
    private ObservableList<Schedule> scheduleList;

    /**
     * Creates a {@code ListsPanel} with the given {@code personList} and {@code scheduleList}.
     */
    public ListsPanel(ObservableList<Person> personList, ObservableList<Schedule> scheduleList) {
        super(FXML);

        this.personList = personList;
        this.scheduleList = scheduleList;

        personListPanel = new PersonListPanel(personList);
        personListPanelPlaceholder.getChildren().add(personListPanel.getRoot());

        scheduleListPanel = new ScheduleListPanel(scheduleList);
        scheduleListPanelPlaceholder.getChildren().add(scheduleListPanel.getRoot());
    }
}

