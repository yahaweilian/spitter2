package com.springinaction.springidol;

import java.util.Collection;
import java.util.Map;

/**
 * 一人乐队
 * @author Administrator
 *
 */
public class OneManBand implements Performer {

	public OneManBand(){
		
	}
	
	private Collection<Instrument> instruments;//乐器组
	private Map<String,Instrument> instruments2;//Map乐器组
	
	public void setInstruments2(Map<String, Instrument> instruments2) {
		this.instruments2 = instruments2;
	}

	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() throws PerformanceException {
		for (Instrument instrument : instruments) {
			instrument.play();
		}
		for (String key : instruments2.keySet()) {
			System.out.println(key + " : ");
			Instrument instrument = instruments2.get(key);
			instrument.play();
		}
	}

}
