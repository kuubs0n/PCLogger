package net.pclogger.pclogger.ApiModels;

import java.util.Date;
import java.util.UUID;

/**
 * Created by j.krawczyk on 06.09.2017.
 */

public class UserDataModel {
    public long Id;
    public long GroupId;
    public String Name;
    public String Email;
    public String FullName;
    public String DomainName;
    public UUID OrganizationGuid;
    public UUID UserGuid;
    public long RoleId;
    public boolean IsImportedOnly;
}
