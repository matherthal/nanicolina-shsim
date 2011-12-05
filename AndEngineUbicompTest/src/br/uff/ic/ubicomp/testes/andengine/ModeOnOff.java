package br.uff.ic.ubicomp.testes.andengine;

public class ModeOnOff extends ResourceProperty {
	ModeOnOff() {
		super.name = "ModeOnOff";
		super.state = "off";
	}
	
	public void setModeOn() {
		if (super.state.equals("off"))
			super.state = "on";
	}
	
	public void setModeOff() {
		if (super.state.equals("on"))
			super.state = "off";
	}
}
