package IPclLicenseServiceContract;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 8/29/2017 12:54:15 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//
public class WS_Enums {

    public enum CommunicationState{
        	Created(0),
        	Opening(1),
        	Opened(2),
        	Closing(3),
        	Closed(4),
        	Faulted(5);
        
        private int code;
        
        CommunicationState(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
        
        public static CommunicationState fromString(String str)
        {
            if (str.equals("Created"))
                return Created;
            if (str.equals("Opening"))
                return Opening;
            if (str.equals("Opened"))
                return Opened;
            if (str.equals("Closing"))
                return Closing;
            if (str.equals("Closed"))
                return Closed;
            if (str.equals("Faulted"))
                return Faulted;
            return null;
        }
    }
    public enum DiscountCodeVerificationStatus{
        	None(0),
        	Invalid(1),
        	DiscountExpired(2),
        	AlreadyUsed(3),
        	OK(4),
        	NotActiveYet(5),
        	InvalidLicensePlan(6);
        
        private int code;
        
        DiscountCodeVerificationStatus(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
        
        public static DiscountCodeVerificationStatus fromString(String str)
        {
            if (str.equals("None"))
                return None;
            if (str.equals("Invalid"))
                return Invalid;
            if (str.equals("DiscountExpired"))
                return DiscountExpired;
            if (str.equals("AlreadyUsed"))
                return AlreadyUsed;
            if (str.equals("OK"))
                return OK;
            if (str.equals("NotActiveYet"))
                return NotActiveYet;
            if (str.equals("InvalidLicensePlan"))
                return InvalidLicensePlan;
            return null;
        }
    }
    public enum DiscountType{
        	None(0),
        	SingleUseCode(1),
        	MultiUseCode(2),
        	Period(3),
        	Devices(4);
        
        private int code;
        
        DiscountType(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
        
        public static DiscountType fromString(String str)
        {
            if (str.equals("None"))
                return None;
            if (str.equals("SingleUseCode"))
                return SingleUseCode;
            if (str.equals("MultiUseCode"))
                return MultiUseCode;
            if (str.equals("Period"))
                return Period;
            if (str.equals("Devices"))
                return Devices;
            return null;
        }
    }
    public enum OrderType{
        	NewLicense(0),
        	AdditionalPeriod(1),
        	AdditionalDevices(2),
        	UpgradeLicense(3);
        
        private int code;
        
        OrderType(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
        
        public static OrderType fromString(String str)
        {
            if (str.equals("NewLicense"))
                return NewLicense;
            if (str.equals("AdditionalPeriod"))
                return AdditionalPeriod;
            if (str.equals("AdditionalDevices"))
                return AdditionalDevices;
            if (str.equals("UpgradeLicense"))
                return UpgradeLicense;
            return null;
        }
    }
    public enum CheckLicenseResultEnum{
        	None(0),
        	OK(1),
        	NoMoreDevicesAvailable(2),
        	LicenseServiceFault(3),
        	Error(4),
        	InternalDbError(5),
        	InternalError(6),
        	EmailOrPinIncorrect(7),
        	AdministratorAccountRequired(8),
        	NoActiveLicense(9),
        	LicenseExpired(10),
        	LicenseNotPaid(11);
        
        private int code;
        
        CheckLicenseResultEnum(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
        
        public static CheckLicenseResultEnum fromString(String str)
        {
            if (str.equals("None"))
                return None;
            if (str.equals("OK"))
                return OK;
            if (str.equals("NoMoreDevicesAvailable"))
                return NoMoreDevicesAvailable;
            if (str.equals("LicenseServiceFault"))
                return LicenseServiceFault;
            if (str.equals("Error"))
                return Error;
            if (str.equals("InternalDbError"))
                return InternalDbError;
            if (str.equals("InternalError"))
                return InternalError;
            if (str.equals("EmailOrPinIncorrect"))
                return EmailOrPinIncorrect;
            if (str.equals("AdministratorAccountRequired"))
                return AdministratorAccountRequired;
            if (str.equals("NoActiveLicense"))
                return NoActiveLicense;
            if (str.equals("LicenseExpired"))
                return LicenseExpired;
            if (str.equals("LicenseNotPaid"))
                return LicenseNotPaid;
            return null;
        }
    }
    public enum CreateUserStatus{
        	None(0),
        	Success(1),
        	DuplicatedEmail(2),
        	EmailSendingError(3),
        	UnknownError(4);
        
        private int code;
        
        CreateUserStatus(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
        
        public static CreateUserStatus fromString(String str)
        {
            if (str.equals("None"))
                return None;
            if (str.equals("Success"))
                return Success;
            if (str.equals("DuplicatedEmail"))
                return DuplicatedEmail;
            if (str.equals("EmailSendingError"))
                return EmailSendingError;
            if (str.equals("UnknownError"))
                return UnknownError;
            return null;
        }
    }
    public enum UpdateUserStatus{
        	None(0),
        	Success(1),
        	DuplicatedEmail(2),
        	UnknownError(3);
        
        private int code;
        
        UpdateUserStatus(int code){
            this.code = code;
        }
        
        public int getCode(){
            return code;
        }
        
        public static UpdateUserStatus fromString(String str)
        {
            if (str.equals("None"))
                return None;
            if (str.equals("Success"))
                return Success;
            if (str.equals("DuplicatedEmail"))
                return DuplicatedEmail;
            if (str.equals("UnknownError"))
                return UnknownError;
            return null;
        }
    }
}