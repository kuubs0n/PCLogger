package net.pclogger.pclogger.ApiModels;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by j.krawczyk on 21.09.2017.
 */

public class UserDailyStatsModel {
    public UUID UserGuid;
    public String FullName;
    public String Email;
    public String DismissedDate;
    public String WorkStarted;
    public String WorkEnded;
    public String Worked;
    public String NotWorked;
    public int BreakCound;
    public String Efficiency;
}
