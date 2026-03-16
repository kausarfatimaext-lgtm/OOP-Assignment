package Services;

import Users.Customer;

public class DeviceRepair extends Service{
    private String deviceType;
    private String issueDesc;

    public DeviceRepair(int reqId, String date, double baseCost, Customer placedBy, String status, String deviceType, String issueDesc){
        super(reqId, date, baseCost, placedBy, status, "Device Repair");
        this.deviceType = deviceType;
        this.issueDesc = issueDesc;
    }

    public String getDeviceType(){
        return deviceType;
    }
    public String getIssueDesc(){
        return issueDesc;
    }
}
