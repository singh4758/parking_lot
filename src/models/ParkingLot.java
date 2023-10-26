package models;

import java.util.List;

public class ParkingLot extends BaseModel{
  private List<ParkingFloor> parkingFloors;
  private List<Gate> gates;
  private ParkingLotStatus parkingLotStatus;
  private SlotAllotmentStrategyType slotAllotmentStrategyType;
  private FeesCalculationStrategyType feesCalculationStrategyType;
  private String address;

  public List<ParkingFloor> getParkingFloors() {
    return parkingFloors;
  }

  public void setParkingFloors(List<ParkingFloor> parkingFloors) {
    this.parkingFloors = parkingFloors;
  }

  public List<Gate> getGates() {
    return gates;
  }

  public void setGates(List<Gate> gates) {
    this.gates = gates;
  }

  public ParkingLotStatus getParkingLotStatus() {
    return parkingLotStatus;
  }

  public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
    this.parkingLotStatus = parkingLotStatus;
  }

  public SlotAllotmentStrategyType getSlotAllotmentStrategyType() {
    return slotAllotmentStrategyType;
  }

  public void setSlotAllotmentStrategyType(SlotAllotmentStrategyType slotAllotmentStrategyType) {
    this.slotAllotmentStrategyType = slotAllotmentStrategyType;
  }

  public FeesCalculationStrategyType getFeesCalculationStrategyType() {
    return feesCalculationStrategyType;
  }

  public void setFeesCalculationStrategyType(FeesCalculationStrategyType feesCalculationStrategyType) {
    this.feesCalculationStrategyType = feesCalculationStrategyType;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
