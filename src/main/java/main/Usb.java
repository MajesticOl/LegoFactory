package main;

import org.usb4java.*;

public class Usb {
    private DeviceList list = new DeviceList();

    public Device getDevice() {
        return device;
    }

    private Device device;

    public Usb(){
        LibUsb.init(null);
    }

    public void list_device(){
        int a = 1;

        int result = LibUsb.getDeviceList(null, list);
        if (result < 0)
        {
            throw new LibUsbException("Unable to get device list", result);
        }

        try
        {
            for (Device device: list)
            {
                int address = LibUsb.getDeviceAddress(device);
                int busNumber = LibUsb.getBusNumber(device);
                DeviceDescriptor descriptor = new DeviceDescriptor();
                result = LibUsb.getDeviceDescriptor(device, descriptor);
                if (result < 0)
                {
                    throw new LibUsbException(
                            "Unable to read device descriptor", result);
                }
                System.out.format(a++ +
                        ".) Bus %03d, Device %03d: Vendor %04x, Product %04x%n",
                        busNumber, address, descriptor.idVendor(),
                        descriptor.idProduct());
            }
        }
        finally
        {
            // Ensure the allocated device list is freed
            LibUsb.freeDeviceList(list, true);
        }
    }

    public void select_device(int a){
        int result = LibUsb.getDeviceList(null, list);
        if (result < 0)
        {
            throw new LibUsbException("Unable to get device list", result);
        }

        try
        {
            this.device = list.get(a);
        }
        finally
        {
            LibUsb.freeDeviceList(list, true);
        }
    }
}
