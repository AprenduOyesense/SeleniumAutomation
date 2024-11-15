package org.oyetest.mail;

import static org.oyetest.constants.FrameworkConstants.REPORT_TITLE;

/**
 * Data for Sending email after execution
 */
public class EmailConfig {


    public static final String SERVER = "smtp.gmail.com";
    public static final String PORT = "587";

    public static final String FROM = "support@oyetest.com";
    public static final String PASSWORD = "******";

    public static final String[] TO = {""};
    public static final String SUBJECT = REPORT_TITLE;
}