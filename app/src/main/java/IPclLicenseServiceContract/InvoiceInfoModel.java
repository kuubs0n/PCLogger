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

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class InvoiceInfoModel implements KvmSerializable {
    

    public String city;
    public String companyName;
    public String country;
    public String district;
    public String homeNumber;
    public boolean isNipEu;
    public String nIP;
    public String postalCode;
    public String street;
    
    public InvoiceInfoModel(){}
    
    public InvoiceInfoModel(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("ExtensionData"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("ExtensionData");

            
        }
        if (soapObject.hasProperty("City"))
        {
            Object obj = soapObject.getProperty("City");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                city = j.toString();
            }else if (obj!= null && obj instanceof String){
                city = (String) obj;
            }
        }
        if (soapObject.hasProperty("CompanyName"))
        {
            Object obj = soapObject.getProperty("CompanyName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                companyName = j.toString();
            }else if (obj!= null && obj instanceof String){
                companyName = (String) obj;
            }
        }
        if (soapObject.hasProperty("Country"))
        {
            Object obj = soapObject.getProperty("Country");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                country = j.toString();
            }else if (obj!= null && obj instanceof String){
                country = (String) obj;
            }
        }
        if (soapObject.hasProperty("District"))
        {
            Object obj = soapObject.getProperty("District");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                district = j.toString();
            }else if (obj!= null && obj instanceof String){
                district = (String) obj;
            }
        }
        if (soapObject.hasProperty("HomeNumber"))
        {
            Object obj = soapObject.getProperty("HomeNumber");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                homeNumber = j.toString();
            }else if (obj!= null && obj instanceof String){
                homeNumber = (String) obj;
            }
        }
        if (soapObject.hasProperty("IsNipEu"))
        {
            Object obj = soapObject.getProperty("IsNipEu");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                isNipEu = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                isNipEu = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("NIP"))
        {
            Object obj = soapObject.getProperty("NIP");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                nIP = j.toString();
            }else if (obj!= null && obj instanceof String){
                nIP = (String) obj;
            }
        }
        if (soapObject.hasProperty("PostalCode"))
        {
            Object obj = soapObject.getProperty("PostalCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                postalCode = j.toString();
            }else if (obj!= null && obj instanceof String){
                postalCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("Street"))
        {
            Object obj = soapObject.getProperty("Street");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                street = j.toString();
            }else if (obj!= null && obj instanceof String){
                street = (String) obj;
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return null;
            case 1:
                return city;
            case 2:
                return companyName;
            case 3:
                return country;
            case 4:
                return district;
            case 5:
                return homeNumber;
            case 6:
                return isNipEu;
            case 7:
                return nIP;
            case 8:
                return postalCode;
            case 9:
                return street;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 10;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = null;
                info.name = "ExtensionData";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "City";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "CompanyName";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Country";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "District";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "HomeNumber";
                break;
            case 6:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "IsNipEu";
                break;
            case 7:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "NIP";
                break;
            case 8:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "PostalCode";
                break;
            case 9:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Street";
                break;
        }
    }
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}