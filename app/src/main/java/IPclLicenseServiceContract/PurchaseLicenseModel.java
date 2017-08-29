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

import IPclLicenseServiceContract.InvoiceInfoModel;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class PurchaseLicenseModel implements KvmSerializable {
    
    public int deviceCount;
    public String licensePlanGuid;
    public int periodCount;

    public String discountCode;
    public InvoiceInfoModel invoiceInfo;
    public boolean isEuro;
    public double price;
    public String userGuid;
    
    public PurchaseLicenseModel(){}
    
    public PurchaseLicenseModel(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("DeviceCount"))
        {
            Object obj = soapObject.getProperty("DeviceCount");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                deviceCount = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                deviceCount = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("LicensePlanGuid"))
        {
            Object obj = soapObject.getProperty("LicensePlanGuid");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                licensePlanGuid = j.toString();
            }else if (obj!= null && obj instanceof String){
                licensePlanGuid = (String) obj;
            }
        }
        if (soapObject.hasProperty("PeriodCount"))
        {
            Object obj = soapObject.getProperty("PeriodCount");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                periodCount = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                periodCount = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("ExtensionData"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("ExtensionData");

            
        }
        if (soapObject.hasProperty("DiscountCode"))
        {
            Object obj = soapObject.getProperty("DiscountCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                discountCode = j.toString();
            }else if (obj!= null && obj instanceof String){
                discountCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("InvoiceInfo"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("InvoiceInfo");
            invoiceInfo =  new InvoiceInfoModel (j);
            
        }
        if (soapObject.hasProperty("IsEuro"))
        {
            Object obj = soapObject.getProperty("IsEuro");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                isEuro = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                isEuro = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("Price"))
        {
            Object obj = soapObject.getProperty("Price");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                price = Double.parseDouble(j.toString());
            }else if (obj!= null && obj instanceof Number){
                price = (Double) obj;
            }
        }
        if (soapObject.hasProperty("UserGuid"))
        {
            Object obj = soapObject.getProperty("UserGuid");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                userGuid = j.toString();
            }else if (obj!= null && obj instanceof String){
                userGuid = (String) obj;
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return deviceCount;
            case 1:
                return licensePlanGuid;
            case 2:
                return periodCount;
            case 3:
                return null;
            case 4:
                return discountCode;
            case 5:
                return invoiceInfo;
            case 6:
                return isEuro;
            case 7:
                return price;
            case 8:
                return userGuid;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 9;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "DeviceCount";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "LicensePlanGuid";
                break;
            case 2:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "PeriodCount";
                break;
            case 3:
                info.type = null;
                info.name = "ExtensionData";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "DiscountCode";
                break;
            case 5:
                info.type = InvoiceInfoModel.class;
                info.name = "InvoiceInfo";
                break;
            case 6:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "IsEuro";
                break;
            case 7:
                info.type = Double.class;
                info.name = "Price";
                break;
            case 8:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "UserGuid";
                break;
        }
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
