package main;

import org.usb4java.*;

public class Usb {

    public Usb(){
        LibUsb.init(null);
    }
    public static void list_device(){
        DeviceList list = new DeviceList();
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
                System.out.format(
                        "Bus %03d, Device %03d: Vendor %04x, Product %04x%n",
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
}
