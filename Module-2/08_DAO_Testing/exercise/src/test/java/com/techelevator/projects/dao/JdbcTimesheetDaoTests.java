package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    private final List<Timesheet> LIST_TIMESHEETS = new ArrayList<>();
    private List<Timesheet> other;



    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
        LIST_TIMESHEETS.add(TIMESHEET_1);
        LIST_TIMESHEETS.add(TIMESHEET_2);
        LIST_TIMESHEETS.add(TIMESHEET_3);
        LIST_TIMESHEETS.add(TIMESHEET_4);
    }

    @Test
    public void getTimesheetById_with_valid_id_returns_correct_timesheet() {
       Assert.assertEquals(LIST_TIMESHEETS.get(0).getTimesheetId(), dao.getTimesheetById(1).getTimesheetId());
    }

    @Test
    public void getTimesheetById_with_invalid_id_returns_null_timesheet() {
        Assert.assertEquals(null, dao.getTimesheetById(0));
    }

    @Test
    public void getTimesheetsByEmployeeId_with_valid_employee_id_returns_list_of_timesheets_for_employee() {
        other = dao.getTimesheetsByEmployeeId(2);
        Assert.assertEquals(LIST_TIMESHEETS.get(3).getEmployeeId(), other.get(0).getEmployeeId());
        Assert.assertEquals(LIST_TIMESHEETS.get(2).getEmployeeId(), other.get(1).getEmployeeId());
    }

    @Test
    public void getTimesheetsByProjectId_with_valid_id_returns_list_of_all_timesheets_for_project() {
        Assert.assertEquals(TIMESHEET_4.getProjectId(),dao.getTimesheetsByProjectId(2).get(0).getProjectId());

    }

    @Test
    public void createTimesheet_creates_timesheet() {
        int currentNum = dao.numOfTimesheets();
        Timesheet newTimesheet = dao.createTimesheet(TIMESHEET_1);
        Assert.assertEquals(currentNum + 1, newTimesheet.getTimesheetId());
    }

    @Test
    public void updateTimesheet_updates_timesheet() {
        Timesheet newTimesheet = dao.updateTimesheet(TIMESHEET_1);
        Assert.assertEquals(LIST_TIMESHEETS.get(0).getTimesheetId(), dao.getTimesheetById(1).getTimesheetId());
    }

    @Test
    public void deleteTimesheetById_deletes_timesheet() {
        Timesheet test = dao.getTimesheetById(1);
        dao.deleteTimesheetById(1);
        Assert.assertEquals(null, dao.getTimesheetById(test.getTimesheetId()));

    }

    @Test
    public void getBillableHours_returns_correct_total() {
        Timesheet temp = dao.getTimesheetById(2);
        double num1 = TIMESHEET_2.getHoursWorked();
        double num2 = dao.getBillableHours(temp.getEmployeeId(), temp.getProjectId());
        Assert.assertTrue(num1 == num2);

    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
