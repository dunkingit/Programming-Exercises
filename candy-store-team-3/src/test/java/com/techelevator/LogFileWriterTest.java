package com.techelevator;

import com.techelevator.filereader.LogFileWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LogFileWriterTest {
    private LogFileWriter newlog = new LogFileWriter("Test1");

    @Test
    public void LogFileWriter_test_output_format_return_String_date_time_action_before_after_transaction(){
        LocalDateTime myDateObj = LocalDateTime.now();
        String formattedDate = myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        String store = this.newlog.outputFormat("test2", 2.0, 2.0);
        Assert.assertEquals(formattedDate +" test2: $2.00 $2.00", store);
    }

    @Test
    public void LogFileWriter_test_log_file_to_txt(){
        LogFileWriter testLog = new LogFileWriter("TestFile");
        boolean wasWriteable = testLog.writeLog("test");
        Assert.assertTrue(wasWriteable);
    }

    @Test
    public void LogFileWriter_test_log_file_to_txt_with_no_string(){
        LogFileWriter testLog = new LogFileWriter("TestFile");
        boolean wasWriteable = testLog.writeLog("");
        Assert.assertTrue(wasWriteable);
    }

}
