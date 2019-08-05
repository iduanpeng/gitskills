package com.iduanpeng.design.mediator;

public class MediaStructure extends Mediator {

    private HouseOwner houseOwner;

    private Tenant tenant;

    @Override
    void constact(String message, Person person) {
        if (person == houseOwner){
            tenant.getMessage(message);
        }else {
            houseOwner.getMessage(message);
        }
    }

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
