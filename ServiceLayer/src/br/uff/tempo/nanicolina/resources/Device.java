package br.uff.tempo.nanicolina.resources;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.61AB7880-E331-B0EC-7ED2-DD2CE90A6B9B]
// </editor-fold> 
public class Device {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8572210D-139F-0F56-3167-4DBC0590C04F]
    // </editor-fold> 
    private String name;
	
	private String id;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.52B8586F-4494-C2F8-6694-B59C94112E4F]
    // </editor-fold> 
    private int onOff;//0: off; 1: on; 2: null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.589F7D2A-30D4-DDD8-C84D-F9842EE0C856]
    // </editor-fold> 
    private Local localization;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AAC4F150-429A-299D-A9F2-36235E88D888]
    // </editor-fold> 
    public Device (String name, String id, int onOff, Local localization) {
    	this.name = name;
    	this.id = id;
    	this.onOff = onOff;
    	this.localization = localization; 
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.151B30A6-51BF-5AC1-E98A-9B1C4A3DE275]
    // </editor-fold> 
    public String getId () {
        return id;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.627AE358-008D-D731-C824-3256ED118888]
    // </editor-fold> 
    public void setId (String val) {
        this.id = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.00832F5D-5031-A53A-8384-7034B3E51CE9]
    // </editor-fold> 
    public Local getLocalization () {
        return localization;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.342222E6-3C3F-87D0-F57D-0D3342CCF627]
    // </editor-fold> 
    public void setLocalization (Local val) {
        this.localization = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B1E9B852-5AAA-1E8A-A08A-D83B6CEB6C4E]
    // </editor-fold> 
    public int getOnOff () {
        return onOff;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0B960A31-A7D2-F6AF-C629-572EBA7E22CB]
    // </editor-fold> 
    public void setOnOff (int val) {
        this.onOff = val;
    }

	public String getName() {
		return name;
	}

	public String toString()
	{
		String status = onOff == 0? "off":"on";
		return "Device: [ name:"+ name+", "+ status +", localization: "+ localization+"]\n";
	}


}
