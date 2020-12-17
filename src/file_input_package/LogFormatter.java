package file_input_package;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Created by sachin on 3/2/19.
 */


public class LogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        StringBuffer sb = new StringBuffer();
        sb.append(record.getMessage());
        sb.append("\n");
        return sb.toString();
    }
}
