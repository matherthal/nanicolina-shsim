package br.uff.ic.ubicomp.testes.base;

import java.util.Scanner;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.61AB7880-E331-B0EC-7ED2-DD2CE90A6B9B]
// </editor-fold> 
public class Resource {

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
    private Position localization;

    private User user;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AAC4F150-429A-299D-A9F2-36235E88D888]
    // </editor-fold> 
    public Resource (String name, String id, int onOff, Position localization) {
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
    public Position getLocalization () {
        return localization;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.342222E6-3C3F-87D0-F57D-0D3342CCF627]
    // </editor-fold> 
    public void setLocalization (Position val) {
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
	
	public void setName(String name)
	{
		this.name = name;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	
	public String toString()
	{
		String status = onOff == 0? "off":"on";
		return "Device: [ name:"+ name+", id:"+id+", "+ status +", localization: "+ localization+"]\n";
	}
	
	public static Resource convert(String format) {
		// TODO Auto-generated method stub
		if (format.length()!=0)
		{	
			int nameBegin = 0;
			int nameEnd = 0;
			int idBegin = 0;
			int idEnd = 0;
			int statusEnd =0;
			int localBegin =0;
			int localEnd = 0;
			int i =0;
			i = thresholdLimit(format,':',i);
			i = thresholdLimit(format,':',i+1);
			nameBegin=i;
			i = thresholdLimit(format,',',i);
			nameEnd = i-1;
			i = thresholdLimit(format,':',i);
			idBegin=i;
			i = thresholdLimit(format,',',i);
			idEnd = i-1;
			i = thresholdLimit(format,',',i);
			statusEnd = i-1;
			i = thresholdLimit(format,':',i);
			localBegin = i;
			i = thresholdLimit(format,']',i);
			localEnd = i-1;
			String nome = format.substring(nameBegin, nameEnd);
			String id = format.substring(idBegin, idEnd);
			String onOffStr = format.substring(idEnd+2, statusEnd);
			int onOff = onOffStr.equals("on")? 1:0;
			return new Resource(nome,id,onOff,Position.convert(format.substring(localBegin, localEnd)));
		}
		else return null;
	}

	private static int thresholdLimit(String format,char ch, int i)
	{
		while(format.charAt(i) != ch)
			i++;
		i++;
		return i;
	}
}

