


public class JavaServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DeviceServer ds = new DeviceServer(10006);
        System.out.println(ds.receiveStatus());
	}

}